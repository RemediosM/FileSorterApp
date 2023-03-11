package pl.pretius.file;

import org.apache.commons.io.FilenameUtils;
import pl.pretius.commons.PathEnum;
import pl.pretius.exceptions.CreateDirectoryException;
import pl.pretius.exceptions.MoveFileException;
import pl.pretius.log.FileMovementLogger;
import pl.pretius.utils.FileTimeUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.List;

public class FileManager {

    private static final String XML_EXTENSION = "xml";
    private static final String JAR_EXTENSION = "jar";
    private static final List<String> VALID_EXTENSIONS = List.of(XML_EXTENSION, JAR_EXTENSION);

    private final FileMovementLogger logger = new FileMovementLogger();
    private final FileTimeUtils fileTimeUtils = new FileTimeUtils();

    public void redirectFilesFromHomeDirectory() {
        try {
            Files.createDirectories(Paths.get(PathEnum.DEV.getPath()));
            Files.createDirectories(Paths.get(PathEnum.TEST.getPath()));
            File homePath = Files.createDirectories(Paths.get(PathEnum.HOME.getPath())).toFile();

            while (true) {
                Arrays.stream(homePath.list())
                        .filter(f -> VALID_EXTENSIONS.contains(FilenameUtils.getExtension(f)))
                        .forEach(this::moveFile);
            }
        } catch (IOException e) {
            throw new CreateDirectoryException(e.getCause());
        }
    }

    private void moveFile(String fileName) {
        String fileExtension = FilenameUtils.getExtension(fileName);
        File file = new File(PathEnum.HOME.getPath() + File.separator + fileName);

        try {
            if (XML_EXTENSION.equals(fileExtension)) {
                Files.move(file.toPath(), Path.of(PathEnum.DEV.getPath() + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
                logger.logMovement(PathEnum.DEV);
            } else if (JAR_EXTENSION.equals(fileExtension)) {
                FileTime creationDate = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
                if (fileTimeUtils.extractHour(creationDate) % 2 == 0) {
                    Files.move(file.toPath(), Path.of(PathEnum.DEV.getPath() + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
                    logger.logMovement(PathEnum.DEV);
                } else {
                    Files.move(file.toPath(), Path.of(PathEnum.TEST.getPath() + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
                    logger.logMovement(PathEnum.TEST);
                }
            }
        } catch (IOException e) {
            throw new MoveFileException(e.getCause());
        }
    }

}
