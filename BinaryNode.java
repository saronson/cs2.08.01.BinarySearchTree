// IMPORTANT:  don't modify
/**
 * Basic node stored in unbalanced binary search trees
 */
public class BinaryNode {
    // Constructors
    BinaryNode( Comparable theValue ) {
        value = theValue;
        left = right = null;
    }
    
    // Friendly data; accessible by other package routines
    Comparable value;      // The data in the node
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
}

