package pkg;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    List<Person> follows;
    List<Person> followers;

    public Person(String name) {
        this.name = name;
        this.follows = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    public void addFollow(Person person) {
        follows.add(person);
        person.addFollower(this);
    }

    public void addFollower(Person person) {
        followers.add(person);
    }

    public List<Person> getFollows() {
        return follows;
    }

    public List<Person> getFollowers() {
        return followers;
    }

    public String getName() {
        return name;
    }
}
