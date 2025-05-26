package Graphs;

import java.util.ArrayList;
//shortest path algo that can detect negative cycles
//make a dist array
//put all the further vertices to inf
//iterate graph vertices n-1 amount of times to find all ways as max would be v-1 to reach shortest path
//use realxation every step
//if we do it v times then if there is change in distance that MEANS there is a negative cycle in the graph i.e a cycle whos sum is negative
public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.weight=wt;
        }

    }
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }
   public static void bellmanford(ArrayList<Edge> graph[], int src){
        int[] dist=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int j=0;j<graph.length-1;j++){
            for(int k=0;k<graph[j].size();k++){
                Edge e=graph[j].get(k);
                int u=e.src;
                int v=e.dest;
                int wt=e.weight;
                //relaxation with a condition that ensures no negative weigth cycles
                if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+wt){
                    dist[v]=dist[u]+wt;
                }
            }
        }
       for(int j=0; j<graph.length; j++) {
           for(int k=0; k<graph[j].size(); k++) {
               Edge e = graph[j].get(k);
               int u = e.src;
               int v = e.dest;
               int wt = e.weight;
               if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                   System.out.println("negative weight cycle exists");
                   break;
               }
           }
       }
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();


   }

    public static void main(String[] args) {
        int m=5;
        ArrayList<Edge> graph[]=new ArrayList[m];
        creategraph(graph);
        int src=0;
        bellmanford(graph,0);
    }
}
