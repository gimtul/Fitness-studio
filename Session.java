import java.util.ArrayList;
enum ForumType{
    All,
    Female,
    Seniors,
    Male
}
public class Session {
    private ForumType forumType;
    final String date;
    private int participants;
    private int availableSpots;
    private int price;
    private ArrayList<Client> clients;
    private SessionType sessionType;
    private Instructor instructor;

    public Session(SessionType sessiontype, String date, ForumType forumtype,Instructor instructor){
        this.forumType=forumtype;
        this.date=date;
        this.clients = new ArrayList<>();
        this.sessionType=sessiontype;
        this.instructor=instructor;
        if (sessiontype==SessionType.Pilates){
            this.price=60;
            this.participants=30;
            availableSpots=30;
        }
        if (sessiontype==SessionType.MachinePilates){
            this.price=80;
            this.participants=10;
            availableSpots=10;
        }
        if (sessiontype==SessionType.ThaiBoxing){
            this.price=100;
            this.participants=20;
            availableSpots=20;
        }
        if (sessiontype==SessionType.Ninja){
            this.price=150;
            this.participants=5;
            availableSpots=5;
        }
        instructor.addPay();
    }

    public boolean isClientRegistered(Person p2) {
        for (Client client : clients) {
            if (client.equals(p2)) {
                return true;
            }
        }
        return false;
    }

    public void register(Client c) throws DuplicateClientException {
        boolean ableToRegister = true;
        if (isClientRegistered(c))
            throw new DuplicateClientException("Error: The client is already registered for this lesson");
        if (this.sessionPassed()){
            Gym.getInstance().getSecretary().addAction("Failed registration: Session is not in the future");
            ableToRegister = false;
        }

        if ((this.forumType==ForumType.Female&&c.getGender()!=Gender.Female)||(this.forumType==ForumType.Male&&c.getGender()!=Gender.Male)){
            Gym.getInstance().getSecretary().addAction("Failed registration: Client's gender doesn't match the session's gender requirements");
            ableToRegister = false;
        }
        if (this.forumType==ForumType.Seniors&&c.getAge()<65){
            Gym.getInstance().getSecretary().addAction("Failed registration: Client doesn't meet the age requirements for this session (Seniors)");
            ableToRegister = false;
        }
        if (c.getBalance()<this.price){
            Gym.getInstance().getSecretary().addAction("Failed registration: Client doesn't have enough balance");
            ableToRegister = false;
        }
        if (availableSpots<=0){
            Gym.getInstance().getSecretary().addAction("Failed registration: No available spots for session");
            ableToRegister = false;
        }
        if (ableToRegister){
            clients.add(c);
            availableSpots--;
            c.setBalance(c.getBalance()-this.price);
            Gym.getInstance().addToGymBalance(this.price);
            Gym.getInstance().getSecretary().addAction("Registered client: "+c.getName()+" to session: "+this.getSessionType()+" on "+this.getDate()+" for price: "+this.getPrice());
        }
    }
    public SessionType getSessionType(){return sessionType;}
    public int getPrice(){return price;}
    public int getAvailableSpots(){
        return availableSpots;
    }
    public int getTakenSpots(){
        return clients.size();
    }
    public int getParticipants(){
        return participants;
    }
    public ArrayList<Client> getRegisteredClients(){
        return clients;
    }
    public ForumType getForumType(){
        return forumType;
    }
    public String getDate(){
        return date;
    }

    public Instructor getInstructor(){
        return instructor;
    }

    public boolean sessionPassed(){
        Time sessionTime = new Time(this.date);
        Time currentTime = new Time();
        return currentTime.isAfter(sessionTime);
    }
}
