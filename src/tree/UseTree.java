package tree;

public class UseTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1, 4, 8, 3, 9, 0, 2, -1, 1, 5, 2, 5, 9}, 5);

        String[][] matrix = new String[tree.maxVLevel + 1][tree.maxHLevel + 1];
        for (int i = 0; i < tree.maxVLevel + 1; i++) {
            for (int j = 0; j < tree.maxHLevel + 1; j++) {
                matrix[i][j] = BinaryTree.STR_SEQ;
            }
        }
        tree.calcuateOutputArray(tree.getRoot(), matrix);

        for (int i = 0; i < tree.maxVLevel + 1; i++) {
            for (int j = 0; j < tree.maxHLevel + 1; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 1; k <= 5 - matrix[i][j].length(); k++) {
                    sb.append(" ");
                }
                System.out.print(matrix[i][j] + sb.toString());
            }
            System.out.println();
        }
    }
}
