package Recursion;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
        //System.out.println(ways(3,3));
        //System.out.println(waystype("",3,3));
        boolean[][] maze={
                {true,true,true},{true,false,true},{true,true,true}
        };
        maze_with_restrictions("",maze,0,0);
    }
    //there is a maze of 3x3 and we have to find in how many way a person can go from one corner to another.
    static int ways(int m,int n){
        if(m==1||n==1){
            return 1;
        }

        int left=ways(m-1,n);
        int right=ways(m,n-1);
        return left+right;
    }
    static ArrayList<String> waystype(String p, int m, int n){
        if(m==1 && n==1){
            ArrayList<String> arr=new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> ans=new ArrayList<>();
        if(m>1){
            ans.addAll(waystype(p+'D',m-1,n));
        }
        if(n>1){
            ans.addAll(waystype(p+'R',m,n-1));
        }
//we can add a dignoally moving condition when m and n both are greater than 1

        return ans;
    }
    static void maze_with_restrictions(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        //if there is an obstacle
        if(maze[r][c]==false){
            return;
        }
        if(r<maze.length-1){
            maze_with_restrictions(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            maze_with_restrictions(p+'R',maze,r,c+1);
        }


    }
}
