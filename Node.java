package com.company;
public class Node {

        String symbol;
        int probability;
        Node left;
        Node right;

        public Node() {
        }

        public Node(String symbol, int probability) {
            this.symbol = symbol;
            this.probability = probability;
            left = null;
            right = null;
        }

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
            probability = left.getProbability() + right.getProbability();
            symbol = left.getSymbol() + "+" + right.getSymbol();
        }

        public void setSymbol(String sy) {
            this.symbol = sy;
        }

        public void setProbability(int prob) {
            this.probability = prob;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getProbability() {
            return probability;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "symbol=" + symbol +
                    ", probability=" + probability +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
}
