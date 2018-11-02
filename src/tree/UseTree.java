package tree;

public class UseTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1, 4, 8, 3, 9, 0, 2, -1, 1, 5, 2, 5, 9}, 5);

        int searchNode = 5;
        if (tree.contain(searchNode)) {
            System.out.println("Значение " + searchNode + " найдено в количестве "
                    + tree.count(searchNode) + " шт.");
        } else {
            System.out.println("Значение " + searchNode + " не найдено");

        }
    }
}
