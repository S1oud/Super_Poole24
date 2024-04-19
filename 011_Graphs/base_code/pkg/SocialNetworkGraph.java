package pkg;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkGraph {
    List<Person> people;

    public SocialNetworkGraph() {
        this.people = new ArrayList<>();
    }

    public void addPerson(String name) {
        if (!personExists(name)) {
            people.add(new Person(name));
        }
    }

    public boolean personExists(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Person getPerson(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void addFollowRelationship(String followerName, String followedName) {
        Person follower = getPerson(followerName);
        Person followed = getPerson(followedName);
        if (follower != null && followed != null) {
            follower.addFollow(followed);
        } else {
            System.out.println("Person does not exist.");
        }
    }

    public void printRelationships(String name) {
        Person person = getPerson(name);
        if (person != null) {
            System.out.println("Followers of " + name + ":");
            if (person.getFollowers().isEmpty()) {
                System.out.println("None");
            } else {
                for (Person follower : person.getFollowers()) {
                    System.out.println("- " + follower.getName());
                }
            }

            System.out.println("\nPeople followed by " + name + ":");
            if (person.getFollows().isEmpty()) {
                System.out.println("None");
            } else {
                for (Person followed : person.getFollows()) {
                    System.out.println("- " + followed.getName());
                }
            }
        } else {
            System.out.println("Person does not exist.");
        }
    }
}
