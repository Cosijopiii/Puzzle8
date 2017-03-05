package com.unistmo.ia.searchs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by COSI on 03/03/2017 For life.
 */
public class DFS {

    private ArrayList<Integer> goalList;
    private List<Puzzle> puzzlesQueue =new ArrayList<>();
    private Queue< List<Integer>> puzzlesVisit=new LinkedList<>();
    private static int[] GOAL ={1,2,3,4,5,6,7,8,9};
    private int index=0;
    public DFS(Puzzle puzzle){
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
            index--;
            puzzlesVisit.add(node.getStates());
            if (node.getStates().equals(goalList)){

//                puzzlesQueue.add(node);
//                puzzlesQueue.forEach(e->{
//                    System.out.println();
//                    e.getStates().forEach(System.out::print);
//                });
                break;
            }else {
                Puzzle nodeleft= Puzzle.moveBlankLeft(new Puzzle(node.getStates()));
                if (!nodeleft.getStates().equals(node.getStates())||!puzzlesVisit.contains(nodeleft.getStates())){
                    nodeleft.setParent(node);
                    index++;
                    puzzlesQueue.add(nodeleft);
                }
                Puzzle noderight= Puzzle.moveBlankRight(new Puzzle(node.getStates()));
                if (!noderight.getStates().equals(node.getStates())||!puzzlesVisit.contains(noderight.getStates())){
                    noderight.setParent(node);
                    index++;

                    puzzlesQueue.add(noderight);
                }
                Puzzle nodedown= Puzzle.moveBlankDown(new Puzzle(node.getStates()));
                if (!nodedown.getStates().equals(node.getStates())||!puzzlesVisit.contains(nodedown.getStates())){
                    nodedown.setParent(node);
                    index++;

                    puzzlesQueue.add(nodedown);
                }
                Puzzle nodeup= Puzzle.moveBlankUp(new Puzzle(node.getStates()));
                if (!nodeup.getStates().equals(node.getStates())||!puzzlesVisit.contains(nodeup.getStates())){
                    nodeup.setParent(node);
                    index++;

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
