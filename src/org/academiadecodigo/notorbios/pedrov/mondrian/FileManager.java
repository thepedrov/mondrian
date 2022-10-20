package org.academiadecodigo.notorbios.pedrov.mondrian;

import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;

import java.io.*;

public class FileManager {

    public static void save(String output) throws IOException {
        FileWriter writer = new FileWriter(Settings.pathSaveFile);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write(output);
        bWriter.close();
    }

    public static String load() throws IOException {
        FileReader reader = new FileReader(Settings.pathSaveFile);
        BufferedReader bReader = new BufferedReader(reader);

        StringBuilder content = new StringBuilder();

        String line = "";

        while ((line = bReader.readLine()) != null) {
            content.append(line + "\n");
        }

        bReader.close();

        return content.toString();
    }

}