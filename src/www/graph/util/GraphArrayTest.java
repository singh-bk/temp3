package www.graph.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class GraphArrayTest {

	public static void main(String[] args) throws Exception{
		int[][] graph = CreateGraph(new File("graph.txt"));
		for(int i=0;i<graph.length;i++){
			for(int j=0;j<graph[i].length;j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] CreateGraph(File file) throws Exception{
		int[][] output = new int[0][0];
		FileReader fr= new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = null;
		int row = -1;
		int column = 0;
		while((str = br.readLine())!= null){
			if(row == -1){
				int noOfLines = Integer.parseInt(str);
				output = new int[noOfLines][noOfLines];
			}
			else
			{
				StringTokenizer token = new StringTokenizer(str, " ");
				while(token.hasMoreTokens()){
					output[row][column] = Integer.parseInt(token.nextToken());
					column++;
				}
			}
			row++;column=0;
		}
		return output;
	}
}
