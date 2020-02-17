package com.microsoft.interview;

import java.util.ArrayList;
import java.util.List;

public class PathTest2 {

    public static void main(String[] args) {

        final PathTest2 obj = new PathTest2();
        final Node src = obj.init();
        final int dest = 45;
        final List<Integer> path = new ArrayList<Integer>();
        System.out.println(obj.hasPath(src, dest, path));
        System.out.println(path);
    }

    public Node init() {
        final Node node1 = new Node(5);
        final Node node2 = new Node(10);
        final Node node3 = new Node(15);
        final Node node4 = new Node(20);
        final Node node5 = new Node(25);
        final Node node6 = new Node(30);
        final Node node7 = new Node(35);
        final Node node8 = new Node(40);
        final Node node9 = new Node(45);
        final Node node10 = new Node(50);
        final Node node11 = new Node(55);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);

        node2.neighbors.add(node5);

        node3.neighbors.add(node6);

        node4.neighbors.add(node6);
        node4.neighbors.add(node7);

        node5.neighbors.add(node8);
        node5.neighbors.add(node3);

        node6.neighbors.add(node10);
        node7.neighbors.add(node10);
        node10.neighbors.add(node11);
        node11.neighbors.add(node9);
        node11.neighbors.add(node8);


        return node1;
    }
    
    public boolean hasPath(Node node, int srch, List<Integer> path) {
        if(node == null) {
            return false;
        }
        path.add(node.id);
        if(node.id == srch) {
            return true;
        }
        for(final Node nn: node.neighbors) {
            if(hasPath(nn, srch, path)) {
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }

    class Node {
        int        id;
        boolean    visited;
        List<Node> neighbors;

        Node(int ii) {
            id = ii;
            neighbors = new ArrayList<Node>();
        }
    }
}
