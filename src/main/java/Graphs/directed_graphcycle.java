package Graphs;
import java.util.*;
//directed graph cycle detection
public class directed_graphcycle {
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
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,3));
        //graph[3].add(new Edge(3,1)); //removed for proving no cycle

    }
    static boolean iscycle(ArrayList<Edge> graph[]){
        boolean[] vis=new boolean[graph.length];
        boolean[] rec=new boolean[graph.length];//a stack to keep check of what vertex is visited ina  cycle and then when we find a true here that means theres a cycle
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                return(iscyclehelper(graph,i,vis,rec));
            }

        }
        return false;
    }
    static boolean iscyclehelper(ArrayList<Edge> graph[],int curr,boolean vis[],boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(rec[e.dest]){//if that vertex is in rec stack then there is a cycle
                return true;
            }
            if(!vis[e.dest] && iscyclehelper(graph,e.dest,vis,rec)){//here if the next neighbour is not visited and there is a cycle for that neighbour also existing then we return true
                return true;
            }

        }
        rec[curr]=false;//after checking for one vertex make it false
        return false;
    }

    public static void main(String[] args) {
        int m=4;
        ArrayList<Edge> graph[]=new ArrayList[m];
        creategraph(graph);
        System.out.print(iscycle(graph));
    }
}
