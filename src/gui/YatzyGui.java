package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Die;
import models.RaffleCup;


public class YatzyGui extends Application {
    private final Label[] lblDice = new Label[5];
    private final CheckBox[] chbHold = new CheckBox[5];
    private final Label lblAntalKastTilbage = new Label("Kast tilbage: 3");
    private final Button btnKastTerning = new Button("Kast terningerne");
    private int kastTilbage = 3;


    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Yatzy");
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

        String diceStyle = """
                -fx-border-color: gray;
                -fx-border-radius: 8;
                -fx-background-color: white;
                -fx-background-radius: 8;
                -fx-font-size: 22;
                -fx-alignment: center;
                -fx-padding: 15 25;
                -fx-min-width: 50;
                """;


        for (int i = 0; i < 5; i++) {
            lblDice[i] = new Label("");
            lblDice[i].setStyle(diceStyle);
            pane.add(lblDice[i], i + 1, 0);
        }
        for (int i = 0; i < 5; i++) {
            chbHold[i] = new CheckBox("Hold");
            pane.add(chbHold[i], i + 1, 1);
        }

        pane.add(lblAntalKastTilbage, 1, 3);
        pane.add(btnKastTerning, 4, 3, 2, 1);
        btnKastTerning.setOnAction(event -> throwDiceAction());


    }

    private void throwDiceAction() {

        if (kastTilbage <= 0) return;
        RaffleCup raffleCup = new RaffleCup();
        Die[] dice = raffleCup.getDice();

        for (int i = 0; i < dice.length; i++) {
            if (!chbHold[i].isSelected()) {
                dice[i].roll();
                lblDice[i].setText(String.valueOf(dice[i].getEyes()));
            }
        }
        kastTilbage--;
        lblAntalKastTilbage.setText(String.valueOf("Kast tilbage " + kastTilbage));

    }

    VBox test = new VBox(20);
}


