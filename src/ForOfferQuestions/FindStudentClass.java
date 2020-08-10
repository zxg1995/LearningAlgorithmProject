package ForOfferQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Paul Z on 2020/4/24
 * 给定List<Student>，然后根据Student的_class属性划分，添加到List<List<Student>>中
 */
public class FindStudentClass {

    static class Student{
        String name;
        String _class;

        Student(String name, String _class){
            this.name = name;
            this._class = _class;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zs", "1班"));
        list.add(new Student("ls", "3班"));
        list.add(new Student("ww", "1班"));
        list.add(new Student("ss", "2班"));
        list.add(new Student("pz", "1班"));
        list.add(new Student("cz", "3班"));
        List<List<Student>> res = process(list);
        for (List<Student> l : res){
            for (Student s : l)
                System.out.print(s.name+":"+s._class+" ");
            System.out.println();
        }
    }

    private static List<List<Student>> process(List<Student> l){
        List<List<Student>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (Student s : l){
            if (map.containsKey(s._class))
                res.get(map.get(s._class)).add(s);
            else{
                List<Student> t = new ArrayList<>();
                t.add(s);
                res.add(t);
                map.put(s._class, res.size()-1);
            }
        }
        return res;
    }

}
