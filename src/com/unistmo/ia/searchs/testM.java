package com.unistmo.ia.searchs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by COSI on 03/03/2017 For life.
 */
public class testM {

    public static void main(String argv[]){
        int[] NOGOAL1 ={1,2,3,4,5,6,7,9,8};
        int[] NOGOAL2 ={1,2,3,4,5,6,9,7,8};
        int[] NOGOAL3 ={1,2,3,4,5,9,6,7,8};
        int[] NOGOAL4 ={1,2,3,4,9,5,6,7,8};
        int[] NOGOAL5 ={1,2,3,9,4,5,6,7,8};


        DFS dfs1=new DFS(new Puzzle(geta(NOGOAL1)));
        System.out.println(dfs1.getPuzzlesQueue().size()+"**************");
        DFS dfs2=new DFS(new Puzzle(geta(NOGOAL2)));
        System.out.println(dfs2.getPuzzlesQueue().size()+"**************");
        DFS dfs3=new DFS(new Puzzle(geta(NOGOAL3)));
        System.out.println(dfs3.getPuzzlesQueue().size()+"**************");
        DFS dfs4=new DFS(new Puzzle(geta(NOGOAL4)));
        System.out.println(dfs4.getPuzzlesQueue().size()+"**************");
        DFS dfs5=new DFS(new Puzzle(geta(NOGOAL5)));
        System.out.println(dfs5.getPuzzlesQueue().size()+"**************");
        //BFS
        BFS bfs1=new BFS(new Puzzle(geta(NOGOAL1)));
        System.out.println(bfs1.getPuzzlesQueue().size()+"**************");
        BFS bfs2=new BFS(new Puzzle(geta(NOGOAL2)));
        System.out.println(bfs2.getPuzzlesQueue().size()+"**************");
        BFS bfs3=new BFS(new Puzzle(geta(NOGOAL3)));
        System.out.println(bfs3.getPuzzlesQueue().size()+"**************");
        BFS bfs4=new BFS(new Puzzle(geta(NOGOAL4)));
        System.out.println(bfs4.getPuzzlesQueue().size()+"**************");
        BFS bfs5=new BFS(new Puzzle(geta(NOGOAL5)));
        System.out.println(bfs5.getPuzzlesQueue().size()+"**************");

    }

    private static ArrayList<Integer> geta(int []NOGOAL){
        ArrayList<Integer> d=new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            d.add(NOGOAL[i]);
        }
    return  d;
    }

}
