package org.pams;

import org.pams.controller.AccountController;
import org.pams.repository.AccountRepository;
import org.pams.repository.AccountRepositoryImpl;
import org.pams.services.AccountService;
import org.pams.services.AccountServiceImpl;
import org.pams.dbcontext.InMemoryDbContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        InMemoryDbContext db =
                new InMemoryDbContext();

        AccountRepository repository =
                new AccountRepositoryImpl(db);

        AccountService service =
                new AccountServiceImpl(repository);

        AccountController controller =
                new AccountController(service);

        Scanner scanner =
                new Scanner(System.in);

        while(true) {

            System.out.println();
            System.out.println("===== CAMS =====");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Display Platinum Accounts");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":
                    controller.displayAllAccounts();
                    break;

                case "2":
                    controller.displayPlatinumAccounts();
                    break;

                case "0":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}