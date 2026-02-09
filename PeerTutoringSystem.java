
import java.util.Scanner;

public class PeerTutoringSystem {
    private SinglyLinkedList<Tutor> tutors;
    private LLQueue<Booking> bookings;
    private Scanner input;

    public PeerTutoringSystem() {
        tutors = new SinglyLinkedList<>();
        bookings = new LLQueue<>();
        input = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.print("\n ---Welcome To Peer Tutoring System--- \n1. Add Tutor\n2. Create Booking\n3. List Tutors\n4. List Bookings\n5. Execute Next Booking\n6. Peek Next Booking\n7. Exit\n>> ");
    }

    public void addTutor() {
        input.nextLine();
        System.out.print("Tutor Name: ");
        String name = input.nextLine();
        System.out.print("Tutor Email: ");
        String email = input.nextLine();
        System.out.print("Subject: ");
        String subject = input.nextLine();
        Tutor t = new Tutor(name, email, subject);
        tutors.addLast(t);
        System.out.println("Tutor added successfully!");
        t.toString();
    }

    public void createBooking() {
        if (tutors.isEmpty()) { System.out.println("No tutors available!"); return; }

        input.nextLine();
        System.out.print("Student Name: ");
        String student = input.nextLine();
        System.out.print("Student Email: ");
        String email = input.nextLine();
        System.out.print("Tutor ID: ");
        int tutorId = input.nextInt();
        Tutor tutor = tutors.searchTutorById(tutorId);
        if (tutor == null) { System.out.println("Tutor not found!"); return; }

        input.nextLine();
        System.out.print("Date (YYYY-MM-DD): ");
        String date = input.nextLine();
        System.out.print("Time (HH:MM): ");
        String time = input.nextLine();

        Booking b = new Booking(student, email, tutor, date, time);
        bookings.add(b);
        System.out.println("Booking created successfully!");
        b.printBooking();
    }

    public void listTutors() { tutors.printAll(); }
    public void listBookings() { bookings.displayAll(); }

    public void executeNextBooking() {
        Booking b = bookings.remove();
        if (b == null) { System.out.println("No bookings to execute."); return; }
        System.out.println("Executing booking:");
        b.printBooking();
    }

    public void peekNextBooking() {
        Booking b = bookings.peek();
        if (b == null) System.out.println("No bookings in queue.");
        else {
            System.out.println("Next booking in queue:");
            b.printBooking();
        }
    }

    public void loadSampleData() {
        Tutor t1 = new Tutor("Ahmed Ali", "ahmed@uni.edu", "Mathematics");
        Tutor t2 = new Tutor("Fatima Hassan", "fatima@uni.edu", "Physics");
        tutors.addLast(t1);
        tutors.addLast(t2);
        Booking b1 = new Booking("Layla Ibrahim", "layla@student.edu", t1, "2025-11-10", "10:00");
        bookings.add(b1);
    }
}