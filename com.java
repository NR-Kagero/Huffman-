package com.company;

import java.util.Comparator;

public class com implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getProbability() - o2.getProbability();
    }
}
