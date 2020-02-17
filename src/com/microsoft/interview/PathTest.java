package com.microsoft.interview;

import java.util.ArrayList;
import java.util.List;

public class PathTest {

    public static void main(String[] args) {
        final PathTest obj = new PathTest();
        final Node root = obj.initialize();
        final List<Integer> path = new ArrayList<Integer>(); 
        System.out.println(obj.findPath(root, root.left.right, path));
        System.out.println(path);
    }
    
    public Node initialize() {
        final Node root = new Node(5);
        final Node node1 = new Node(10);
        final Node node2 = new Node(15);
        final Node node3 = new Node(20);
        final Node node4 = new Node(25);
        final Node node5 = new Node(30);
        final Node node6 = new Node(35);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        return root;
    }
    
    public boolean findPath(Node node, Node srch, List<Integer> path) { 
        if(node == null) {
            return false;
        }
        path.add(node.id);
        if(node.id == srch.id) {
            return true;
        }
        if(findPath(node.left, srch, path) || findPath(node.right, srch, path)) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    
    class Node{
        int id;
        Node left;
        Node right;
        Node(int ii){
            id = ii;
        }
    }
}
