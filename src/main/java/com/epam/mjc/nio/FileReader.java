package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder strBuilder = new StringBuilder();

        try (InputStream fileInputStream = Files.newInputStream(file.toPath())) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                strBuilder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultStr = strBuilder.toString();
        String[] strArray = resultStr.split("\r\n");
        return fillProfile(strArray);
    }

    public Profile fillProfile(String[] arr) {
        Profile profile = new Profile();

        profile.setName(arr[0].replace("Name: ", ""));
        profile.setAge(Integer.valueOf(arr[1].replace("Age: ", "")));
        profile.setEmail(arr[2].replace("Email: ", ""));
        profile.setPhone(Long.valueOf(arr[3].replace("Phone: ", "")));

        return profile;
    }
}
