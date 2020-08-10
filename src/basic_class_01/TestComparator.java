package basic_class_01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Paul Z on 2019/12/16
 */
public class TestComparator {

    static class Student{
        String name;
        int id;
        int score;

        Student(String name, int id, int score){
            this.name = name;
            this.id = id;
            this.score =score;
        }
    }

    static class ScoreAscendingSort implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.score - o2.score;
        }
    }

    static class ScoreDescendingSort implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o2.score - o1.score;
        }
    }

    private static void printStudents(Student[] students){
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Score : " + student.score);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student s1 = new Student("A", 1, 95);
        Student s2 = new Student("B", 2, 59);
        Student s3 = new Student("C", 3, 85);
        Student s4 = new Student("D", 4, 14);
        Student[] students = new Student[]{s1, s2, s3, s4};
        printStudents(students);

        Arrays.sort(students, new ScoreAscendingSort());
        printStudents(students);

        Arrays.sort(students, new ScoreDescendingSort());
        printStudents(students);
    }
}
