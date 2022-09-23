import metro.Line;
import metro.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    final static String path = "data";
    static List<File> fileList = new ArrayList<>();
    static LinkedHashMap<String, Station> stationSet = new LinkedHashMap<>();
    static LinkedHashMap<String, Line> lineSet = new LinkedHashMap<>();
    static JSONParser parser = new JSONParser();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        readHTTP();

        getFolders(path);

        for (File f : fileList) {
            parseFile(f);
        }

        writeStationsJson(stationSet.values());
        writeMapJson(lineSet.values());

        countStationsInLine();

    }

    private static void readHTTP() {
        try {
            Document document = Jsoup.connect("https://skillbox-java.github.io/").get();

            Elements wholeData = document.select("span");
            List<String> stringsList = wholeData.stream().map(strings -> strings.text().toLowerCase(Locale.ROOT))
                    .toList();
            List<String> changesList = getUniqueChanges(wholeData);


            AtomicReference<Line> line = new AtomicReference<>();
            AtomicReference<Station> station = new AtomicReference<>();

            wholeData.forEach(e -> {

                String name;

                if (String.valueOf(e).contains("data-line")) {
                    line.set(new Line());
                    line.get().setNumber(e.attr("data-line"));
                    line.get().setName(e.text());
                    lineSet.put(e.attr("data-line"), line.get());
                }
                if (String.valueOf(e).contains("num")) {
                    station.set(new Station());
                    station.get().setNumber(parseStationNumber(e.text()));
                }
                if (String.valueOf(e).contains("name")) {

                    /**Checking for equal names in different CASES(font)*/
                    if (stringsList.contains(e.text().toLowerCase(Locale.ROOT))) {
                        name = wholeData.stream().map(Element::text).sorted().filter(match ->
                                match.equalsIgnoreCase(e.text())).findFirst().get();
                    } else {
                        name = e.text();
                    }
                    station.get().setName(name);
                    station.get().setLine(line.get());

                    if (changesList.contains(station.get().getName())) {
                        station.get().setHasChange(true);
                    }
                    /**Creating unique keys*/
                    stationSet.put(station.get().getName() + " line is " + line.get().getNumber(), station.get());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getFolders(String url) {
        File foil = new File(url);
        File[] subDirs = foil.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        getFiles(url);
        for (File f : subDirs) {
            getFolders(f.getPath());
        }
    }

    private static void getFiles(String url) {
        File dir = new File(url);
        File[] files = dir.listFiles();
        assert files != null;
        Arrays.stream(files).forEach(e -> {
            boolean trueFile = e.isFile() && e.getName().charAt(0) != '.';
            if (trueFile) {
                fileList.add(e);
            }
        });
    }

    private static int parseStationNumber(String s) {
        int end = s.indexOf('.');
        return Integer.parseInt(s.substring(0, end));
    }

    private static void parseFile(File file) {
        if (file.getName().contains("json")) {
            parseJSON(file);
        } else {
            parseCSV(file);
        }
    }

    private static void parseJSON(File file) {
        JSONParser parser = new JSONParser();

        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

            jsonArray.forEach(object -> {
                JSONObject jsonObject = (JSONObject) object;
                List<String> list = null;

                if (jsonObject.containsKey("name")) {
                    list = new ArrayList<>(stationSet.keySet().stream()
                            .filter(key -> {
                                int end = key.indexOf("line") - 1;
                                String subKey = key.substring(0, end);
                                return yuoMeth(subKey, (String) jsonObject.get("name"));
                            }).toList());
                }
                if (jsonObject.containsKey("station_name")) {
                    list = new ArrayList<>(stationSet.keySet().stream()
                            .filter(key -> {
                                int end = key.indexOf("line") - 1;
                                String subKey = key.substring(0, end);
                                return yuoMeth(subKey, (String) jsonObject.get("station_name"));
                            }).toList());
                }
                if (jsonObject.containsKey("depth")) {
                    list.forEach(key -> stationSet.get(key).setDepth(String.valueOf(jsonObject.get("depth"))));
                }
                if (jsonObject.containsKey("depth_meters")) {
                    list.forEach(key -> stationSet.get(key).setDepth(String.valueOf(jsonObject.get("depth_meters"))));
                }
                if (jsonObject.containsKey("date")) {
                    list.forEach(key -> stationSet.get(key).setDate((String) jsonObject.get("date")));
                }
                list.forEach(key -> stationSet.put(key, stationSet.get(key)));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseCSV(File file) {

        List<String> list;
        try {
            List<String> strings = Files.readAllLines(Path.of(file.getPath()));
            String title = strings.iterator().next();
            strings.remove(title);
            for (String s : strings) {
                String[] splits;
                if (s.contains("\"")) {
                    splits = s.split(",\"");
                } else {
                    splits = s.split(",");
                }
                list = new ArrayList<>(stationSet.keySet().stream()
                        .filter(key -> {
                            int end = key.indexOf("line") - 1;
                            String subKey = key.substring(0, end);
                            return yuoMeth(subKey, splits[0]);

                        }).toList());
                if (file.getName().contains("dates")) {
                    list.forEach(key -> stationSet.get(key).setDate(splits[1]));
                } else if (file.getName().contains("depths")) {
                    list.forEach(key -> stationSet.get(key).setDepth(splits[1]));
                }
                list.forEach(key -> stationSet.put(key, stationSet.get(key)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Е VS Ё conflict
     */
    private static boolean yuoMeth(String one, String two) {
        String first = one;
        String second = two;

        if (one.contains("ё")) {
            first = one.replace('ё', 'е');
        }
        if (two.contains("ё")) {
            second = two.replace('ё', 'е');
        }
        return first.equalsIgnoreCase(second);
    }

    private static List<String> getUniqueChanges(Elements wholeData) {
        List<String> changeList = new ArrayList<>(wholeData.stream().filter(e -> (String.valueOf(e)
                .contains("t-icon"))).map(f ->
                f.attr("title")).filter(s -> !s.isEmpty()).map(e -> {
            int str = e.indexOf('«') + 1;
            int end = e.indexOf('»');
            return e.substring(str, end);
        }).distinct().sorted().toList());

        for (int i = 0; i < changeList.size() - 1; i++) {
            String first = changeList.get(i);
            String second = changeList.get(i + 1);
            if (first.equalsIgnoreCase(second)) {
                changeList.remove(second);
            }
        }
        return changeList;
    }

    private static void writeStationsJson(Collection<Station> collection) {

        JSONObject fileObject = new JSONObject();
        JSONArray stationsArray = new JSONArray();


        collection.forEach(e -> {

                    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
                    map.put("name", e.getName());
                    map.put("line", e.getLine().getName());
                    if (e.getDate() != null) {
                        map.put("date", e.getDate());
                    }
                    if (e.getDepth() != null && Double.valueOf(e.getDepth()) % 1 == 0) {
                        map.put("depth", Integer.valueOf(e.getDepth()));
                    } else if (e.getDepth() != null && Double.valueOf(e.getDepth()) % 1 != 0) {
                        map.put("depth", Double.valueOf(e.getDepth()));
                    }
                    map.put("hasConnection", e.isHasChange());
                    stationsArray.add(map);
                }
        );

        fileObject.put("stations", stationsArray);
        try (FileWriter fileWriter = new FileWriter("stations.json")) {
            fileWriter.write(String.valueOf(fileObject));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMapJson(Collection<Line> collection) {
        JSONObject fileObject = new JSONObject();
        LinkedHashMap<String, JSONArray> stationsObject = new LinkedHashMap<>();
        JSONArray linesArray = new JSONArray();
        collection.forEach(l -> {

            /**For stations*/
            JSONArray lineArray = new JSONArray();
            List<String> stationInLine = stationSet.values().stream().filter(s -> s.getLine() == l)
                    .map(Station::getName).toList();
            lineArray.addAll(stationInLine);
            stationsObject.put(l.getNumber(), lineArray);
            /**For lines*/
            LinkedHashMap<String, String> lineMap = new LinkedHashMap<>();
            lineMap.put("number", l.getNumber());
            lineMap.put("name", l.getName());
            linesArray.add(lineMap);
        });
        fileObject.put("stations", stationsObject);
        fileObject.put("lines", linesArray);

        try (FileWriter fileWriter = new FileWriter("map.json")) {
            fileWriter.write(String.valueOf(fileObject));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void countStationsInLine() {
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("map.json"));
            JSONObject stations = (JSONObject) jsonObject.get("stations");
            System.out.println("Enter line number");
            String input = scanner.nextLine();
            if (lineSet.keySet().contains(input)) {
                JSONArray array = (JSONArray) stations.get(input);
                System.out.println("Line " + input + " has " + array.size() + " stations");
            } else {
                System.err.println("Wrong line number");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}