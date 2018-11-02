package tree;

import java.util.ArrayList;

class BinaryTree {

    private ArrayList<Integer> treeData = new ArrayList<>();

    BinaryTree(int[] data, int rootValue) {

        Node root = new Node(rootValue);
        treeData.add(rootValue);

        for (int newVal : data) {
            addNode(newVal, root);
        }
    }

    private void addNode(int newVal, Node node) {
        if (newVal < node.getValue()) {
            if (node.getLeft() == null) {
                treeData.add(newVal);
                node.setLeft(new Node(newVal));
            } else {
                addNode(newVal, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                treeData.add(newVal);
                node.setRight(new Node(newVal));
            } else {
                addNode(newVal, node.getRight());
            }
        }
    }

    boolean contain(int val) {
        return treeData.contains(val);
    }

    int count(int val) {
        int found = 0;
        if (!contain(val)) {
            return found;
        }
        for (int i : treeData) {
            if (i == val) {
                found++;
            }
        }
        return found;
    }

    private class Node {
        private Node left = null;
        private Node right = null;
        private int value;

        Node(int val) {
            this.setValue(val);
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

    }
}
