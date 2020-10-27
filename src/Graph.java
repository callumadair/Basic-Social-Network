import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A graph allows for relationships to be made between profiles and uses triadic
 * closure to suggest further relationships based off the existing ones.
 * 
 * @author Callum Adair
 * @version 1.2
 */
public class Graph {
    private BST tree;

    /**
     * Creates a new instance of graph, reading and creating the friendships between
     * names in the file and using those names to locate the relevant profile in the
     * binary search tree.
     * 
     * @param filename the specified file containing the edge list of friendships.
     * @param tree     the tree containing the profiles of all the individuals.
     */
    Graph(String filename, BST tree) {
        setTree(tree);
        readListOfFriends(filename);
    }

    /**
     * Sets the tree to be the specified BST.
     * 
     * @param tree the BST being specified.
     */
    private void setTree(BST tree) {
        this.tree = tree;
    }

    /**
     * Reads a list of friendship combinations and adds the two profiles as the
     * friend of each other.
     * 
     * @param filename the name of the file containing the edge list.
     */
    private void readListOfFriends(String filename) {
        File friendsCombinations = new File(filename);
        try {
            Scanner in = new Scanner(friendsCombinations);
            Scanner lineScanner;

            while (in.hasNextLine()) {

                String line = in.nextLine();
                lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                String firstName = lineScanner.next();
                Profile firstFriend = tree.findProfile(firstName);

                String secondName = lineScanner.next();
                Profile secondFriend = tree.findProfile(secondName);

                if ((firstFriend != null) && (secondFriend != null)) {
                    firstFriend.addFriend(secondFriend);
                    secondFriend.addFriend(firstFriend);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open " + filename);
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Returns an array of binary search trees each containing profiles that would
     * be a good friend recommendation based on triadic closure.
     * 
     * @param users the array of users to have friend recommendations made to.
     * @return returns a BST array containing the friend recommendations for each
     *         user.
     */
    public BST[] friendRecommendations(Profile[] users) {
        ArrayList<BST> recommendationsAL = new ArrayList<BST>();

        for (int i = 0; i < users.length; ++i) {

            HashSet<Profile> newFriends = new HashSet<Profile>();
            for (int j = 0; j < users[i].numOfFriends(); ++j) {
                newFriends.addAll(compareFriends(users[i], users[i].getFriend(j)));
            }

            ArrayList<Profile> friendSuggestions = new ArrayList<Profile>();
            friendSuggestions.addAll(newFriends);
            BST temp = new BST();

            for (int k = 0; k < friendSuggestions.size(); ++k) {
                temp.insertProfile(friendSuggestions.get(k));
            }
            recommendationsAL.add(temp);
        }
        BST[] recommendations = new BST[recommendationsAL.size()];
        for (int n = 0; n < recommendationsAL.size(); ++n) {
            recommendations[n] = recommendationsAL.get(n);
        }

        return recommendations;
    }

    /**
     * Compares the friends lists of two profiles and returns any that are present
     * in the second friend's list that are not present in the first friend's.
     * 
     * @param firstFriend  the profile to get new friends for.
     * @param secondFriend the profile to get new friends from.
     * @return returns an arraylist containing new friend suggestions based on
     *         triadic closure.
     */
    public ArrayList<Profile> compareFriends(Profile firstFriend, Profile secondFriend) {

        ArrayList<Profile> friendsList = new ArrayList<Profile>();
        for (int i = 0; i < firstFriend.numOfFriends(); ++i) {
            friendsList.add(firstFriend.getFriend(i));

        }
        ArrayList<Profile> newFriends = new ArrayList<Profile>();
        for (int j = 0; j < secondFriend.numOfFriends(); ++j) {
            if (!friendsList.contains(secondFriend.getFriend(j)) && !firstFriend.equals(secondFriend.getFriend(j))) {
                newFriends.add(secondFriend.getFriend(j));
            }
        }
        return newFriends;
    }
}