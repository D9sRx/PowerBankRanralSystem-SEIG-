public class PowerBankBillCounter {
    Data data;

    public int power;

    static double money;

    double userLessMoney;

    public String a;



    public void count(){

        data = new Data();

        power = (1-data.second/10800)*100;
        //money = data.second/3600*3.6;
        if(data.second>0){
            if(data.second<=3600) {
                money = 1.5;
                System.out.println("费用：" + money);
            }
        }else if(data.second>3600) {
            if(data.second<=7200) {
                money = 1.5 * 2;
                System.out.println("费用：" + money);
            }
        }else if(data.second>7200) {
            if (data.second <= 10800) {
                money = 1.5 * 3;
                System.out.println("费用：" + money);
            }
        }

        a=String.valueOf(money);
        //data.bill=a;
        data.setBill(a);



    }

}
