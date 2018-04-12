package com.tw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ids {
    String ids ;
    Student student;

    public Ids(String ids) {
        this.ids = ids;
    }

    public boolean isCorrect(){
        return ids.matches("^\\d{1,}(,\\d{1,})*");
    }


    public boolean isExist(List<Student> studentList, String id){
        boolean result = false;
        for(Student item:studentList){
            if(item.getId().equals(id)) {
                result = true;
                this.student = item;
            }
        }
        return result;
    }

    public String printTranscript(List<Student> studentList){
        String printList = "成绩单\n"
                + "姓名|数学|语文|英语|编程|平均分|总分\n"
                + "========================";
        int stuNum = 0;
        int scoreSum = 0;
        List<String> idList = Arrays.asList(ids.split(","));
        List<Integer> sumList = new ArrayList<>();
        for(String idStr:idList){
            for(Student stuId : studentList){
                if(idStr.equals(stuId.getId())){
                    printList += "\n"+stuId.getName()+"|"+stuId.getMath()+"|"+stuId.getChinese()+"|"+stuId.getEnglish()+"|"+stuId.getProgram()+"|"+stuId.getAverage()+"|"+stuId.getSum();
                    stuNum ++;
                    scoreSum +=stuId.getSum();
                    sumList.add(stuId.getSum());
                }
            }
        }
        printList +="\n========================\n"
                + "全班总分平均数："+scoreSum*1.0/stuNum+"\n"
                + "全班总分中位数："+getMedian(sumList);
        return printList;
    }
    public Double getMedian(List<Integer> list){
        int len = list.size();
        if(len/2 == 0){
            return (list.get(len/2-1)*1.0+list.get(len/2)*1.0)/2;
        }else{
            return list.get(len/2)*1.0;
        }
    }

}
