package com.tw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Command {

    public Command(List<Student> studentList) {
        this.studentList = studentList;
    }

    List<Student> studentList;



    public void mainInterface() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：");
        String secStr=null;
        try
        {
            secStr=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (secStr){
            case "1":
                submitInterface();
                break;
            case "2":
                generateInterface();
                break;
            case "3":
//                System.out.println("已退出");
                break;
            default :
                System.out.println("请重新输入：");
                mainInterface();
        }
    }

    public void submitInterface(){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        String secStr=null;
        try
        {
            secStr=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student secStu = new Student(secStr);
        if(secStu.isformatted()){
            studentList.add(secStu);
            mainInterface();
        }else {
            errorStudent();
        }
    }

    public void generateInterface(){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        String secStr=null;
        try
        {
            secStr=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Ids ids = new Ids(secStr);
        if (ids.isCorrect()){
            System.out.println(ids.printTranscript(studentList));
            mainInterface();
        }else {
            errorNumber();
        }
    }

    public void errorStudent() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
        String secStr=null;
        try
        {
            secStr=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student secStu = new Student(secStr);
        if(secStu.isformatted()){
            studentList.add(secStu);
            mainInterface();
        }else {
            errorStudent();
        }
    }

    public void errorNumber() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        String secStr=null;
        try
        {
            secStr=bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Ids ids = new Ids(secStr);
        if (ids.isCorrect()){
            System.out.println(ids.printTranscript(studentList));
            mainInterface();
        }else {
            errorNumber();
        }
    }

}
