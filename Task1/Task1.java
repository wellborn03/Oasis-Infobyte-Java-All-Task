
import java.util.Scanner;
import java.util.regex.*;

class Demo {

    static boolean[] seats = new boolean[10]; // initialize an array of 10 seats, all empty

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("If You Want Reserved Your Seats Then \nFirst Up All Login With Your UserName And Password");
        System.out.println("\n\n");
        System.out.println("If you want to login plz enter 'yes' otherwise 'no'");
        String str1 = in.nextLine();
        if (str1.equals("yes")) {
            System.out.println("Enter your email..");
            String str = in.nextLine();
            Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
            Matcher m = p.matcher(str);
            if (m.find() && m.group().equals(str)) {
                System.out.println("Proceed to Password");
            } else {
                System.out.println("Plz Enter valid Username..");
            }

            System.out.println("\n");
            System.out.println("Enter the Password..");
            String pw = in.nextLine();
            Pattern pt = Pattern.compile("Admin");
            Matcher mh = pt.matcher(pw);
            if (mh.find() && mh.group().equals(pw)) {
                System.out.println("You are succesfully Login..");
            } else {
                System.out.println("Plz Enter valid Password...");
            }
        } else {
            System.exit(0);
        }

        while (true) {

            // display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. See the Total seats");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // get user input
            int option = in.nextInt();

            switch (option) {

                case 1:
                    seatCollection();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void seatCollection() {
        System.out.println("\nCurrent Seat Are:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print an "X" if the seat is reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = in.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}