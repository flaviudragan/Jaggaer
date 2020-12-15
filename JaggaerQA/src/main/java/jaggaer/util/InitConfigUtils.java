package jaggaer.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitConfigUtils {
    private static final String DATA_PROPERTIES = "src/test/resources/properties/data.properties";
    private static final String PAGE_PROPERTIES ="src/test/resources/properties/pages.properties";

    private static Properties configFile;
    private static Properties configPagesFile;

    public InitConfigUtils() throws IOException {
        initData();
        initPages();
    }

    private void initData() {
        configFile = new Properties();
        try {
            configFile.load(new FileReader(DATA_PROPERTIES));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initPages() {
        configPagesFile = new Properties();
        try {
            configPagesFile.load(new FileReader(PAGE_PROPERTIES));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

    public static String getPageProperty(String keyName) {
        return configPagesFile.getProperty(keyName);
    }

}
