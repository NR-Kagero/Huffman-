package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Tree {
    Node root;

    public Tree(ArrayList list) {
        while (list.size() != 1) {
            root = new Node((Node) list.get(0), (Node) list.get(1));
            list.remove(0);
            list.remove(0);
            list.add(root);
            Collections.sort(list, new com());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "tree{" +
                "root=" + root +
                '}';
    }
}
