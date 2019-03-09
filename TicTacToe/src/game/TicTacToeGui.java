package game;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeGui extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		primaryStage.setScene(new Scene(root, 1000, 1000));
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setResizable(false);
		ObservableList<Node> rootList = root.getChildren();

		TicTacToeGame game = new TicTacToeGame();
		Button[][] tileArray = new Button[3][3];
		for (int i = 0; i < tileArray.length; i++) {
			HBox rowHold = new HBox(10);
			for (int j = 0; j < tileArray.length; j++) {
				Button temp = new Button();

				temp.setMinSize(300, 300);

				temp.setOnAction(new EventHandler<ActionEvent>() {
					private int row, col;

					public EventHandler<ActionEvent> init(int x, int y) {
						row = x;
						col = y;
						return this;
					}

					@Override
					public void handle(ActionEvent event) {
						Image symbol;
						game.claimTile(row, col);
						if (game.getTile(row, col) == Symbol.CROSS) {
							symbol = new Image(getClass().getResourceAsStream("../x.jpg"));
						} else {
							symbol = new Image(getClass().getResourceAsStream("../o.jpg"));
						}
						Button tile = (Button) event.getSource();
						ImageView I = new ImageView(symbol);
						I.setFitHeight(280);
						I.setFitWidth(280);
						tile.setGraphic(I);
					}
				}.init(i, j));

				rowHold.getChildren().add(temp);
				tileArray[i][j] = temp;
			}
			rootList.add(rowHold);
		}

		primaryStage.show();
	}

}
