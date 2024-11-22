package a008_HuffmanCode;

import java.util.ArrayList;
import java.util.List;

public class HuffmanAlg {
	private HuffmanTree huffmanTree;

    public HuffmanAlg(String source) {
        huffmanTree = new HuffmanTree(source);
    }

    // 문자열을 인코딩하여 이진 데이터로 변환
    public List<Boolean> encode(String source) {
        List<Boolean> encodedData = new ArrayList<>();
        Node root = huffmanTree.getRoot();

        for (char ch : source.toCharArray()) {
            List<Boolean> encodedChar = root.traverse(ch, new ArrayList<>());
            if (encodedChar != null) {
                encodedData.addAll(encodedChar);
            }
        }
        return encodedData;
    }

    // 이진 데이터를 디코딩하여 원래 문자열로 복원
    public String decode(List<Boolean> encodedData) {
        StringBuilder decoded = new StringBuilder();
        Node current = huffmanTree.getRoot();

        for (Boolean bit : encodedData) {
            current = bit ? current.right : current.left;

            if (current.left == null && current.right == null) {  // 리프 노드
                decoded.append(current.symbol);
                current = huffmanTree.getRoot();
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        String input = "Example input for Huffman encoding and decoding.";
        
        HuffmanAlg huffmanAlg = new HuffmanAlg(input);
        
        // Encode
        List<Boolean> encoded = huffmanAlg.encode(input);
        System.out.print("Encoded : ");
        for (Boolean bit : encoded) {
            System.out.print(bit ? 1 : 0);
        }
        System.out.println();

        // Decode
        String decoded = huffmanAlg.decode(encoded);
        System.out.println("Decoded : " + decoded);
        
        System.out.println("Encoded length: " + encoded.size() + " bits");
        System.out.println("Decoded length: " + decoded.length() * 8 + " bits");
        System.out.println("Compression rate: " + ((double) encoded.size() / (decoded.length() * 8) * 100) + " %");
    }
}