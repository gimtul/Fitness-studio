import java.util.ArrayList;

public class Secretary extends Person{
    private boolean hasAccess;
    private ArrayList<Client> clients;
    private ArrayList<Instructor> instructors;
    public Time currentTime=new Time();
    public Secretary(Person person, int salary){
        super(person.getName(),salary,person.getGender(),person.getBirthdate());
        this.hasAccess=true;
        this.clients = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }
    public void revokeAccess(){
        this.hasAccess=false;
    }

    public boolean isClientRegistered(Person p2) {
        for (Client client : this.clients) {
            if (client.equals(p2)) {
                return true;
            }
        }
        return false;
    }

    public Client registerClient(Person p2) throws InvalidAgeException, DuplicateClientException {
        if (p2.getAge()<18)
            throw new InvalidAgeException("Invalid age, to register you have to be over 18");

        if (isClientRegistered(p2))
            throw new DuplicateClientException("Client is already in the system");

        Client newClient = new Client(p2);
        clients.add(newClient);
        return newClient;
    }

    public void unregisterClient(Client c2) throws ClientNotRegisteredException {///////////////////
        if (!isClientRegistered(c2))
            throw new ClientNotRegisteredException("client is not registered");
        c2.unregister();
        clients.remove(c2);
    }

    public Instructor hireInstructor(Person p4, int i, ArrayList<SessionType> objects) {
        Instructor instructor=new Instructor(p4,i,objects);
        instructors.add(instructor);
        return(instructor);
    }
    public Session addSession(SessionType type, String date, ForumType gender, Instructor instructor) throws InstructorNotQualifiedException {
        ArrayList<SessionType> instructureType=instructor.getAllowedSessions();
        if (!instructureType.contains(type))
            throw new InstructorNotQualifiedException("instructor is not qualified to instruct this session");
        return (new Session(type,date,gender,instructor));
    }

    public void registerClientToLesson(Client c1, Session s1) throws ClientNotRegisteredException, DuplicateClientException {
        if (!c1.isClient())
            throw new ClientNotRegisteredException("client is not registered");

        if (s1.getRemainingSpots()>0) {
            if (!s1.sessionPassed()) {
                //System.out.println(s1.getDate() + ", client: " + c1.getName());
                s1.register(c1);
            }
            else
                c1.message("session has passed");
        }
        else
            c1.message("session is full");
    }

    public void notify(Session sess, String str) {
        if (sess.getRegisteredClients() != null) {
            ArrayList<Client> clientsRegistered = new ArrayList<>(sess.getRegisteredClients());
            for (Client client : clientsRegistered)
                client.message(str);
        }
    }
    public void notify(String date,String str){

    }
    public void notify(String str){
        for (Client client: this.clients)
            client.message(str);
    }
    public void notify(Client c, String str){
        c.message(str);
    }
    public void printActions() {

    }

    public void paySalaries() {
        for (Instructor inst: instructors){
            inst.setBalance(inst.getBalance()+ inst.getPay());
            inst.setPay(0);
        }
    }
}
