import java.util.HashMap;
import java.util.HashSet;

public class Group implements  ITestable{
    private int groupId;
    HashSet<Hotel> hotels;

    public Group(int id){
        hotels = new HashSet<Hotel>();
        groupId = id;
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
        //my code---constraint 1
        for (Hotel h1 : hotels) {
            String city = h1.getCity();
            for (Hotel h2 : hotels) {
                if (h1!= h2 && h2.getCity().equals(city)) { ////if the hotels aren't the same - AMIT
                    return false;
                }
            }
        }

        //Roy Peled code---constraint 4
        Hotel hotel = hotels.stream().findFirst().get();
        HashMap<Service, HotelService> serviceHashMap = hotel.getServices();
        for (Hotel h : hotels) {
            HashMap<Service, HotelService> serviceHashMap2 = h.getServices();
            if (serviceHashMap.size() != serviceHashMap2.size())
                return false;
            for (Service s : serviceHashMap.keySet()) {
                if (!serviceHashMap2.containsKey(s))
                    return false;
            }
        }

        return true;
    }


    public static boolean checkAllIntancesConstraints(Model model){
        Boolean isOk = true;
        for(Object object :model.allObjects) {
            if(object instanceof Group){
                Group group = (Group)object;
                isOk = isOk && group.checkConstraints();
                if(!isOk)
                    return false;
            }
        }
        return true;
    }
}
