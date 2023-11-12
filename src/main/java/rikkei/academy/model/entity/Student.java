package rikkei.academy.model.entity;

public class Student {
    private int studentCode ;
    private String studentName;
    private int age ;
    private boolean gender ;
    public Student() {

    }

    public Student(String studentName, int age, boolean gender) {
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
    }

    public Student(int studentCode, String studentName, int age, boolean gender) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
