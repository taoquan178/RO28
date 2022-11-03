package Entity;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private String homeTown;
    public enum Gender {
        MALE, FEMALE, UNKNOWN
    }

    public Person() {
    }

    public Person(String name, Gender gender, LocalDate birthday, String homeTown) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.homeTown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void inputInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.name = scanner.next();
        System.out.print("Chọn giới tính: 1-Male, 2-Female, 3-UNKNOWN: ");
        int gender1 = scanner.nextInt();
        switch(gender1){
            case 1:
                this.gender = Gender.MALE;
                break;
            case 2:
                this.gender = Gender.FEMALE;
                break;
            case 3:
                this.gender = Gender.UNKNOWN;
                break;
            default:
                System.out.println("Mời bạn nhập lại");
        }
        System.out.print("Nhập vào ngày sinh của bạn (kiểu định dạng: 2001-05-29): ");
//        System.out.print("Day: ");
//        int day = scanner.nextInt();
//        System.out.print("Month: ");
//        int month = scanner.nextInt();
//        System.out.print("Yaer: ");
//        int year = scanner.nextInt();
//        this.birthday = LocalDate.of(year,month,day);
        this.birthday = LocalDate.parse(scanner.next());
        System.out.print("Nhập địa chỉ: ");
        this.homeTown = scanner.next();
    }

    public void showInfo(){
        System.out.println("Person{" +
                "name='" + getName() + '\'' +
                ", gender=" + getGender() +
                ", birthday=" + getBirthday() +
                ", homeTown='" + getHomeTown() + '\'' +
                '}');
    }

}
