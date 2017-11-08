package 상속;

// 조상(부모)클래스( Super class - 상위 클래스 )
class Human {
    String name;
    int age;

    public void getInfo() {
        System.out.println("이름: " + name + "\n나이: " + age);
    }
}

// 자손(자식)클래스( Sub class - 하위 클래스 )
class Employee extends Human {
    int salary;

    @Override // 메서드 오버라이딩(overriding): 재정의
    public void getInfo() {
        super.getInfo();
        System.out.println("월급: " + salary);
    }
}

class Student extends Human {

}

public class InheritanceEx {
    public static void main(String[] args) {

        Employee em = new Employee();
        em.getInfo();

        Student st = new Student();
        st.getInfo();
    }

}
