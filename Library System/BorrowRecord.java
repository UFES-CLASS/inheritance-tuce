package Library;

public class BorrowRecord {
    private String recordId;
    private Member member;
    private LibraryItem item;       // diganti dari Book ke LibraryItem
    private String borrowDate;
    private String returnDate;
    private boolean returned;       // field baru sesuai class diagram

    public BorrowRecord(String recordId, Member member, LibraryItem item, String borrowDate) {
        this.recordId = recordId;
        this.member = member;
        this.item = item;
        this.borrowDate = borrowDate;
        this.returnDate = "-";
        this.returned = false;
    }

    public String getRecordId() {
        return recordId;
    }

    public Member getMember() {
        return member;
    }

    public LibraryItem getItem() {
        return item;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        this.returned = true;
    }

    public boolean isReturned() {
        return returned;
    }

    @Override
    public String toString() {
        return "BorrowRecord{recordId='" + recordId + "', item='" + item.getTitle() +
                "', member='" + member.getName() + "', borrowDate='" + borrowDate +
                "', returnDate='" + returnDate + "', returned=" + returned + "}";
    }
}
