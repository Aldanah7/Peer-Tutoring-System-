
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PeerTutoringSystem system = new PeerTutoringSystem();
        system.loadSampleData();

        int option = 0;
        do {
            try {
                system.showMenu();
                option = input.nextInt();
                switch (option) {
                    case 1:
                        system.addTutor();
                        break;
                    case 2:
                        system.createBooking();
                        break;
                    case 3:
                        system.listTutors();
                        break;
                    case 4:
                        system.listBookings();
                        break;
                    case 5:
                        system.executeNextBooking();
                        break;
                    case 6:
                        system.peekNextBooking();
                        break;
                    case 7:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input, please enter a number.");
                input.next();
            }
        } while (option != 7);
    }
}


