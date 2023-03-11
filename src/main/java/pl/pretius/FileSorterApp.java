package pl.pretius;

import pl.pretius.file.FileManager;

public class FileSorterApp {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.redirectFilesFromHomeDirectory();
    }

}