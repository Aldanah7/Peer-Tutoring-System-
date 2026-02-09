
public class Booking implements Bookable {

    private static int counter = 500;
    private int id;
    private String studentName;
    private String studentEmail;
    private int tutorId;
    private String tutorName;
    private String subject;
    private String bookingDate;
    private String bookingTime;

    public Booking(String studentName, String studentEmail, Tutor tutor, String bookingDate, String bookingTime) {
        this.id = ++counter;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.tutorId = tutor.getId();
        this.tutorName = tutor.getName();
        this.subject = tutor.getSubject();
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void printBooking() {
        System.out.println("Booking ID: " + id + " | Student: " + studentName
                + " | Tutor: " + tutorName + " | Subject: " + subject
                + " | Date: " + bookingDate + " | Time: " + bookingTime);
    }

    public boolean isForStudent(String name) {
        return studentName.equalsIgnoreCase(name);
    }

    public boolean isForTutor(int tutorId) {
        return this.tutorId == tutorId;
    }

    @Override
    public String toString() {
        return ("Booking ID: " + id + " | Student: " + studentName
                + " | Tutor: " + tutorName + " | Subject: " + subject
                + " | Date: " + bookingDate + " | Time: " + bookingTime);
    }

    @Override
    public void printBookingInfo() {
        printBooking();
    }
}
