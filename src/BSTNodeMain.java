/**
 * Tests the functionality of the BSTNode class and its set and get L and R
 * methods.
 */
public class BSTNodeMain {
    public static void main(String[] args) {
        String[] interests1 = { "computers", "video games" };
        String[] activitiesAndGroups1 = { "gym" };
        Profile test1 = new Profile("Adair", "Callum", 5, 8, 1900, "someone@website.com", interests1,
                activitiesAndGroups1);
        Profile test2 = new Profile("Person", "Fake", 8, 5, 1910, "fake@email.co.uk", interests1, activitiesAndGroups1);
        Profile test3 = new Profile("lastName", "firstName", 0, 6, 12, "emailAddress", interests1,
                activitiesAndGroups1);

        BSTNode test4 = new BSTNode(test1);
        test4.setL(new BSTNode(test2));
        test4.setR(new BSTNode(test3));

        System.out.println(test4.getR().getProfile().toString());
        System.out.println(test4.toString());
    }

}