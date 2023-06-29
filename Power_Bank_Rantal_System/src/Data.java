public class Data {
    static String startTime;//租借时间
    static String overTime;//退还时间
    static public String userName;//当前登录的用户名

    static public int hId;//历史记录表的id

    static public String selectedUser;//用户管理表中被选择的用户

    static int second;//计时器中的秒

    static int minutes;//计时器中的分钟
    static int hours;//计时器中的小时

    static String bill;//费用

    static public int pId;//充电宝编号
    static public String type;//充电宝类型
    static public int power;//充电宝电量
    static public String status;//充电宝状态



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


    public void print(){//用于测试数据的方法

        System.out.println(pId);
        System.out.println(status);
        System.out.println(type);
        System.out.println(power);

    }

    public static void setHid(int Hid) {
        Data.hId = Hid;
    }
    public static void setSelectedUser(String selectedUser) {
        Data.selectedUser = selectedUser;
    }

    public static void setpId(int pId) {
        Data.pId = pId;
    }

    public static void setType(String type) {
        Data.type = type;
    }

    public static void setPower(int power) {
        Data.power = power;
    }

    public static void setStatus(String status) {
        Data.status = status;
    }
}
