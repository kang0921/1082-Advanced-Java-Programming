package com.company;

public class ScoreSheet{
    private final int Math;
    private final int English;
    private final int Chinese;
    private final double Average;

    ScoreSheet(int Math, int English, int Chinese){
        this.Math = Math;
        this.English = English;
        this.Chinese = Chinese;
        this.Average = (Math + English + Chinese)/3;
    }
    public int getMath(){
        return Math;
    }
    public int getEnglish(){
        return English;
    }
    public int getChinese(){
        return Chinese;
    }
    public double getAverage(){
        return Average;
    }
    public void printScoresheet(){
        System.out.print(getMath() + " " + getEnglish() + " " + getChinese() + " " + getAverage() );
    }
}
