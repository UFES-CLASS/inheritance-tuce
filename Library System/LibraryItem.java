package Library;

// SUPERCLASS - Parent class untuk Books dan Multimedia
public abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected boolean available;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.available = true;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Abstract method - WAJIB di-override oleh subclass
    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo();
    }
}
