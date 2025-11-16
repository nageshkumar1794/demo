package com.example.demo.override;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Examone {
    public String name;

    public Examone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void readFile() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(name))){
//            FileReader fileReader = new FileReader(name);
//            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("Reading from File");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
