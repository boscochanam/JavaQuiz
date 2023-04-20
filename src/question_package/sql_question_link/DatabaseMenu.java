package question_package.sql_question_link;

import java.util.Scanner;

public class DatabaseMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Enter your choice:");
            System.out.println("1. MCQ Database");
            System.out.println("2. Desc Database");
            System.out.println("3. Int Database");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    MCQ_Updt.main(args);
                    break;
                case 2:
                    Desc_Updt.main(args);
                    break;
                case 3:
                    Int_Updt.main(args);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
