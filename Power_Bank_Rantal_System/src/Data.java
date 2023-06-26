import java.util.Date;
import java.text.SimpleDateFormat;
public class Data {
    String startTime;
    String overTime;
    String userName;
    int bill;
    public void setBill(int bill) {
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
    public void dataClear(){
        startTime = null;
        overTime = null;
        userName = null;
    }

}
