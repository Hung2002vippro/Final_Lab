package final_lab;

import java.util.*;
import java.text.SimpleDateFormat;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomList roomList = new RoomList();
        int choice;
        do {
            System.out.println("\n--- Room Management System ---");
            System.out.println("1. Add a new meeting room");
            System.out.println("2. Add a new bedroom");
            System.out.println("3. Update room by ID");
            System.out.println("4. Delete room by ID");
            System.out.println("5. Find room by ID");
            System.out.println("6. Display all rooms");
            System.out.println("7. Find the most expensive room");
            System.out.println("8. Count total number of rooms");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter Meeting Room ID: ");
                    String meetingRoomId = scanner.nextLine();
                    System.out.print("Enter Meeting Room Name: ");
                    String meetingRoomName = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double meetingRoomCost = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Check-in Date (yyyy-MM-dd): ");
                    String checkinDateStr = scanner.nextLine();
                    System.out.print("Enter Check-out Date (yyyy-MM-dd): ");
                    String checkoutDateStr = scanner.nextLine();
                    System.out.print("Enter Capacity: ");
                    int meetingRoomCapacity = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Date checkinDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkinDateStr);
                        Date checkoutDate = new SimpleDateFormat("yyyy-MM-dd").parse(checkoutDateStr);
                        roomList.addRoom(new MeetingRoom(meetingRoomCapacity, meetingRoomId, meetingRoomName, meetingRoomCost, checkinDate, checkoutDate));
                        System.out.println("Meeting Room added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid date format!");
                    }
                    break;

                case 2:

                    System.out.print("Enter Bedroom ID: ");
                    String bedRoomId = scanner.nextLine();
                    System.out.print("Enter Bedroom Name: ");
                    String bedRoomName = scanner.nextLine();
                    System.out.print("Enter Base Cost: ");
                    double bedRoomCost = scanner.nextDouble();
                    scanner.nextLine();  // Consume the newline character
                    System.out.print("Enter Check-in Date (yyyy-MM-dd): ");
                    String bedCheckinDateStr = scanner.nextLine();
                    System.out.print("Enter Check-out Date (yyyy-MM-dd): ");
                    String bedCheckoutDateStr = scanner.nextLine();
                    System.out.print("Enter Number of Beds: ");
                    int numberOfBeds = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Date bedCheckinDate = new SimpleDateFormat("yyyy-MM-dd").parse(bedCheckinDateStr);
                        Date bedCheckoutDate = new SimpleDateFormat("yyyy-MM-dd").parse(bedCheckoutDateStr);

                        roomList.addRoom(new BedRoom(numberOfBeds, bedRoomId, bedRoomName, bedRoomCost, bedCheckinDate, bedCheckoutDate));
                        System.out.println("Bedroom added successfully.");
                    } catch (Exception e) {
                        System.out.println("Invalid date format!");
                    }
                    break;

                case 3:

                    System.out.print("Enter the Room ID to update: ");
                    String updateId = scanner.nextLine();
                    roomList.updateRoomById(updateId);
                    System.out.println("Room updated successfully.");
                    break;

                case 4:

                    System.out.print("Enter the Room ID to delete: ");
                    String deleteId = scanner.nextLine();
                    roomList.deleteRoomById(deleteId);
                    System.out.println("Room deleted successfully.");
                    break;

                case 5:

                    System.out.print("Enter Room ID to find: ");
                    String findId = scanner.nextLine();
                    roomList.findRoomById(findId);
                    break;

                case 6:

                    roomList.displayAllRooms();
                    break;

                case 7:

                    Room mostExpensive = roomList.findMostExpensiveRoom();
                    if (mostExpensive != null) {
                        mostExpensive.displayDetails();
                    } else {
                        System.out.println("No rooms found.");
                    }
                    break;

                case 8:

                    roomList.countRooms();
                    break;

                case 9:

                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}
