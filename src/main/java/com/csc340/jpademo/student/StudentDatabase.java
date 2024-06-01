package com.csc340.jpademo.student;

/*
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class StudentDatabase {
    private static String DATABASE_LOCATION = "./../../../resources/student_database.json";
    private Object obj;
    private JSONObject jo;

    public StudentDatabase() throws IOException, ParseException {
        this.pullDatabase();
    }

    public void pullDatabase() throws IOException, ParseException {
        this.obj = new JSONParser().parse(new FileReader(DATABASE_LOCATION));
        this.jo = (JSONObject) obj;
    }

    public Map<Integer, Student> getStudentMap() {
        JSONArray studentArr = (JSONArray) this.jo.get("students");
        Iterator itr = studentArr.iterator();
        Map<Integer, Student> studentMap = new HashMap<>();

        while (itr.hasNext()) {
            JSONObject jsonStudent = (JSONObject) itr.next();
            Integer id = (Integer) jsonStudent.get("id");
            String name = (String) jsonStudent.get("name");
            String major = (String) jsonStudent.get("csc");
            Double gpa = (Double) jsonStudent.get("gpa");
            Student student = new Student(id, name, major, gpa);
            studentMap.put(id, student);
        }

        return studentMap;
    }
}


 */