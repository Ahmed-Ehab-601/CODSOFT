package task5;


public class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    int noStudents;
    public Course(String code, String title, String description, int capacity, String schedule){
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        noStudents = 0;
    }
   
}
