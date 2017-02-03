package HuffmanTree;

import static HuffmanTree.HuffmanCode.buildTree;

/**
 * Created by Tony Howarth on 10/20/2016.
 */
public class Main {

    public static void main(String[] args) {
        String test = "this is an example for huffman encoding";

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[256];
        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++;

        // build tree
        HuffmanTree tree = buildTree(charFreqs);

        // print out results
        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }


    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
