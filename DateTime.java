package carparkmanager;

public class DateTime {

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    
    ////////////////////////////// Defining varibles //////////////////////////////
    protected int date;
    protected int month;
    protected int year;
    
    protected int hour;
    protected int minute;
    protected int second;

    ////////////////////////////// Setting default values //////////////////////////////
    public void DateTime(){
        date = 0;
        month = 0;
        year = 0;
        
        hour = 0;
        minute = 0;
        second = 0;
    }
    
    ////////////////////////////// Getting formatted date and time string //////////////////////////////
    public String getDateTime(){
        return String.format("%02d/%02d/%04d|%02d:%02d:%02d", date, month, year, hour, minute, second);
    }

    ////////////////////////////// Validating and sortind variables //////////////////////////////
    public DateTime(int d, int mo, int y, int h, int m, int s) {
        date = ((d>=0 && d<=31) ? d : 0);
        month = ((mo>=0 && mo<=12) ? mo : 0);
        year = ((y>=0 && y<=9999) ? y : 0);
        
        hour = ((h>=0 && h<24) ? h : 0);
        minute = ((m>=0 && m<60) ? m : 0);
        second = ((s>=0 && s<60) ? s : 0);
    }
}
