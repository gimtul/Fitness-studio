import java.util.ArrayList;
enum SessionType{
    ThaiBoxing,
    MachinePilates,
    Pilates,
    Ninja
}
public class Instructor extends Person {
    private boolean hasaccess;
    private ArrayList<SessionType> allowedSessions;
    final int income;
    private int pay = 0;
    public Instructor(Person p,int i, ArrayList<SessionType> arr){
        super(p);
        hasaccess=true;
        this.allowedSessions=new ArrayList<>(arr);
        this.income=i;
    }
    public ArrayList<SessionType> getAllowedSessions(){
        return this.allowedSessions;
    }
    public void addPay(){
        this.pay=pay+income;
    }
    public int getPay(){
        return pay;
    }
    public int getIncome(){
        return income;
    }
    public void setPay(int i){
        this.pay=i;
    }
}
