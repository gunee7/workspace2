package 캡슐화;

public class Student {
    private String name;
    private int id;
    private int age;

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void showInfo() {
        System.out.println("-----학생정보-----");
        System.out.println("이름: " + getName());
        System.out.println("학번: " + getId());
        System.out.println("나이: " + getAge());
    }
}
