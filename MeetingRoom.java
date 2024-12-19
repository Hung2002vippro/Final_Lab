package final_lab;

import java.util.*;

public class MeetingRoom extends Room {

    private int capacity;

    public MeetingRoom(int capacity, String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        super(id, name, baseCost, checkinDate, checkoutDate);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double calculateCost() {
        if (getCapacity() > 50) {
            return ((getBaseCost() * 1.2) * calculateDayStays());
        }
        return getBaseCost() * calculateDayStays();
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Capacity: " + getCapacity());
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
        System.out.println("Nhap capacity: ");
        this.capacity = sc.nextInt();
    }

}
