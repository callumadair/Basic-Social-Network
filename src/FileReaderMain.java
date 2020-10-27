/**
 * Tests the file reader class and its readprofileset method using the file of
 * profiles.
 */
public class FileReaderMain {
    public static void main(String[] args) {
        BST tree = FileReader.readProfileSet("src/data/profiles_01.txt");

        tree.printTree();
    }
}