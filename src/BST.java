/**
 * A binary search tree contains a reference to a root node, and has the ability
 * to insert profiles as new nodes in alphabetical order, and to print out the
 * tree.
 * 
 * @author Callum Adair
 * @version 1.0
 */
public class BST {
    private BSTNode root;

    /** Creates a new instance of a BST and sets the root to null. */
    BST() {
        this.root = null;
    }

    /**
     * 
     * @return returns true if the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserts a profile, p, as the root if the tree is empty, and if not empty,
     * calls a recursive method to insert alphabetically.
     * 
     * @param p the profile to be inserted as a new node in the tree.
     */
    public void insertProfile(Profile p) {
        BSTNode input = new BSTNode(p);

        if (isEmpty()) {
            this.root = input;
        } else {
            insertNode(root, input);
        }
    }

    /**
     * Inserts a node to the left of the current node if the name of the profile
     * precedes the name of the profile in the current node alphabetically,
     * otherwise the node is inserted to the right of the current node.
     * 
     * @param curNode the current node in the tree.
     * @param newNode the node being inserted into the tree.
     */
    private void insertNode(BSTNode curNode, BSTNode newNode) {
        if (alphabeticalOrder(curNode, newNode) == true) {
            if (curNode.getL() == null) {
                curNode.setL(newNode);
            } else {
                insertNode(curNode.getL(), newNode);
            }
        } else if (alphabeticalOrder(curNode, newNode) == false) {
            if (curNode.getR() == null) {
                curNode.setR(newNode);
            } else {
                insertNode(curNode.getR(), newNode);
            }
        }
    }

    /**
     * Compares the names of the individuals in the profiles referenced by the two
     * nodes and returns true if the new node's profile name precedes the current
     * node's profile name.
     * 
     * @param curNode the current node in the tree.
     * @param newNode the node being inserted into the tree.
     * @return returns true if the new node should precede the current node.
     */
    private Boolean alphabeticalOrder(BSTNode curNode, BSTNode newNode) {
        return (newNode.getProfile().getName().compareTo(curNode.getProfile().getName()) < 0);
    }

    /**
     * Prints the names of the profiles stored in the tree using preOrder traversal
     * if the tree is not empty.
     */
    public void printTree() {
        if (!isEmpty()) {
            preOrderTraversal(root);
        }
    }

    /**
     * Traverses the binary search tree by visting the current node then its left
     * branch if it is not empty, and then its right branch if it is not empty.
     * 
     * @param curNode the current node in the tree.
     */
    private void preOrderTraversal(BSTNode curNode) {
        System.out.println(curNode.getProfile().getName());
        if (curNode.getL() != null) {
            preOrderTraversal(curNode.getL());
        }
        if (curNode.getR() != null) {
            preOrderTraversal(curNode.getR());
        }
    }

    /**
     * Prints out the names of the profiles in the binary search tree
     * alphabetically, using inOrder traversal if the tree is not empty.
     */
    public void printAlphabetical() {
        if (!isEmpty()) {
            inorderTraversal(root);
        } else if (isEmpty()) {
            System.out.println("Binary Search Tree is empty");
        }
    }

    /**
     * Prints out the name of the profile stored in the specified node and all of
     * its children in order of a binary search tree.
     * 
     * @param curNode the node specified to start the traversal at.
     */
    private void inorderTraversal(BSTNode curNode) {
        if (curNode.getL() != null) {
            inorderTraversal(curNode.getL());
        }
        System.out.println(curNode.getProfile().getName());
        if (curNode.getR() != null) {
            inorderTraversal(curNode.getR());
        }
    }

    /**
     * Finds the profile of the person specified in the binary search tree.
     * 
     * @param name the name of the person.
     * @return returns a profile that is either null if this person is not stored in
     *         the tree, or contains the information of this person.
     */
    public Profile findProfile(String name) {
        Profile namedProfile = null;
        return preOrderName(root, name.toLowerCase(), namedProfile);
    }

    /**
     * Traverses the binary search tree using preOrder traversal, comparing the
     * specified name to the names stored in the profile of the BST, and returning a
     * profile if the name of the profile matches the specified name.
     * 
     * @param curNode      the node currently being checked.
     * @param name         the name specified to be compared to.
     * @param namedProfile the profile to be returned if the name is a match.
     * @return returns a profile that contains the specified name.
     */
    private Profile preOrderName(BSTNode curNode, String name, Profile namedProfile) {

        if (name.equals(curNode.getProfile().getName())) {
            return namedProfile = curNode.getProfile();
        } else if (name.equals(curNode.getProfile().getNameInOrder())) {
            return namedProfile = curNode.getProfile();
        } else {
            if (curNode.getL() != null) {
                namedProfile = preOrderName(curNode.getL(), name, namedProfile);

                if (namedProfile != null) {
                    return namedProfile;
                }
            }
            if ((curNode.getR() != null) && (namedProfile == null)) {
                namedProfile = preOrderName(curNode.getR(), name, namedProfile);

                if (namedProfile != null) {
                    return namedProfile;
                }
            }

        }
        return namedProfile;
    }

}