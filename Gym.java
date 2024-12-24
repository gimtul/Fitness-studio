public class Gym {
    private String name;
    private Secretary currentsecretary;
    private int gymBalance;
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

}
