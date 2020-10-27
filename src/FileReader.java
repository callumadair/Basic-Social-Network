import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Takes an input file and reads each line containing profile information, and
 * inserts all of the profiles into a binary search tree.
 * 
 * @author Callum Adair
 * @version 1.0
 */
public class FileReader {
    private static String lastName, firstName, emailAddress;
    private static int dobDay, dobMonth, dobYear;
    private static String[] interests, activitiesAndGroups;

    /**
     * Reads a file containing profile information and inserts it into a new binary
     * search tree.
     * 
     * @param filename the name of the file containing profile information.
     * @return returns a tree with the profiles inserted.
     */
    public static BST readProfileSet(String filename) {
        BST newTree = new BST();
        return readProfileSet(filename, newTree);
    }

    /**
     * Reads a file containing profile information and inserts it into the specified
     * binary search tree.
     * 
     * @param filename the name of the file containing profile information.
     * @param curTree  the tree the profiles will be inserted into.
     * @return returns the specified tree with the profiles inserted.
     */
    public static BST readProfileSet(String filename, BST curTree) {
        File input = new File(filename);
        try {
            Scanner fileScanner = new Scanner(input);
            while (fileScanner.hasNextLine()) {
                String curLine = fileScanner.nextLine();
                curTree.insertProfile(readLine(curLine));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open " + input.getName());
            System.exit(0);
        }

        return curTree;
    }

    /**
     * Creates a new profile and copies the information from the scanner into this
     * profile.
     * 
     * @param curLine the current line of the file being read.
     * @return returns a new profile containing the information from this line in
     *         the file.
     */
    private static Profile readLine(String curLine) {
        Scanner lineScanner = new Scanner(curLine);
        readPersonalInformation(lineScanner);

        Profile newProfile = new Profile(lastName, firstName, dobDay, dobMonth, dobYear, emailAddress, interests,
                activitiesAndGroups);
        return newProfile;
    }

    /**
     * Reads in the information from the scanner and stores it as the class
     * attributes.
     * 
     * @param lineScanner the scanner to be read from.
     */
    private static void readPersonalInformation(Scanner lineScanner) {
        lineScanner.useDelimiter(",");

        lastName = lineScanner.next();
        firstName = lineScanner.next();
        dobDay = lineScanner.nextInt();
        dobMonth = lineScanner.nextInt();
        dobYear = lineScanner.nextInt();
        emailAddress = lineScanner.next();

        String allInterests = lineScanner.next();
        String allActivities = lineScanner.next();

        interests = fillArray(allInterests);
        activitiesAndGroups = fillArray(allActivities);
    }

    /**
     * Copies the information from the specified string and stores it in a new
     * array.
     * 
     * @param array       the array to be filled.
     * @param arrayInputs the information to be copied.
     */
    private static String[] fillArray(String arrayInputs) {
        ArrayList<String> dataForArray = readToArrayList(arrayInputs);

        String[] array = new String[dataForArray.size()];
        for (int i = 0; i <= (dataForArray.size() - 1); ++i) {
            array[i] = dataForArray.get(i);
        }
        return array;
    }

    /**
     * Stores the data from the string in an ArrayList.
     * 
     * @param arrayListInput the string containing the data to be stored.
     * @return returns an ArrayList containing the specified data.
     */
    private static ArrayList<String> readToArrayList(String arrayListInput) {
        Scanner input = new Scanner(arrayListInput);
        input.useDelimiter(";");

        ArrayList<String> inputAL = new ArrayList<String>();
        while (input.hasNext()) {
            inputAL.add(input.next());
        }

        return inputAL;
    }
}