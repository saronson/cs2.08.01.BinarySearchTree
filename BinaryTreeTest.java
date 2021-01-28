import static org.junit.Assert.*;
import org.junit.*;

public class BinaryTreeTest {
    BinaryTree n1b = null;
    BinaryTree tree = null;
    BinaryTree a = null;
    BinaryTree single = null;
    BinaryTree empty = null;

    public static void main(String[] args) {
        BinaryTreeTest b = new BinaryTreeTest();
        b.test_all();
    }    

    public void init() {
        BinaryTree n6 = new BinaryTree(6);
        BinaryTree n10 = new BinaryTree(10);
        BinaryTree n9 = new BinaryTree(9, n10, null);
        BinaryTree n5 = new BinaryTree(5, n6, null);
        BinaryTree n7 = new BinaryTree(7, null, n9);
        BinaryTree n4 = new BinaryTree(4);
        BinaryTree n8 = new BinaryTree(8);
        BinaryTree n2 = new BinaryTree(2, n4, n5);
        BinaryTree n3 = new BinaryTree(3, n8, n7);
        tree = new BinaryTree(1, n2, n3);

        BinaryTree d = new BinaryTree("d");
        BinaryTree e = new BinaryTree("e");
        BinaryTree b = new BinaryTree("b", d, e);
        BinaryTree c = new BinaryTree("c");
        a = new BinaryTree("a", b, c);

        single = new BinaryTree("s");
        empty = new BinaryTree();

        BinaryTree n13b = new BinaryTree(13);
        BinaryTree n10b = new BinaryTree(10, null, n13b);
        BinaryTree n9b = new BinaryTree(9);
        BinaryTree n7b = new BinaryTree(7, n9b, n10b);
        BinaryTree n4b = new BinaryTree(4, n7b, null);
        BinaryTree n14b = new BinaryTree(14, null, null);
        BinaryTree n12b = new BinaryTree(12, null, null);
        BinaryTree n11b = new BinaryTree(11, null, n14b);
        BinaryTree n8b = new BinaryTree(8, n11b, n12b);
        BinaryTree n5b = new BinaryTree(5, null, n8b);
        BinaryTree n2b = new BinaryTree(2, n4b, n5b);
        BinaryTree n6b = new BinaryTree(6, null, null);
        BinaryTree n3b = new BinaryTree(3, null, n6b);
        n1b = new BinaryTree(1, n2b, n3b);

    }

    @Test
    public void test_all() {
        init();
        
        System.out.print("Testing numNodes...");
        assertEquals(10, tree.numNodes());
        assertEquals(14, n1b.numNodes());
        assertEquals(5, a.numNodes());
        assertEquals(1, single.numNodes());
        assertEquals(0, empty.numNodes());
        System.out.println("success");

        System.out.print("Testing numLeaves...");
        assertEquals(4, tree.numLeaves());
        assertEquals(5, n1b.numLeaves());
        assertEquals(3, a.numLeaves());
        assertEquals(1, single.numLeaves());
        assertEquals(0, empty.numLeaves());
        System.out.println("success");

        System.out.print("Testing height...");
        assertEquals(4, tree.height());
        assertEquals(5, n1b.height());
        assertEquals(2, a.height());
        assertEquals(0, single.height());
        //   assertEquals(0, empty.height());
        System.out.println("success");

        System.out.print("Testing width...");
        assertEquals(7, tree.width());
        assertEquals(8, n1b.width());
        assertEquals(3, a.width());
        assertEquals(0, single.width());
        //     assertEquals(0, empty.width());
        System.out.println("success");

        System.out.print("Testing isFull...");
        assertEquals(false, tree.isFull());
        assertEquals(false, n1b.isFull());
        assertEquals(true, a.isFull());
        assertEquals(true, single.isFull());
        assertEquals(true, empty.isFull());
        System.out.println("success");

        System.out.print("Testing isDescendant...");
        assertEquals(true, tree.isDescendant(2, 6));
        assertEquals(true, tree.isDescendant(1, 4));
        assertEquals(true, tree.isDescendant(3, 10));
        assertEquals(false, tree.isDescendant(8, 10));
        assertEquals(false, tree.isDescendant(3, 6));

        assertEquals(true, a.isDescendant("b", "d"));
        assertEquals(true, a.isDescendant("a", "e"));
        assertEquals(true, a.isDescendant("a", "c"));
        assertEquals(false, a.isDescendant("d", "e"));
        assertEquals(false, a.isDescendant("b", "c"));
        assertEquals(false, single.isDescendant("b", "d"));
        assertEquals(false, empty.isDescendant("b", "d"));
        System.out.println("success");

        System.out.print("Testing isPerfect...");
        assertEquals(false, tree.isPerfect());
        assertEquals(false, n1b.isPerfect());
        assertEquals(false, a.isPerfect());
        assertEquals(true, single.isPerfect());
        assertEquals(true, empty.isPerfect());
        BinaryTree d1 = new BinaryTree("d");
        BinaryTree e1 = new BinaryTree("e");
        BinaryTree f1 = new BinaryTree("f");
        BinaryTree g1 = new BinaryTree("g");
        BinaryTree b1 = new BinaryTree("b", d1, e1);
        assertEquals(true, b1.isPerfect());
        BinaryTree c1 = new BinaryTree("c", f1, g1);
        assertEquals(true, c1.isPerfect());
        BinaryTree a1 = new BinaryTree("a", b1, c1);
        assertEquals(true, a1.isPerfect());
        System.out.println("success");

        System.out.print("Testing inOrder (i.e. toString)...");
        assertEquals("[4, 2, 6, 5, 1, 8, 3, 7, 10, 9]", tree.toString());
        assertEquals("[9, 7, 10, 13, 4, 2, 5, 11, 14, 8, 12, 1, 3, 6]", n1b.toString());
        assertEquals("[d, b, e, a, c]", a.toString());
        assertEquals("[s]", single.toString());
        assertEquals("[]", empty.toString());
        System.out.println("success");

        System.out.print("Testing preOrder...");
        assertEquals("[1, 2, 4, 5, 6, 3, 8, 7, 9, 10]", tree.preOrder());
        assertEquals("[1, 2, 4, 7, 9, 10, 13, 5, 8, 11, 14, 12, 3, 6]", n1b.preOrder());
        assertEquals("[a, b, d, e, c]", a.preOrder());
        assertEquals("[s]", single.preOrder());
        assertEquals("[]", empty.preOrder());
        System.out.println("success");

        System.out.print("Testing postOrder...");
        assertEquals("[4, 6, 5, 2, 8, 10, 9, 7, 3, 1]", tree.postOrder());
        assertEquals("[9, 13, 10, 7, 4, 14, 11, 12, 8, 5, 2, 6, 3, 1]", n1b.postOrder());
        assertEquals("[d, e, b, c, a]", a.postOrder());
        assertEquals("[s]", single.postOrder());       
        assertEquals("[]", empty.postOrder());
        System.out.println("success");

        System.out.print("Testing levelOrder...");
        assertEquals("[1, 2, 3, 4, 5, 8, 7, 6, 9, 10]", tree.levelOrder());
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]", n1b.levelOrder());
        assertEquals("[a, b, c, d, e]", a.levelOrder());
        assertEquals("[s]", single.levelOrder());
        assertEquals("[]", empty.levelOrder());
        System.out.println("success");
    }
}
