package utils;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVUtil {

    public static Object[][] readCSV(String path) {

        try {

            CSVReader reader = new CSVReader(new FileReader(path));

            List<String[]> data = reader.readAll();

            Object[][] testData =
                    new Object[data.size() - 1][data.get(0).length];

            for (int i = 1; i < data.size(); i++) {

                for (int j = 0; j < data.get(i).length; j++) {

                    testData[i - 1][j] = data.get(i)[j];
                }
            }

            return testData;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}