package graph;

/* See restrictions in Graph.java. */

/** A partial implementation of ShortestPaths that contains the weights of
 *  the vertices and the predecessor edges.   The client needs to
 *  supply only the two-argument getWeight method.
 *  @author
 */
public abstract class SimpleShortestPaths extends ShortestPaths {

    /** The shortest paths in G from SOURCE. */
    public SimpleShortestPaths(Graph G, int source) {
        this(G, source, 0);
    }

    /** A shortest path in G from SOURCE to DEST. */
    public SimpleShortestPaths(Graph G, int source, int dest) {
        super(G, source, dest);
    }

    @Override
    public double getWeight(int v) {
        // FIXME
        return _weight[v];
    }

    @Override
    protected void setWeight(int v, double w) {
        // FIXME
        _weight[v] = w;
    }

    @Override
    public int getPredecessor(int v) {
        // FIXME
        if (_parent[v] == -1) {
            return 0;
        }

        return _parent[v];
    }

    @Override
    protected void setPredecessor(int v, int u) {
        // FIXME
        _parent[v] = u;
    }

    // FIXME

}
