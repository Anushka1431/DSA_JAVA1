package Backtracking;

import java.util.Arrays;

//this is backtracking
//as you move ahead keep putting false on the path so that it doesnt return back and start from the same path
//then when u reach the destination move back and make everything true again so it can be used by other paths


public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze={{true,true,true},{true,true,true},{true,true,true}};
        allpaths("",maze,0,0);

        int[][] path= new int[maze.length][maze[0].length];

        //allpathsprint("",maze,0,0,path,1);
    }
    static void allpaths(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        //if there is an obstacle
        if(maze[r][c]==false){
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1){
            allpaths(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allpaths(p+'R',maze,r,c+1);
        }
//take up and left too
        if(r>0){
            allpaths(p+'U',maze,r-1,c);
        }
        if(c>0){
            allpaths(p+'L',maze,r,c-1);
        }
        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c]=true;

    }

    //now make a function such that we can print the path on the matrix and shw steps how to follow
    static void allpathsprint(String p, boolean[][] maze, int r, int c, int[][] path, int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c]=step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        //if there is an obstacle
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        path[r][c]=step;
        if(r<maze.length-1){
            allpathsprint(p+'D',maze,r+1,c,path,step+1);
        }
        if(c<maze[0].length-1){
            allpathsprint(p+'R',maze,r,c+1,path,step+1);
        }
//take up and left too
        if(r>0){
            allpathsprint(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allpathsprint(p+'L',maze,r,c-1,path,step+1);
        }
        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c]=true;
        path[r][c]=0;

    }

}
