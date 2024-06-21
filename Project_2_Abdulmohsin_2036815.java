//Name: Abdulmohsin Mustafa Ageel
//University ID: 2036815
//Section: AA

//All classes are included in this class!!!!!!!

import java.util.Scanner;
import java.io.*;
import java.util.Date;


//University class
class University {
    //Variables
    private String uniName, uniCity;
    private Course [] uniCourses;
    //Constructors
    public University() {
    }
    public University(String uniName, String uniCity, int NumberOfCourses) {
        this.uniName = uniName;
        this.uniCity = uniCity;
        this.uniCourses = new Course[NumberOfCourses];
    }
    //Getters
    public String GetUniName() {
        return uniName;
    }
    public String GetUniCity() {
        return uniCity;
    }
    public Course GetCourse(int index) {
        return uniCourses[index];
    }
    public Course[] GetAllCourses() {
        return uniCourses;
    }
    //Setters
    public void SetUniName(String uniName) {
        this.uniName = uniName;
    }
    public void SetUniCity(String uniCity) {
        this.uniCity = uniCity;
    }

    public void AddCourse(Course uniCourses, int index){
        this.uniCourses[index] = uniCourses;
    }
}
//#####################################################################################################################################################################
//Course class
class Course {
    //Variables
    private String courseName, courseDays, courseTime, courseRoom, courseBuilding, courseInstructor;
    private Student [] RegisteredStudents;
    //courseNumber varaible is missing in the add_course line in the input file.
    //Constructors
    public Course(){
    }
    public Course(String courseName, String courseDays, String courseTime, String courseRoom, String courseBuilding, String courseInstructor, int capacity) {
        this.courseName = courseName;
        this.courseDays = courseDays;
        this.courseTime = courseTime;
        this.courseRoom = courseRoom;
        this.courseBuilding = courseBuilding;
        this.courseInstructor = courseInstructor;
        this.RegisteredStudents = new Student[capacity];
    }
    //Getters
    public String GetCourseName() {
        return courseName;
    }
    public String GetCourseDays() {
        return courseDays;
    }
    public String GetCourseTime() {
        return courseTime;
    }
    public String GetCourseRoom() {
        return courseRoom;
    }
    public String GetCourseBuilding() {
        return courseBuilding;
    }
    public String GetCourseInstructor() {
        return courseInstructor;
    }
    public Student GetStudent(int index) {
        return RegisteredStudents[index];
    }
    public Student[] GetAllStudents() {
        return RegisteredStudents;
    }
    //Setters
    public void SetCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void SetCourseDays(String courseDays) {
        this.courseDays = courseDays;
    }
    public void SetCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    public void SetCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }
    public void SetCourseBuilding(String courseBuilding) {
        this.courseBuilding = courseBuilding;
    }
    public void SetCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
    
    public void AddStudent(Student stud, int index) {
        this.RegisteredStudents[index] = stud;
    }
}
//#####################################################################################################################################################################
//Student class
 class Student {
    //Variables
    private String studID, studName;
    private float studGPA;
    private double studGrade;
    private static int studentsCounter = 0;
    //Constructors
    public Student(){
        studentsCounter++;
    }
    //UML didn't include studGrade in the Constructor so it was correcetd to be included.
    public Student(String studID, String studName, float studGPA, double studGrade){
        this.studID = studID;
        this.studName = studName;
        this.studGPA = studGPA;
        this.studGrade = studGrade;
        studentsCounter++;
    }
    //Getters
    public String GetStudName() {
        return studName;
    }
    public String GetStudID() {
        return studID;
    }
    public float GetStudGPA() {
        return studGPA;
    //Added a getter for studGrade.
    }
    public double GetStudGrade() {
        return studGrade;
    }
    public double GetstudentsCounter() {
        return studentsCounter;
    }
    //Setters
    public void SetStudName(String studName) {
        this.studName = studName;
    }
    public void SetStudID(String studID) {
        this.studID = studID;
    }
    public void SetStudGPA(float studGPA) {
        this.studGPA = studGPA;
    }
    //Added a setter for studGrade.
    public void SetStudGrade(double studGrade) {
        this.studGrade = studGrade;
    }
}
//#####################################################################################################################################################################
//main class
public class Project_2_Abdulmohsin_2036815 {
    public static void main(String[] args) throws FileNotFoundException {

        //Reading from input file initialization.
        File Input_File = new File("Input.txt");
        if (!Input_File.exists()) {
            System.out.println("File " + Input_File + " was not found! the program will terminate.");
            System.exit(0);
        }
        Scanner Read = new Scanner(Input_File);

        //Writing to output file initialization.
        File OutputFile = new File("output.txt");
        PrintWriter Output_File = new PrintWriter(OutputFile);

        Output_File.println("################################################");
        Output_File.println("####### Students Information System v.2 ########");
        Output_File.println("################################################");
        //University object array.
        University[] universities = new University[Read.nextInt()];

        Output_File.println("- Number of universities: " + universities.length);
        Output_File.println();

        Read.nextLine();

        int UniversityCount = 0;
        int courseNumber = 0;
        String UNIVERSITY = "";
        String[] FirstandLastName;

        //Beginning to read commands from file.
        while (Read.hasNextLine()) {
            //Command reading initialization.
            String Line = Read.nextLine();
            String[] SplitedLine = Line.split(" ");
            String Command = SplitedLine[0];

            switch (Command) {
//#####################################################################################################################################################################
                case "add_universities":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    //Giving the universities[UniversityCount] a reference 
                    universities[UniversityCount] = new University(SplitedLine[1], SplitedLine[2], Integer.parseInt(SplitedLine[3]));
                    Output_File.println("                + " + SplitedLine[1]);
                    Output_File.println();
                    UniversityCount++;
                    break;
//#####################################################################################################################################################################
                case "add_courses":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    if (!UNIVERSITY.equals(SplitedLine[1])) {
                        UNIVERSITY = SplitedLine[1];
                        courseNumber = 0;
                    }
                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            //Due to the lack of a courseNumber in the add_course command, to determine the course's number, a self-implemented variable called courseNumber will be used and will reset to 0 if the university changes.
                            //The variable UNIVERSITY will reset the courseNumber to 0 if the university in add_course changes.
                            Course C = new Course(SplitedLine[2], SplitedLine[3], SplitedLine[4], SplitedLine[5], SplitedLine[6], SplitedLine[7], Integer.parseInt(SplitedLine[8]));
                            universities[University].AddCourse(C, courseNumber);

                            Output_File.println("		+ " + SplitedLine[2] + " - " + universities[University].GetUniName());
                            Output_File.println();
                            courseNumber++;
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "add_students":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                                //The universities[University].GetCourse(Course) will return the specified course object, and then the .GetCourseName() will return the course's name.
                                if (universities[University].GetCourse(Course).GetCourseName().equals(SplitedLine[2])) {
                                    //StudentNumber will determine the index of a student.
                                    int StudentsToRecored = Integer.parseInt(SplitedLine[3]);
                                    
                                    if (StudentsToRecored > universities[University].GetCourse(Course).GetAllStudents().length){
                                        Output_File.println("last " + (StudentsToRecored - universities[University].GetCourse(Course).GetAllStudents().length) + " student/s won't be recorded because they will exceed the capacity for course " + universities[University].GetCourse(Course).GetCourseName());
                                    }
                                    for (int StudentNumber = 0; StudentNumber < StudentsToRecored; StudentNumber++) {
                                        
                                        Read.nextLine();
                                        Line = Read.nextLine();
                                        SplitedLine = Line.split(" ");
                                        
                                        if (StudentNumber >= universities[University].GetCourse(Course).GetAllStudents().length){
                                            Output_File.println("		  Not recorded");
                                            continue;
                                        }

                                        //if statement because (7011231 Faisal_Hamza 3.2  73) has 2 spaces between the GPA and grade which results in an error when splitting.
                                        if (SplitedLine[3].equals("")) {
                                            SplitedLine[3] = SplitedLine[4];
                                        }

                                        Student S = new Student(SplitedLine[0], SplitedLine[1], Float.parseFloat(SplitedLine[2]), Double.parseDouble(SplitedLine[3]));
                                        universities[University].GetCourse(Course).AddStudent(S, StudentNumber);

                                        FirstandLastName = SplitedLine[1].split("_");
                                        Output_File.println("		+ " + FirstandLastName[0] + " " + FirstandLastName[1] + " - " + universities[University].GetCourse(Course).GetCourseName() + " - " + universities[University].GetUniName());
                                    }
                                    Output_File.println();
                                }
                            }
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "print_result":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {

                                Output_File.println("	-> University: " + universities[University].GetUniName());
                                Output_File.println("	-> Course: " + universities[University].GetCourse(Course).GetCourseName());
                                Output_File.println("	-> Number of students: " + universities[University].GetCourse(Course).GetAllStudents().length);
                                Output_File.println("--------------------------------------------------------------------");
                                Output_File.println("ID             First Name     Last Name      GPA            Grade   ");
                                Output_File.println("--------------------------------------------------------------------");

                                for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {

                                    Output_File.printf("%-15s", universities[University].GetCourse(Course).GetStudent(Student).GetStudID());
                                    FirstandLastName = universities[University].GetCourse(Course).GetStudent(Student).GetStudName().split("_");
                                    Output_File.printf("%-15s", FirstandLastName[0]);
                                    Output_File.printf("%-15s", FirstandLastName[1]);
                                    Output_File.printf("%-15s", universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA());
                                    Output_File.printf("%-15s", universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade());
                                    Output_File.println();
                                }
                                Output_File.println("--------------------------------------------------------------------");
                                Output_File.println();
                            }
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "find_average_grade":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                                if (universities[University].GetCourse(Course).GetCourseName().equals(SplitedLine[2])) {

                                    Output_File.println("		-> University: " + universities[University].GetUniName());
                                    Output_File.println("		-> Course: " + universities[University].GetCourse(Course).GetCourseName());

                                    double GradeSum = 0;
                                    int StudentCount = 0;
                                    for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                        GradeSum += universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade();
                                        StudentCount++;
                                    }
                                    Output_File.println("		-> Average Grades: " + (GradeSum / StudentCount));
                                    Output_File.println();
                                }
                            }
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "find_max_grade":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                                if (universities[University].GetCourse(Course).GetCourseName().equals(SplitedLine[2])) {
                                    Output_File.println("		-> University: " + universities[University].GetUniName());
                                    Output_File.println("		-> Course: " + universities[University].GetCourse(Course).GetCourseName());

                                    double MaxGrade = 0;
                                    String StudentInformation = "";
                                    for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                        if (universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade() > MaxGrade) {
                                            MaxGrade = universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade();
                                            FirstandLastName = universities[University].GetCourse(Course).GetStudent(Student).GetStudName().split("_");
                                            StudentInformation = MaxGrade + " for student " + FirstandLastName[0] + " " + FirstandLastName[1] + " (" + universities[University].GetCourse(Course).GetStudent(Student).GetStudID() + ")";
                                        }
                                    }
                                    Output_File.println("		-> Max Grades:" + StudentInformation);
                                    Output_File.println();
                                }
                            }
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "find_min_grade":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    for (int University = 0; University < universities.length; University++) {
                        if (universities[University].GetUniName().equals(SplitedLine[1])) {
                            for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                                if (universities[University].GetCourse(Course).GetCourseName().equals(SplitedLine[2])) {
                                    Output_File.println("		-> University: " + universities[University].GetUniName());
                                    Output_File.println("		-> Course: " + universities[University].GetCourse(Course).GetCourseName());

                                    double MinGrade = 1000;
                                    String StudentInformation = "";
                                    for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                        if (universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade() < MinGrade) {
                                            MinGrade = universities[University].GetCourse(Course).GetStudent(Student).GetStudGrade();
                                            FirstandLastName = universities[University].GetCourse(Course).GetStudent(Student).GetStudName().split("_");
                                            StudentInformation = MinGrade + " for student " + FirstandLastName[0] + " " + FirstandLastName[1] + " (" + universities[University].GetCourse(Course).GetStudent(Student).GetStudID() + ")";
                                        }
                                    }
                                    Output_File.println("		-> Min Grades:" + StudentInformation);
                                    Output_File.println();
                                }
                            }
                        }
                    }
                    break;
//#####################################################################################################################################################################
                case "find_average_gpa":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    double GPASum = 0;
                    int StudentCount = 0;
                    for (int University = 0; University < universities.length; University++) {
                        for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                            for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                GPASum += universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA();
                                StudentCount++;
                            }
                        }
                    }
                    Output_File.println("	* The average GPA for all students in all universities is " + (GPASum / StudentCount));
                    Output_File.println();
                    break;
//#####################################################################################################################################################################
                case "find_max_gpa":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    double MaxGPA = 0;
                    int WhichUniversity = 0,
                     WhichCourse = 0,
                     WhichStudent = 0;
                    for (int University = 0; University < universities.length; University++) {
                        for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                            for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                if (universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA() > MaxGPA) {
                                    MaxGPA = universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA();
                                    WhichUniversity = University;
                                    WhichCourse = Course;
                                    WhichStudent = Student;
                                }
                            }
                        }
                    }
                    Output_File.println("	* The Top Performing Student in all universities is:");
                    Output_File.println("--------------------------------------------------------------------");
                    Output_File.println("ID             Full Name      GPA            Grade          ");
                    Output_File.println("--------------------------------------------------------------------");

                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudID());
                    FirstandLastName = universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudName().split("_");
                    Output_File.printf("%-15s", FirstandLastName[0] + " " + FirstandLastName[1]);
                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudGPA());
                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudGrade());
                    Output_File.println();
                    Output_File.println("--------------------------------------------------------------------");
                    Output_File.println("	-> University: " + universities[WhichUniversity].GetUniName());
                    Output_File.println();
                    break;
//#####################################################################################################################################################################
                case "find_min_gpa":
                    Output_File.println("- Command: " + SplitedLine[0]);

                    double MinGPA = 1000;
                    WhichUniversity = 0;
                    WhichCourse = 0;
                    WhichStudent = 0;
                    for (int University = 0; University < universities.length; University++) {
                        for (int Course = 0; Course < universities[University].GetAllCourses().length; Course++) {
                            for (int Student = 0; Student < universities[University].GetCourse(Course).GetAllStudents().length; Student++) {
                                if (universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA() < MinGPA) {
                                    MinGPA = universities[University].GetCourse(Course).GetStudent(Student).GetStudGPA();
                                    WhichUniversity = University;
                                    WhichCourse = Course;
                                    WhichStudent = Student;
                                }
                            }
                        }
                    }
                    Output_File.println("	* The Worst Performing Student in all universities is:");
                    Output_File.println("--------------------------------------------------------------------");
                    Output_File.println("ID             Full Name      GPA            Grade          ");
                    Output_File.println("--------------------------------------------------------------------");

                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudID());
                    FirstandLastName = universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudName().split("_");
                    Output_File.printf("%-15s", FirstandLastName[0] + " " + FirstandLastName[1]);
                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudGPA());
                    Output_File.printf("%-15s", universities[WhichUniversity].GetCourse(WhichCourse).GetStudent(WhichStudent).GetStudGrade());
                    Output_File.println();
                    Output_File.println("--------------------------------------------------------------------");
                    Output_File.println("	-> University: " + universities[WhichUniversity].GetUniName());
                    Output_File.println();
                    break;
//#####################################################################################################################################################################
                case "about_app":
                    Output_File.println("- Command: " + Command);

                    Output_File.println("        -> Developed By: Abdulmohsin Mustafa Ageel");
                    Output_File.println("        -> University ID: 2036815");
                    Output_File.println("        -> Section: AA");
                    Output_File.println();
                    break;
//#####################################################################################################################################################################
                case "exit":
                    Output_File.println("Goodbye :)");
                    Date D = new Date();
                    Output_File.println("This file is generated on " + D.toString());
                    Output_File.close();
                    break;
//#####################################################################################################################################################################
            }//End of switch.
        }//End of while-loop.
    }//End of main.
}//End of class.
