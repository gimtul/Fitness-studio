import gym.ForumType;

import java.util.ArrayList;

public class Secretary extends Person{
    private boolean hasaccess;
    private ArrayList<Client> clients;
    public Time currentTime=new Time(29,12,2024,12,0);
    public Secretary(Person person, int salary){
        super(person.getName(),salary,person.getGender(),person.getBirthdate());
        this.hasaccess=true;
    }
    public void revokeAccess(){
        this.hasaccess=false;
    }

    public Client registerClient(Person p2) throws InvalidAgeException, DuplicateClientException {
        if (p2.getAge(currentTime)<18)
            throw new InvalidAgeException("Invalid age, to register you have to be over 18");
        if (clients.contains(p2))
            throw new DuplicateClientException("client is already in system");
        clients.add((Client) p2);
        return(new Client(p2));
    }

    public void unregisterClient(Client c2) {
        c2.unregister();
        clients.remove(c2);
    }

    public Instructor hireInstructor(Person p4, int i, ArrayList<SessionType> objects) {
        return(new Instructor(p4,i,objects));
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
        if (s1.getRemainingSpots()>0)
            s1.register(c1);
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
        for (Client client: this.clients){
        }
    }
    public void notify(String str){
        for (Client client: this.clients)
            client.message(str);
    }
    public void notify(Client c, String str){

    }
    public void printActions() {

    }
}
