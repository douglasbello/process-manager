package program;

import entities.Process;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Process process = new Process();

        int choice;

        do {
            System.out.println("""
                Welcome!
                To list all the processes running type: 1
                Suspend process by id: 2
                Suspend process by name: 3
                Kill process by id: 4
                Kill process by name: 5
                Resume process by id: 6
                Resume process by name: 7
                Exit the menu: 0""");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    List<Process> processes = process.getAllProcesses();
                    process.listAllProcesses(processes);
                }
                case 2 -> {
                    System.out.println("Process id: ");
                    long pid = scanner.nextLong();
                    process.suspendProcessByPid(pid);
                }
                case 3 -> {
                    System.out.println("Process name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    process.suspendProcessByName(name);
                }
                case 4 -> {
                    System.out.println("Process id: ");
                    long killPid = scanner.nextLong();
                    process.killProcessByPid(killPid);
                }
                case 5 -> {
                    System.out.println("Process name: ");
                    scanner.nextLine();
                    String killName = scanner.nextLine();
                    process.killProcessByName(killName);
                }
                case 6 -> {
                    System.out.println("Process id: ");
                    long resumePid = scanner.nextLong();
                    process.resumeProcessByPid(resumePid);
                }
                case 7 -> {
                    System.out.println("Process name: ");
                    scanner.nextLine();
                    String resumeName = scanner.nextLine();
                    process.resumeProcessByName(resumeName);
                }
                case 0 -> System.out.println("Breaking...");
                default -> System.out.println("Invalid option");
            }

        } while (choice != 0);
        scanner.close();
    }
}