package lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;
    private Node tempNode;                    //   вспомогательная
    private int height = 0;                   //   вспомогательная, для сохранения и передачи внутреннего height.
    private boolean isBalanced = true;        //   вспомогательная

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;   //  у каждого узла своя, показывает в каком слое находится.

        public Node() {
        }

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", size=" + size +
                    ", height=" + height +
                    '}';
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node) {
        if(node == null){
            return height;
        }
        else{
            if(node.height > height){
                height = node.height;
            }
            height(node.right);
            height(node.left);
        }
        return height;
    }


    public boolean isEmpty() {
        return root == null;
    }

    private void isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key shouldn't be null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        isKeyNotNull(key);
        if (value == null) {
            //delete
            return;
        }
        root = put(root, key, value);
        tempNode = null;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            Node newNode = new Node(key, value);
           tempNode = newNode;
//            return new Node(key, value);
            return newNode;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;

        if(tempNode != null){
            tempNode.height ++;
        }
        return node;
    }


    public Key minKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return min(node.right);
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("map empty");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        isKeyNotNull(key);
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public boolean isBalanced(){
        isBalanced = true;
        isBalanced(root);
        return isBalanced;
    }

    private boolean isBalanced(Node node) {
        if(node == null){
            return true;
        }else {
            if (node.right != null && node.left != null) {
                int leftHeight = min(node.left).height;
                int rightHeight = max(node.right).height;
                if (Math.abs(leftHeight - rightHeight) > 1) {
                    isBalanced = false;
                }
            }

            isBalanced(node.right);
            isBalanced(node.left);

        }
        return true;
    }

//     private Node allElement(Node node){
//        if(node.left == null && node.right == null){
////            if(node.right == null && node.left == null){
//            return node;
//        }else {
//
//                    return allElement(node.left).height > allElement(node.right).height ? allElement(node.left) : allElement(node.right);
////            allElement(node.right);
//        }
////        return node;
//
//     }



    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + "/" + node.height + "/" + node.size  + " " + toString(node.right);
    }
}
