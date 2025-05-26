package Graphs;

import java.util.*;
//in this type of traversal we always print the next neighbour
//      1   3
//    /     |  \
//  0       |    5 ---6
//    \     |  /
//      2   4
//so bfs is 0 1 2 3 4 5 6
//and dfs is 0 1 3 4 2 5 6
public class graphDFS {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.weight=w;
        }

    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }
            graph[0].add(new Edge(0, 1, 1));
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

        //O(V+E)
    public static void dfs(ArrayList<Edge> graph[]){
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfshelper(graph,i,visited);
            }
        }
    }
    public static void dfshelper(ArrayList<Edge> graph[],int curr,boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                dfshelper(graph,e.dest,vis);
            }
        }
    }
    //O(V^V)
    public static void printallpath(ArrayList<Edge> graph[], boolean[] vis, int curr,String path, int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr]=true;
                printallpath(graph,vis,e.dest,path+e.dest,tar);
                vis[curr]=false;
            }
        }
    }
    public static void main(String args[]) {

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        creategraph(graph);
        //dfs(graph);


        int src=0,tar=5;
        printallpath(graph,new boolean[V],src,"0",tar);
    }

}
