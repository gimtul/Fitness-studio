import gym.ForumType;

import java.util.ArrayList;

public class Secretary extends Person{
    private boolean hasAccess;
    private ArrayList<Client> clients;
    private ArrayList<Instructor> instructors;
    public Time currentTime=new Time();
    public Secretary(Person person, int salary){
        super(person.getName(),salary,person.getGender(),person.getBirthdate());
        this.hasAccess=true;
    }
    public void revokeAccess(){
        this.hasAccess=false;
    }

    public Client registerClient(Person p2) throws InvalidAgeException, DuplicateClientException {
        if (p2.getAge()<18)
            throw new InvalidAgeException("Invalid age, to register you have to be over 18");
        else if (clients.contains(p2)) {
            throw new DuplicateClientException("client is already in system");
        }
        clients.add((Client) p2);
        return(new Client(p2));
    }

    public void unregisterClient(Client c2) throws ClientNotRegisteredException {
        if (!clients.contains(c2))
            throw new ClientNotRegisteredException("client is not registerd");
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
        Time sessionTime=new Time(s1.getDate());
        if (s1.getRemainingSpots()>0) {
            if (s1.sessionPassed()) {
                s1.register(c1);
            }
            else
                c1.message("session has passed");
        }
        else
            c1.message("session is full");
    }

    public void notify(Session sess, String str) {
        ArrayList<Client> clientsRegisterd=null;
        clientsRegisterd.addAll(sess.getRegisteredClients());
        for (Client client: clientsRegisterd)
            client.message(str);
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
