package com.company;

import java.io.*;
import java.util.*;

public class Compression {
    static ArrayList<Character> cha = new ArrayList<Character>();
    static ArrayList<String> codes = new ArrayList<String>();

    public static void decopmress(ArrayList<String> codes, ArrayList<Character> cha, String text) throws IOException {
        File file3 = new File("decompress.txt");
        file3.createNewFile();
        FileWriter write = new FileWriter(file3);
        String text2 = new String();
        String compare = new String();
        for (int i = 0; i < text.length(); i++) {
            compare = compare + String.valueOf(text.charAt(i));
            if (codes.contains(compare)) {
                text2 = text2 +cha.get(codes.indexOf(compare));
                compare="";
            }
        }
        write.write(text2);
        write.close();
    }

    public static void processing(String path) throws IOException {
        cha.clear();
        codes.clear();
        int a = 0;
        File file2 = new File(path);
        Scanner read = new Scanner(file2);
        String re="";
        while (read.hasNextLine()) {
             re = String.valueOf(read.nextLine());
            if (a == 0) {
                re = re.substring(1, re.length() - 1);
                String[] res = re.split(", ");
                for (int i = 0; i < res.length; i++) {
                    cha.add(res[i].charAt(0));
                }
                a = 1;
            } else if (a == 1) {
                re = re.substring(1, re.length() - 1);
                String[] res = re.split(", ");
                for (int i = 0; i < res.length; i++) {
                    codes.add(res[i]);
                }
                a = 2;
            }
        }
        decopmress(codes,cha,re);

    }

    public static void compress(ArrayList<String> codes, ArrayList<Character> cha, String text) throws IOException {
        String text2 = new String();
        File file = new File("compress.txt");
        file.createNewFile();
        FileWriter write = new FileWriter(file);
        for (int i = 0; i < text.length(); i++) {
            text2 = text2 + codes.get(cha.indexOf(text.charAt(i)));
        }
        write.write(cha.toString());
        write.write("\n" + codes.toString());
        write.write("\n" + text2);
        write.close();
    }

    public static void Code(Node root, String s) {
        if (root.left == null && root.right == null && root.getSymbol().length() == 1) {
            cha.add(root.getSymbol().charAt(0));
            codes.add(s);
            return;
        }
        Code(root.left, s + "0");
        Code(root.right, s + "1");
    }

    public static Character[] charecter(String string) {
        ArrayList<Character> cha = new ArrayList<Character>(string.length());
        String dum = string;
        while (!dum.equals("")) {
            cha.add(dum.charAt(0));
            dum = dum.replaceAll(String.valueOf(dum.charAt(0)), "");
        }
        Character[] chas = new Character[cha.size()];
        cha.toArray(chas);
        return chas;
    }

    public static Integer[] count(String string) {
        ArrayList<Integer> num = new ArrayList<Integer>(string.length());
        int i = 0;
        String dum = string;
        while (!dum.equals("")) {
            num.add(countChar(dum.charAt(0), dum));
            dum = dum.replaceAll(String.valueOf(dum.charAt(0)), "");
            i++;
        }
        Integer[] nums = new Integer[num.size()];
        num.toArray(nums);
        return nums;
    }

    public static int countChar(char c, String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        //HashMap<String, Integer> list = new HashMap<String, Integer>();
        File text = new File("huffman.txt");
        Scanner input = new Scanner(text);
        String code = "";
        String text1 = "";
        while (input.hasNextLine()) {
            text1 = input.nextLine();
        }
        Integer[] charcterFreq = count(text1);
        Character[] characters = charecter(text1);

        ArrayList<Node> sortedList = new ArrayList<Node>(characters.length);
        for (int i = 0; i < characters.length; i++) {
            Node node = new Node();
            node.setProbability(charcterFreq[i]);
            node.setSymbol(String.valueOf(characters[i]));
            sortedList.add(node);
        }
        Collections.sort(sortedList, new com());
        Tree tree = new Tree(sortedList);
        Code(tree.getRoot(), code);
        compress(codes, cha, text1);
        processing("compress.txt");

    }

}

