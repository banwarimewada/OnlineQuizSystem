package util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandler {
    public static void ensureDataFolder() {
        try { Files.createDirectories(Paths.get("data")); }
        catch (IOException e) { System.err.println("Could not create data folder: " + e.getMessage()); }
    }

    public static List<String> readAllLines(String path) {
        try {
            Path p = Paths.get(path);
            if (!Files.exists(p)) return new ArrayList<>();
            return Files.readAllLines(p);
        } catch (IOException e) {
            System.err.println("Read error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void appendLine(String path, String line) {
        try {
            Files.write(Paths.get(path), Collections.singletonList(line),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }
    }

    public static void overwrite(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }
    }
}
