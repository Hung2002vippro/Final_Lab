package final_lab;

import java.util.*;

public class BedRoom extends Room {

    private int numberOfBeds;

    public BedRoom(int numberOfBeds, String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public double calculateCost() {
        if (getNumberOfBeds() >= 3) {
            return ((getBaseCost() * 1.1) * calculateDayStays());
        }
        return getBaseCost() * calculateDayStays();
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("NumberOfBeds: " + getNumberOfBeds());
        System.out.println("Total cost: " + calculateCost());
    }

    @Override
    public void updateRoomById(String id) {
        super.updateRoomById(id); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void enterRoomInfo() {
        super.enterRoomInfo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap NumberOfBeds: ");
        this.numberOfBeds = sc.nextInt();
    }

}
