package Library;

import java.util.ArrayList;

// SUBCLASS dari Person (INHERITANCE)
public class Member extends Person {
    private String phone;
    private ArrayList<LibraryItem> borrowedItems;
    private int borrowCount;

    public Member(String memberId, String name, String phone) {
        super(memberId, name);  // memanggil constructor Person
        this.phone = phone;
        this.borrowedItems = new ArrayList<>();
        this.borrowCount = 0;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public ArrayList<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
        borrowCount++;
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    // METHOD OVERLOADING - searchItem tanpa keyword (cari semua)
    public LibraryItem searchItem(LibraryItem[] catalog, int size) {
        System.out.println("Searching first " + size + " items in catalog...");
        if (catalog != null && catalog.length > 0 && size > 0) {
            return catalog[0];
        }
        return null;
    }

    // METHOD OVERLOADING - searchItem dengan keyword
    public LibraryItem searchItem(LibraryItem[] catalog, int size, String kw) {
        System.out.println("Searching for keyword: '" + kw + "'");
        for (int i = 0; i < size && i < catalog.length; i++) {
            if (catalog[i].getTitle().toLowerCase().contains(kw.toLowerCase())) {
                return catalog[i];
            }
        }
        return null;
    }

    // OVERRIDING getInfo() dari Person
    @Override
    public String getInfo() {
        return "Member{id='" + id + "', name='" + name +
                "', phone='" + phone + "', borrowCount=" + borrowCount + "}";
    }

    // OVERRIDING toString() dari Object
    @Override
    public String toString() {
        return getInfo();
    }
}
