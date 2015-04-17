package graph;

import java.util.ArrayList;
/* See restrictions in Graph.java. */

/** Represents an undirected graph.  Out edges and in edges are not
 *  distinguished.  Likewise for successors and predecessors.
 *
 *  @author Mingtao Fang
 */
public class UndirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public int inDegree(int v) {
        // FIXME
        return outDegree(v);
    }

    @Override
    public int predecessor(int v, int k) {
        if (!contains(v)) {
            return 0;
        }

        // for (int vertex : vertices()) {
        //     if (contains(v, vertex)) {
        //         count += 1;
        //         if (count == k) {
        //             return vertex;
        //         }
        //     }
        // }
        int count = -1;
        for (int[] currentEdge : edges()) {
            if (currentEdge[1] == v) {
                count++;
                if (count == k) {
                    return currentEdge[0];
                }
            }

            if (currentEdge[0] == v) {
                count++;
                if (count == k) {
                    return currentEdge[1];
                }
            }
        }




        return 0;
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // for (int vertex : vertices()) {
        //     if (contains(v, vertex)){
        //         result.add(vertex);
        //     }
        // }

        for (int[] currentEdge : edges()) {
            if (currentEdge[1] == v) {
                result.add(currentEdge[0]);
            }
            if (currentEdge[0] == v) {
                result.add(currentEdge[1]);
            }
        }



        return Iteration.iteration(result.iterator());
    }

    // FIXME

}
