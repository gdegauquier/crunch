package com.dugauguez.crunch.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.text.MessageFormat;

@Component
public class FilesService {


    @Value("${ffa.url}")
    private String ffaUrl;

    private static final String SUFFIX_URL_FFA = "/asp.net/liste.aspx?" +
            "frmpostback=true&frmbase=calendrier&frmmode=1&frmespace=0&frmsaison={0}&frmdepartement={1}&frmposition={2}";

    private static final String LOCAL_DIR = "../crunch/src/main/resources/files";

    @Async
    public void createFiles(String type, String year, String department) throws IOException {

        // create the url
        String page = "1";
        String urlStr = ffaUrl + SUFFIX_URL_FFA;
        urlStr = MessageFormat.format(urlStr, year, department, page);

        URL url = new URL(urlStr);

        // open the url stream, wrap it an a few "readers"
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        // write the output to stdout
        String line;
        String lineConcat = "";
        while ((line = reader.readLine()) != null) {
            lineConcat += line;
        }

        String directory = MessageFormat.format(LOCAL_DIR + "/{0}/{1}", year, department);
        new File(directory).mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/" + "global_" + page + ".html"));
        writer.write(lineConcat);
        writer.close();

        // close our reader
        reader.close();

    }


}
