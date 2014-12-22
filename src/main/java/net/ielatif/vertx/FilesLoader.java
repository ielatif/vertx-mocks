package net.ielatif.vertx;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by issam on 23/12/2014.
 */
public class FilesLoader {

    private Map<String, String> filesMap = new HashMap<>();

    public static void init() {
        URL url = FilesLoader.class.getResource("/mocks");
        File[] files = new File[0];
        try {
            files = new File(url.toURI()).listFiles();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        loadFiles(files);
    }

    private static void loadFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                loadFiles(file.listFiles());
            } else {
                String parentPath = file.getParent();
                System.out.println(parentPath);
            }
        }
    }
}
