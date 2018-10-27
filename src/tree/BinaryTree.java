package tree;

class BinaryTree {

    private Node root;
    int maxVLevel = 0;
    int maxHLevel = 0;
    final static String STR_SEQ = "     ";

    Node getRoot() {
        return root;
    }

    BinaryTree(int[] data, int rootValue) {

        root = new Node(rootValue, 0, 5);

        for (int newVal : data) {
            addNode(newVal, root);
        }
    }

    void calcuateOutputArray(Node node, String[][] matrix) {
        matrix[node.getvLevel()][node.gethLevel()] = matrix[node.getvLevel()][node.gethLevel()].equals(STR_SEQ) ? String.valueOf(node.getValue()) : matrix[node.getvLevel()][node.gethLevel()] + "|" + String.valueOf(node.getValue());
        if (node.getLeft() != null) {
            calcuateOutputArray(node.getLeft(), matrix);
        }
        if (node.getRight() != null) {
            calcuateOutputArray(node.getRight(), matrix);
        }
    }

    private void addNode(int newVal, Node node) {
        int newVLevel = node.getvLevel() + 1;
        int newHLevel = node.gethLevel();

        if (newVal < node.getValue()) {
            if (node.getLeft() == null) {
                if (maxVLevel < newVLevel) {
                    maxVLevel = newVLevel;
                }
                node.setLeft(new Node(newVal, newVLevel, newHLevel - 1));
            } else {
                addNode(newVal, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                maxHLevel = newHLevel + 1;
                if (maxVLevel < newVLevel) {
                    maxVLevel = newVLevel;
                }
                node.setRight(new Node(newVal, newVLevel, newHLevel + 1));
            } else {
                addNode(newVal, node.getRight());
            }
        }
    }

    private class Node {
        private Node left = null;
        private Node right = null;
        private int value;
        private int vLevel;
        private int hLevel;

        Node(int val, int vLevel, int hLevel) {
            this.setValue(val);
            this.setvLevel(vLevel);
            this.sethLevel(hLevel);
        }

        Node getLeft() {
            return left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node getRight() {
            return right;
        }

        void setRight(Node right) {
            this.right = right;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }

        int getvLevel() {
            return vLevel;
        }

        void setvLevel(int vLevel) {
            this.vLevel = vLevel;
        }

        int gethLevel() {
            return hLevel;
        }

        void sethLevel(int hLevel) {
            this.hLevel = hLevel;
        }

    }
}
