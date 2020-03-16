package tr.example.data;

import java.io.Serializable;

public class UserData implements Serializable {
    private String name;
    private String number;

    public UserData(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
