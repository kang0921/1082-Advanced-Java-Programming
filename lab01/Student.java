package com.company;

public class Student{
    private final String Id;
    private final Person info;
    private final ScoreSheet Scores;
    Student(String Id, Person info, ScoreSheet Scores){
        this.Id = Id;
        this.info = info;
        this.Scores = Scores;
    }
    public String getId(){
        return Id;
    }
    public Person getPerson(){
        return info;
    }
    public ScoreSheet getScores(){
        return Scores;
    }
    public double getScoresAverage(){
        return Scores.getAverage();
    }
    public void printStudent(){
        System.out.print(getId() + " ");
        getPerson().printPerson();
        System.out.print(" ");
        getScores().printScoresheet();
        System.out.println();
    }
    public void print_Id_Name_Average(){
        System.out.println(getId() + " " + getPerson().toString() + " " + getScores().getAverage() );
    }
    public String toString(){
        return "\n" + getPerson().getFirstName() + " "
                + getPerson().getLastName() + " "
                + getPerson().getCity() + " "
                + getPerson().getBirthday() + " "
                + getPerson().getGender() + " "
                + "Math : " + getScores().getMath() + " "
                + "English : " + getScores().getEnglish() + " "
                + "Chinese : " + getScores().getChinese() + " "
                + "Average : " + getScoresAverage();
    }
}
