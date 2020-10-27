/**
 * A node contains a reference to a profile and to two other nodes,l and r.
 * 
 * @author Callum Adair
 * @version 1.0
 */
public class BSTNode {
    private Profile data;
    private BSTNode l, r;

    /**
     * Creates a new instance of a node.
     * 
     * @param data a profile that is linked to by the node.
     */
    BSTNode(Profile data) {
        this.data = data;
    }

    /**
     * Sets the node to the left of this node.
     * 
     * @param l the node specified to be set to the left.
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * Sets the node to the right of this node.
     * 
     * @param r the node specified to be set to the right.
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     * 
     * @return returns the profile this node contains to a reference to.
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * 
     * @return returns the node to the left of this node.
     */
    public BSTNode getL() {
        return this.l;
    }

    /**
     * 
     * @return returns the node to the right of this node.
     */
    public BSTNode getR() {
        return this.r;
    }

}