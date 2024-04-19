import pkg.SocialNetworkGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocialNetworkGraph graph = new SocialNetworkGraph();

        // Populate the graph with names from the file
        List<String> names = readNamesFromFile("C:\\Users\\natha\\reactWebsite\\Poole Labs\\Super_Poole24\\011_Graphs\\base_code\\pkg\\names.txt");
        for (String name : names) {
            graph.addPerson(name);
        }

        // Establish random follow relationships
        for (String name : names) {
            int numFollows = (int) (Math.random() * 500); // Random number of follows (up to 500)
            for (int i = 0; i < numFollows; i++) {
                String followedName = names.get((int) (Math.random() * names.size()));
                graph.addFollowRelationship(name, followedName);
            }
        }

        // Taking user input to view relationships
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to see the relationships: ");
        String inputName = scanner.nextLine();
        System.out.println("Relationships for " + inputName + ":");
        graph.printRelationships(inputName);

        scanner.close();
    }

    private static List<String> readNamesFromFile(String filename) {
        List<String> names = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                names.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return names;
    }
}
