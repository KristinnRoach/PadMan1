package padman.vidmot;

import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import padman.vinnsla.SampleHolder;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class PadController implements Initializable {
    @FXML
    private GridPane fxGrid;
    @FXML
    private Button fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9;
    private Button[] pads;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pads = new Button[] { fxPad1, fxPad2, fxPad3, fxPad4, fxPad5, fxPad6, fxPad7, fxPad8, fxPad9 };
    }
    @FXML
    private void keyPressedSample(KeyEvent e) {
        if (e.getCode() == KeyCode.Z) {
            SampleHolder.playMedia(0);
        }
        if (e.getCode() == KeyCode.X) {
            SampleHolder.playMedia(1);
        }
        if (e.getCode() == KeyCode.C) {
            SampleHolder.playMedia(2);
        }
        if (e.getCode() == KeyCode.A) {
            SampleHolder.playMedia(3);
        }
        if (e.getCode() == KeyCode.S) {
            SampleHolder.playMedia(4);
        }
        if (e.getCode() == KeyCode.D) {
            SampleHolder.playMedia(5);
        }
        if (e.getCode() == KeyCode.Q) {
            SampleHolder.playMedia(6);
        }
        if (e.getCode() == KeyCode.W) {
            SampleHolder.playMedia(7);
        }
        if (e.getCode() == KeyCode.E) {
            SampleHolder.playMedia(8);
        }
    }

    @FXML
    private void mousePressedSample(MouseEvent e) {
        if (e.getSource().equals(fxPad1)) {
            SampleHolder.playMedia(0);
        }
        if (e.getSource().equals(fxPad2)) {
            SampleHolder.playMedia(1);
        }
        if (e.getSource().equals(fxPad3)) {
            SampleHolder.playMedia(2);
        }
        if (e.getSource().equals(fxPad4)) {
            SampleHolder.playMedia(3);
        }
        if (e.getSource().equals(fxPad5)) {
            SampleHolder.playMedia(4);
        }
        if (e.getSource().equals(fxPad6)) {
            SampleHolder.playMedia(5);
        }
        if (e.getSource().equals(fxPad7)) {
            SampleHolder.playMedia(6);
        }
        if (e.getSource().equals(fxPad8)) {
            SampleHolder.playMedia(7);
        }
        if (e.getSource().equals(fxPad9)) {
            SampleHolder.playMedia(8);
        }
    }

    @FXML
    private void onDragOver(DragEvent e) {
        if (e.getDragboard().hasFiles()) {
            e.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void onDragDropped(DragEvent e) throws FileNotFoundException {
        Button targetButton = (Button) e.getGestureTarget();
        int key = Arrays.asList(pads).indexOf(targetButton);
        SampleHolder.handleDragDropped(e, key);
    }
}