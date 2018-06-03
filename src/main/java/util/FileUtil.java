package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileUtil {

    private static final String USER_DIR_PATH = System.getProperty("user.dir");
//    private String localPath;
    private File file;
    private Path localPath;

    private FileUtil(String localPath) {
//        this.localPath = localPath;
        this.file = new File(localPath);
        this.localPath = Paths.get(USER_DIR_PATH + File.separator + localPath);
    }

    public static FileUtil createFile(String localPath) {
        return new FileUtil(localPath);
    }

    public boolean isFolderExists() {
        return Files.isDirectory(localPath);
    }

    public boolean isFileExists() {
        return Files.isRegularFile(localPath);
    }

    public void safeMkdir() {
        if (isFolderExists()) return;
        file.mkdir();

    }

    public void safeFileCreate() {
        if (isFileExists()) return;
        try {
            Files.createFile(localPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//    public boolean isFolderExists(String localPath) {
//        return Files.isDirectory(Paths.get(USER_DIR_PATH + File.separator + localPath));
//    }
//
//    public boolean isFileExists(String localPath) {
//        return Files.isRegularFile(Paths.get(USER_DIR_PATH + File.separator + localPath));
//    }
}
