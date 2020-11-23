import java.util.HashMap;


public class Client implements  ITestable {
    private HashMap<Hotel,ReservationSet> reservationsHistory;
    private int id;
    private int age;
    private String name;
    private String city;

    public HashMap<Hotel, ReservationSet> getReservationsHistory() {
        return reservationsHistory;
    }

    public Client(int a_id, int a_age, String a_name, String a_city){
        reservationsHistory = new HashMap<Hotel,ReservationSet>();
        id = a_id;
        age = a_age;
        city = a_city;
        name = a_name;
    }

    public void addReservationSet(Hotel hotel, ReservationSet reset){
        reservationsHistory.put(hotel,reset);
    }

    // getters

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkConstraints() {

        //my code--constrain 2
        if (reservationsHistory.size() > 4) {
            int count = 0;
            for (ReservationSet hs : this.reservationsHistory.values()) {
                for (Reservation r : hs.getReservations()) {
                    if (r.getRoomCategory().getType() == RoomCategory.RoomType.VIP) {
                        count++; //AMIT
                    }
                }
                if (count == 0) //at least 1 reservation in VIP -AMIT
                    return false;
            }
        }
        //constraint9
        for(ReservationSet reservationSet : this.reservationsHistory.values()){
            for(Reservation reservation: reservationSet.getReservations()){
                Booking booking = reservation.getBookings();
                if(booking != null){
                    for(HotelService hotelService: booking.getServices()){
                        if(hotelService.getService() instanceof VipService){
                            if(booking.getReview() == null)
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof Client){
                Client client = (Client)object;
                isOk = isOk && client.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
