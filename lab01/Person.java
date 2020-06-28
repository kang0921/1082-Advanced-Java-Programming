package com.company;

public class Person {

    private final String FirstName;
    private final String LastName;
    private final String Birthday;
    private City city;
    private Gender gender;

    enum City{
        TAIPEI,
        TAICHUNG,
        KAOHSIUNG,
        OTHER;
        public static City conversion(String s){
            if(s != null){
                if(s.equals("TAIPEI"))return City.TAIPEI;
                else if(s.equals("TAICHUNG"))return City.TAICHUNG;
                else if(s.equals("KAOHSIUNG"))return City.KAOHSIUNG;
                else if(s.equals("OTHER"))return City.OTHER;
            }
            return null;
        }
    };
    public enum Gender{
        MALE,
        FEMALE;

        public static Gender conversion(String s){
            if(s != null){
                if(s.equals("MALE"))return Gender.MALE;
                else if(s.equals("FEMALE"))return Gender.FEMALE;
            }
            return null;
        }
    };

    public Person(String FirstName, String LastName, City City, String Birthday, Gender Gender) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.city = City;
        this.Birthday = Birthday;
        this.gender = Gender;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getName() {return FirstName + " " + LastName;}
    public City getCity(){
        return city;
    }
    public String getBirthday(){
        return Birthday;
    }
    public Gender getGender(){
        return gender;
    }
    public boolean isMALE(){ return getGender().equals(Gender.MALE); }
    public boolean isFEMALE(){ return getGender().equals(Gender.FEMALE); }
    public void printPerson(){
        System.out.print(getFirstName() + " " + getLastName() + " " + getCity() + " " + getBirthday() + " " + getGender() );
    }
    public String toString(){
        return getFirstName() + " " + getLastName();
    }
}