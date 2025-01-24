package day13.exam4;

public class Student {
    private String name;
    private String subject;
    private int fee;
    private double returnFee;

    public Student(int fee, String subject, String name) {
        this.fee = fee;
        this.subject = subject;
        this.name = name;
    }

    public void calcReturnFee(){
        if(subject.equals("javaprogram")){
           returnFee = fee * 0.25;
        } else if (subject.equals("jspprogram")) {
            returnFee = fee * 0.2;
        } else{
            System.out.println("그런 과정명은 없습니다.");
        }
    }

    public void print(){
        System.out.println(name + " 씨의 광정명은 " + subject + " 이고 교육비는 " + fee + " 이며 환급금은 " + returnFee +" 입니다.");
    }
}
