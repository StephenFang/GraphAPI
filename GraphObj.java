package graph;

import java.util.HashMap;
import java.util.ArrayList;


// import static proj3.make.Main.error;

/* See restrictions in Graph.java. */

/** A partial implementation of Graph containing elements common to
 *  directed and undirected graphs.
 *
 *  @author Mingtao Fang
 */
abstract class GraphObj extends Graph {

    /** A new, empty Graph. */
    GraphObj() {
        // FIXME
        _graph = new HashMap<Integer, ArrayList<Integer>>();
        _value = new ArrayList<Integer>();
        _removeList = new ArrayList<Integer>();
        _addingVertex = 1;
        _edgeHistory = new ArrayList<int[]>();
        _edgeSize = 0;
    }

    @Override
    public int vertexSize() {
        // FIXME
        return _graph.size();
    }

    @Override
    public int maxVertex() {
        // FIXME
        int result = 0;
        for (int i : _graph.keySet()) {
            if (i >= result) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int edgeSize() {
        // FIXME
        return _edgeSize;
    }

    @Override
    public abstract boolean isDirected();

    @Override
    public int outDegree(int v) {
        // FIXME
        if (!contains(v)) {
            return 0;
        }
        int result = _graph.get(v).size();
        return result;
    }

    @Override
    public abstract int inDegree(int v);

    @Override
    public boolean contains(int u) {
        // FIXME
        if (_graph.keySet().contains(u)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(int u, int v) {
        // FIXME
        if (contains(u) && contains(v)) {
            if (_graph.get(u).contains(v)) {
                return true;
            } else {
                return false;
            }            
        } else {
            return false;
        }

    }

    @Override
    public int add() {
        // FIXME
        if (_removeList.isEmpty()) {
            _graph.put(_addingVertex, new ArrayList<Integer>());
            _addingVertex += 1;
            return _addingVertex - 1;
        } else {
            int toAdd = findSmallest(_removeList);
            _graph.put(toAdd, new ArrayList<Integer>());
            _removeList.remove((Object) toAdd);
            return toAdd;
        }
    }

    @Override
    public int add(int u, int v) {
        // FIXME
        if (contains(u, v)) {
            return u; //do nothing
        }



        if (isDirected()) { //the graph here is directed;
            ArrayList<Integer> toAddList = _graph.get(u);
            toAddList.add(v);
            _graph.put(u, toAddList);
            
            int[] newEdge = new int[2];
            newEdge[0] = u; newEdge[1] = v;
            _edgeHistory.add(newEdge);


            _edgeSize += 1;
        } else { //the graph is not directed;
            ArrayList<Integer> toAddList1 = _graph.get(u);
            toAddList1.add(v);
            _graph.put(u, toAddList1);

            int[] newEdge1 = new int[2];
            newEdge1[0] = u; newEdge1[1] = v;
            _edgeHistory.add(newEdge1);




            
            ArrayList<Integer> toAddList2 = _graph.get(v);
            toAddList2.add(u);
            _graph.put(v, toAddList2);

            // int[] newEdge2 = new int[2];
            // newEdge2[0] = v; newEdge2[1] = u;
            // _edgeHistory.add(newEdge2);
            
            _edgeSize += 1;
        }

        return u;
    }

    @Override
    public void remove(int v) {
        // FIXME
        if (contains(v)) {
            _edgeSize -= _graph.get(v).size();
            _graph.remove((Object) v);
            _removeList.add(v);
            
            for (int vertex : _graph.keySet()) {
                if (_graph.get(vertex).contains(v)) {
                    // ArrayList<Integer> toAddList = new ArrayList<Integer>();
                    // toAddList = _graph.get(vertex);
                    // toAddList.remove((Object) v);
                    // _graph.put(vertex, toAddList);
                    _graph.get(vertex).remove((Object) v);
                    if (isDirected()) {
                        _edgeSize -= 1;
                    }
                }
            }

            ArrayList<int[]> _edgesToRemove = new ArrayList<int[]>();

            for (int[] edges : _edgeHistory) {
                if (edges[0] == v || edges[1] == v) {
                    _edgesToRemove.add(edges);
                }
            }

            for (int[] edgesToBeOut : _edgesToRemove) {
                _edgeHistory.remove(edgesToBeOut);
            }
        }
    }

    @Override
    public void remove(int u, int v) {
        // FIXME
        if (contains(u, v)) {
            if (isDirected()) { //the graph is directed;
                ArrayList<Integer> toAddList = _graph.get(u);
                toAddList.remove((Object) v);
                _graph.put(u, toAddList);
                _edgeSize -= 1;



                int[] edgeToRemove = new int[2];
                edgeToRemove[0] = u; edgeToRemove[1] = v;



                int temp = -1000;
                for (int i = 0; i < _edgeHistory.size(); i++) {
                    if (_edgeHistory.get(i)[0] == u) {
                        if (_edgeHistory.get(i)[1] == v) {
                            temp = i;
                        }
                    }
                }




                if (temp != -1000) {
                    _edgeHistory.remove(temp);
                }


                



                // int edgeRemoveIndex = -1;
                // for (int i = 0; i < _edgeHistory.size(); i++) {
                //     System.out.println("remove succssed");
                //     if (_edgeHistory.get(i).equals(edgeToRemove)) {
                //         edgeRemoveIndex = i;
                //     }
                // }

                // System.out.println(edgeRemoveIndex);

                // if (edgeRemoveIndex != -1) {
                //     System.out.println("remove succssed");
                //     _edgeHistory.remove(edgeRemoveIndex);
                // }
                



            } else { //the graph is not directed;
                ArrayList<Integer> toAddList1 = _graph.get(u);
                toAddList1.remove((Object) v);
                _graph.put(u, toAddList1);

                ArrayList<Integer> toAddList2 = _graph.get(v);
                toAddList2.remove((Object) u);
                _graph.put(v, toAddList2);

                int temp1 = -1000;
                for (int i = 0; i < _edgeHistory.size(); i++) {
                    if (_edgeHistory.get(i)[0] == u) {
                        if (_edgeHistory.get(i)[1] == v) {
                            temp1 = i;
                        }
                    }
                }

                if (temp1 != -1000) {
                    _edgeHistory.remove(temp1);
                }

                int temp2 = -1000;
                for (int i = 0; i < _edgeHistory.size(); i++) {
                    if (_edgeHistory.get(i)[0] == v) {
                        if (_edgeHistory.get(i)[1] == u) {
                            temp2 = i;
                        }
                    }
                }

                if (temp2 != -1000) {
                    _edgeHistory.remove(temp2);
                }






                // int[] edgeToRemove1 = new int[2];
                // edgeToRemove1[0] = u; edgeToRemove1[1] = v;
                // // _edgeHistory.remove(edgeToRemove1);

                // int edgeRemoveIndex1 = -1;
                // for (int i = 0; i < _edgeHistory.size(); i++) {
                //     if (_edgeHistory.get(i).equals(edgeToRemove1)) {
                //         edgeRemoveIndex1 = i;
                //     }
                // }


                // if (edgeRemoveIndex1 != -1) {
                //     _edgeHistory.remove(edgeRemoveIndex1);
                // }



                // int[] edgeToRemove2 = new int[2];
                // edgeToRemove2[0] = v; edgeToRemove2[1] = u;
                // // _edgeHistory.remove(edgeToRemove2);

                // int edgeRemoveIndex2  = -1;
                // for (int j = 0; j < _edgeHistory.size(); j++) {
                //     if (_edgeHistory.get(j).equals(edgeToRemove2)) {
                //         edgeRemoveIndex2 = j;
                //     }
                // }


                // if (edgeRemoveIndex2 != -1) {
                //     _edgeHistory.remove(edgeRemoveIndex2);
                // }



                _edgeSize -= 1;
            }
        } else {
            return;
        }
    }

    @Override
    public Iteration<Integer> vertices() {
        // FIXME
        return Iteration.iteration(_graph.keySet().iterator());
    }

    @Override
    public int successor(int v, int k) {
        // FIXME
        if (!contains(v)) {
            return 0;
        } else if (_graph.get(v).size() <= k) {
            return 0;
        }
        int result = _graph.get(v).get(k);
        return result;
    }

    @Override
    public abstract int predecessor(int v, int k);

    @Override
    public Iteration<Integer> successors(int v) {
        // FIXME
        ArrayList<Integer> successorList = _graph.get(v);

        return Iteration.iteration(successorList.iterator());
    }

    @Override
    public abstract Iteration<Integer> predecessors(int v);

    @Override
    public Iteration<int[]> edges() {
        // FIXME
        return Iteration.iteration(_edgeHistory.iterator());
    }

    @Override
    protected boolean mine(int v) {
        if (_graph.keySet().contains(v)) {
            return true;
        }
        return false;
    }

    @Override
    protected void checkMyVertex(int v) {
        // FIXME
        if (!mine(v)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected int edgeId(int u, int v) {
        // FIXME
        // int[] arr = new int[2];
        // arr[0] = u; arr[1] = v;
        // int idNumber = _edgeHistory.indexOf(arr);
        // if (idNumber == -1) {
        //     return 0;
        // }

        /** not sure if i should return the same index for edge[1,2] and edge[2,1] in undirected map because they are the same edge*/


        int count = 1;

        if (isDirected()) {
            for (int[] edges : _edgeHistory) {
                if (edges[0] == u && edges[1] == v) {
                    return count;
                }
                count++;
            }            

            System.out.println("!!!" + count);

        }


        System.out.println("return 0");



        return 0;
    }


    private int findSmallest(ArrayList<Integer> arr) {
        int result = arr.get(0);
        for (int i : arr) {
            if (i <= result) {
                result = i;
            }
        }
        return result;
    }

    // FIXME
    private ArrayList<int[]> _edgeHistory;

    private int _addingVertex;

    private HashMap<Integer, ArrayList<Integer>> _graph;

    private ArrayList<Integer> _value;

    private ArrayList<Integer> _removeList;

    private int _edgeSize;
}
