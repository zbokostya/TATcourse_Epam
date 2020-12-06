package collections.util;

public enum  AudioStyle {
    AFRICAN("african"),
    ASIAN("asian"),
    AVANT_GARDE("avant-garde"),
    BLUES("blues"),
    CARIBBEAN("Caribbean"),
    ELECTRONIC("Electronic"),
    EASY_LISTENING("easy-listening"),
    COUNTRY("country"),
    FOLK("folk"),
    HIP_HOP("hip-hop"),
    JAZZ("jazz"),
    LATIN("latin"),
    POP("pop"),
    ROCK("rock"),
    CLASSICAL("Classical");
    private final String description;
    AudioStyle(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
