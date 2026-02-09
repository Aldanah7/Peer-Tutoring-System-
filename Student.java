
public class Student extends Person {

    public Student(String name, String email) {
        super(name, email);
    }

    public void display() {
        System.out.println("Student Name: " + getName() + " | Email: " + getEmail());
    }
}
