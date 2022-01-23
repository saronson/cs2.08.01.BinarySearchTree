/**
 * Implements an unbalanced binary search tree.
 * @author Weiss/Aronson
 */
public class BinarySearchTree {
    //  root of the tree
    public BinaryNode root;

    // Will be used later
    public boolean isAVL = false;

    /**
     * Construct the tree.
     */
    public BinarySearchTree( ) {
        root = null;
    }

    /**
     * Makes the tree logically empty.
     */
    public void makeEmpty( ) {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return root == null;
    }

    /**
     * Helper method to get value field.
     * @param t the node.
     * @return the value field or null if t is null.
     */
    private Comparable valueAt( BinaryNode t ) {
        return t == null ? null : t.value;
        // a ? b : c means
        // if (a)
        //   b
        // else
        //   c
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert( Comparable x ) {
        root = insert( x, root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryNode insert( Comparable x, BinaryNode t ) {
        return t;
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public Comparable findMin( ) {
        return valueAt( findMin( root ) );
    }

    /**
     * Helper method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode findMin( BinaryNode t ) {

        return t;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public Comparable findMax( ) {
        return valueAt( findMax( root ) );
    }

    /**
     * Helper method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode findMax( BinaryNode t ) {

        return t;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public Comparable find( Comparable x ) {
        return valueAt( find( x, root ) );
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode find( Comparable x, BinaryNode t ) {

        return null;
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin( ) {
        root = removeMin( root );
    }

    /**
     * Helper method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if tree is empty.
     */
    protected BinaryNode removeMin( BinaryNode t ) {
 
        return t;
    }

    /**
     * Remove from the tree..
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove( Comparable x ) {
        root = remove( x, root );
    }

    /**
     * Helper method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode remove( Comparable x, BinaryNode t ) {

        return t;
    }
}

