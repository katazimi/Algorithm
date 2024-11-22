package a008_HuffmanCode;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
	char symbol;
    int frequency;
    Node left;
    Node right;

    Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    // 특정 문자의 인코딩 경로를 찾기 위한 트리 순회 메서드
    public List<Boolean> traverse(char targetSymbol, List<Boolean> path) {
        if (left == null && right == null) {  // 리프 노드
            if (symbol == targetSymbol) {
                return path;
            }
            return null;
        } else {
            List<Boolean> leftPath = null, rightPath = null;

            if (left != null) {
                List<Boolean> leftCopy = new ArrayList<>(path);
                leftCopy.add(false);
                leftPath = left.traverse(targetSymbol, leftCopy);
            }
            if (right != null) {
                List<Boolean> rightCopy = new ArrayList<>(path);
                rightCopy.add(true);
                rightPath = right.traverse(targetSymbol, rightCopy);
            }
            return leftPath != null ? leftPath : rightPath;
        }
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}