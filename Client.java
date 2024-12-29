import java.util.ArrayList;

public class Client extends Person{
    private boolean hasAccess;
    private ArrayList<String> messages;
    public Client(Person p){
        super(p);
        this.hasAccess = true;
        this.messages = new ArrayList<>();
    }
    public void unregister(){
        this.hasAccess=false;
    }
    public void message(String str){
        this.messages.add(str);
    }
    public boolean isClient(){
        return hasAccess;
    }

    public ArrayList<String> getNotifications() {
        return messages;
    }
    public void setClientBalance(int i){
        super.setBalance(i);
    }
    public int getClientBalance(){
        return super.getBalance();
    }
}
