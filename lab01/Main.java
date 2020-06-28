package com.company;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        List<Person> person = new ArrayList<>();
        List<ScoreSheet> scoresheets = new ArrayList<>();
        List<Student> student = new ArrayList<>();

        for(int i = 0; i<cases ; i++){
            String id = input.next();

            String firstname = input.next();
            String lastname = input.next();
            String city = input.next();
            String birthday = input.next();
            String gender = input.next();
            Person _person = new Person(firstname, lastname, Person.City.conversion(city), birthday, Person.Gender.conversion(gender) );
            person.add( _person );

            int math = input.nextInt();
            int english = input.nextInt();
            int chinese = input.nextInt();
            ScoreSheet _scoresheet = new ScoreSheet(math, english, chinese);
            scoresheets.add( _scoresheet );
            student.add( new Student(id, _person, _scoresheet));

        }

        // Q1(1) 學生資料按照學號升序印出
        System.out.println("Q1(1):");
        student.stream().sorted(Comparator.comparing(Student::getId)).forEach(Student::printStudent);

        // Q1(2) 按照出生日降序(年紀小到大)印出學生姓名(FirstName, Last Name)
        System.out.println("\nQ1(2):");
        person.sort((a1, a2) -> Integer.parseInt(String.valueOf(Integer.parseInt( a2.getBirthday() ) - Integer.parseInt( a1.getBirthday() ))));
        person.forEach(System.out::println);

        //Q2  把學生居住城市轉存在Set中並輸出城市名稱
        System.out.println("\nQ2:");
        Set<Person.City>set = person.stream()
                                    .map(Person::getCity)
                                    .collect(toSet());
        set.forEach(System.out::println);

        //Q3 按照學生居住城市別，輸出居住在該城市之學生姓名 (FirstName, Last Name)。要求: 使用Grouping。
        System.out.println("\nQ3:");
        Map<Person.City, List<Person>> groupStudentByCity = person.stream().collect(groupingBy(Person::getCity));
        System.out.println(groupStudentByCity);

        //Q4 使用Partitioning 將學生分成 MALE 與 FEMALE兩群組並輸出學生姓名
        System.out.println("\nQ4:");
        Map<Boolean, List<Person>> groupStudentByGender1 = person.stream().collect(partitioningBy(Person::isMALE));
        List<Person> maleList = groupStudentByGender1.get(true);
        System.out.println("MALE = " + maleList);
        Map<Boolean, List<Person>> groupStudentByGender2 = person.stream().collect(partitioningBy(Person::isFEMALE));
        List<Person> femaleList = groupStudentByGender2.get(true);
        System.out.println("FEMALE = " + femaleList);

        //Q5 請輸出每個考科的平均分數、最低分與最高分。You have to use IntSummaryStatistics or  DoubleSummaryStatistics.
        System.out.println("\nQ5:");
        IntSummaryStatistics statsMath = scoresheets.stream().collect(
                Collectors.summarizingInt(ScoreSheet::getMath)
        );
        System.out.println( "Average of math score: " + statsMath.getAverage() );
        System.out.println( "Lowest of math score: " + statsMath.getMin() );
        System.out.println( "Highest fo math score: " + statsMath.getMax() + "\n");

        IntSummaryStatistics statsEnglish = scoresheets.stream().collect(
                Collectors.summarizingInt(ScoreSheet::getEnglish)
        );
        System.out.println( "Average of english score: " + statsEnglish.getAverage() );
        System.out.println( "Lowest of english score: " + statsEnglish.getMin() );
        System.out.println( "Highest fo english score: " + statsEnglish.getMax() + "\n");

        IntSummaryStatistics statsChinese = scoresheets.stream().collect(
                Collectors.summarizingInt(ScoreSheet::getChinese)
        );
        System.out.println( "Average of chinese score: " + statsChinese.getAverage() );
        System.out.println( "Lowest of chinese score: " + statsChinese.getMin() );
        System.out.println( "Highest fo chinese score: " + statsChinese.getMax() );


        //Q6 根據考科別，輸出該科不及格同學之學號與姓名
        System.out.println("\nQ6:");
        List<String> failMath =
                student.stream().filter(student1 -> student1.getScores().getMath() < 60)
                        .map(student1 -> student1.getId() + student1.getPerson().toString())
                        .collect(toList());
        System.out.println("Failed Math:");
        failMath.forEach(System.out::println);

        List<String> failEnglish =
                student.stream().filter(student1 -> student1.getScores().getEnglish() < 60)
                        .map(student1 -> student1.getId() +  student1.getPerson().toString())
                        .collect(toList());
        System.out.println("\nFailed English:");
        failEnglish.forEach(System.out::println);

        List<String> failChinese =
                student.stream().filter(student1 -> student1.getScores().getChinese() < 60)
                        .map(student1 ->  student1.getId() + student1.getPerson().toString() )
                        .collect(toList());
        System.out.println("\nFailed Chinese:");
        failChinese.forEach(System.out::println);

        //Q7: 將學生資料 [學號，姓名，三科平均分數] 按照三科平均分數降序(分數高到低) 輸出
        System.out.println("\nQ7:");
        student.sort(comparing(Student::getScoresAverage,
                (s1, s2) -> {
                    return s2.compareTo(s1);
                }));
        student.forEach(Student::print_Id_Name_Average);

        //Q8: 將各科學生分群，分成及格與不及格兩群學生並印出
        System.out.println("\nQ8:");
        Map<Boolean, List<Student>> MathFailedOrNot = student.stream().collect(Collectors.partitioningBy(student1 -> student1.getScores().getMath() >= 60));
        MathFailedOrNot.forEach((x, y) -> {
            if (x.equals(Boolean.TRUE))System.out.println("Math Pass : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
            else System.out.println("Math Fail : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
        });

        Map<Boolean, List<Student>> EnglishFailedOrNot = student.stream().collect(Collectors.partitioningBy(student1 -> student1.getScores().getEnglish() >= 60));
        EnglishFailedOrNot.forEach((x, y) -> {
            if (x.equals(Boolean.TRUE))System.out.println("English Pass : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
            else System.out.println("English Fail : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
        });

        Map<Boolean, List<Student>> ChineseFailedOrNot = student.stream().collect(Collectors.partitioningBy(student1 -> student1.getScores().getChinese() >= 60));
        ChineseFailedOrNot.forEach((x, y) -> {
            if (x.equals(Boolean.TRUE))System.out.println("Chinese Pass : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
            else System.out.println("Chinese Fail : " + y.stream().map(Student::getPerson).map(Person::getName).collect(Collectors.toList()));
        });
    }

}