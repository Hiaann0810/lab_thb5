/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5;

/**
 *
 * @author vietthanh
 */
public class Computer extends Room{
    private int numComputer;
    private final static String label = "C";
    public Computer(String roomId, int num, double area, int numberOfBulbs, int numComputer) {
        super(label+roomId, num, area, numberOfBulbs);
        this.numComputer = numComputer;
    }
    @Override
    public boolean isQualified() {
        return (this.getArea()/this.numComputer) >= 1.5f && super.isQualified();      
    }

    public int getNumComputer() {
        return numComputer;
    }

    public void setNumComputer(int numComputer) {
        this.numComputer = numComputer;
    }
    public static Computer input(String roomId) {
        Room room = Room.input(roomId);
        int numComputer = Common.getInt("Enter number of computer: ");
        return new Computer(roomId, room.getNum(), room.getArea(), room.getNumberOfBulbs(), numComputer);
    }
    
}
