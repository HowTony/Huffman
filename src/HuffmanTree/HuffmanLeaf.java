package HuffmanTree;

/**
 * Created by Tony Howarth on 10/20/2016.
 */
class HuffmanLeaf extends HuffmanTree {
    public final char value; // the character this leaf represents

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}