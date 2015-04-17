package graph;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
/** Unit tests for the Graph class.
 *  @author Mingtao Fang
 */




public class TraversalTesting {

	public class FindPathDepth1 extends DepthFirstTraversal {

		public FindPathDepth1(Graph G) {
			super(G);
			_path = new ArrayList<Integer>();
		}

		protected boolean visit(int v) {
			_path.add(v);
			return super.visit(v);
		}

		public ArrayList<Integer> getBiggest(int start) {
			traverse(start);

			return _path;
		}




		private ArrayList<Integer> _path;

	}


	public class FindPathDepth2 extends DepthFirstTraversal {
		public FindPathDepth2(Graph G) {
			super(G);
			_path = new ArrayList<Integer>();
		}

		protected boolean postVisit(int v) {
			_path.add(v);
			return super.postVisit(v);
		}


		protected boolean shouldPostVisit(int v) {
			return true;
		}

		public ArrayList<Integer> getPostBiggest(int start) {
			traverse(start);

			return _path;
		}

		private ArrayList<Integer> _path;
	}

	public class FindPathBreadth extends BreadthFirstTraversal {

		public FindPathBreadth(Graph G) {
			super(G);
			_path = new ArrayList<Integer>();
		}

		protected boolean visit(int v) {
			_path.add(v);
			return super.visit(v);
		}




		public ArrayList<Integer> getBiggest(int start) {
			traverse(start);

			return _path;
		}



		private ArrayList<Integer> _path;

	}



	@Test
	public void testBreadthFirstTraversal() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add();
		d1.add();

		d1.add(5, 4);
		d1.add(5, 3);
		d1.add(4, 1);
		d1.add(3, 2);
		d1.add(1, 5);

		FindPathBreadth fp1 = new FindPathBreadth(d1);
		
		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(5);
		answer1.add(4);
		answer1.add(3);
		answer1.add(1);
		answer1.add(2);

		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		answer2.add(5);
		answer2.add(3);
		answer2.add(4);
		answer2.add(2);
		answer2.add(1);

		ArrayList<Integer> answer3 = new ArrayList<Integer>();
		answer3.add(5);
		answer3.add(4);
		answer3.add(3);
		answer3.add(2);
		answer3.add(1);

		ArrayList<Integer> answer4 = new ArrayList<Integer>();
		answer4.add(5);
		answer4.add(3);
		answer4.add(4);
		answer4.add(2);
		answer4.add(1);

		ArrayList<Integer> test = fp1.getBiggest(5);
		assertTrue(test.equals(answer4) || test.equals(answer3) || test.equals(answer2) || test.equals(answer1));


	}

	@Test
	public void testDFS() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add();
		d1.add();

		d1.add(5, 4);
		d1.add(5, 3);
		d1.add(4, 1);
		d1.add(3, 2);
		d1.add(1, 5);

		FindPathDepth1 fd1 = new FindPathDepth1(d1);

		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(5);
		answer1.add(4);
		answer1.add(1);
		answer1.add(3);
		answer1.add(2);

		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		answer2.add(5);
		answer2.add(3);
		answer2.add(2);
		answer2.add(4);
		answer2.add(1);

		ArrayList<Integer> test = fd1.getBiggest(5);
		assertTrue(test.equals(answer2) || test.equals(answer1));
	}

	@Test
	public void testPostDFS() {
		DirectedGraph d1 = new DirectedGraph();
		d1.add();
		d1.add();
		d1.add();
		d1.add();
		d1.add();

		d1.add(5, 4);
		d1.add(5, 3);
		d1.add(4, 1);
		d1.add(3, 2);
		d1.add(1, 5);

		FindPathDepth2 postfd1 = new FindPathDepth2(d1);

		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		answer1.add(1);
		answer1.add(4);
		answer1.add(2);
		answer1.add(3);
		answer1.add(5);

		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		answer2.add(2);
		answer2.add(3);
		answer2.add(1);
		answer2.add(4);
		answer2.add(5);

		ArrayList<Integer> test = postfd1.getPostBiggest(5);
		assertTrue(test.equals(answer2) || test.equals(answer1));
	}







}