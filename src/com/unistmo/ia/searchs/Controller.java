package com.unistmo.ia.searchs;

import com.sun.xml.internal.ws.util.StreamUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Controller {

    @FXML
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl8;
    @FXML
    private Label lbl9;
    @FXML
    private TextField txtInput;
    @FXML
    private Button btnGo;
    ScheduledExecutorService timer;
    int i=0;
    List<Puzzle> path;
    @FXML
    void initialize() {
        timer = Executors.newSingleThreadScheduledExecutor();
    }

    @FXML
    void handleGo(ActionEvent event) {

        ArrayList<Integer> input = new ArrayList<>();
        for (char anIn : txtInput.getText().toCharArray()) {
            input.add(Integer.parseInt(anIn + ""));
        }
        BFS bfs = new BFS(new Puzzle(input));

        path = bfs.getPuzzlesQueue();
        timer.scheduleWithFixedDelay(this::states, 0, 2, TimeUnit.SECONDS);
    }
    private void states(){

        if(i==path.size()-1){
         timer.shutdown();
        }
        Puzzle puzzle=path.get(i);
            List<Integer> s=puzzle.getStates();
            Platform.runLater(()->{
                lbl1.setText(s.get(0)!=9 ? s.get(0)+"":"");
                lbl2.setText(s.get(1)!=9 ? s.get(1)+"":"");
                lbl3.setText(s.get(2)!=9 ? s.get(2)+"":"");
                lbl4.setText(s.get(3)!=9 ? s.get(3)+"":"");
                lbl5.setText(s.get(4)!=9 ? s.get(4)+"":"");
                lbl6.setText(s.get(5)!=9 ? s.get(5)+"":"");
                lbl7.setText(s.get(6)!=9 ? s.get(6)+"":"");
                lbl8.setText(s.get(7)!=9 ? s.get(7)+"":"");
                lbl9.setText(s.get(8)!=9 ? s.get(8)+"":"");
            });
        i++;
    }

}
