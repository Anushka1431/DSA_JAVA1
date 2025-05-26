package Graphs;

import java.util.*;
//finding cost
public class prims_MST {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
     static class Pair implements Comparable<Pair>{
        int n;
        int wt;
        public Pair(int n,int wt){
            this.n=n;
            this.wt=wt;
        }


         @Override
         public int compareTo(Pair p2) {
             return this.wt-p2.wt;
         }
     }
     public static void primsMST(ArrayList<Edge> graph[]){
        boolean[] vis =new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int cost=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            //if vertex not visited then do so
            if(vis[curr.n]!=true){
                vis[curr.n]=true;
                cost=cost+curr.wt;
//if dest not visited from that vertex then do that
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }

            }
        }
        System.out.print(cost);
     }

    public static void main(String[] args) {
        int m=4;
        ArrayList<Edge> graph[]=new ArrayList[m];
        creategraph(graph);

        primsMST(graph);
    }
}
