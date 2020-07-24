package practice.pmd;

import java.util.List;

public class BestPracticesSamples {

    private String firstName, lastName;

    public void loop(List<String> list) {
        if (list.size() == 0) {
            System.out.println("List empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    public void printName() {
        int i = 5; // Unused
        System.out.println(firstName + " " + lastName);
    }

    private void foo() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
