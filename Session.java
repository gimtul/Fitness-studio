import java.util.ArrayList;

public class Session {
    private ForumType forumType;
    private String date;
    private String hour;
    private int participants;
    private static int availableSpots;
    private int price;
    private ArrayList<Client> clients;

    public Session(SessionType sessiontype, String date, ForumType forumtype,Instructor instructor){
        this.forumType=forumtype;
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

    }
    public void register(Client c) throws DuplicateClientException {
        if (clients.contains(c))
            throw new DuplicateClientException("client is already registerd to this lesson");
        clients.add(c);
        availableSpots--;
    }
    public int getRemainingSpots(){
        return availableSpots;
    }
    public ArrayList<Client> getRegisteredClients(){
        return clients;
    }
}
