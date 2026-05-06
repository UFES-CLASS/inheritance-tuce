package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Librarian sekarang mengelola semua data (tidak perlu LibrarySystem)
        Librarian librarian = new Librarian("L001", "Tubagus");

        // Register default members
        Member member1 = new Member("M001", "Zaina", "08123456789");
        Member member2 = new Member("M002", "Razzan", "08987654321");

        librarian.registerMember(member1);
        librarian.registerMember(member2);

        // Add default books menggunakan OVERLOADING (dengan genre)
        librarian.addBook("B001", "Bumi", "Tere Liye", "Fiction");
        librarian.addBook("B002", "Bedebah di Ujung Tanduk", "Tere Liye", "Fiction");
        librarian.addBook("B003", "Mariposa", "Luluk HF", "Romance");
        librarian.addBook("B004", "Atomic Habits", "James Clear", "Self-Help");
        librarian.addBook("B005", "Sirah Nabawiyah", "Syekh Shofiyyurahman Al-mubarakfuri", "Religion");

        // Add default multimedia menggunakan OVERLOADING (dengan duration)
        librarian.addMultimedia("MM001", "Introduction to Java", "Video", "2h 30m");
        librarian.addMultimedia("MM002", "Data Structures Explained", "Audio", "1h 45m");

        System.out.println("\nDefault members, books, and multimedia have been added!");
        System.out.println("Librarian Info: " + librarian.getInfo());  // test OVERRIDING

        int choice;

        do {
            System.out.println("\n===============================");
            System.out.println("   LIBRARY BORROWING SYSTEM");
            System.out.println("===============================");
            System.out.println("1.  Register New Member");
            System.out.println("2.  Add New Book (without genre)");
            System.out.println("3.  Add New Book (with genre)");
            System.out.println("4.  Add Multimedia (without duration)");
            System.out.println("5.  Add Multimedia (with duration)");
            System.out.println("6.  Search Item by Title");
            System.out.println("7.  Borrow Item");
            System.out.println("8.  Return Item");
            System.out.println("9.  Display All Books");
            System.out.println("10. Display All Multimedia");
            System.out.println("11. Display All Members");
            System.out.println("12. Display All Borrow Records");
            System.out.println("0.  Exit");
            System.out.print("Choose menu: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Register New Member ---");
                    System.out.print("Enter Member ID: ");
                    String memberId = input.nextLine();
                    System.out.print("Enter Member Name: ");
                    String memberName = input.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = input.nextLine();

                    Member newMember = new Member(memberId, memberName, phone);
                    librarian.registerMember(newMember);
                    System.out.println("Member successfully registered!");
                    System.out.println("Member Info: " + newMember.getInfo()); // test OVERRIDING
                    break;

                case 2:
                    // OVERLOADING addBook - tanpa genre
                    System.out.println("\n--- Add New Book (without genre) ---");
                    System.out.print("Enter Book ID: ");
                    String bookId2 = input.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title2 = input.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author2 = input.nextLine();

                    librarian.addBook(bookId2, title2, author2);
                    System.out.println("Book successfully added (genre: General)!");
                    break;

                case 3:
                    // OVERLOADING addBook - dengan genre
                    System.out.println("\n--- Add New Book (with genre) ---");
                    System.out.print("Enter Book ID: ");
                    String bookId3 = input.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title3 = input.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author3 = input.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre3 = input.nextLine();

                    librarian.addBook(bookId3, title3, author3, genre3);
                    System.out.println("Book successfully added!");
                    break;

                case 4:
                    // OVERLOADING addMultimedia - tanpa duration
                    System.out.println("\n--- Add Multimedia (without duration) ---");
                    System.out.print("Enter Multimedia ID: ");
                    String mmId4 = input.nextLine();
                    System.out.print("Enter Title: ");
                    String mmTitle4 = input.nextLine();
                    System.out.print("Enter Type (Video/Audio/DVD): ");
                    String mmType4 = input.nextLine();

                    librarian.addMultimedia(mmId4, mmTitle4, mmType4);
                    System.out.println("Multimedia successfully added!");
                    break;

                case 5:
                    // OVERLOADING addMultimedia - dengan duration
                    System.out.println("\n--- Add Multimedia (with duration) ---");
                    System.out.print("Enter Multimedia ID: ");
                    String mmId5 = input.nextLine();
                    System.out.print("Enter Title: ");
                    String mmTitle5 = input.nextLine();
                    System.out.print("Enter Type (Video/Audio/DVD): ");
                    String mmType5 = input.nextLine();
                    System.out.print("Enter Duration (e.g. 1h 30m): ");
                    String mmDur5 = input.nextLine();

                    librarian.addMultimedia(mmId5, mmTitle5, mmType5, mmDur5);
                    System.out.println("Multimedia successfully added!");
                    break;

                case 6:
                    System.out.println("\n--- Search Item by Title ---");
                    System.out.print("Enter keyword: ");
                    String searchKw = input.nextLine();

                    LibraryItem found = librarian.findItemByTitle(searchKw);
                    if (found != null) {
                        System.out.println("Item Found: " + found.getInfo()); // test OVERRIDING
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- Borrow Item ---");
                    System.out.print("Enter Record ID: ");
                    String recordId = input.nextLine();
                    System.out.print("Enter Member ID: ");
                    String borrowMemberId = input.nextLine();
                    System.out.print("Enter Item Title: ");
                    String borrowTitle = input.nextLine();
                    System.out.print("Enter Borrow Date (YYYY-MM-DD): ");
                    String borrowDate = input.nextLine();

                    Member borrower = librarian.findMemberById(borrowMemberId);
                    if (borrower == null) {
                        System.out.println("Member not found. Please register first.");
                    } else {
                        librarian.recordBorrow(recordId, borrower, borrowTitle, borrowDate);
                    }
                    break;

                case 8:
                    System.out.println("\n--- Return Item ---");
                    System.out.print("Enter Item Title: ");
                    String returnTitle = input.nextLine();
                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    String returnDate = input.nextLine();

                    librarian.recordReturn(returnTitle, returnDate);
                    break;

                case 9:
                    librarian.displayAllBooks();
                    break;

                case 10:
                    librarian.displayAllMultimedia();
                    break;

                case 11:
                    librarian.displayAllMembers();
                    break;

                case 12:
                    librarian.displayAllRecords();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid menu choice!");
            }

        } while (choice != 0);

        input.close();
    }
}
