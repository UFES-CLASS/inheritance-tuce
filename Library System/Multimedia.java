package Library;

// SUBCLASS dari LibraryItem (INHERITANCE)
public class Multimedia extends LibraryItem {
    private String type;
    private String duration;

    // Constructor OVERLOADING - tanpa duration
    public Multimedia(String itemId, String title, String type) {
        super(itemId, title);
        this.type = type;
        this.duration = "Unknown";
    }

    // Constructor OVERLOADING - dengan duration
    public Multimedia(String itemId, String title, String type, String duration) {
        super(itemId, title);
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public String getDuration() {
        return duration;
    }

    // OVERRIDING getInfo() dari LibraryItem
    @Override
    public String getInfo() {
        return "Multimedia{itemId='" + itemId + "', title='" + title +
                "', type='" + type + "', duration='" + duration +
                "', available=" + available + "}";
    }

    // OVERRIDING toString() dari Object
    @Override
    public String toString() {
        return getInfo();
    }

    // Static method untuk data multimedia awal
    public static Multimedia[] getInitialMultimedia() {
        return new Multimedia[]{
            new Multimedia("MM001", "Introduction to Java", "Video", "2h 30m"),
            new Multimedia("MM002", "Data Structures Explained", "Audio", "1h 45m")
        };
    }
}
