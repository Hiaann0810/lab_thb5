/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5;

/**
 *
 * @author vietthanh
 */
public class Theory extends Room{
    private final static String label = "T";
    private boolean isProjector;
    // constructor
    public Theory(String roomId, int num, double area, int numberOfBulbs, boolean isProjector) {
        super(label+roomId, num, area, numberOfBulbs);
        this.isProjector = isProjector;
    }
    @Override
    public boolean isQualified() {
        return this.isProjector && super.isQualified();
    }

    public boolean isIsProjector() {
        return isProjector;
    }

    public void setIsProjector(boolean isProjector) {
        this.isProjector = isProjector;
    }
    public static Theory input(String roomId) {
        Room room = Room.input(roomId);
        boolean isProjector = Common.getBoolean("Enter isProjector: ");
        return new Theory(roomId, room.getNum(), room.getArea(), room.getNumberOfBulbs(), isProjector);
    }
    
}
