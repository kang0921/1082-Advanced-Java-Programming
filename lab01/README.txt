Problem

請宣告以下三類別:

1.   Class Person{
   FirstName: String;
   LastName: String;
   City: Enum{TAIPEI, TAICHUNG, KAOHSIUNG,OTHER};       // 居住城市

   BirthDay:String ;    // format as:   2020/09/28

   Gender:Enum { MALE, FEMALE};

}

2.   Class ScoreSheet {
   Math: Int;             //數學成績 0 ~ 100
   English: Int;             // 英文成績 0 ~ 100
   Chinese: Int;            // 中文成績 0 ~ 100
   Average: Double;   //  3 科平均分數
}

3.   Class Student {
   Id: String;            //學號9位數字:  405261112
   Info: Person;

   Scores: ScoreSheet;
}

請使用Java 8 Streams, Lambdas, and Method Reference撰寫程式，程式中不可使用external iteration (for, while, do while statements), 未依規定以0分計。

Input/Output

輸入/輸出格式請自行設計，至少輸入10筆學生(學號、個人資料/成績單)資料。

   

請實作以下問題之解答程式。

Q1: (1) 學生資料按照學號升序印出及(2) 按照出生日降序(年紀小到大)印出學生姓名(FirstName, Last Name)。

Q2: 把學生居住城市轉存在Set中並輸出城市名稱。

Q3: 按照學生居住城市別，輸出居住在該城市之學生姓名 (FirstName, Last Name)。要求: 使用Grouping。

Q4: 使用Partitioning 將學生分成 MALE 與 FEMALE兩群組並輸出學生姓名。

Q5: 請輸出每個考科的平均分數、最低分與最高分。You have to use IntSummaryStatistics or  DoubleSummaryStatistics.

Q6: 根據考科別，輸出該科不及格同學之學號與姓名。

Q7: 將學生資料 [學號，姓名，三科平均分數] 按照三科平均分數降序(分數高到低) 輸出。

Q8: 將各科學生分群，分成及格與不及格兩群學生並印出。