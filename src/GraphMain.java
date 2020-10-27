/**
 * Tests the graph class using the profiles from the profiles text file and the
 * edge list from the graph text file.
 */
public class GraphMain {
    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("src/data/profiles_01.txt");

        Profile john = tree.findProfile("John Tolkien");
        Profile joanne = tree.findProfile("Joanne Rowling");
        Profile agatha = tree.findProfile("Agatha Christie");
        Profile jon = tree.findProfile("Jon Favreau");
        Profile jeffrey = tree.findProfile("jeffrey abrams");
        Profile steven = tree.findProfile("steven spielberg");

        Graph graphTest = new Graph("src/data/graph_01.txt", tree);
        Profile[] users = { joanne, john, agatha, jon, jeffrey, steven };

        BST[] recommendations = graphTest.friendRecommendations(users);

        for (int i = 0; i < recommendations.length; ++i) {
            System.out.println(users[i].getName() + "'s friend recommendations: ");
            recommendations[i].printAlphabetical();
        }
    }
}