package graph;


import java.util.ArrayList;
/* See restrictions in Graph.java. */

/** Represents a general unlabeled directed graph whose vertices are denoted by
 *  positive integers. Graphs may have self edges.
 *
 *  @author Mingtao Fang
 */
public class DirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public int inDegree(int v) {
        // FIXME
        int result = 0;
        // for (ArrayList<Integer> arr : _graph.values()){
        //     for (int i : arr) {
        //         if (i == v) {
        //             result += 1;
        //         }
        //     }
        // }
        return result;
    }

    @Override
    public int predecessor(int v, int k) {
        // FIXME
        if (!contains(v)) {
            return 0;
        }
        int count = -1;
        // for (int vertex : vertices()) {
        //     if (contains(v, vertex)) {
        //         count += 1;
        //         if (count == k) {
        //             return vertex;
        //         }
        //     }
        // }

        for (int[] currentEdge : edges()) {
            if (currentEdge[1] == v) {
                count++;
                if (count == k) {
                    return currentEdge[0];
                }
            }
        }



        return 0;
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        // FIXME
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
        }


        return Iteration.iteration(result.iterator());
    }

    // FIXME

}
