package com.dugauguez.crunch.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class FilesService {


    @Value("${ffa.url}")
    private String ffaUrl;


    @Async
    public void createFiles(String type, String year, String department) throws IOException {

        // create the url
        URL url = new URL(ffaUrl);

        // open the url stream, wrap it an a few "readers"
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        // write the output to stdout
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // close our reader
        reader.close();


    }


}
