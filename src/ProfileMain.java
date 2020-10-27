/**
 * Tests the functionality of the Profile class and its add and get friend
 * methods.
 */
public class ProfileMain {
    public static void main(String[] args) {
        String[] interests1 = { "computers", "video games" };
        String[] activities1 = { "gym" };
        Profile test1 = new Profile("Adair", "Callum", 5, 8, 1900, "someone@website.com", interests1, activities1);
        Profile test2 = new Profile("Person", "Fake", 8, 5, 1910, "fake@email.co.uk", interests1, activities1);

        test1.addFriend(test2);
        System.out.println(test1.getFriend(0).toString());
    }
}