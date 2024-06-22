package task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RegistrationSystem {
    ArrayList <Course> courses = new ArrayList<>();
    ArrayList <Student> students = new ArrayList<>();
    HashMap <String,Course> coursemap = new HashMap<>();
    HashMap <String,Student> studentMap = new HashMap<>();
    Student student;
    Scanner in = new Scanner(System.in);
    public RegistrationSystem(){
        Course A = new Course("CSE 121", "Programming 1", "Basics of Programming using C", 2, "Mon 10:20");
        addCourse(A);
        Course B = new Course("CSE x22", "Data Structures", "Data Structure using java", 1, "Sun 10:20");
        addCourse(B);
        Course C = new Course("EMP 114", "Diffrintial Equations", "Diffrintial Equations", 5, "Mon 8:30");
        addCourse(C);
        Student Aseel = new Student("A101", "Aseel");
        Student Zain = new Student("A102", "Zain");
        Student Peter = new Student("A103", "Peter");
        addStudent(Aseel);
        addStudent(Zain);
        addStudent(Peter);
    
    }
    public void addCourse(Course course){
        courses.add(course);
        coursemap.put(course.code,course);
    }
    public void addStudent(Student student){
        students.add(student);
        studentMap.put(student.id,student);
    }
    public void coursesListing(ArrayList <Course> courses){
       if(courses.isEmpty()){
        System.out.println("No Courses");
        return;
       }
        for(Course c : courses){
            System.out.println("Code : " + c.code);
            System.out.println("Title : " + c.title);
            System.out.println("Describtion : " + c.description);
            System.out.println("places : " + (c.capacity - c.noStudents)+"\n");
            
        }
    }
    public void menu(){
        System.out.print("Enter Student ID : ");
        String id = in.nextLine();
        student = studentMap.get(id);
        while (student == null) {
            System.out.print("Enter Valid Id : ");
            id = in.nextLine();
            student = studentMap.get(id);
            
        }
        System.out.println("Welcome " + student.name);
        options(); 

    }
    public void options(){
        System.out.println("Enter A For Course Listing");
        System.out.println("Enter B For Student Registration");
        System.out.println("Enter C for Course Removal");
        System.out.println("Enter D For Registered Course Listing");
        System.out.println("Enter E for Exit");
        
        System.out.print("Input : ");
        String s = in.nextLine();
        s = s.toUpperCase();
        while(!s.equals("A") && !s.equals("B") && !s.equals("E") && !s.equals("C") && !s.equals("D") ){
            System.out.print("Enter Valid Input : ");
            s = in.nextLine();
        }
        switch (s) {
            case "E":
                System.exit(0);
            case "A":
                System.out.println("Avaliable Courses This Semester");
                coursesListing(courses);
                break;
        
            case "B":
                studentRegister();
                break;
            case "C":
                courseRemoval();
                break;
            case "D":
                System.out.println("Registered Courses :");
                coursesListing(student.courses);
                break;

        }
        System.out.println("Enter Q For Another query");
        System.out.println("Enter U For New Users Menu");
        System.out.println("Enter E for Exit");
        System.out.print("Input : ");
        String h = in.nextLine();
        h = h.toUpperCase();
        while(!h.equals("Q") && !h.equals("U") && !h.equals("E") ){
            System.out.print("Enter Valid Input : ");
            h = in.nextLine();
        }
        switch (h) {
            case "E":
                System.exit(0);
            case "Q":
                options();;
                break;
        
            case "U":
                student = null;
                menu();
                break;

        }

    }
    public void studentRegister(){
        System.out.println("Registered Courses :");
        coursesListing(courses);
        System.out.print("Enter Code Of Course : ");
        String code = in.nextLine();
        Course s = coursemap.get(code);
        while(s == null){
            System.out.print("Enter Valid Code : ");
            code = in.nextLine();
            s = coursemap.get(code);

        }
        student.registerCourse(s);
        
        

    }
    public void courseRemoval(){
        System.out.println("Registered Courses :");
        coursesListing(student.courses);
        System.out.print("Enter Code Of Course : ");
        String code = in.nextLine();
        Course s = coursemap.get(code);
        while(s == null){
            System.out.print("Enter Valid Code : ");
            code = in.nextLine();
            s = coursemap.get(code);

        }
        student.removeCouse(s);


    }

    public static void main(String[] args) {
        RegistrationSystem registrationSystem = new RegistrationSystem();
        registrationSystem.menu();

    }



    
}
