/**
 * @author: 
 */
import java.util.*;

public class BinaryTree  {
    private TreeNode myRoot;
    // create no other instance variables

    // -----------------------------------------------------------------------------------
    // Part 0 - Constructors and Utilities
    //     IMPORTANT: DO NOT CHANGE ANYTHING HERE
    // -----------------------------------------------------------------------------------

    public BinaryTree() { myRoot = null; }

    public BinaryTree(Object obj)
    {
        myRoot = new TreeNode(obj, null, null);
    }

    public BinaryTree(Object object, BinaryTree left, BinaryTree right)
    {
        myRoot = new TreeNode(object, (left != null)? left.myRoot : null, (right != null)?right.myRoot: null);
    }

    public void clear() {
        myRoot = null;  // this method is done
    }

    // -----------------------------------------------------------------------------------
    // Part 1 - Binary Tree Methods Only
    // -----------------------------------------------------------------------------------

    /** 
     * count the total number of nodes in the tree
     */
    public int numNodes() {
        // solve recursively by calling helper
        return 0;
    }

    private int numNodesHelper(TreeNode root) {
        return 0;
    }

    /**
     * count the total number of leaves in the tree
     */
    public int numLeaves() {
        // solve recursively by calling helper
        return 0;
    }

    private int numLeavesHelper(TreeNode root) {
        return 0;
    }

    /**
     * calculate the height of the tree
     * height is the maximum number of edges from the root to a leaf
     */
    public int height() {
        // solve recursively by calling helper
        return heightHelper(myRoot);
    }

    private int heightHelper(TreeNode root){
        return 0;
    }

    /**
     * calculate the width of the tree
     * The width is defined as the maximum number of edges from one
     * node in the tree to any other node.
     */
    public int width() {
        // solve recursively by calling helper
        return 0;
    }

    private int widthHelper(TreeNode root){
        return 0;
    }

    /**
     *  return true if the tree is full, false otherwise
     *  full means every node has 0 or 2 children
     *  an empty tree is full
     */
    public boolean isFull() {
        return isFullHelper(myRoot);
    }

    private boolean isFullHelper(TreeNode root) {
        return true;
    }

    /**
     *  
     *  precondition: ancestor and possibleDescendant not necessarily in the tree
     *  return true if possibleDescendant is a descendant of ancestor
     *  that means possibleDescendent is in some branch of the tree beneath ancestor
     */
    public boolean isDescendant(Object ancestor, Object possibleDescendant) {
        return true;
    }

    /**
     * return true if the tree is perfect, false otherwise
     * perfect means every internal node has exactly two child nodes 
     * and all the leaf nodes are at the same level.
     * You come up with a helper function...
     */
    public boolean isPerfect() {
        return true;
    }

    // -----------------------------------------------------------------------
    // Part 2 - Binary Tree Traversal
    // -----------------------------------------------------------------------
    /**
     *  solve recursively for an in-order traversal
     *  there should be a comma and single space between each item
     *  there should be square brackets around the whole thing
     *  e.g., if you had a tree with String data items A, B, and C, 
     *        then your toString() would return  [A, B, C]
     *  an empty tree should return []
     */
    public String toString() {
        // use toStringHelper so you can solve this recursively  
        return "";
    }

    private String toStringHelper(TreeNode root){
        return "";
    }

    /**
     * return the tree in pre-order
     */
    public String preOrder() {
        // should be formatted the same way as described in toString() 
        return "";
    }

    private String preOrderRecursiveHelper(TreeNode root){
        return "";
    }

    /**
     * return the tree in post-order
     */
    public String postOrder() {
        // should be formatted the same way as described in toString()
        return "";
    }

    private String postOrderRecursiveHelper(TreeNode root){
        return "";
    }

    /**
     * return the tree in level order
     * no recursion - use a helper Queue (i.e. LinkedList in Java)
     */
    public String levelOrder() {
        // should be formatted the same way as described in toString()
        return "";
    }

}
