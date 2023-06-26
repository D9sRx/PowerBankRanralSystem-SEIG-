import java.util.Date;
import java.text.SimpleDateFormat;
public class Data {
    static String startTime;
    static String overTime;
    static public String userName;


    static int second;

    static int minutes;
    static int hours;

    static String bill;



    public void setBill(String bill) {
        this.bill = bill;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        second += minutes*60;
    }

    public void setHours(int hours) {
        this.hours = hours;
        second += hours*3600;
    }
    public void print(){

        System.out.println(bill+"\n"+second+"\n"+minutes+"\n"+hours+"\n"+userName+"\n"+startTime+"\n"+overTime);

    }


}
