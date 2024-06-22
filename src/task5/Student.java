package task5;

import java.util.ArrayList;

public class Student {
    String id;
    String name;
    ArrayList <Course> courses; 

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public void registerCourse (Course course){
        if(course.noStudents < course.capacity){
            courses.add(course);
            course.noStudents++;
            System.out.println("Registration Done !!");
            
            
        }
        else{
            System.out.println("No Available Slots");
            
        }

    }
    public void removeCouse(Course course){
        if(!courses.contains(course)){
            System.out.println("Course Is Not Registered");
            

        }
        else{
            courses.remove(course);
            course.noStudents--;
            System.out.println("Course Removed");

            
        }

    }
    
}
