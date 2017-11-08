package 캡슐화;

public class School {
    public static void main(String[] args) {

        Student stu = new Student();

        stu.setName("홍길동");
        stu.setId(20141234);
        stu.setAge(25);

        stu.showInfo();
    }

}
