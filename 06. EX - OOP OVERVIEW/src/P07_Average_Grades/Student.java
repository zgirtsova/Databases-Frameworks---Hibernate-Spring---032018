package P07_Average_Grades;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private double[] grades;
    private double averageGrade;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
        Double total =0.0;
        for(Double grade : grades){
            total += grade;
        }
        this.averageGrade = total / grades.length;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double[] getGrades() {
        return grades;
    }
    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public Double getAverage() {
        return this.averageGrade;
    }

}
