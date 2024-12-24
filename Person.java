enum Gender{
    Male,
    Female,
    Other
}
public class Person {
    private String name;
    private int income;
    private String birthdate;
    private Gender gender;
    private int age;
    public Person(String name, int income,Gender gender,String birthdate){
        this.name=name;
        this.income=income;
        this.gender=gender;
        this.birthdate=birthdate;
    }
    public int getAge(Time currenttime){
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
    protected String getName() {
        return this.name;
    }
    protected int getSalary(){
        return this.income;
    }
    protected Gender getGender(){
        return this.gender;
    }
    protected String getBirthdate(){
        return this.birthdate;
    }
}
