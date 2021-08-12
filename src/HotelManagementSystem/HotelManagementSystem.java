package HotelManagementSystem;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * -> Design Hotel Management System.
 *
 * Hotel - managed (customers can book, manager can see the booking, sweepers/take careeres - see and put their attendance.
 * Generic..
 *
 * Requirements:
 * ------------
 * 1. Customer can login/logouot and signup (login cred) - cetners of hotel, the available rooms in hotel, rate.
 * 2. Customer can update/cancel his dates/booking rooms/persons with some constraints
 * 3. Customer can make payment for food / room/ services.
 * 3. Customer can book the internal servies provided by hotel after check - in
 * 4. Customer can checkin/checkout from app, upload his ID.
 * 5. FrontDesk can see all room status in the hotel.
 * 6. FrontDesk can also book on behalf of customer.
 * 7. Customer can allow for delivery or any guest.
 * 8. HotelAdmin can add/remove/block rooms, as required.
 * 9. Chef can see the rooms he needs to deliver the food to.
 * 10. CareTakers can see their next task.
 * 11. What lift the user should take to reach his/her room
 *
 * ---  10 mins
 *
 *
 * Actors:
 * --------
 * 1. Customer
 * 2. Caretakers
 * 3. Chef
 * 4. HotelAdmin
 * 5. FrontDesk
 *
 * Classes:
 * --------
 * Hotel, HotelAddress, PersonAddress, Address, Floor, Lift, Gate, Room, Section
 * Customer, CareTaker, Chef, HotelAdmin, FrontDesk, Guest
 * Account, Cost, Booking, ExtraServices, Food, Order
 * Payment
 *
 * --- 6 mins
 *
 *
 * UseCases:
 * 1. Booking by customer
 *
 * */


public class HotelManagementSystem {
    public static void main(String[] args) {
        System.out.println("I am here");
    }
}


class Account {
    String username;
    String password;
    LocalDateTime creationDate;
    public void login(String username, String password) {

    }
}

class Person {
    PersonAddress personAddress;
    String name;
}

class PersonAddress {
    String address;
    String pin;
}

class CustomerAccount {
    public void createAccount(Customer customer) {

    }
}

class RoomService {
    public Room getRoom(RoomType roomType, int roomSize){
        return new Room();
    }
}

class BookingService {
    public void bookRoom(Room room) {
        //take lock on this room for 15 mins

    }
}

class PaymentServic {
    public void makePayment(double amount, PaymentMethod paymentMethod) {

    }
}

class PaymentMethod {
    //
}

class Customer extends Person{
    Account account;
    public void checkin(){}
    public void checkout(){}
}

class Chef extends Person{
    Account account;
    double yearExperience;
    LocalDateTime joinDate;
}

class HotelAdmin extends Person{
    Account account;

}

class CareTaker extends Person{
    Account account;
    public void itemDelivered(){};
    public void roomCleaned(){};
}

class FrontDesk extends Person{
    Account account;
}

class Guest extends Person {

}

//Hotel, HotelAddress, PersonAddress, Address, Floor, Lift, Gate, Room, Section

class Hotel {
  HotelAddress address;
  List<Floor> floors;
}

class Floor {
    List<Gate> gates;
    List<Section> sections;
    List<Lift> lifts;
}

class Gate {
    String gateId;
    boolean isOpen;
    public void openGate() {}
    public void closeGate(){}
}
class Lift {
    String liftNo;
    boolean isFunctioning;
}

class Section {
    String sectionId;
    List<Room> rooms;
}

class Room {
    RoomStatus roomStatus;
    String roomNo;
    RoomType roomType;
    int roomSize;
}

enum RoomStatus {
    CLEANED, AVAILABLE, UNDER_CONSTRUCTION, MAINTAINANCE, CLEANING;
}

enum RoomType {
    BUSINESS, ECONOMIC, LUXURY
}

class HotelAddress {
    String area;
    //....
}
