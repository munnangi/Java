import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graphs {
    public static Integer V;
    public static LinkedList<Integer> adj[]; // adjacency list


    Graphs(int v)
    {
       V = v;
       adj = new LinkedList[V];
       for (int i=0; i < v; ++i) {
           adj[i] = new LinkedList();
       }
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    // Breadth first search graph
    // Add a value to the queue and iterate its adjacent vertices.
    // if not visited add it to the queue, dequeue and repeat

    public void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;

        while (queue.size() != 0) {
            int val = queue.poll();
            System.out.print(val + " ");

            Iterator<Integer> i = adj[val].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    // use recursion and go depth first search for the graph
    public void DFSVisited(int s, boolean[] visited)
    {

        visited[s] = true;
        System.out.println(s);

        // iterate for all vertices adjacent to this vertex
        Iterator<Integer> i = adj[s].listIterator();

        while (i.hasNext()) {
            int next = i.next();
            if (!visited[next]) {
                DFSVisited(next, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSVisited(v, visited);
    }


    // same as depth first search but add the values to the stack instead of printing out.
    // it only works for directed acyclic graph (DAG)
    public void topologicalSortVisited(int s, boolean[] visited, Stack st)
    {
        Iterator<Integer> i = adj[s].listIterator();
        visited[s] = true;

        while (i.hasNext()) {
            int next = i.next();
            if (!visited[next]) {
                topologicalSortVisited(next, visited, st);
            }
        }


        // add the vertex to the stack when no adjacent vertex exists
        st.push(new Integer(s));
    }

    public void topologicalSort() {
        boolean visited[] = new boolean[V];
        Stack st = new Stack();

        for(int i=0; i < V; i++) {
            // since using directed graph check all the vertices if not visited
            if (!visited[i]) {
                topologicalSortVisited(i, visited, st);
            }
        }

        while (!st.empty()) {
            System.out.print(st.pop() + " ");
        }
    }
    public static void main(String[] args)
    {
        Graphs g = new Graphs(6);
        g.addEdge(0 ,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1, 5);
        g.addEdge(3,4);
//        g.BFS(6);
//        g.DFS(6);
        g.topologicalSort();
    }
}
