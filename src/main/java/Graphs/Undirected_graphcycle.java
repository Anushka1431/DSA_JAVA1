package Graphs;

import java.util.ArrayList;

public class Undirected_graphcycle {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,0));

        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,1));

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,2));

        graph[3].add(new Edge(3,0));
        graph[0].add(new Edge(0,3));
        //graph[3].add(new Edge(3,1)); //removed for proving no cycle

    }
    public static boolean iscycle(ArrayList<Edge> graph[]){
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                return iscyclehelper(graph,vis,i,-1);
            }
        }
        return false;
    }
    public static boolean iscyclehelper(ArrayList<Edge> graph[],boolean[] vis,int curr, int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            //case 1 : if the neighbour node is visited and is not the parent i. e we are going towards it then there is cycle
            if (vis[e.dest] && e.dest != par) {
                return true;
            }
            //ignore the second case of when the node is visited and is parent
            //3rd case is a non visted node and then we can put the cycle test on that also
            else if (!vis[e.dest]){
                return iscyclehelper(graph,vis,e.dest,curr);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int m=4;
        ArrayList<Edge> graph[]=new ArrayList[m];
        creategraph(graph);
        System.out.print(iscycle(graph));
    }
}
