import java.util.HashSet;
import java.util.Set;

public class RoomCategory implements  ITestable{
    HashSet<Room> rooms;
    HashSet<Reservation> reservations;

    enum  RoomType{
        BASIC, SUITE , VIP;
    }
    private int price;
    private RoomType type;

    public RoomCategory(int price, RoomType rType){
        rooms = new HashSet<Room>();
        reservations = new HashSet<Reservation>();
        type = rType;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void addReservation(Reservation reservation){reservations.add(reservation);}

    public HashSet<Room> getRooms() {
        return rooms;
    }

    public int getPrice() {
        return price;
    }

    public RoomType getType() {
        return type;
    }

    @Override
    public boolean checkConstraints() {
        //Roy Peled code---constraint 5-VIPCheckservice
        if (type == RoomType.VIP) {
            for (Room r : rooms)
                for (Service s : r.getHotel().getServices().keySet()) {
                    if (!(s instanceof VipService))
                        return false;
                }
        }
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof RoomCategory){
                RoomCategory roomCategory = (RoomCategory)object;
                isOk = isOk && roomCategory.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
