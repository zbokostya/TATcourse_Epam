package collections.entity;


import java.time.Duration;
import java.util.Objects;

public abstract class Composition {
    private String name;
    private Duration duration;
    private String artist;

    public Composition() {
    }

    public Composition(String name, Duration duration, String artist) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition that = (Composition) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(artist, that.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, artist);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Composition{");
        sb.append("name='").append(name).append('\'');
        sb.append(", duration=").append(duration.toMinutes());
        sb.append(" ").append(duration.getSeconds() % 60);
        sb.append(", artist='").append(artist).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
