package HomeWork6;

public class Test {

    public static void main(String[] args) {
        Tree<Integer> firstTree = generateRandomTree();
        Tree<Integer> secondTree = generateRandomTree();
        Tree<Integer> thirdTree = generateRandomTree();
        Tree<Integer> fourthTree = generateRandomTree();

        firstTree.display();
        secondTree.display();
        thirdTree.display();
        fourthTree.display();
    }

    public static Tree<Integer> generateRandomTree(){
        Tree<Integer> tree = new TreeImpl<>();
        while (tree.treeDepth()<=4){
            int randomValue = (int)(Math.random()*50)-25;
            tree.add(randomValue);
        }
        return tree;
    }
}
