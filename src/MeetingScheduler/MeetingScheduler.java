package MeetingScheduler;


import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * Meeting Scheduler
 * User should be able to book meeting and corresponding available room for all the available users.
 *
 * Requirements:
 * 1. User should be able to select which room he wants to book
 * 2. User should be able to add all the receipients in the meeting.
 * 3. The room which is being booked should be vacant for that specific time.
 * 4. User should not be allowed to book for more than certain period of time.
 * 5. User can book recurring meetings.
 * 6. User should be able to update, remove, decline, rechedule the meeting.
 * 7. Clashing during the parallel booking should be handled properly.
 * 8. Admin will be able to add/remove rooms
 * 9. Users should be able to check calendar and see all the past and future meetings.
 * 10. User will be notified of the meeting before 15mins of start.
 *
 *
 * Classes:
 * User, Account, Admin,
 * MeetingRoom, MeetingSchedule, UserCalendar, MeetingRoomCalendar, Calendar
 * enum: MeetingType (recurring, one-time), RoomStatus (Blocked, OngoingMeeting, UnderMaintainance, NOT_AVAILABLE),
 * AccountStatus
 *
 *
 * UseCase:
 * 1. User books a meeting room along with some of colleagues and they are notified of the same.
 *
 * */


public class MeetingScheduler {
    public static void main(String[] args) {
        UseCases useCases = new UseCases();
        useCases.bookMeetingRoom();
    }

    public static void scheduleMeeting(MeetingRoom room, List<User> userList, Interval interval){
        if(!room.isAvailable(interval) || room.capacity < userList.size()) return;
        MeetingSchedule meetingSchedule = new MeetingSchedule(); // room, userList, interval
        // featch calendar of all users and booked room and add the meeting schedule in that.
        //notify all the users about the booking.
    }
}

class CalendarService {
    Calendar fetchCalendar(User user) {
        return new UserCalendar();
    }

    Calendar fetchCalendar(MeetingRoom room) {
        return new RoomCalendar();
    }
}

class UseCases {
    public void bookMeetingRoom() {
        SearchService searchService = new SearchService();
        List<MeetingRoom> meetingRooms = searchService.searchRoom("roomId");
        List<User> userList = searchService.searchUser("userId");
        MeetingRoom room = new MeetingRoom();
        MeetingScheduler.scheduleMeeting(room, userList, new Interval());
    }
}

enum AccountStatus {
    active, inactive, blocked
}

class SearchService {
    List<User> searchUser(String user) {
        return null;
    }
    List<MeetingRoom> searchRoom(String room){
        return null;
    }
}

class Interval {
    LocalDateTime startTime;
    LocalDateTime endTime;
}

class MeetingRoom {
    String roomNo;
    String roomDescription;
    int capacity;
    MeetingRoomStatus status;

    boolean isAvailable(Interval interval) {
        return false;
    }
}

enum MeetingRoomStatus {
    OCCUPIED, MAINTENANCE, AVAILABLE
}

class Account {
    String name;
    String password;
    LocalDateTime createDate;
    LocalDateTime lastLogin;
    AccountStatus accountStatus;
    public void resetPassword(){};
}

class MeetingSchedule {
    Interval interval;
    MeetingType meetingType;
    MeetingStatus meetingStatus;
    String subject;
    String description;
    MeetingRoom room;
    List<User> userList;
}

// recurring : time, day of week,
class RecurringMeetingSchedule extends MeetingSchedule {

}

class OneTimeMeetingSchedule extends MeetingSchedule {

}


enum MeetingStatus {
    COMPLETED, ONGOING, UPCOMING, CANCELLED, DECLINED
}

enum MeetingType {
    ONETIME, RECURRING
}

class Calendar {
    List<MeetingSchedule> meetingScheduleList;
}
class UserCalendar extends Calendar{
    User user;
}

class RoomCalendar extends Calendar{
    MeetingRoom room;
}

class User {
    Account account;
}






