package dataStructures;

import java.util.Comparator;

public class SBinarySearchTree<E> extends SBinaryTree<E> {

    public static void main(String[] args) {
        SBinarySearchTree<Integer> tree = new SBinarySearchTree<>(Comparator.comparingInt(n -> n));
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        for(Integer element : tree.inorder()) {
         System.out.print(element + " ");
        }
        System.out.println(tree.find(6));
        System.out.println(tree.find(8));
    }

    Comparator<E> comparator;

    public SBinarySearchTree(Comparator<E> comparator){
        super();
        this.comparator = comparator;
    }

    public void insert(E element){
        if (root() == null){
            setRoot(element);
        }else{
            moveDown(element,root());
        }
    }
    //Recursive portion of insert
    public void moveDown(E element, Node<E> node){
        if (comparator.compare(node.value,element) > 0){
            if (left(node) == null){
                setLeft(node,element);
            }else{
                moveDown(element,node.left);
            }
        }else{
            if (right(node) == null){
                setRight(node,element);
            }else{
                moveDown(element,node.right);
            }
        }
    }


    public Node<E> remove(E element){
        Node<E> found = find(element);
        return found == null ? null : remove(found);
    }

    private Node<E> remove(Node<E> node){
        Node<E> parentNode = node.parent;
        boolean isRight;
        boolean isRoot  = false;
        if (node.parent.left==node){
            node.parent.left = null;
            isRight = false;
        }else{
            node.parent.right = null;
            isRight = true;
        }
        if (node.left==null && node.right==null){
            //0 child
            node.parent=null;
        } else if (node.left != null ^ node.right != null){
            //1 child
            if (node.right!=null){
                node.right.parent = parentNode;
                if(isRoot) {

                } else if (isRight){
                    parentNode.right = node.right;
                }else{
                    parentNode.left = node.right;
                }
                node.right = null;
            }
            node.left.parent = parentNode;

        } else {
            // 2 child
        }


        return node;
    }

    private Node<E> inOrderPredecessor(Node<E> node){
        Node<E> currentNode = node.left;
        while (currentNode.right != null){
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public Node<E> find(E element){
        return find(element, root());
    }

    public Node<E> find(E element, Node<E> node){
        if (node == null){return null;}
        int result = comparator.compare(node.value,element);
        if (result > 0){
            return find(element,node.left);
        }else if (result < 0){
            return find(element,node.right);
        }else{
            return node;
        }
    }



}
