package graph;


import java.util.ArrayDeque;
/* See restrictions in Graph.java. */

/** Implements a depth-first traversal of a graph.  Generally, the
 *  client will extend this class, overriding the visit and
 *  postVisit methods, as desired (by default, they do nothing).
 *  @author
 */
public class DepthFirstTraversal extends Traversal {

    /** A depth-first Traversal of G, using FRINGE as the fringe. */
    protected DepthFirstTraversal(Graph G) {
        super(G, new ArrayDeque<Integer>());
        // FIXME
    }

    @Override
    protected boolean visit(int v) {
        return super.visit(v);
    }

    @Override
    protected boolean postVisit(int v) {
        return super.postVisit(v);
    }

    // FIXME

}
