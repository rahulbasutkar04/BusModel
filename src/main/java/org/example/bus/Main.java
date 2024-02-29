package org.example.bus;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Bus Booking System!");
        System.out.print("Enter the capacity of the bus: ");
        int capacity = scanner.nextInt();
        Bus bus = new Bus(capacity);

        int choice;
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check available space");
            System.out.println("2. Book a ticket");
            System.out.println("3. Display total fare");
            System.out.println("4. Display passenger list");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int availableSpace = bus.getVacancy();
                    System.out.println("Available space in the bus: " + availableSpace);
                    break;
                case 2:
                    try {
                        System.out.print("Enter passenger ID: ");
                        int id = scanner.nextInt();
                        if (bus.getPassenger().containsKey(id)) {
                            throw new NoVacantSeatException("ID already booked. Please choose another ID.");
                        }
                        System.out.print("Enter passenger name: ");
                        String name = scanner.next();
                        System.out.print("Enter fare: ");
                        float fare = scanner.nextFloat();
                        bus.OnBoardPassenger(id, name, fare);
                        System.out.println("Ticket booked successfully!");
                    } catch (NoVacantSeatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    float totalFare = bus.getTotalfare();
                    System.out.println("Total fare collected: " + totalFare);
                    break;

                case 4: // Display passenger list option
                    List<String> passengers = bus.displayPassenger();
                    if (!passengers.isEmpty()) {
                        System.out.println("Passenger List:");
                        for (String passenger : passengers) {
                            System.out.println(passenger);
                        }
                    } else {
                        System.out.println("No passengers on board.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
