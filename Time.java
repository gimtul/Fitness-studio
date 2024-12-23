public class Time {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    public Time(int day, int month, int year, int hour, int minute){
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;
        this.minute=minute;
    }
    public void addDay(){
        day++;
        if ((day<30&&(month==4||month==6||month==9||month==11)||(day<31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12))||(day<28&&month==2))){
            day=1;
            if(month>=12){
                month=1;
                year++;
            }
            else
                month++;
        }
    }
    public void addMonth(){
        month++;
        if(month>=12){
            month=1;
            year++;
        }
        else
            month++;
    }
    public void addYear(){
        year++;
    }
    public void addHour(){
        hour++;
        if (hour>=24){
            hour=0;
            day++;
            if ((day<30&&(month==4||month==6||month==9||month==11)||(day<31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12))||(day<28&&month==2))){
                day=1;
                if(month>=12){
                    month=1;
                    year++;
                }
                else
                    month++;
            }
        }
    }
    public void addMinute(){
        minute++;
        if (minute>=60){
            minute=0;
            hour++;
            if (hour>=24){
                hour=0;
                day++;
                if ((day<30&&(month==4||month==6||month==9||month==11)||(day<31&&(month==1||month==3||month==5||month==7||month==8||month==10||month==12))||(day<28&&month==2))){
                    day=1;
                    if(month>=12){
                        month=1;
                        year++;
                    }
                    else
                        month++;
                }
            }
        }
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
