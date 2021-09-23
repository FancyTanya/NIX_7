package ua.com.alevel.dto.request;

public class StudentDtoRequest {

    private String firsName;
    private String lastName;

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firsName + " " + lastName;
    }
}
