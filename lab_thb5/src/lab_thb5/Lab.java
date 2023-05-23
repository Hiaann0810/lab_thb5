/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5;

/**
 *
 * @author vietthanh
 */
public class Lab extends Room{
    private String specializedInfo;
    private int size;
    private boolean isHassink;
    private final static String label = "L";
    public Lab(String roomId, int num, double area, int numberOfBulbs, String specializedInfo, int size, boolean isHassink) {
        super(label+roomId, num, area, numberOfBulbs);
        this.specializedInfo = specializedInfo;
        this.size = size;
        this.isHassink = isHassink;       
    }
    @Override
    public boolean isQualified() {
        return this.isHassink && super.isQualified();
    }
    public String getSpecializedInfo() {
        return specializedInfo;
    }

    public void setSpecializedInfo(String specializedInfo) {
        this.specializedInfo = specializedInfo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsHassink() {
        return isHassink;
    }

    public void setIsHassink(boolean isHassink) {
        this.isHassink = isHassink;
    }
    public static Lab input(String roomId){
    Room room = Room.input(roomId);
    String specializedInfo = Common.getString("Enter specializedInfo: ");
    int size = Common.getInt("Enter size: ");
    boolean isHassink = Common.getBoolean("Enter isHassink: ");
    return new Lab(roomId, room.getNum(), room.getArea(), room.getNumberOfBulbs(), specializedInfo, size, isHassink);
  }
}
