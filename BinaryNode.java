// IMPORTANT:  don't modify
/**
 * Basic node stored in unbalanced binary search trees
 */
public class BinaryNode {
    // Constructors
    BinaryNode( Comparable theElement ) {
        element = theElement;
        left = right = null;
    }
    
    // Friendly data; accessible by other package routines
    Comparable element;      // The data in the node
    BinaryNode left;         // Left child
    BinaryNode right;        // Right child
}

