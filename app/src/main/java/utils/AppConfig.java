package utils;

import com.cz.jetpack.study.medel.Destination;
import java.util.HashMap;

public class AppConfig {
    private static HashMap<String, Destination> sDestConfig;
    public static HashMap<String, Destination> getDestConfig() {
        if(sDestConfig == null) {

        }
        return sDestConfig;
    }

    private static String parseFile(String fileName) {
        return "";
    }
}
