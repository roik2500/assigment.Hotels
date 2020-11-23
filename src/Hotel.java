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


    // my code-->constrain 11
    public boolean UniqeRoomNumber(){
        HashSet<String> name= new HashSet<String>();
        for(Service s1:this.services.keySet()) {
            if(name.contains(s1.getServiceName())){return false;}
            name.add(s1.getServiceName());
        }
        return true;
    }


    //not more then 10% of vip rooms
    public boolean constraint_14(){
        double counter=0;
        double sum=0;
        for (Room r:this.rooms.values()){
            if(r.getRoomCategory().getType()== RoomCategory.RoomType.VIP)
                counter++;
            sum++;
        }
        if(counter/sum>0.1)
            return false;
        return true;

    }

    //constrain 10
    public boolean avaregeRank()
    {
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
        return true;
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
        return true;
    }

    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
