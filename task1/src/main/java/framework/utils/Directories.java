package framework.utils;

import java.io.File;

public class Directories {
    public static void cleanDirectory(String path) {
        for (File file : new File(path).listFiles())
            if (file.isFile()) file.delete();
    }
}
