package pl.pretius.commons;

public enum PathEnum {

    HOME("HOME"),
    DEV("DEV"),
    TEST("TEST");

    private final String path;

    PathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
