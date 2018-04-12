package com.tw;

public class Student {
    String message;

    public Student(String message) {
        this.message = message;
    }

    public boolean isformatted(){
        return message.matches("^[\\u0391-\\uFFE5]{1,}，(\\d){1,}(，[\\u0391-\\uFFE5]{1,}：(\\d){1,}){4}");
    }

    public String getName() {
        return message.split("，")[0];
    }
    public Integer getMath(){
        return Integer.parseInt(message.split("数学：")[1].split("，")[0]);
    }
    public Integer getChinese(){
        return Integer.parseInt(message.split("语文：")[1].split("，")[0]);
    }
    public Integer getEnglish(){
        return Integer.parseInt(message.split("英语：")[1].split("，")[0]);
    }
    public Integer getProgram(){
        return Integer.parseInt(message.split("编程：")[1]);
    }

    public Integer getSum(){
        return getMath()+getChinese()+getEnglish()+getProgram();
    }
    public double getAverage(){
        return getSum()*1.0/4;
    }

    public String getId(){
        return message.split("，")[1];
    }
}
