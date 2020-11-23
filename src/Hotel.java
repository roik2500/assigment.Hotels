import java.util.HashMap;
import java.util.HashSet;

public class Hotel implements  ITestable{
    private String name;
    private HashMap<Client, ReservationSet> allReservation;
    private HashMap<Service, HotelService> services;
    private HashMap<Integer,Room> rooms;
    private String city;
    private Group group;
    private int rate;



    public Hotel(String city, String name,int rate){
        this.city = city;
        this.name = name;
        this.rate = rate;
        rooms = new HashMap<Integer,Room>();
        allReservation = new HashMap<Client, ReservationSet>();
        services = new HashMap<Service, HotelService>();
    }

    public void addReservationSet(Client client,ReservationSet reservationSet){
        allReservation.put(client,reservationSet);
    }

    public void addService(Service service, HotelService hotelService){
        services.put(service,hotelService);
    }

    public void addRoom(int roomNumber, Room room){
        rooms.put(roomNumber,room);
    }


    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public HashMap<Client, ReservationSet> getAllReservation(){return allReservation;}

    public HashMap<Service, HotelService> getServices(){return services;}

    public int getRate(){return rate;}

    @Override
    public boolean checkConstraints() {
        //constraint7-if you in hotel in las vegas you must be 21 or more
        if(this.city.equals("LAS VEGAS")) {
            for (Client client : allReservation.keySet()) {
                if (client.getAge() < 21)
                    return false;
            }
        }
        //constraint6
        double counter = 0;
        double sum = 0;
        for (Room r : this.rooms.values()) {
            if (r.getRoomCategory().getType() == RoomCategory.RoomType.VIP)
                counter++;
            sum++;
        }
        if (counter / sum > 0.1)
            return false;


        //constrain 10
        double sumRank = 0; //sum ranks from all review
        double count = 0;  //count all reviews
        if(this.rate != 5)
            return false;
        for (Room room :rooms.values())
        {
            for(Booking booking: room.getBookings().values())
            {
                if(booking.getReview() != null)
                {
                    sumRank += booking.getReview().getRank();
                    count++;
                }
            }
        }
        if(!((sumRank/count) > 7.5))
            return false;
        //constraint 11
        for (Service s : services.keySet()) {
            for (Service s1 : services.keySet()) {
                if (s1 != s && s.serviceName.equals(s1.serviceName))
                    return false;
            }
        }
        //constraint 12
        HashSet<Integer> years = new HashSet<Integer>();
        for (HotelService hotelService : this.services.values()) {
            for (Booking booking : hotelService.getGivenServices()) {
                years.add(booking.getDate().getYear() + 1900);
            }
        }
        for (Integer year : years) {
            if (revenueYear(year) <= revenueYear(year - 1))
                return false;
        }
        return true;
    }

    private float revenueYear(int year){
        float revenue = 0;
        for(HotelService hotelService: this.services.values()){
            for(Booking booking: hotelService.getGivenServices())
                if(booking.getDate().getYear()+1900 == year){
                    revenue +=hotelService.getPrice();
                }
        }
        return revenue;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof Hotel){
                Hotel hotel = (Hotel)object;
                isOk = isOk && hotel.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
