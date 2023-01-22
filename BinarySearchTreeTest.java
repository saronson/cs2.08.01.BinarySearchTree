import static org.junit.Assert.*;
import org.junit.*;

public class BinarySearchTreeTest {
    public static boolean testAVL = false;
    public static void main(String[] args) {
        BinarySearchTreeTest b = new BinarySearchTreeTest();
        b.test_all();
        b.test_avl();
    } 

    private void failure(String str) {
        System.out.println(str);
        fail(str);
    }

    @Test
    public void test_all() {
        BinarySearchTree t = new BinarySearchTree( );
        t.isAVL = false;
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking..." );

        int min = GAP;
        int max = GAP;
        System.out.println("Performing inserts...");
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            t.insert( i );
            if (i < min) min = i;
            if (i > max) max = i;
        }
        try {
            t.insert(min);
            failure("Should throw DuplicateItemException if inserting duplicate item in tree.");
        } catch (DuplicateItemException e) {
        } catch (Exception e) {
            failure("Should throw DuplicateItemException if inserting duplicate item in tree.");
        }
        System.out.println("Done");

        System.out.println("Testing findMin...");
        int foundMin = ((Integer)(t.findMin( ))).intValue( );
        if( foundMin != min ) {
            failure( "Min should be " + min + " but was " + foundMin);
        }
        System.out.println("Success");

        System.out.println("Testing findMax...");
        int foundMax = ((Integer)(t.findMax( ))).intValue( );
        if( foundMax != max ) {
            failure( "Max should be " + max + " but was " + foundMax);
        }
        System.out.println("Success");

        System.out.println("Testing find...");
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            if( ((Integer)(t.find( i ))).intValue( ) != i ) {
                failure("Could not find " + i);
            }
        }

        Comparable b = t.find( max + 1);
        if (b != null) {
            failure("Found " + (max + 1) + " which is not in tree");
        }
        System.out.println("Success");

        System.out.println("Testing removeMin...");
        t.removeMin();
        int foundMin2 = ((Integer)(t.findMin( ))).intValue( );
        if( foundMin2 != 2 ) {
            failure( "Min should be 2 but was " + foundMin2);
        }

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            if( i != min && (int)t.find( i ) != i ) {
                failure("Could not find " + i + " (after removeMin)");
            }
        }
        System.out.println("Success");

        System.out.println("Testing remove...");
        for( int i = 3; i < NUMS; i+= 2 )
            t.remove( i );

        if ((int)t.findMin( ) != 2 || (int)t.findMax( ) != NUMS - 2 ) {
            failure("findMin or findMax error after calling remove!");
        }

        for( int i = 1; i < NUMS; i+=2 ) {
            if( t.find( i) != null ) {
                failure( "Should not have found " + i + " after remove" );
            }
        }

        for( int i = 2; i < NUMS; i+=2 ) {
            if( ((Integer)(t.find( i ))).intValue( ) != i ) {
                failure("Could not find " + i + " (after remove)");
            }
        }
        try {
            t.remove(max + 1);
            failure("Should throw ItemNotFoundException if removing item that cannot be found.");
        } catch (ItemNotFoundException e) {
        } catch (Exception e) {
            failure("Should throw ItemNotFoundException if removing item that cannot be found.");
        }
      BinarySearchTree t2 = new BinarySearchTree( );
      t2.insert("abc".substring(0,3));
      Object obj = t2.find("abc".substring(0,3));
      assertEquals("should compare with .equals", "abc".substring(0,3), obj);
        System.out.println("Success");

   //     System.out.println("Testing finished!");
    }

    @Test
    public void test_avl()
    {
        if (!testAVL)
            return;
      System.out.println("Testing AVL...");
        BinarySearchTree t = new BinarySearchTree();
        t.isAVL = true;

        for( int i = 1; i < 30; i++) {
            t.insert( new Integer( i ) );
            int h = height(t.root);
            int should = 1+(int)(Math.round(Math.log(i)/Math.log(2)));
         //   System.out.println(h + " " + should);
            assertTrue("height is " + h + " but should be " + should, Math.abs(h-should) <= 1);
         //      printTree(t.root);
         //      System.out.println();
        }

    //    printTree(t.root);
   //     System.out.println();
      System.out.println("Success");
      System.out.println();
    }

    public void printTree(BinaryNode t) {
        if (t == null)
            return;
        System.out.print(t.value +  " ");
        printTree(t.left);
     //   System.out.print(t.value +  " ");

        printTree(t.right);
    }


    private int height(BinaryNode t) {
        if (t == null)
            return 0;
        int leftHeight = 1 + height(t.left);
        int rightHeight = 1 + height(t.right);
        assertTrue("leftHeight is " + leftHeight + " and right height is " + rightHeight, Math.abs(leftHeight-rightHeight) <= 1);
        return Math.max(1 + height(t.left), 1 + height(t.right));
    }

}