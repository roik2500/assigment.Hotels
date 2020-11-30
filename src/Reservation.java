import java.util.Date;

public class Reservation implements  ITestable {
    private int id;
    private RoomCategory roomCategory;
    private Date orderDate;
    private Date requestDate;
    private Booking booking;
    private ReservationSet reservationSet;


    public Reservation(Date ordDate, Date reqDate, int id) {
        this.id = id;
        orderDate = ordDate;
        requestDate = reqDate;
    }

    public void setReservationSet(ReservationSet reservationSet){
        this.reservationSet = reservationSet;
    }

    public void addRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public void addBooking(Booking _booking) {
        booking = _booking;
    }


    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Booking getBookings() {
        return booking;
    }

    public int getId() {
        return id;
    }

    public ReservationSet getReservationSet(){return reservationSet;}

    @Override
    public boolean checkConstraints() {

        // my code---> constrain 3
        if(this.booking.getRoom()!=null){
            Room room = this.booking.getRoom();
            if(room.getHotel() != this.reservationSet.getHotel())
                return false;
        }
        /*
        
        for (Room r : this.roomCategory.getRooms()) {
            if (r.getHotel() != this.booking.getRoom().getHotel()) {
                return false;
            }
        }

         */
        return true;




    }




    public static boolean checkAllIntancesConstraints(Model model) {
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof Reservation){
                Reservation reservation = (Reservation)object;
                isOk = isOk && reservation.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }


}
    