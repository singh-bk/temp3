package www.graph.util;

public class DirectedGraphTest {

	public static void main(String[] args) {
		
		DirectedGraphNode a = new DirectedGraphNode("a");
		DirectedGraphNode b = new DirectedGraphNode("b");
		DirectedGraphNode c = new DirectedGraphNode("c");
		DirectedGraphNode d = new DirectedGraphNode("d");
		DirectedGraphNode e = new DirectedGraphNode("e");
		DirectedGraphNode f = new DirectedGraphNode("f");
		DirectedGraphNode g = new DirectedGraphNode("g");
		DirectedGraphNode h = new DirectedGraphNode("h");
		DirectedGraphNode i = new DirectedGraphNode("i");
		
		a.addNeighbor(b, 5);
		a.addNeighbor(c, 7);
		a.addNeighbor(d, 1);
		b.addNeighbor(e, 4);
		e.addNeighbor(i, 4);
		c.addNeighbor(f, 3);
		c.addNeighbor(i, 2);
		d.addNeighbor(f, 3);
		d.addNeighbor(g, 1);
		d.addNeighbor(h, 3);
		f.addNeighbor(i, 2);
		f.addNeighbor(h, 2);
		
	}
}
