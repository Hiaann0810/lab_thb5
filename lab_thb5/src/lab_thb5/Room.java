/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5;

/**
 *
 * @author vietthanh
 */
public class Room {
    private String roomId;
    private int num;
    private double area;
    private int numberOfBulbs;
    // constructor
    public Room(String roomId, int num, double area, int numberOfBulbs){
        this.roomId = roomId;
        this.num = num;
        this.area = area;
        this.numberOfBulbs = numberOfBulbs;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfBulbs() {
        return numberOfBulbs;
    }

    public void setNumberOfBulbs(int numberOfBulbs) {
        this.numberOfBulbs = numberOfBulbs;
    }
    @Override
    public String toString() {
        return String.format("%20s %10s %15s %10s", roomId, num, area, numberOfBulbs);
    }
    public boolean isQualified() {
        return (this.area / this.num) >= 10;
    }
    public static Room input(String roomId) {
        int num = Common.getInt("Enter number: ");
        double area = Common.getDouble("Enter area: ");
        int numberOfBulbs = Common.getInt("Enter number of bulbs: ");
        return new Room(roomId, num, area, numberOfBulbs);
        
    }
}
