import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class JSONManager {
    public static void writeException(JsonException jsonException) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("logs/Exceptions.txt"), jsonException);
        } catch (IOException ex) {
            System.err.println("Unable to write exception message");
            ex.printStackTrace();
        }
    }

    public static void writeFatalError(JsonException jsonException) {
        writeException(jsonException);
        System.err.println("Fatal error occurred");
        System.exit(1);
    }

    public static void writeLog(JSONAction jsonAction) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("logs/" + jsonAction.getClassName() + "_log.txt");
            file.createNewFile();
            FileOutputStream oFile = new FileOutputStream(file, true);
            JsonGenerator g = objectMapper.getFactory().createGenerator(oFile);
            objectMapper.writeValue(g, jsonAction);
            oFile.write("\n".getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.err.println("Unable to write log message");
            ex.printStackTrace();
        }
    }

    public static <T> T readFromFile(String fileName, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T data = objectMapper.readValue(ClassLoader.getSystemResourceAsStream(fileName), tClass);
            System.out.println("Loaded: " + data);
            return data;
        } catch (DatabindException e) {
            System.err.println("Invalid file " + fileName + " format");
            e.printStackTrace();
            try {
                objectMapper.writeValue(new File("logs/Exceptions.txt"),
                        new JsonException("DatabindException", "Invalid file " + fileName + " format"));
            } catch (IOException ex) {
                System.err.println("Unable to write exception message");
                ex.printStackTrace();
            }
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Open file " + fileName + " exception");
            e.printStackTrace();
            try {
                objectMapper.writeValue(new File("logs/Exceptions.txt"),
                        new JsonException("DatabindException", "Open file " + fileName + " exception"));
            } catch (IOException ex) {
                System.err.println("Unable to write exception message");
                ex.printStackTrace();
            }
            System.exit(1);
        }
        return null;
    }
}

