package Task3;

import java.util.*;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username:");
        String name = sc.next();
        System.out.println("Enter your pin:");
        sc.next();
        System.out.println("Login Successful!!\n\nWelcome " + name);

        int bal = 0, n;
        String hist = "";
        do {
            System.out.println(
                    "\n\nChoose your options \n1.Withdraw \n2.Deposit \n3.Transfer \n4.Transaction History \n5.Exit");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    System.out.println("Enter withdrawl amount:");
                    int x = sc.nextInt();
                    if (bal >= x) {
                        bal -= x;
                        System.out.println("Operation Successfull");
                        hist += String.valueOf(x) + " Amount withdrawn\n";
                    } else
                        System.out.println("Operation Failed");
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    int y = sc.nextInt();
                    if (y <= 50000) {
                        bal += y;
                        System.out.println("Operation Successfull");
                        hist += String.valueOf(y) + " Amount deposited\n";
                    } else
                        System.out.println("Amount is too large\n Sorry can't deposit");
                    break;

                case 3:
                    System.out.println("Enter amount to transfer");
                    int z = sc.nextInt();
                    System.out.println("Enter account holders username to transfer money to");
                    String trans = sc.next();
                    bal -= z;
                    System.out.println("Operation Successfull");
                    hist += String.valueOf(z) + " amount transferred to " + trans + "\n";
                    break;

                case 4:
                    System.out.println("Your transaction history is:\n" + hist);

                case 5:
                    break;
            }
            System.out.println("Do you want to continue?\n1.Yes\n2.No");
            n = sc.nextInt();
        } while (n == 1);
        sc.close();
    }
}