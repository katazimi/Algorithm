package a008_HuffmanCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	private Node root;
    private Map<Character, Integer> frequencies;

    HuffmanTree(String source) {
        frequencies = new HashMap<>();
        build(source);
    }

    // 주어진 문자열을 바탕으로 허프만 트리를 구축
    private void build(String source) {
        for (char ch : source.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('*', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            queue.add(parent);
        }

        root = queue.poll();  // 트리의 루트 노드
    }

    public Node getRoot() {
        return root;
    }

    public Map<Character, Integer> getFrequencies() {
        return frequencies;
    }
}