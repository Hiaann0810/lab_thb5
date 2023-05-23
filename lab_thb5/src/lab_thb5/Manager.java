/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_thb5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vietthanh
 */
public class Manager {
    private List<Room> listroom = new ArrayList<Room>();
    private Room findById(String roomId) {
        for (Room room : listroom) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }
    private List<Room> sortByNum() {
        List<Room> listroomx = this.listroom;
        listroomx.sort((o1, o2) -> o1.getNum() - o2.getNum());
        this.listroom = listroomx;
        return listroomx;
    }
    private List<Room> sortByArea() {
        List<Room> listroomx = this.listroom;
        listroomx.sort((o1, o2) -> (int) (o1.getArea() - o2.getArea()));
        this.listroom = listroomx;
        return listroomx;
    }
    private List<Room> sortByBulbs() {
        List<Room> listroomx = this.listroom;
        listroomx.sort((o1, o2) -> o1.getNumberOfBulbs() - o2.getNumberOfBulbs());
        this.listroom = listroomx;
        return listroomx;
    }
    private void Print(List<Room> listroomx) {
        System.out.println(String.format("%20s %10s %15s %10s", "RoomId", "Num", "Area", "numberOfBulbs"));
        for (Room room : this.listroom) {
                System.out.println(room);
        }
    }
    private void checklistQualified() {
        System.out.println("List of qualified room: ");
        System.out.println(String.format("%20s %10s %15s %10s", "RoomId", "Num", "Area", "numberOfBulbs"));
        for (Room room : this.listroom) {
            if(room.isQualified()) {
                System.out.println(room);
            }
        }
    }
    private void updateComputerInroom(String roomId, int numComputer){
        Computer room = (Computer)this.findById(roomId);
        if(room != null)
        {
            room.setNumComputer(numComputer);
            for(int i = 0; i < listroom.size(); i++)
            {
                if(listroom.get(i).getRoomId().equals(roomId))
                {
                    listroom.remove(i);
                    listroom.add(i, room);
                }
            }
        }
    }
    private void init() {
        this.listroom.add(new Computer("1", 1, 100, 10, 2));
        this.listroom.add(new Computer("2", 2, 200, 20, 4));
        this.listroom.add(new Computer("3", 3, 300, 30, 6));
        this.listroom.add(new Computer("4", 4, 400, 40, 8));
        this.listroom.add(new Lab ("5",1,100,10,"TECH",1,true));
        this.listroom.add(new Lab ("6",2,200,20,"TECH",2,true));
        this.listroom.add(new Lab ("7",3,300,30,"TECH",3,true));
        this.listroom.add(new Lab ("9",4,400,40,"TECH",4,true));
        this.listroom.add(new Theory("9", 1, 100, 10, true));
        this.listroom.add(new Theory("10", 2, 200, 20, true));
        this.listroom.add(new Theory("11", 3, 300, 30, true));
        this.listroom.add(new Theory("12", 4, 400, 40, true));
    }
    private void menu() {
        System.out.println("1. add room Computer");
        System.out.println("2. add room Lab");
        System.out.println("3. add room Theory");
        System.out.println("4. update number of computer in room");
        System.out.println("5. sort by number of building");
        System.out.println("6. sort by Area");
        System.out.println("7. sort by num");
        System.out.println("8. sort by number of bulbs");
        System.out.println("9. print all room");
        System.out.println("10. print qualified room");
        System.out.println("11. exit");
        int choice = Common.getInt("Enter your choice: ");
        menu(choice);
    }
    private void menu(int choice) {
        switch(choice) {
            case 1:
                this.listroom.add(Computer.input((listroom.size()+"")));
                break;
            case 2:
                this.listroom.add(Lab.input((listroom.size()+"")));
                break;
            case 3:
                this.listroom.add(Theory.input((listroom.size()+"")));
                break;
            case 4:
                String roomId = Common.getString("Enter roomId: ");
                int numComputer = Common.getInt("Enter number of computer: ");
                this.updateComputerInroom(roomId, numComputer);
                break;
            case 5:
                this.Print(this.sortByNum());
                break;
            case 6:
                this.Print(this.sortByArea());
                break;
            case 7:
                this.Print(this.sortByNum());
                break;
            case 8:
                this.Print(this.sortByBulbs());
                break;
            case 9:
                this.Print(this.listroom);
                break;
            case 10:
                this.checklistQualified();
                break;
            case 11: 
                System.exit(0);
                break;
        }
    }
    public void Start() {
        this.init();
        while(true) {
            this.menu();
        }
    }
    
}
