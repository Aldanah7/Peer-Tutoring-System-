
public class Tutor extends Person {

    private static int counter = 100;
    private int id;
    private String subject;
    private boolean available;

    public Tutor(String name, String email, String subject) {
        super(name, email);
        this.id = ++counter;
        this.subject = subject;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean status) {
        this.available = status;
    }

    public boolean teachesSubject(String subj) {
        return subject.equalsIgnoreCase(subj);
    }

    public boolean nameMatches(String name) {
        return getName().equalsIgnoreCase(name);
    }

    @Override
    public String toString() {
        return "Tutor ID: " + id + " | Name: " + getName()
                + " | Subject: " + subject + " | Status: " + (available ? "Available" : "Busy");
    }

}
