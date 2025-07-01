package ru.nsd.addressbook.common;

import java.io.File;
import java.nio.file.Paths;
import java.util.Random;

public class CommonFunctions {
    public static String randomString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result = result + (char) ('a' + new Random().nextInt(26));
        }
        return result;
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var index = new Random().nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }
}
