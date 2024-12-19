package final_lab;

import java.util.*;

public class RoomList {

    ArrayList<IRoom> roomList;

    public RoomList() {
        roomList = new ArrayList();
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public void updateRoomById(String id) {
        for (IRoom room : roomList) {
            room.updateRoomById(id);
        }
    }

    public void deleteRoomById(String id) {
        roomList.removeIf(room -> ((Room) room).getId().equals(id));

    }

    public void findRoomById(String id) {
        for (IRoom room : roomList) {
            if (((Room) room).getId().equals(id)) {
                room.displayDetails();
                return;
            }
        }
        System.out.println("Room not found");
    }

    public void displayAllRooms() {
        for (IRoom room : roomList) {
            room.displayDetails();
        }
    }

    public Room findMostExpensiveRoom() {
        Room mostExpensiveRoom = null;
        double maxCost = 0;
        for (IRoom room : roomList) {
            if (room.calculateCost() > maxCost) {
                maxCost = room.calculateCost();
                mostExpensiveRoom = ((Room) room);
            }
        }
        return mostExpensiveRoom;
    }

    public void countRooms() {
        int countMeetingRoom = 0;
        int countBedRoom = 0;
        for (IRoom room : roomList) {
            if (room instanceof MeetingRoom) {
                countMeetingRoom++;
            } else if (room instanceof BedRoom) {
                countBedRoom++;
            }
        }
        System.out.println("Total Meeting Room= " + countMeetingRoom);
        System.out.println("Total Bed Room= " + countBedRoom);
    }

}
