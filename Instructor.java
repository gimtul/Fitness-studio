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

    public Instructor(Person p,int i, ArrayList<SessionType> arr){
        super(p.getName(), i, p.getGender(),p.getBirthdate());
        hasaccess=true;
        this.allowedSessions.addAll(arr);
    }
    public ArrayList<SessionType> getAllowedSessions(){
        return this.allowedSessions;
    }
}
