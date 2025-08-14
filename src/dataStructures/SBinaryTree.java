package dataStructures;

import java.util.*;

public class SBinaryTree<E>  {

    public static void main(String[] args) {
        SBinaryTree<String> tree = new SBinaryTree<>();
        Node<String> a = tree.setRoot("A");
        Node<String> b = tree.setLeft(a, "B");
        Node<String> c = tree.setRight(a, "C");
        Node<String> d = tree.setLeft(b, "D");
        Node<String> e = tree.setRight(b, "E");
        Node<String> f = tree.setRight(c, "F");

        for(String element : tree.inorder()) {
            System.out.print(element + " ");
        }
    }

    private Node<E> root;
    public SBinaryTree() {
        root = null;
    }

    public List<E> postorder() {
        ArrayList<E> list = new ArrayList<>();
        postorderSubtree(root, list);
        return list;
    }

    private void postorderSubtree(Node<E> p, List<E> snapshot){
        if(p.left!=null) postorderSubtree(p.left, snapshot);
        if(p.right !=null) postorderSubtree(p.right, snapshot);
        snapshot.add(p.value);
    }

    private void inorderExpression(Node<E> p, List<E> snapshot){
        if(p.left!=null) inorderExpression(p.left, snapshot);
        snapshot.add(p.value);
        if(p.right !=null) inorderExpression(p.right, snapshot);
    }


    public List<E> inorder() {
        ArrayList<E> list = new ArrayList<>();
        inorderExpression(root, list);
        return list;
    }

    public List<E> preorder() {
        ArrayList<E> list = new ArrayList<>();
        preorderSubtree(root, list);
        return list;
    }

    private void preorderSubtree(Node<E> p, List<E> snapshot) {
        snapshot.add(p.value);
        if(p.left!=null) preorderSubtree(p.left, snapshot);
        if(p.right !=null) preorderSubtree(p.right, snapshot);
    }

    public List<E> preorderNonRecursive() {
        ArrayList<E> list = new ArrayList<>();

        Stack<Node<E>> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node<E> p = stack.pop();
            list.add(p.value);
            if(p.left!=null) stack.add(p.left);
            if(p.right !=null) stack.add(p.right);
        }

        return list;
    }

    public List<E> levelOrder() {
        ArrayList<E> list = new ArrayList<>();

        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node<E> p = queue.poll();
            list.add(p.value);
            if(p.left!=null) queue.add(p.left);
            if(p.right !=null) queue.add(p.right);
        }

        return list;
    }

    public Node<E> root() {
        return root;
    }
    public Node<E> setRoot(E root) {
        this.root = new Node<>(root);
        return this.root;
    }

    public Node<E> left(Node<E> p) {
        return p.left;
    }

    public Node<E> setLeft(Node<E> p, E left) {
        p.left = new Node<>(left);
        return p.left;
    }

    public Node<E> right(Node<E> p) {
        return p.right;
    }
    public Node<E> setRight(Node<E> p, E right) {
        p.right = new Node<>(right);
        return p.right;
    }

    public Node<E> parent(Node<E> p) {
        return p.parent;
    }
    public Node<E> setParent(Node<E> p) {
        p.parent = p;
        return p.parent;
    }

    public static class Node<E> {
        public E value;
        public Node<E> parent;
        public Node<E> left;
        public Node<E> right;

        public Node(E value) {
            this.value = value;
        }
    }
}
