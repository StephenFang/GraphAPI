package graph;

import org.junit.Test;
import static org.junit.Assert.*;

/** Unit tests for the Graph class.
 *  @author Mingtao Fang
 */
public class GraphTesting {

    // Add tests.  Here's a sample.

    @Test
    public void emptyGraph() {
        DirectedGraph g = new DirectedGraph();
        assertEquals("Initial graph has vertices", 0, g.vertexSize());
        assertEquals("Initial graph has edges", 0, g.edgeSize());
    }


    @Test
    public void testContainsVertex() {

    }

	@Test
	public void testVertexSize() {
		UndirectedGraph g = new UndirectedGraph();
		g.add();
		assertEquals(1, g.vertexSize());
		assertTrue(g.contains(1));
		g.add();
		assertEquals(2, g.vertexSize());
		assertTrue(g.contains(2));
		assertFalse(g.contains(5));
		g.add();
		assertEquals(3, g.vertexSize());
		assertTrue(g.contains(3));
		
		g.remove(3);
		assertFalse(g.contains(3));
		assertEquals(2, g.vertexSize());
		
		g.add();
		assertTrue(g.contains(3));
		assertEquals(3, g.vertexSize());

		g.remove(3);
		assertEquals(2, g.vertexSize());

		g.remove(2);
		assertEquals(1, g.vertexSize());

		g.remove(1);
		assertEquals(0, g.vertexSize());
	}


	@Test
	public void testMaxVertex() {
		UndirectedGraph g = new UndirectedGraph();
		g.add();
		assertEquals(1, g.vertexSize());
		g.add();
		assertEquals(2, g.vertexSize());
		g.add();
		assertEquals(3, g.vertexSize());

		assertEquals(3, g.maxVertex());

		g.add();
		g.add();
		g.add();
		assertEquals(6, g.vertexSize());
		assertEquals(6, g.maxVertex());

		g.remove(3);
		assertEquals(5, g.vertexSize());
		assertEquals(6, g.maxVertex());


		g.add();
		assertEquals(6, g.maxVertex());
		assertEquals(6, g.vertexSize());

		g.remove(6);
		assertEquals(5, g.maxVertex());
		assertEquals(5, g.vertexSize());

		g.remove(5);
		g.remove(4);
		g.remove(2);
		assertEquals(3, g.maxVertex());
		assertEquals(2, g.vertexSize());
	}


	@Test
	public void testAddEdge() {
		UndirectedGraph g1 = new UndirectedGraph();
		g1.add();
		assertEquals(1, g1.vertexSize());
		g1.add();
		assertEquals(2, g1.vertexSize());
		g1.add();
		assertEquals(3, g1.vertexSize());

		assertEquals(3, g1.maxVertex());

		g1.add(1, 2);
		assertEquals(1, g1.edgeSize());

		g1.add(2, 3);
		assertEquals(2, g1.edgeSize());

		g1.add(1, 3);
		assertEquals(3, g1.edgeSize());

		g1.add(1, 3);
		g1.add(2, 3);
		g1.add(1, 2);
		g1.add(1, 3);
		g1.add(2, 3);
		g1.add(1, 2);
		g1.add(1, 3);
		g1.add(2, 3);
		g1.add(1, 2);
		assertEquals(3, g1.edgeSize());


		DirectedGraph g2 = new DirectedGraph();
		g2.add();
		assertEquals(1, g2.vertexSize());
		g2.add();
		assertEquals(2, g2.vertexSize());
		g2.add();
		assertEquals(3, g2.vertexSize());

		g2.add(1, 2);
		assertEquals(1, g2.edgeSize());

		g2.add(2, 1);
		assertEquals(2, g2.edgeSize());
		g2.add(1, 3);
		g2.add(3, 1);
		assertEquals(4, g2.edgeSize());
		g2.add(2, 3);
		assertEquals(5, g2.edgeSize());
		g2.add(3, 2);
		assertEquals(6, g2.edgeSize());
	}

	@Test
	public void testContainEdge() {
		DirectedGraph g1 = new DirectedGraph();
		g1.add();
		g1.add();
		g1.add();
		g1.add(1, 2);
		assertTrue(g1.contains(1, 2));
		assertFalse(g1.contains(2, 1));
		g1.add(2, 1);
		assertTrue(g1.contains(2, 1));

		UndirectedGraph g2 = new UndirectedGraph();
		g2.add();
		g2.add();
		g2.add();
		g2.add(1, 2);
		assertTrue(g2.contains(1, 2));
		assertTrue(g2.contains(2, 1));
	}

	@Test
	public void testRemoveEdge() {
		DirectedGraph g1 = new DirectedGraph();
		g1.add();
		g1.add();
		g1.add();
		g1.add(1, 2);
		assertTrue(g1.contains(1, 2));
		assertFalse(g1.contains(2, 1));
		g1.add(2, 1);
		assertTrue(g1.contains(2, 1));

		g1.remove(1, 2);
		assertFalse(g1.contains(1, 2));
		assertTrue(g1.contains(2, 1));
		g1.remove(2, 1);
		assertFalse(g1.contains(2, 1));


		UndirectedGraph g2 = new UndirectedGraph();
		g2.add();
		g2.add();
		g2.add();
		g2.add(1, 2);
		assertTrue(g2.contains(1, 2));
		assertTrue(g2.contains(2, 1));
		g2.remove(2, 1);
		assertFalse(g2.contains(1, 2));
		assertFalse(g2.contains(2, 1));
	}


	@Test
	public void testRemoveVertex() {
		DirectedGraph g1 = new DirectedGraph();
		g1.add();
		g1.add();
		g1.add();
		g1.add(1, 2);
		g1.add(2, 1);
		g1.add(1, 3);
		g1.add(3, 1);
		g1.add(2, 3);
		g1.add(3, 2);
		assertEquals(6, g1.edgeSize());
		g1.remove(1);
		assertEquals(2, g1.edgeSize());	
		
		UndirectedGraph g2 = new UndirectedGraph();
		g2.add();
		g2.add();
		g2.add();
		g2.add(1, 2);
		g2.add(2, 3);
		g2.add(1, 3);
		assertEquals(3, g2.edgeSize());
		g2.remove(1);
		assertEquals(1, g2.edgeSize());
	}


	@Test
	public void testSuccessor() {
		DirectedGraph g1 = new DirectedGraph();
		g1.add();
		g1.add();
		g1.add();
		g1.add();
		g1.add(1, 3);
		g1.add(1, 2);
		g1.add(1, 4);
		assertEquals(3, g1.successor(1, 0));
		assertEquals(2, g1.successor(1, 1));
		assertEquals(4, g1.successor(1, 2));
		assertEquals(0, g1.successor(100, 0));
		assertEquals(0, g1.successor(1, 100));
	}


	@Test
	public void testOutDegree() {
		DirectedGraph g1 = new DirectedGraph();
		g1.add();
		g1.add();
		g1.add();
		g1.add();
		g1.add(1, 3);
		g1.add(1, 2);
		g1.add(1, 4);
		assertEquals(3, g1.outDegree(1));
		assertEquals(0, g1.outDegree(3));



		UndirectedGraph g2 = new UndirectedGraph();
		g2.add();
		g2.add();
		g2.add();
		g2.add(1, 3);
		g2.add(2, 3);
		assertEquals(2, g2.outDegree(3));
		assertEquals(1, g2.outDegree(2));
	}

	@Test
	public void testMine() {

	}

	@Test
	public void testEdgeId() {

	}


	@Test
	public void testCheckMyVertex() {

	}

	@Test
	public void testPredecessor() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add(2, 1);
		d1.add(3, 1);
		// for (int i : d1.predecessors(1)) {
		// 	System.out.println(i);
		// }
		// System.out.println(d1.predecessors(1));
		// System.out.println(d1.edges());
		// for (int[] a : d1.edges()) {
		// 	System.out.print(a[0]);
		// 	System.out.print("-");
		// 	System.out.print(a[1]);
		// 	System.out.println(" ");
		// }
	}

	@Test
	public void testRemoveVertexandPre() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add(2, 1);
		d1.add(3, 1);
		d1.add(2, 3);

		// System.out.println("for removing");

		// for (int i : d1.predecessors(1)) {
		// 	System.out.println(i);
		// }

		// for (int[] a : d1.edges()) {
		// 	System.out.print(a[0]);
		// 	System.out.print("-");
		// 	System.out.print(a[1]);
		// 	System.out.println(" ");
		// }
		
		// System.out.println("after removing");
		
		d1.remove(2, 3);
		// System.out.println("successor");
		// for (int b : d1.successors(2)) {
		// 	System.out.println(b);
		// }
		// System.out.println("successor");

		// for (int[] a : d1.edges()) {
		// 	System.out.print(a[0]);
		// 	System.out.print("-");
		// 	System.out.print(a[1]);
		// 	System.out.println(" ");
		// }


		// for (int i : d1.predecessors(1)) {
		// 	System.out.println(i);
		// }

	}


	@Test
	public void testAddUndirected() {
		UndirectedGraph u1 = new UndirectedGraph();
		u1.add();
		u1.add();
		u1.add();
		u1.add(1, 2);
		u1.add(2, 3);
		u1.add(1, 3);


		for (int[] a : u1.edges()) {
			System.out.print(a[0]);
			System.out.print("-");
			System.out.print(a[1]);
			System.out.println(" ");
		}

		System.out.println("remove 2");
		u1.remove(2);

		for (int[] a : u1.edges()) {
			System.out.print(a[0]);
			System.out.print("-");
			System.out.print(a[1]);
			System.out.println(" ");
		}		



	}


	@Test
	public void testSuccessPreDire() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add(2, 1);
		d1.add(3, 1);
		d1.add(2, 3);


		System.out.println("for vertices");
		for (int i : d1.vertices()) {
			System.out.println(i);
		}

		assertEquals(2, d1.predecessor(1, 0));
		assertEquals(3, d1.predecessor(1, 1));
		assertEquals(1, d1.successor(2, 0));
		assertEquals(3, d1.successor(2, 1));
		assertEquals(1, d1.successor(3, 0));
		assertEquals(2, d1.predecessor(3, 0));
	}


}
