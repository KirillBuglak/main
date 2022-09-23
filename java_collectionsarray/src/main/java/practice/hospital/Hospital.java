package practice.hospital;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] array = new float[patientsCount];
        for (int i = 0; i < array.length; i++) {
            float genTemp = 40 - (float) Math.round(8 * Math.random());
            array[i] = genTemp;
        }
        return array;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        StringBuilder temperatures = new StringBuilder();
        String averageTemperature = "";
        int healthyNumber = 0;
        float sumTemp = 0;

        for (float t : temperatureData) {
            temperatures.append(" ").append(t);
            sumTemp += t;
            if (t >= 36.2f && t <= 36.9f) {
                healthyNumber++;
            }
        }

        averageTemperature = String.format("%.2f",sumTemp / temperatureData.length);

        String report =
                "Температуры пациентов:" + temperatures +
                        "\nСредняя температура: " + averageTemperature +
                        "\nКоличество здоровых: " + healthyNumber;

        return report;
    }
}
