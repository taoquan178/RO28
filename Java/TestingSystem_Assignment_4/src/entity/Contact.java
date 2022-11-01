package entity;

public class Contact{
    private String name;
    private String numberPhone;

    public Contact(){

    }

    public Contact(String name, String numberPhone) {

        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }
}
