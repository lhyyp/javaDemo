package day_01.web.domain;

public class Member {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String adress;
    private String email;
    private int qq;

    public Member() {
    }

    public Member(String name, String sex, int age, String adress, String email, int qq) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.adress = adress;
        this.email = email;
        this.qq = qq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", qq=" + qq +
                '}';
    }
}
