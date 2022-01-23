import static org.junit.Assert.*;
import org.junit.*;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeTest b = new BinarySearchTreeTest();
        b.test_all();
    } 

    private void failure(String str) {
        System.out.println(str);
        fail(str);
    }

    @Test
    public void test_all() {
        BinarySearchTree t = new BinarySearchTree( );
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

        System.out.println("Success");

        System.out.println("Testing finished!");
    }
}
