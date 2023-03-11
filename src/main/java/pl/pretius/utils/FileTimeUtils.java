package pl.pretius.utils;

import java.nio.file.attribute.FileTime;
import java.time.Clock;
import java.time.ZoneId;

public class FileTimeUtils {

    private final ZoneId systemZoneId = Clock.systemDefaultZone().getZone();

    public int extractHour(FileTime fileTime) {
        return fileTime.toInstant().atZone(systemZoneId).getHour();
    }

}
