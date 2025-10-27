package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;


public class YatzyGui extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private final CheckBox chboxhold1 = new CheckBox("Hold");
    private final CheckBox chboxhold2 = new CheckBox("Hold");
    private final CheckBox chboxhold3 = new CheckBox("Hold");
    private final CheckBox chboxhold4 = new CheckBox("Hold");
    private final CheckBox chboxhold5 = new CheckBox("Hold");
    private final Label lblKast = new Label("Kast tilbage: ");


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);


        Label lblThrowsLeft = new Label("Antal kast tilbage: ");
        pane.add(lblThrowsLeft, 0, 0);

        pane.add(chboxhold1, 0, 1);
        pane.add(chboxhold2, 1, 1);
        pane.add(chboxhold3, 2, 1);
        pane.add(chboxhold4, 3, 1);
        pane.add(chboxhold5, 4, 1);
        pane.add(lblThrowsLeft, 5,2);


        Button btnDiceThrow = new Button("Kast terningerne ");
        pane.add(btnDiceThrow, 6, 0);

    }

}

