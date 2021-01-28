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

        System.out.println( "Checking... (no more output means success)" );

        int min = GAP;
        int max = GAP;
        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            t.insert( new Integer( i ) );
            if (i < min) min = i;
            if (i > max) max = i;
        }

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS ) {
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i ) {
                System.out.println( "Could not find " + i );
                fail("Could not find " + i);
            }
        }

        if( ((Integer)(t.findMin( ))).intValue( ) != min || ) {
            System.out.println( "FindMin or FindMax error!" );
            fail("FindMin or FindMax error!");
        }

        if( ((Integer)(t.findMin( ))).intValue( ) != min ||
        ((Integer)(t.findMax( ))).intValue( ) != max ) {
            System.out.println( "FindMin or FindMax error!" );
            fail("FindMin or FindMax error!");
        }

        for( int i = 1; i < NUMS; i+= 2 )
            t.remove( new Integer( i ) );

        if( ((Integer)(t.findMin( ))).intValue( ) != 2 ||
        ((Integer)(t.findMax( ))).intValue( ) != NUMS - 2 ) {
            System.out.println( "FindMin or FindMax error!" );
            fail("FindMin or FindMax error!");
        }

        for( int i = 2; i < NUMS; i+=2 ) {
            if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i ) {
                System.out.println( "Could not find " + i );
                fail("Could not find " + i);
            }
        }

        for( int i = 1; i < NUMS; i+=2 ) {
            if( t.find( new Integer( i ) ) != null ) {
                System.out.println( "Should not have found " + i );
                fail( "Should not have found " + i );
            }
        }
    }

}
