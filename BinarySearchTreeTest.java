import static org.junit.Assert.*;
import org.junit.*;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeTest b = new BinarySearchTreeTest();
        b.test_all();
    } 

    @Test
    public void test_all() {
        BinarySearchTree t = new BinarySearchTree( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking..." );

        int min = GAP;
        int max = GAP;
        System.out.print("Performing inserts...");
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            t.insert( new Integer( i ) );
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println("success");

        System.out.print("Testing find...");
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i ) {
                System.out.println( "Could not find " + i );
                fail("Could not find " + i);
            }
        }
        System.out.println("success");
        System.out.print("Testing findMin...");
        int foundMin = ((Integer)(t.findMin( ))).intValue( );
        if( foundMin != min ) {
            System.out.println( "Min should be " + min + " but was " + foundMin);
            fail( "Min should be " + min + " but was " + foundMin);
        }
        System.out.println("success");
        System.out.print("Testing findMax...");
        int foundMax = ((Integer)(t.findMax( ))).intValue( );
        if( foundMax != max ) {
            System.out.println( "Max should be " + max + " but was " + foundMax);
            fail( "Max should be " + max + " but was " + foundMax);
        }
        System.out.println("success");
        System.out.print("Testing remove...");
        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( new Integer( i ) );

        if( ((Integer)(t.findMin( ))).intValue( ) != 2 ||
        ((Integer)(t.findMax( ))).intValue( ) != NUMS - 2 ) {
            System.out.println( "FindMin or FindMax error!" );
            fail("FindMin or FindMax error!");
        }

        int max2 = 2;
        for( int i = 2; i < NUMS; i+=2 ) {
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i ) {
                System.out.println( "Could not find " + i );
                fail("Could not find " + i);
            }
            max2 = i;
        }

        for( int i = 1; i < NUMS; i+=2 ) {
            if( t.find( new Integer( i ) ) != null ) {
                System.out.println( "Should not have found " + i );
                fail( "Should not have found " + i );
            }
        }
        System.out.println("success");
        System.out.print("Testing removeMin...");
        t.removeMin();
        int foundMin2 = ((Integer)(t.findMin( ))).intValue( );
        if( foundMin2 != 4 ) {
            System.out.println( "Min should be 4 but was " + foundMin2);
            fail( "Min should be 4 but was " + foundMin2);
        }
        System.out.println("success");
        System.out.println("Testing finished!");
    }

}
