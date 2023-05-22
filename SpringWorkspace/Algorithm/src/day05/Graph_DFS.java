package day05;
//1 -> 2 -> 6 -> 8 -> 3 -> 5 -> 4 -> 7
public class Graph_DFS {
	
	//방문처리에 사용할 배열 선언
	static boolean[] visited=new boolean[9];//디폴트값 false
	
	static int[][] graph= {{},{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
						//  0  1        2      3	 4		5	  6	   7     8

	static void dfs(int nodeIndex) {
		visited[nodeIndex]=true;
		//방문노드를 출력하자
		System.out.print(nodeIndex+"->");
		//방문한 노드에 인접한 노드를 찾기
		for(int node:graph[nodeIndex]) {
			//인접노드가 방문한 적이 없다면 dfs수행함
			if(!visited[node]) {
				dfs(node);//재귀호출
			}
		}
		
	}
	
	public static void main(String[] args) {
		dfs(1);
		
	}

}
