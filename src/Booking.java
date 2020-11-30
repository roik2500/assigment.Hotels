
import java.util.ArrayList;
import java.util.Date;

public class Booking implements  ITestable{
    private Date date;
    private Room room;
    private ArrayList<HotelService> services;
    private Reservation reservation;
    private Review review;


    public Booking(Date a_date, Room a_room){
        date = a_date;
        room = a_room;
        services = new ArrayList<HotelService>();
    }

    public void addService(HotelService s){
        services.add(s);
    }

    public void addReview(Review a_review) {review  = a_review; }

    public void addReservation(Reservation r){
        reservation = r;
    }

    public void assignRoom(Room room){
        this.room = room;
    }


    // getters

    public Date getDate() {
        return date;
    }

    public Room getRoom() {
        return room;
    }

    public ArrayList<HotelService> getServices() {
        return services;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Review getReview() {
        return review;
    }


    @Override
    public boolean checkConstraints() {

        //Roy Peled code---constraint 5-VIPCheckservice
        if (this.room!=null)
            if(this.room.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
                for (HotelService hs : this.services)
                    if(!(hs.getService() instanceof VipService))
                        return  false;



        //constraint8 - room must be in his level or higher
        if (this.reservation.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
            if (this.room.getRoomCategory().getType() != RoomCategory.RoomType.VIP)
                return false;
        if (this.reservation.getRoomCategory().getType() == RoomCategory.RoomType.SUITE)
            if ((this.room.getRoomCategory().getType() != RoomCategory.RoomType.VIP) && (this.room.getRoomCategory().getType() != RoomCategory.RoomType.SUITE))
                return false;
        //constraint 13
        Hotel hotel = this.reservation.getReservationSet().getHotel();
        for(HotelService hotelService: this.services){
            if(hotelService.getHotel() != hotel)
                return false;
        }
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof Booking){
                Booking booking = (Booking)object;
                isOk = isOk && booking.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}