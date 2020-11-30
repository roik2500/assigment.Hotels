import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
/*
        Model m1 = new Model();
        //check for constraint 1
        Group g = new Group(1);
        Hotel h1 = new Hotel("Haifa", "Dan Panorama", 4);
        Hotel h2 = new Hotel("Haifa", "Dan Carmel", 4);
        m1.addObjectToModel(g);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.create_link_group_hotel(h1, g);
        m1.create_link_group_hotel(h2, g);
        boolean f=m1.checkModelConstraints();
        System.out.println(m1.checkModelConstraints()); //should print false
/*
        //check for constraint 7
        Model m = new Model();
        Client client1 = new Client(1,20,"Dolev","Tel Aviv");
        Hotel hotel1 = new Hotel("Las Vegas","Paris",5);
        Room room1 = new Room(404);
        ReservationSet reservationSet1 = new ReservationSet();
        Date orDate = Model.getDateFromString("25-12-2019");
        Date reqDate = Model.getDateFromString("01-01-2020");
        Reservation reservation1 = new Reservation(orDate,reqDate,100);
        RoomCategory roomCategory1 = new RoomCategory(200,RoomCategory.RoomType.BASIC);
        m.addObjectToModel(client1);
        m.addObjectToModel(hotel1);
        m.addObjectToModel(reservationSet1);
        m.addObjectToModel(reservation1);
        m.addObjectToModel(room1);
        m.create_link_client_hotel_reservationSet(client1,hotel1,reservationSet1);
        m.create_link_reservationSet_reservation(reservationSet1,reservation1);
        m.create_link_reservation_roomCategory(reservation1,roomCategory1);
        m.create_link_hotel_room(room1,hotel1);
        m.create_link_room_roomCategory(room1,roomCategory1);
        System.out.println(m.checkModelConstraints());
*/
        //1-checkIf2HotelsInTheSameCity
        /*Model m1 = new Model();
        Hotel h1 = new Hotel("Haifa", "Dan", 4);
        Hotel h2 = new Hotel("Haifa", "Dani", 4);
        Group g1 = new Group(1);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.addObjectToModel(g1);
        m1.create_link_group_hotel(h1, g1);
        m1.create_link_group_hotel(h2, g1);
        System.out.println(m1.checkModelConstraints());
        */

        /* //allClientsAbove21InLasVegas
        Model m1 = new Model();
        Hotel h1 = new Hotel("LAS VEGAS", "Dan", 4);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        Room r1 = new Room(666);
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r = new Reservation(d1, d2, 1);
        RoomCategory rc = new RoomCategory(100,RoomCategory.RoomType.BASIC);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(r);
        m1.addObjectToModel(rc);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r);
        m1.create_link_hotel_room(r1,h1);
        m1.create_link_reservation_roomCategory(r,rc);
        m1.create_link_room_roomCategory(r1,rc);
        System.out.println(m1.checkModelConstraints());
        */

         /*  //9-vipReview
        Model m1 = new Model();

        Hotel h1 = new Hotel("Tel Aviv", "Dan", 4);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.VIP);
        Room rm1 = new Room(666);
        Booking b1 = new Booking(d2,rm1);

        //review
       // Review rev = new Review(8,"asdfg",d2);
       // m1.addObjectToModel(rev);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_reservation_booking(b1,r1);
      //  m1.create_link_booking_review(b1,rev);
        System.out.println(m1.checkModelConstraints());
        */


         /*  //3-checkReservationAndBookingFromSameHotel
        Model m1 = new Model();
        Hotel h1 = new Hotel("Tel Aviv", "Dan", 4);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.BASIC);
        Room rm1 = new Room(666);
        Room rm2 = new Room(666);
        Hotel h2 = new Hotel("asdf","asdf",4);
        Booking b1 = new Booking(d2,rm1);
        m1.addObjectToModel(h2);
        m1.addObjectToModel(rm2);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.create_link_hotel_room(rm2,h2);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs); //h2-false
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_reservation_booking(b1,r1);
        boolean x= m1.checkModelConstraints();
        System.out.println(x);
        //System.out.println(m1.checkModelConstraints());
        */


        /*//6-vipRoomsLessThan10Percent
        Model m1 = new Model();
        Hotel h1 = new Hotel("Tel Aviv", "Dan", 4);
        Room r1 = new Room(100);
        Room r2 = new Room(101);
        Room r3 = new Room(102);
        Room r4 = new Room(103);
        Room r5 = new Room(104);
        Room r6 = new Room(105);
        Room r7 = new Room(106);
        Room r8 = new Room(107);
        Room r9 = new Room(108);
        Room r10 = new Room(109);
        RoomCategory basic = new RoomCategory(100, RoomCategory.RoomType.BASIC);
        RoomCategory vip = new RoomCategory(300, RoomCategory.RoomType.VIP);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(r2);
        m1.addObjectToModel(r3);
        m1.addObjectToModel(r4);
        m1.addObjectToModel(r5);
        m1.addObjectToModel(r6);
        m1.addObjectToModel(r7);
        m1.addObjectToModel(r8);
        m1.addObjectToModel(r9);
        m1.addObjectToModel(r10);
        m1.addObjectToModel(basic);
        m1.addObjectToModel(vip);
        m1.create_link_hotel_room(r1,h1);
        m1.create_link_hotel_room(r2,h1);
        m1.create_link_hotel_room(r3,h1);
        m1.create_link_hotel_room(r4,h1);
        m1.create_link_hotel_room(r5,h1);
        m1.create_link_hotel_room(r6,h1);
        m1.create_link_hotel_room(r7,h1);
        m1.create_link_hotel_room(r8,h1);
        m1.create_link_hotel_room(r9,h1);
        m1.create_link_hotel_room(r10,h1);
        m1.create_link_room_roomCategory(r1,basic);
        m1.create_link_room_roomCategory(r2,basic);
        m1.create_link_room_roomCategory(r3,basic);
        m1.create_link_room_roomCategory(r4,basic);
        m1.create_link_room_roomCategory(r5,basic);
        m1.create_link_room_roomCategory(r6,basic);
        m1.create_link_room_roomCategory(r7,basic);
        m1.create_link_room_roomCategory(r8,basic);
        m1.create_link_room_roomCategory(r9,basic); //vip
        m1.create_link_room_roomCategory(r10,vip);

        System.out.println(m1.checkModelConstraints());
        */

        /*//11-uniqueServices
        Model m1 = new Model();
        Hotel h1 = new Hotel("tel aviv", "dan", 4);
        Service s1 = new VipService("a");
        Service s2 = new CommunityService("a");
        HotelService hs1 = new HotelService(100,10);
        HotelService hs2 = new HotelService(30, 5);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(s1);
        m1.addObjectToModel(s2);
        m1.addObjectToModel(hs1);
        m1.addObjectToModel(hs2);
        m1.create_link_hotel_service_hotelService(h1,s1,hs1);
        m1.create_link_hotel_service_hotelService(h1,s2,hs2);
        System.out.println(m1.checkModelConstraints());
        */


       /*//10-fiveStarAbove75Rating
        Model m1 = new Model();
        Hotel h1 = new Hotel("Tel Aviv", "Dan", 5);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.VIP);
        Room rm1 = new Room(666);
        Booking b1 = new Booking(d2,rm1);
        //review
        Review rev = new Review(7,"asdfg",d2);
        m1.addObjectToModel(rev);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_booking_review(b1,rev);
        Boolean x = m1.checkModelConstraints();
        System.out.println(x);
        */

        /*//4-checkIfAllHotelsHaveSameServices
        Model m1 = new Model();
        Hotel h1 = new Hotel("tel aviv", "Dan", 4);
        Hotel h2 = new Hotel("Haifa", "Dani", 4);
        Group g1 = new Group(1);
        Service s1 = new VipService("a");
        Service s2 = new CommunityService("b");
        HotelService hs1 = new HotelService(100,10);
        HotelService hs2 = new HotelService(30, 5);
        HotelService hs3 = new HotelService(100,10);
        HotelService hs4 = new HotelService(30, 5);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(s1);
        m1.addObjectToModel(s2);
        m1.addObjectToModel(hs1);
        m1.addObjectToModel(hs2);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(h2);
        m1.addObjectToModel(g1);
        m1.create_link_hotel_service_hotelService(h1,s1,hs1);
        m1.create_link_hotel_service_hotelService(h1,s2,hs2);
        m1.create_link_hotel_service_hotelService(h2,s1,hs3);
        //m1.create_link_hotel_service_hotelService(h2,s2,hs4);
        m1.create_link_group_hotel(h1, g1);
        m1.create_link_group_hotel(h2, g1);
        System.out.println(m1.checkModelConstraints());
        */

        //5-allVIPservices
        /*Model m1 = new Model();
        Hotel h1 = new Hotel("Tel Aviv", "Dan", 5);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.VIP);
        Room rm1 = new Room(666);
        Booking b1 = new Booking(d2,rm1);
        //review
        Review rev = new Review(8,"asdfg",d2);
        Service s1 = new VipService("a");
        //Service s2 = new CommunityService("b");
        Service s2 = new VipService("b");
        HotelService hs1 = new HotelService(100,10);
        HotelService hs2 = new HotelService(30, 5);
        m1.addObjectToModel(s1);
        m1.addObjectToModel(s2);
        m1.addObjectToModel(hs1);
        m1.addObjectToModel(hs2);
        m1.addObjectToModel(rev);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.create_link_hotel_service_hotelService(h1,s1,hs1);
        m1.create_link_hotel_service_hotelService(h1,s2,hs2);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_booking_review(b1,rev);
        m1.create_link_hotelService_booking(hs1,b1);
        m1.create_link_hotelService_booking(hs2,b1);
        System.out.println(m1.checkModelConstraints());
        */

        //8-checkRoomType
        /*Model m1 = new Model();

        Hotel h1 = new Hotel("Tel Aviv", "Dan", 4);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.VIP);
        Room rm1 = new Room(666);
        RoomCategory rc2 = new RoomCategory(100,RoomCategory.RoomType.SUITE);
        Room rm2 = new Room(111);
        Booking b1 = new Booking(d2,rm2);////
        Review rev = new Review(8,"asdfg",d2);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(rm2);
        m1.addObjectToModel(rc2);
        m1.addObjectToModel(b1);
        m1.addObjectToModel(rev);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_hotel_room(rm2,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_roomCategory(rm2,rc2);
        m1.create_link_room_Booking(rm2,b1);//////
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_booking_review(b1,rev);
        System.out.println(m1.checkModelConstraints());
        */

        //13-allServicesSameHotel
        /*Model m1 = new Model();
        Hotel h1 = new Hotel("tel aviv", "Dan", 4);
        Hotel h2 = new Hotel("Haifa", "Dani", 4);
        Group g1 = new Group(1);
        Service s1 = new VipService("a");
        Service s2 = new CommunityService("b");
        HotelService hs1 = new HotelService(100,10);
        HotelService hs2 = new HotelService(30, 5);
        HotelService hs3 = new HotelService(100,10);
        HotelService hs4 = new HotelService(30, 5);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.SUITE);
        Room rm1 = new Room(666);
        Booking b1 = new Booking(d2,rm1);////
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.addObjectToModel(s1);
        m1.addObjectToModel(s2);
        m1.addObjectToModel(hs1);
        m1.addObjectToModel(hs2);
        m1.addObjectToModel(h2);
        m1.addObjectToModel(g1);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_hotel_service_hotelService(h1,s1,hs1);
        m1.create_link_hotel_service_hotelService(h1,s2,hs2);
        m1.create_link_hotel_service_hotelService(h1,s1,hs3); //h2
        m1.create_link_hotel_service_hotelService(h2,s2,hs4);
        m1.create_link_group_hotel(h1, g1);
        m1.create_link_group_hotel(h2, g1);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_hotelService_booking(hs3,b1);
        System.out.println(m1.checkModelConstraints());
        */

        //12-revenueIncreased
        /*Model m1 = new Model();
        Hotel h1 = new Hotel("tel aviv", "Dan", 4);
        Service s1 = new VipService("a");
        Service s2 = new CommunityService("b");
        HotelService hs1 = new HotelService(100,10);
        HotelService hs2 = new HotelService(30, 5);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Date d3 = Model.getDateFromString("25-12-2018");
        Date d4 = Model.getDateFromString("01-01-2019");
        Reservation r1 = new Reservation(d1, d2, 1);
        Reservation r2 = new Reservation(d3, d4, 2);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.SUITE);
        Room rm1 = new Room(666);
        Booking b1 = new Booking(d3,rm1);////
        Booking b2 = new Booking(d4,rm1);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(r2);
        m1.addObjectToModel(b2);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(b1);
        m1.addObjectToModel(s1);
        m1.addObjectToModel(s2);
        m1.addObjectToModel(hs1);
        m1.addObjectToModel(hs2);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_reservationSet_reservation(rs,r2);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_reservation_roomCategory(r2,rc1);
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_reservation_booking(b2,r2);
        m1.create_link_hotel_service_hotelService(h1,s1,hs1);
        m1.create_link_hotel_service_hotelService(h1,s2,hs2);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_room_Booking(rm1,b2);
        m1.create_link_hotelService_booking(hs1,b2);
        m1.create_link_hotelService_booking(hs2,b1);
        System.out.println(m1.checkModelConstraints());
        */

         /*   //vipGuestRoom
        Model m1 = new Model();
        Hotel h1 = new Hotel("Tel Aviv", "Dan", 4);
        Client c1 = new Client(123,20,"Tomer","Modi'in");
        ReservationSet rs = new ReservationSet();
        Date d1 = Model.getDateFromString("25-12-2019");
        Date d2 = Model.getDateFromString("01-01-2020");
        Reservation r1 = new Reservation(d1, d2, 1);
        Reservation r2 = new Reservation(d1, d2, 2);
        Reservation r3 = new Reservation(d1, d2, 3);
        Reservation r4 = new Reservation(d1, d2, 4);
        //Reservation r5 = new Reservation(d1, d2, 5);
        RoomCategory rc1 = new RoomCategory(100,RoomCategory.RoomType.BASIC);
        RoomCategory rc2 = new RoomCategory(100,RoomCategory.RoomType.SUITE);
        Room rm1 = new Room(666);
        Room rm2 = new Room(111);
        Booking b1 = new Booking(d2,rm1);
        Booking b2 = new Booking(d2,rm1);
        Booking b3 = new Booking(d2,rm1);
        Booking b4 = new Booking(d2,rm1);
        Booking b5 = new Booking(d2,rm2);
        m1.addObjectToModel(rm2);
        m1.addObjectToModel(h1);
        m1.addObjectToModel(c1);
        m1.addObjectToModel(r1);
        m1.addObjectToModel(r2);
        m1.addObjectToModel(r3);
        m1.addObjectToModel(r4);
        //m1.addObjectToModel(r5);
        m1.addObjectToModel(rs);
        m1.addObjectToModel(rm1);
        m1.addObjectToModel(rc1);
        m1.addObjectToModel(rc2);
        m1.addObjectToModel(b1);
        m1.addObjectToModel(b2);
        m1.addObjectToModel(b3);
        m1.addObjectToModel(b4);
        m1.addObjectToModel(b5);
        m1.create_link_hotel_room(rm2,h1);
        m1.create_link_client_hotel_reservationSet(c1,h1,rs);
        m1.create_link_reservationSet_reservation(rs,r1);
        m1.create_link_reservationSet_reservation(rs,r2);
        m1.create_link_reservationSet_reservation(rs,r3);
        m1.create_link_reservationSet_reservation(rs,r4);
        //m1.create_link_reservationSet_reservation(rs,r5);
        m1.create_link_hotel_room(rm1,h1);
        m1.create_link_reservation_roomCategory(r1,rc1);
        m1.create_link_reservation_roomCategory(r2,rc1);
        m1.create_link_reservation_roomCategory(r3,rc1);
        m1.create_link_reservation_roomCategory(r4,rc1);
        //m1.create_link_reservation_roomCategory(r5,rc1);//////
        m1.create_link_room_roomCategory(rm1,rc1);
        m1.create_link_room_roomCategory(rm2,rc2);
        m1.create_link_room_Booking(rm1,b1);
        m1.create_link_room_Booking(rm1,b2);
        m1.create_link_room_Booking(rm1,b3);
        m1.create_link_room_Booking(rm1,b4);
        m1.create_link_room_Booking(rm2,b5);
        m1.create_link_reservation_booking(b1,r1);
        m1.create_link_reservation_booking(b2,r2);
        m1.create_link_reservation_booking(b3,r3);
        m1.create_link_reservation_booking(b4,r4);
        //m1.create_link_reservation_booking(b5,r5);
        System.out.println(m1.checkModelConstraints());*/
    }
}
