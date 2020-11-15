import java.util.HashSet;

public class Group implements  ITestable{
    private int groupId;
    HashSet<Hotel> hotels;

    public Group(int id){
        hotels = new HashSet<Hotel>();
        groupId = id;
    }


    //my code---constraint 1
    boolean MultiHotels(){
        for(Hotel h1:hotels){
           String city=h1.getCity();
           for(Hotel h2:hotels){
               if(h2.getCity()==city){return false;}
           }
        }
        return true;
    }


    public void addHotelToGroup(Hotel hotel){
        hotels.add(hotel);
    }

    //getters

    public int getGroupId() {
        return groupId;
    }

    public HashSet<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public boolean checkConstraints() {
        return true;
    }
    public static boolean checkAllIntancesConstraints(Model model){
        return true;
    }
}
