enum Gender{
    Male,
    Female,
    Other
}
public class Person {
    private String name;
    private int balance;
    private String birthdate;
    private Gender gender;
    private int age;
    public Person(String name, int income,Gender gender,String birthdate){
        this.name=name;
        this.balance=income;
        this.gender=gender;
        this.birthdate=birthdate;
    }
    public int getAge(){
        Time currenttime=new Time();
        String[] parts=birthdate.split("-");
        this.age=currenttime.getYear()-(Integer.parseInt(parts[2]));
        if (currenttime.getMonth()<(Integer.parseInt(parts[1])))
            this.age--;
        if (currenttime.getMonth()==(Integer.parseInt(parts[1]))){
            if (currenttime.getDay()<(Integer.parseInt(parts[0])))
                this.age--;
        }
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public int getBalance(){
        return this.balance;
    }
    public Gender getGender(){
        return this.gender;
    }
    public String getBirthdate(){
        return this.birthdate;
    }
    public void setBalance(int i){
        this.balance=i;
    }
}
