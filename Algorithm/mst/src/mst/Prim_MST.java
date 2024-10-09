package mst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prim_MST {
    static int MAX = 100; // 최대 정점의 수
    static int INF = 999; // 무한대
    private int V; // 정점의 갯수
    String[] vertex = new String[MAX];
    int[][] adj = new int[MAX][MAX];
    private int MSTWeight = 0;
    
    // 인스턴스 변수로 변경
    private boolean[] selected;
    private int[] dist;

    void Prim(int start) {
        selected = new boolean[V];
        dist = new int[V];

        for (int i = 0; i < V; i++) {
            selected[i] = false;
            dist[i] = INF;
        }

        PrintDist(dist);
        PrintSelected(selected);

        dist[start] = 0; // 시작점

        for (int i = 0; i < V; i++) {
            int u = GetMinVertex(selected, dist);
            selected[u] = true;

            MSTWeight += dist[u];
            System.out.println(vertex[u] + " (" + MSTWeight + ") ->");

            for (int v = 0; v < V; v++) {
                if (adj[u][v] != INF) {
                    if (!selected[v] && adj[u][v] < dist[v]) {
                        dist[v] = adj[u][v];
                    }
                }
            }
            PrintDist(dist);
            PrintSelected(selected);
        }
    }

    private int GetMinVertex(boolean[] selected, int[] dist) {
        int minV = -1;
        int minDist = INF;
        for (int v = 0; v < V; v++) {
            if (!selected[v] && dist[v] < minDist) {
                minV = v; // 인덱스를 제대로 설정
                minDist = dist[v];
            }
        }
        return minV;
    }

    private void PrintSelected(boolean[] selected) {
        System.out.print("Selected[] : \t");
        for (int i = 0; i < V; i++) {
            System.out.printf("%8b", selected[i]); // boolean 값 출력 시 %b 사용
        }
        System.out.println();
    }

    private void PrintDist(int[] dist) {
        System.out.print("Dist[] : \t");
        for (int i = 0; i < V; i++) {
            System.out.printf("%8d", dist[i]);
        }
        System.out.println();
    }

    void PrintGraph() {
        System.out.println("Vertex 수 : " + V);
        for (int i = 0; i < V; i++) {
            System.out.print(vertex[i]);
            for (int j = 0; j < V; j++)
                System.out.printf("%8d", adj[i][j]);
            System.out.println();
        }
    }

    void ReadGraph(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // 첫 번째 줄은 정점의 수를 나타냄
        line = reader.readLine();
        V = Integer.parseInt(line); // prim_MST의 V에 값을 할당

        for (int i = 0; (line = reader.readLine()) != null; i++) {
            String[] s = line.split("\t");

            // 정점 삽입
            InsertVertex(i, s[0]); // i 사용

            for (int j = 1; j < s.length; j++) {
                // 간선 삽입
                InsertEdge(i, j - 1, Integer.parseInt(s[j])); // j - 1 사용
            }
        }

        reader.close();
    }

    private void InsertVertex(int index, String name) {
        vertex[index] = name;
    }

    private void InsertEdge(int i, int j, int w) {
        adj[i][j] = w;
    }

    public static void main(String[] args) throws IOException {
        Prim_MST prim_MST = new Prim_MST();
        prim_MST.ReadGraph("graph2.txt"); // 인스턴스 메서드 호출
        prim_MST.PrintGraph();

        prim_MST.Prim(6); // 시작 정점으로 0을 사용
    }
}
