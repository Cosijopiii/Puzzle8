package com.unistmo.ia.searchs;

import java.util.*;

/**
 * Created by COSI on 03/03/2017 For life.
 */
public class BFS {


    private ArrayList<Integer> goalList;
    private List<Puzzle> puzzlesQueue =new ArrayList<>();
    private Queue< List<Integer>> puzzlesVisit=new LinkedList<>();
    private static int[] GOAL ={9,1,2,3,4,5,6,7,8};
    private int index=0;
    public BFS(Puzzle puzzle){
        //root
        puzzlesQueue.add(puzzle);
        goalList=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            goalList.add(GOAL[i]);
        }
        search();
    }

    private void search(){
        while (true){
            final Puzzle node= puzzlesQueue.get(index);
            index++;
            puzzlesVisit.add(node.getStates());
                if (node.getStates().equals(goalList)){

//                    puzzlesQueue.add(node);
//                    puzzlesQueue.forEach(e->{
//                        System.out.println();
//                        e.getStates().forEach(System.out::print);
//                    });
                    break;
                }else {
                    Puzzle nodeleft= Puzzle.moveBlankLeft(new Puzzle(node.getStates()));
                    if (!puzzlesVisit.contains(nodeleft.getStates())){
                            nodeleft.setParent(node);
                            puzzlesQueue.add(nodeleft);
                    }
                    Puzzle noderight= Puzzle.moveBlankRight(new Puzzle(node.getStates()));
                    if (!puzzlesVisit.contains(noderight.getStates())){
                        noderight.setParent(node);
                        puzzlesQueue.add(noderight);
                    }
                    Puzzle nodedown= Puzzle.moveBlankDown(new Puzzle(node.getStates()));
                    if (!puzzlesVisit.contains(nodedown.getStates())){
                        nodedown.setParent(node);
                        puzzlesQueue.add(nodedown);
                    }
                    Puzzle nodeup= Puzzle.moveBlankUp(new Puzzle(node.getStates()));
                    if (!puzzlesVisit.contains(nodeup.getStates())){
                        nodeup.setParent(node);
                        puzzlesQueue.add(nodeup);
                    }
                }
        }

    }

    public List<Puzzle> getPuzzlesQueue() {
        return puzzlesQueue;
    }

    public void setPuzzlesQueue(List<Puzzle> puzzlesQueue) {
        this.puzzlesQueue = puzzlesQueue;
    }
}
