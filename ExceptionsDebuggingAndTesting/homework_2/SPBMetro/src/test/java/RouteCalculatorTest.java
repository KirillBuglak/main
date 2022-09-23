import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    List<Station> routeNoChange;
    RouteCalculator calculator;
    StationIndex stationIndex;
    Station s1;
    Station s11;
    Station s111;
    Station s2;
    Station s22;
    Station s222;
    Station s3;
    Station s33;
    Station s333;
    Line line1;
    Line line2;
    Line line3;

    public static void main(String[] args) throws Exception {
        RouteCalculatorTest test = new RouteCalculatorTest();
        test.setUp();
        System.out.println(test.stationIndex.getConnectedStations(test.s3));

    }

    @Override
    protected void setUp() {

        stationIndex = new StationIndex();
        route = new ArrayList<>();
        routeNoChange = new ArrayList<>();
        line1 = new Line(1, "First");
        line2 = new Line(2, "Second");
        line3 = new Line(3, "Third");
        s1 = new Station("f1", line1);
        s11 = new Station("f11", line1);
        s111 = new Station("f111", line1);
        s2 = new Station("f2", line2);
        s22 = new Station("f22", line2);
        s222 = new Station("f222", line2);
        s3 = new Station("f3", line3);
        s33 = new Station("f33", line3);
        s333 = new Station("f333", line3);
        line1.addStation(s1);
        line1.addStation(s11);
        line1.addStation(s111);
        line2.addStation(s2);
        line2.addStation(s22);
        line2.addStation(s222);
        line3.addStation(s3);
        line3.addStation(s33);
        line3.addStation(s333);

        route.add(s1);
        route.add(s11);
        route.add(s111);
        route.add(s2);
        route.add(s22);
        route.add(s222);
        routeNoChange.add(s1);
        routeNoChange.add(s11);
        routeNoChange.add(s111);

        stationIndex.addStation(s1);
        stationIndex.addStation(s11);
        stationIndex.addStation(s111);
        stationIndex.addStation(s2);
        stationIndex.addStation(s22);
        stationIndex.addStation(s222);
        stationIndex.addStation(s3);
        stationIndex.addStation(s33);
        stationIndex.addStation(s333);


        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        List<Station> connection1 = new ArrayList<>();
        connection1.add(s111);
        connection1.add(s2);
        stationIndex.addConnection(connection1);

        List<Station> connection2 = new ArrayList<>();
        connection2.add(s222);
        connection2.add(s3);
        stationIndex.addConnection(connection2);


        calculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 13.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = calculator.getShortestRoute(s1, s111);
        List<Station> expected = new ArrayList<>();
        expected.add(s1);
        expected.add(s11);
        expected.add(s111);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = calculator.getShortestRoute(s22, s11);
        List<Station> expected = new ArrayList<>();
        expected.add(s22);
        expected.add(s2);
        expected.add(s111);
        expected.add(s11);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = calculator.getShortestRoute(s33, s11);
        List<Station> expected = new ArrayList<>();
        expected.add(s33);
        expected.add(s3);
        expected.add(s222);
        expected.add(s22);
        expected.add(s2);
        expected.add(s111);
        expected.add(s11);
        assertEquals(expected, actual);
    }
}