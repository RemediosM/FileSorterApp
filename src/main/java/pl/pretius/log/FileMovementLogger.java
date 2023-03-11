package pl.pretius.log;

import pl.pretius.commons.PathEnum;
import pl.pretius.exceptions.LogFileException;

import java.io.*;

public class FileMovementLogger {

    private static final String LOG_FILE_NAME = PathEnum.HOME.getPath() + File.separator +  "count.txt";

    private long movedToDev;
    private long movedToTest;

    public void logMovement(PathEnum destination) {
        try(FileWriter fileWriter = new FileWriter(LOG_FILE_NAME, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter))
        {
            if (PathEnum.DEV.equals(destination)) {
                movedToDev++;
            } else if (PathEnum.TEST.equals(destination)) {
                movedToTest++;
            }
            long all = movedToDev + movedToTest;
            printWriter.println("All: " + all);
            printWriter.println(PathEnum.DEV + ": " + movedToDev);
            printWriter.println(PathEnum.TEST + ": " + movedToTest);
        } catch (IOException e) {
            throw new LogFileException(e.getCause());
        }
    }

}
