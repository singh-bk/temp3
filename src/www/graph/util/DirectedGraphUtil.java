package www.graph.util;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import com.hp.util.Pair;

public class DirectedGraphUtil {

	public static int findShortest(DirectedGraphNode src, DirectedGraphNode dest){
		int dist = 0;
		int minDist = 9999;
		Stack<Pair<DirectedGraphNode, Integer>> stack = new Stack<Pair<DirectedGraphNode, Integer>>();
		stack.add(new Pair<>(src,0));
		while(!stack.isEmpty()){
			Pair<DirectedGraphNode, Integer> top = stack.peek();
			DirectedGraphNode topNode = top.getK();
			int topDist = top.getV();
			List<Pair<DirectedGraphNode, Integer>> neighbors = topNode.getNeighbors();
			Optional<Pair<DirectedGraphNode, Integer>> selected = neighbors.stream().filter(neighbor -> !neighbor.getK().isVisited()).findFirst();
			if(selected.isPresent()){
				DirectedGraphNode currentNode = selected.get().getK();
				currentNode.setVisited(true);
				int currentDist = selected.get().getV();
				if(currentNode.getId().equals(dest.getId())){
					int latestMinDist = topDist + currentDist;
					if(latestMinDist < minDist) minDist = latestMinDist;
					stack.pop();
				}else{
					int latestTopDist = topDist + currentDist;
					stack.push(new Pair<>(currentNode, latestTopDist));
				}
			}else{
				stack.pop();
			}
		}
		return minDist;
	}
}
