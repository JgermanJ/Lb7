package org.l7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    private final String fileName = "cars";
    private final String fileExtension = ".json";
    private final String directory = "userfiles/";
    private final String filePath = directory + fileName + fileExtension;


    public void writeFile(List<Car> cars) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File(filePath), cars);

        } catch (IOException ex) {

            ex.printStackTrace();
        }

    }

    public List<Car> readFile() {

        File file = new File(filePath);
        List<Car> cars = new ArrayList<>();

        if (file.length() == 0) {

            return cars;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            cars = objectMapper.readValue(new File(filePath), new TypeReference<>() {
            });

        } catch (IOException err) {

            err.printStackTrace();
        }

        return cars;


    }

}