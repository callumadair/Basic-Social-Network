/**
 * Tests the printAlphabetical method of the BST class using a file of profiles
 * and some hard coded profiles.
 */
public class AlphaMain {
    public static void main(String[] args) {
        String[] interests1 = { "computers", "video games" };
        String[] activitiesAndGroups1 = { "gym" };
        Profile test1 = new Profile("Adair", "Callum", 5, 8, 1900, "someone@website.com", interests1,
                activitiesAndGroups1);
        Profile test2 = new Profile("Person", "Fake", 8, 5, 1910, "fake@email.co.uk", interests1, activitiesAndGroups1);
        Profile test3 = new Profile("LastName", "firstName", 0, 6, 12, "emailAddress", interests1,
                activitiesAndGroups1);

        BST tree = new BST();
        FileReader.readProfileSet("Profiles.txt", tree);
        tree.insertProfile(test1);
        tree.insertProfile(test2);
        tree.insertProfile(test3);
        tree.insertProfile(test3);

        tree.printAlphabetical();
    }
}