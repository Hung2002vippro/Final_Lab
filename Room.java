package final_lab;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Room implements IRoom {

    private String id;
    private String name;
    private double baseCost;
    private Date checkinDate;
    private Date checkoutDate;

    public Room(String id, String name, double baseCost, Date checkinDate, Date checkoutDate) {
        this.id = id;
        this.name = name;
        this.baseCost = baseCost;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", baseCost=" + baseCost + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate + '}';
    }

    @Override
    public abstract double calculateCost();

    @Override
    public void enterRoomInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id: ");
        this.id = sc.nextLine();
        System.out.println("Nhap name: ");
        this.name = sc.nextLine();
        System.out.println("Nhap id: ");
        this.baseCost = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhap check in day(yyyy-MM-dd): ");
        try {
            this.checkinDate = new SimpleDateFormat("yyyy-MM-dd").parse(sc.nextLine());
            System.out.println("Nhap check out day(yyyy-MM-dd): ");
            this.checkoutDate = new SimpleDateFormat("YYYY-MM-dd").parse(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid Date Format");
        }
    }

    @Override
    public void updateRoomById(String id) {
        if (this.id.equals(id)) {
            enterRoomInfo();
        } else {
            System.out.println("Not find room");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println(toString());
    }

    public long calculateDayStays() {
        long daystay = checkoutDate.getTime() - checkinDate.getTime();
        return daystay / (1000 * 60 * 60 * 24);
    }
    
}
