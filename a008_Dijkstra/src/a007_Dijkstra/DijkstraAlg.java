package a007_Dijkstra;

public class DijkstraAlg {
	static int V = 10;
	static String[] city = {"서울", "천안", "원주", "강릉", "논산", "대전", "대구", "포항", "광주", "부산"};
	static boolean[] sptSet = new boolean[V];	//shortest path 집합, true면 포함
	static int[] D = new int[V];	//최단 경로의 값 저장할 배열
	static int[][] graph = new int[][] {
		{ 0,   12,  15,  0,   0,   0,   0,   0,   0,   0 },
        { 12,  0,   0,   0,   4,   10,  0,   0,   0,   0 },
        { 15,  0,   0,   21,  0,   0,   7,   0,   0,   0 },
        { 0,   0,   21,  0,   0,   0,   0,   25,  0,   0 },
        { 0,   4,   0,   0,   0,   3,   0,   0,   13,  0 },
        { 0,   10,  0,   0,   3,   0,   10,  0,   0,   0 },
        { 0,   0,   7,   0,   0,   10,  0,   19,  0,   9 },
        { 0,   0,   0,   25,  0,   0,   19,  0,   0,   5 },
        { 0,   0,   0,   0,   13,  0,   0,   0,   0,   15 },
        { 0,   0,   0,  0,   0,   0,   9,   5,   15,  0 } 
    };
    
    //graph에 대해서 s 버텍스에서 출발하는 최단경로 구하기
    private static void ShortestPath(int[][] graph, int s) {
    	for (int i=0; i<V; i++) {
    		D[i] = Integer.MAX_VALUE;
    		sptSet[i] = false;
    	}
    	
    	D[s] = 0;
    	
    	for (int i=0; i< V-1; i++) {
    		int min = MinDistance();
    		sptSet[min] = true;
    		
    		// D[] 배열을 업데이트한다.
    		for (int v=0; v<V; v++) {
    			// 아직 결정되지 않은 vertex 중에서, i와 연결되었고, 
    			// 현재까지 알려진 최단경로보다 지금 찾아진 경로를 통한 거리가 더 가까우
    			if (sptSet[v] == false && graph[min][v] != 0 && 
    					/*D[i] != Integer.MAX_VALUE &&*/ D[min] + graph[min][v] < D[v]) {
    				D[v] = D[min] + graph[min][v];
    			}
    		}
    		
    		System.out.println("최단경로 vertex : " + city[min]);
    		PrintDist();
    	}
    }
	
    private static void PrintDist() {
		for (int i=0; i<V; i++) {
			System.out.println(city[i]+ " " + D[i]);
		}
		
	}

	// D[i]에서 가장 작은 값을 갖는 인덱스를 리턴
    // setSpt[i]는 false인 것 중에 찾는다.
	private static int MinDistance() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i=0; i<V; i++) {
			if (sptSet[i] == false && D[i] < min) {
				min = D[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}

	public static void main(String[] args) {
		ShortestPath(graph, 5); //0은 처음 시작하는 도시의 인덱스 번호
	}

}
