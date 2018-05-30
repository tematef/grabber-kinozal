package objects.enums;

import util.Properties;

public enum DataFiles {

    UHD_RELEASE(Properties.getProperty("uhd_releases_file")),
    GRABBED_DATA_FOLDER(Properties.getProperty("folder_to_grab"));

    private String value;

    DataFiles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
