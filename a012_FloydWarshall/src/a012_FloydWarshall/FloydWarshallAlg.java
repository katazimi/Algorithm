package a012_FloydWarshall;

public class FloydWarshallAlg {
	static int V = 5; //정점의 갯수
	final static int Inf = 100;	//무한대
	
	private static void FloydWarshall(int[][] graph, int v) {
		System.out.println("Graph");
		PrintGraph(graph, V);
		
		for(int k=0; k<v;k++) {
			for (int i=0; i<v; i++) {
				for (int j=0; j<v; j++) {
					if (graph[i][k] != 100 && graph[k][j] != 100 && graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
						System.out.println("Change : " + "[" + i + ", " + j + "]" + " = " + "[" + i + ", " + k + "]" + " + " + "[" + k + ", " + j + "]" + " = " + graph[i][j]);
					}
					
				}
			}
			PrintGraph(graph, v);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Result");
		PrintGraph(graph, v);
	}
	
	private static void PrintGraph(int[][] graph, int v) {
		for (int i=0; i<v; i++) {
			for (int j=0; j<v; j++) {
				System.out.print(graph[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		int[][] graph = {
				{0,4,2,5,Inf}, 
				{Inf,0,1,Inf,4}, 
				{1,3,0,1,2}, 
				{-2, Inf,Inf,0,2}, 
				{Inf,-3,3,1,0}
		};
		
		FloydWarshall(graph, V);

	}
}