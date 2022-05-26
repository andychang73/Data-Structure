package tree;

import Iterator.Iterator;
import Iterator.ArrayList;
import Iterator.positionalList.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.impl.LinkedBinaryTree;
import tree.util.TreeUtil;


public class LinkedBinaryTreeTest {

    private LinkedBinaryTree<Integer> tree;
    private LinkedBinaryTree<String> stringTree;

    @Before
    public void init(){
        tree = new LinkedBinaryTree<>();
        stringTree = new LinkedBinaryTree<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRootFailed_WhenTreeIsNotEmpty(){
        tree.addRoot(1);
        tree.addRoot(1);
    }

    @Test
    public void testAddRootSuccessful_WhenTreeIsEmpty(){
        tree.addRoot(1);
    }

    @Test
    public void testGetRootSuccessful(){
        Integer root = 1;
        tree.addRoot(root);

        Assert.assertEquals(root, tree.root().getElement());
    }

    @Test
    public void testGetParentSuccessful_WhenPIsRoot(){
        tree.addRoot(1);

        Position<Integer> root = tree.root();
        Assert.assertNull(tree.parent(root));
    }

    @Test
    public void testGetParentSuccessFul_WhenPIsNotRoot(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 2);

        Assert.assertEquals(Integer.valueOf(1), tree.parent(left).getElement());
    }

    @Test
    public void testAddLeftSuccessful_WhenLeftIsNull(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 2);

        Assert.assertEquals(Integer.valueOf(2), left.getElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddLeftFailed_WhenLeftIsNotNull(){
        Position<Integer> root = tree.addRoot(1);
        tree.addLeft(root, 2);
        tree.addLeft(root, 2);
    }

    @Test
    public void testAddRightSuccessful_WhenRightIsNull(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> right = tree.addRight(root, 2);

        Assert.assertEquals(Integer.valueOf(2), right.getElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRightFailed_WhenRightIsNotNull(){
        Position<Integer> root = tree.addRoot(1);
        tree.addRight(root, 2);
        tree.addRight(root, 2);
    }

    @Test
    public void testSetSuccessFul(){
        Position<Integer> root = tree.addRoot(1);
        Integer r = tree.set(root, 2);

        Assert.assertEquals(Integer.valueOf(1), r);
        Assert.assertEquals(Integer.valueOf(2), root.getElement());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFailed_WhenNodeHasTwoChildren(){
        Position<Integer> root = tree.addRoot(1);
        tree.addLeft(root, 2);
        tree.addRight(root, 2);
        tree.remove(root);
    }

    @Test
    public void testRemoveSuccessful_WhenRemoveRootAndHasNoChild(){
        Position<Integer> root = tree.addRoot(1);
        Integer r = tree.remove(root);

        Assert.assertEquals(0, tree.size());
        Assert.assertNull(tree.root());
        Assert.assertEquals(Integer.valueOf(1), r);
    }

    @Test
    public void testRemoveSuccessful_WhenRemoveRootAndHasAChild(){
        Position<Integer> root = tree.addRoot(1);
        tree.addLeft(root, 2);
        Integer r = tree.remove(root);

        Assert.assertEquals(1, tree.size());
        Assert.assertEquals(Integer.valueOf(1), r);
        Assert.assertEquals(Integer.valueOf(2), tree.root().getElement());
    }

    @Test
    public void testRemoveSuccessFul_WhenRemoveLeftOfTheRoot(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.addLeft(root, 2);
        Position<Integer> left2 = tree.addLeft(left, 3);
        Integer l = tree.remove(left);

        Assert.assertEquals(Integer.valueOf(2), l);
        Assert.assertEquals(2, tree.size());
        Assert.assertSame(left2, tree.left(root));
        Assert.assertNull(left.getElement());
    }

    @Test
    public void testPreOrderIterator(){
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> one = tree.addLeft(root, 1);
        Position<Integer> two = tree.addRight(root, 2);
        Position<Integer> three = tree.addLeft(one, 3);
        Position<Integer> four = tree.addRight(one, 4);
        Position<Integer> five = tree.addLeft(two, 5);
        Position<Integer> six = tree.addRight(two, 6);

        Iterator<Integer> iterator = tree.preorderIterator();
        int[] result = new int[]{0,1,3,4,2,5,6};

        for (int j : result) {
            Assert.assertEquals(Integer.valueOf(j), iterator.next());
        }
    }

    @Test
    public void testPostOrderIterator(){
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> one = tree.addLeft(root, 1);
        Position<Integer> two = tree.addRight(root, 2);
        Position<Integer> three = tree.addLeft(one, 3);
        Position<Integer> four = tree.addRight(one, 4);
        Position<Integer> five = tree.addLeft(two, 5);
        Position<Integer> six = tree.addRight(two, 6);

        Iterator<Integer> iterator = tree.postorderIterator();
        int[] result = new int[]{3,4,1,5,6,2,0};

        for(int j : result){
            Assert.assertEquals(Integer.valueOf(j), iterator.next());
        }
    }

    @Test
    public void testBreadthFirstIterator(){
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> one = tree.addLeft(root, 1);
        Position<Integer> two = tree.addRight(root, 2);
        Position<Integer> three = tree.addLeft(one, 3);
        Position<Integer> four = tree.addRight(one, 4);
        Position<Integer> five = tree.addLeft(two, 5);
        Position<Integer> six = tree.addRight(two, 6);

        Iterator<Integer> iterator = tree.breadthFirstIterator();
        int[] result = new int[]{0,1,2,3,4,5,6};

        for(int j : result){
            Assert.assertEquals(Integer.valueOf(j), iterator.next());
        }
    }

    @Test
    public void testInOrderIterator(){

        Position<Integer> root = tree.addRoot(0);
        Position<Integer> one = tree.addLeft(root, 1);
        Position<Integer> two = tree.addRight(root, 2);
        Position<Integer> three = tree.addLeft(one, 3);
        Position<Integer> four = tree.addRight(one, 4);
        Position<Integer> five = tree.addLeft(two, 5);
        Position<Integer> six = tree.addRight(two, 6);

        Iterator<Integer> iterator = tree.inorderIterator();
        int[] result = new int[] {3,1,4,0,5,2,6};

        for(int j : result){
            Assert.assertEquals(Integer.valueOf(j), iterator.next());
        }
    }

    @Test
    public void testPrintPreOrderIndent(){
        Position<Integer> root = tree.addRoot(0);
        Position<Integer> one = tree.addLeft(root, 1);
        Position<Integer> two = tree.addRight(root, 2);
        Position<Integer> three = tree.addLeft(one, 3);
        Position<Integer> four = tree.addRight(one, 4);
        Position<Integer> five = tree.addLeft(two, 5);
        Position<Integer> six = tree.addRight(two, 6);

        TreeUtil.printPreorderIndent(tree, tree.root(), 0);
    }

    @Test
    public void testPrintPreorderLabeled(){
        Position<String> root = stringTree.addRoot("A");
        Position<String> one = stringTree.addLeft(root, "B");
        Position<String> two = stringTree.addRight(root, "C");
        Position<String> three = stringTree.addLeft(one, "D");
        Position<String> four = stringTree.addRight(one, "E");
        Position<String> five = stringTree.addLeft(two, "F");
        Position<String> six = stringTree.addRight(two, "G");

        TreeUtil.printPreorderLabeled(stringTree, stringTree.root(), new ArrayList<Integer>());
    }

    @Test
    public void testDiskSpace(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> one = tree.addLeft(root, 2);
        Position<Integer> two = tree.addRight(root, 3);
        Position<Integer> three = tree.addLeft(one, 4);
        Position<Integer> four = tree.addRight(one, 5);
        Position<Integer> five = tree.addLeft(two, 6);
        Position<Integer> six = tree.addRight(two, 7);

        Assert.assertEquals(28, TreeUtil.diskSpace(tree, tree.root()));
    }

    @Test
    public void testParenthesize(){
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> one = tree.addLeft(root, 2);
        Position<Integer> two = tree.addRight(root, 3);
        Position<Integer> three = tree.addLeft(one, 4);
        Position<Integer> four = tree.addRight(one, 5);
        Position<Integer> five = tree.addLeft(two, 6);
        Position<Integer> six = tree.addRight(two, 7);

        TreeUtil.parenthesize(tree, tree.root());
    }
}
