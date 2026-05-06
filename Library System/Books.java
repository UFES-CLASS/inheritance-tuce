package Library;

// SUBCLASS dari LibraryItem (INHERITANCE)
public class Books extends LibraryItem {
    private String author;
    private String genre;

    // Constructor OVERLOADING - tanpa genre
    public Books(String itemId, String title, String author) {
        super(itemId, title);   // memanggil constructor superclass
        this.author = author;
        this.genre = "General";
    }

    // Constructor OVERLOADING - dengan genre
    public Books(String itemId, String title, String author, String genre) {
        super(itemId, title);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    // OVERRIDING getInfo() dari LibraryItem
    @Override
    public String getInfo() {
        return "Books{itemId='" + itemId + "', title='" + title +
                "', author='" + author + "', genre='" + genre +
                "', available=" + available + "}";
    }

    // OVERRIDING toString() dari Object
    @Override
    public String toString() {
        return getInfo();
    }

    // Static method untuk data buku awal
    public static Books[] getInitialBooks() {
        return new Books[]{
            new Books("B001", "Bumi", "Tere Liye", "Fiction"),
            new Books("B002", "Bedebah di Ujung Tanduk", "Tere Liye", "Fiction"),
            new Books("B003", "Mariposa", "Luluk HF", "Romance"),
            new Books("B004", "Atomic Habits", "James Clear", "Self-Help"),
            new Books("B005", "Sirah Nabawiyah", "Syekh Shofiyyurahman Al-mubarakfuri", "Religion")
        };
    }
}
