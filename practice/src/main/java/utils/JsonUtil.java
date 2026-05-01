package utils;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static List<Object> readJson(String filePath) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Object>>() {});

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}