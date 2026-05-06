package Library;

import java.util.ArrayList;

// SUBCLASS dari Person (INHERITANCE)
public class Librarian extends Person {
    private ArrayList<Books> catalog;
    private ArrayList<Multimedia> multimedia;
    private ArrayList<Member> members;
    private ArrayList<BorrowRecord> borrowRecords;

    public Librarian(String staffId, String name) {
        super(staffId, name);   // memanggil constructor Person
        this.catalog = new ArrayList<>();
        this.multimedia = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    // ======== OVERLOADED addBook ========

    // addBook tanpa genre (OVERLOADING)
    public void addBook(String id, String title, String author) {
        Books book = new Books(id, title, author);
        catalog.add(book);
        System.out.println("Librarian added book: " + title);
    }

    // addBook dengan genre (OVERLOADING)
    public void addBook(String id, String title, String author, String genre) {
        Books book = new Books(id, title, author, genre);
        catalog.add(book);
        System.out.println("Librarian added book: " + title + " [" + genre + "]");
    }

    // ======== OVERLOADED addMultimedia ========

    // addMultimedia tanpa duration (OVERLOADING)
    public void addMultimedia(String id, String title, String type) {
        Multimedia m = new Multimedia(id, title, type);
        multimedia.add(m);
        System.out.println("Librarian added multimedia: " + title);
    }

    // addMultimedia dengan duration (OVERLOADING)
    public void addMultimedia(String id, String title, String type, String duration) {
        Multimedia m = new Multimedia(id, title, type, duration);
        multimedia.add(m);
        System.out.println("Librarian added multimedia: " + title + " [" + duration + "]");
    }

    // ======== Manage Books ========

    public void removeBook(String itemId) {
        catalog.removeIf(b -> b.getItemId().equalsIgnoreCase(itemId));
        System.out.println("Book removed: " + itemId);
    }

    public void updateBook(String itemId, String newAuthor) {
        for (Books b : catalog) {
            if (b.getItemId().equalsIgnoreCase(itemId)) {
                System.out.println("Book found: " + b.getTitle() + " - update author to: " + newAuthor);
                return;
            }
        }
        System.out.println("Book not found: " + itemId);
    }

    // ======== Manage Members ========

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Librarian registered member: " + member.getName());
    }

    public void removeMember(String memberId) {
        members.removeIf(m -> m.getId().equalsIgnoreCase(memberId));
        System.out.println("Member removed: " + memberId);
    }

    // ======== Find Items ========

    public LibraryItem findItemById(String itemId) {
        for (Books b : catalog) {
            if (b.getItemId().equalsIgnoreCase(itemId)) return b;
        }
        for (Multimedia m : multimedia) {
            if (m.getItemId().equalsIgnoreCase(itemId)) return m;
        }
        return null;
    }

    public LibraryItem findItemByTitle(String title) {
        for (Books b : catalog) {
            if (b.getTitle().equalsIgnoreCase(title)) return b;
        }
        for (Multimedia m : multimedia) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public ArrayList<LibraryItem> getAllItems() {
        ArrayList<LibraryItem> all = new ArrayList<>();
        all.addAll(catalog);
        all.addAll(multimedia);
        return all;
    }

    public Member findMemberById(String memberId) {
        for (Member m : members) {
            if (m.getId().equalsIgnoreCase(memberId)) return m;
        }
        return null;
    }

    // ======== Borrow & Return ========

    public BorrowRecord recordBorrow(String recordId, Member member, String itemTitle, String borrowDate) {
        LibraryItem item = findItemByTitle(itemTitle);

        if (item == null) {
            System.out.println("Item not found: " + itemTitle);
            return null;
        }
        if (!item.isAvailable()) {
            System.out.println("Item is currently borrowed: " + itemTitle);
            return null;
        }

        item.setAvailable(false);
        member.borrowItem(item);
        BorrowRecord record = new BorrowRecord(recordId, member, item, borrowDate);
        borrowRecords.add(record);
        System.out.println(member.getName() + " borrowed: " + item.getTitle());
        return record;
    }

    public boolean recordReturn(String itemTitle, String returnDate) {
        LibraryItem item = findItemByTitle(itemTitle);

        if (item == null) {
            System.out.println("Item not found: " + itemTitle);
            return false;
        }
        if (item.isAvailable()) {
            System.out.println("Item is not currently borrowed: " + itemTitle);
            return false;
        }

        item.setAvailable(true);

        for (BorrowRecord record : borrowRecords) {
            if (record.getItem().getTitle().equalsIgnoreCase(itemTitle) && !record.isReturned()) {
                record.setReturnDate(returnDate);
                record.getMember().returnItem(item);
                System.out.println("Item returned successfully: " + itemTitle);
                return true;
            }
        }

        System.out.println("Borrow record not found for: " + itemTitle);
        return false;
    }

    // ======== Display Methods ========

    public void displayAllBooks() {
        System.out.println("\n--- Book Catalog ---");
        if (catalog.isEmpty()) System.out.println("No books available.");
        for (Books b : catalog) System.out.println(b);
    }

    public void displayAllMultimedia() {
        System.out.println("\n--- Multimedia List ---");
        if (multimedia.isEmpty()) System.out.println("No multimedia available.");
        for (Multimedia m : multimedia) System.out.println(m);
    }

    public void displayAllMembers() {
        System.out.println("\n--- Member List ---");
        if (members.isEmpty()) System.out.println("No members registered.");
        for (Member m : members) System.out.println(m);
    }

    public void displayAllRecords() {
        System.out.println("\n--- Borrow Records ---");
        if (borrowRecords.isEmpty()) System.out.println("No borrow records.");
        for (BorrowRecord r : borrowRecords) System.out.println(r);
    }

    // OVERRIDING getInfo() dari Person
    @Override
    public String getInfo() {
        return "Librarian{id='" + id + "', name='" + name +
                "', totalBooks=" + catalog.size() +
                ", totalMultimedia=" + multimedia.size() +
                ", totalMembers=" + members.size() + "}";
    }

    // OVERRIDING toString() dari Object
    @Override
    public String toString() {
        return getInfo();
    }
}
