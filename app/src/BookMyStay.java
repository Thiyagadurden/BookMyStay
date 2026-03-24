import java.util.ArrayList;
import java.util.List;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room Type: " + roomType;
    }
}

class BookingHistory {
    private List<Reservation> history = new ArrayList<>();

    public void addRecord(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllRecords() {
        return new ArrayList<>(history);
    }
}

class BookingReportService {
    public void generateSummaryReport(BookingHistory bookingHistory) {
        List<Reservation> records = bookingHistory.getAllRecords();

        System.out.println("Booking History Report");
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Reservation res : records) {
                System.out.println(res);
            }
        }
    }
}

public class BookMyStay {
    public static void main(String[] args) {
        System.out.println("Booking History and Reporting\n");

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        history.addRecord(new Reservation("Abhi", "Single"));
        history.addRecord(new Reservation("Subha", "Double"));
        history.addRecord(new Reservation("Vanmathi", "Suite"));

        reportService.generateSummaryReport(history);
    }
}