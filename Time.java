import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    public Time(){
        ZonedDateTime now = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = now.format(formatter);
        String[] parts=formattedDateTime.split("[- :]");
        this.day=Integer.parseInt(parts[0]);
        this.month=Integer.parseInt(parts[1]);
        this.year=Integer.parseInt(parts[2]);
        this.hour=Integer.parseInt(parts[3]);
        this.minute=Integer.parseInt(parts[4]);
    }
    public Time(String s){
        String[] parts=s.split("[- :]");
        this.day=Integer.parseInt(parts[0]);
        this.month=Integer.parseInt(parts[1]);
        this.year=Integer.parseInt(parts[2]);
        this.hour=Integer.parseInt(parts[3]);
        this.minute=Integer.parseInt(parts[4]);
    }
    public int getDay() {
        return day;
    }
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
}
