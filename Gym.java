public class Gym {
    private String name;
    private Secretary currentsecretary;
    private int gymBalance=0;
    private static Gym instance;

    public Gym(){

    }

    public static Gym getInstance() {
        if (instance == null) {
            instance = new Gym(); // Create the instance only if it doesn't exist
        }
        return instance;    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setSecretary(Person p, int n){
        if (currentsecretary!=null){
            currentsecretary.revokeAccess();
        }
        this.currentsecretary= new Secretary(p,n);
    }
    public Secretary getSecretary(){
        return currentsecretary;
    }
    public void addToBalance(int i){
        this.gymBalance = gymBalance+1;
    }

    public int getGymBalance() {
        return this.gymBalance;
    }

    public void addToGymBalance(int amount) {
        gymBalance += amount;
    }
    public void subtractFromGymBalance(int amount) {
        gymBalance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Gym Name: %s\nGym Secretary: %s\nGym Balance: %d\n\nClients Data:\n", getName(), getSecretary(), getGymBalance());
    }

}
