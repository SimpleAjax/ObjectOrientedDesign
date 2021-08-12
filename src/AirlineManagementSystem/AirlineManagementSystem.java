package AirlineManagementSystem;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  (MMT + Airline management)
 * 1. User can come and see what all flights are available
 * 2. He can book selected fligts, select seats, make payment and get ticket.
 * 3. Airline front desk person can add/remove/update the flight and schedule
 * 4. Pilot/Airhostess can also check the status of flights and their assigned flights and schedules
 * 5. Admin will be able to add/remove airlines
 *
 *
 *
 * ACTORs:
 * 1. User (Guest, Customer -> passenger)
 * 2. Airline FrontDesk
 * 3. Admin
 * 4. Pilot
 *
 *
 * CLASSEs:
 * 1. Guest, Customer, Account, Admin, Pilot, AirlineFrontDesk
 * 2. Ticket, Booking, Catalog, Payment, Card
 * 3. Flight, AirCraft, Seat, Airline, Airport
 * 4. FlightSchedule
 *
 *
 *
 * SEARCH flight Scenario:
 * 1. put user's date, source to destination -> search
 *
 * */

public class AirlineManagementSystem {
    public static void main(String[] args) {

    }
}

enum AccountType {
    PREMIUM,
    GENERAL
}

class Account {
    String userName;
    String password;
    LocalDateTime creationDate;
    AccountType accountType;
    PaymentMethod paymentMethod;
}

class Customer {
    PersonAddress address;
    String name;
    Account account;
}

class Guest {
    public void signUp(String userName, String password, AccountType accountType){};
}

class Catalog {
    Map<Date, FlightSchedule> dateVsFlightSchedule;
}

class SearchService {
    Catalog catalog;
    public List<FlightSchedule> findFlightsByDate(Date date){ return null; };
}

class BookingService {
    Booking createBooking(FlightSchedule flightSchedule, Customer customer) {
        FlightScheduleSeat seat = fetchAvailableFlightScheduleSeat();
        if(seat==null) {
            return null;
        }
        Booking booking = new Booking(flightSchedule, customer, seat);
        return booking;
    }
    private FlightScheduleSeat fetchAvailableFlightScheduleSeat(){ return null; };
}

class PaymentService {
    boolean makePayment(Booking booking) {
        // third party call to :
        return new ExternalPartyService().callThirdParty("Stripe", booking);
    }
}

class Payment {
    double cost;
    PaymentMethod method;
}

class ExternalPartyService {
    public boolean callThirdParty(String ThirdPartyName, Object object) {
        return true;
    }
}

class PaymentMethodFactory {

}

class PaymentMethod {

}

class DebitCardPayment extends PaymentMethod {
    String cardDetails;
}

class CreditCardPayment extends PaymentMethod {
    String cardDetails;
}

// TODO: make more robust payment service and methods
class WalletPayment extends PaymentMethod{
    String walletDetails;
}

class Booking {
    Booking(FlightSchedule flightSchedule, Customer customer, FlightScheduleSeat seat) {
        this.flightSchedule = flightSchedule;
        this.customer = customer;
        this.seat = seat;
    }
    LocalDateTime bookingDate;
    FlightSchedule flightSchedule;
    Customer customer;
    FlightScheduleSeat seat;
}

class Address {
    String city;
    String pinCode;
    String street;
    String addressLine1;
}

class PersonAddress extends Address {
    String name;
}

class AirportAddress extends Address{
    String name;
    double area;
}

class Airport {
    AirportAddress address;
}

class FlightSchedule {
    Flight flight;
    Airport source;
    Airport destination;
    LocalDateTime expectedDepartureTime;
    LocalDateTime expectedArrivalTime;
}

class FlightScheduleAudit {
    String flightScheduleId;
    LocalDateTime updateTime;
    FlightSchedule oldFlightSchedule;
}

class Flight {
    AirCraft airCraft;
    Airline airline;
    String flightNo;
    Set<FlightSeat> seats;
}

class FlightSeat {
    String seatNo;
}

class FlightScheduleSeat extends FlightSeat{
    SeatType seatType;
    double cost;
    boolean isAvailable;
}

enum SeatType {
    PREMIUM, WINDOW, GENERAL, BUSINESS;
}

class AirCraft {
    String airCraftId;
    LocalDateTime buyTime;
}

class AirCraftLedger {
    AirCraft airCraft;
    LocalDateTime lastMaintainance;
    String maintainer;
}

class Airline {
    String name;
    String id;
    LocalDateTime joinDate;
}

// all flights realated to airline

