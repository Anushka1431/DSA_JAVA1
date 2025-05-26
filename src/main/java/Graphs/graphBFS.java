package Graphs;
import java.util.*;
/*BFS
* 1. make a boolean array visited to store all the visited nodes
* 2. we have to travel level wise for bfs
* 3. make a queue as a linked list and add 0 in it first. then check if queue is empty and remove first node
* 4. if the visited is false then print the first node in queue then make that number in visited array true.
* 5. there is an array graphs which stores lists of all edges vertexes and destinations.
* 6. so run a loop from 0 to the size of this array element for the current number. this will give number of edges and then
* get all the destination edges of this vertex and add them all in the queue
* 7. then repeat the process
* wt is weight
* */
public class graphBFS {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

    }
    //vis is visited array
    public static void bfs(ArrayList<Edge> graph[]){
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfs_helper(graph,vis);
            }
        }
    }
    public static void bfs_helper(ArrayList<Edge> graph[],boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int size=7;
        ArrayList<Edge> graph[]=new ArrayList[size];
        creategraph(graph);
        bfs(graph);
    }

}
