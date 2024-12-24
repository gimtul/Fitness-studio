public class Gym {
    private String name;
    private Secretary currentsecretary;

    public Gym(){

    }

    public static Gym getInstance() {
        return null;
    }

    public String getName(){
        return name;
    }
    public void setName(String n){
        this.name=n;
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
