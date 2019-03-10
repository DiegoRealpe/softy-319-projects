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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeGui extends Application {

	private TicTacToeGame game = new TicTacToeGame();
	private final Image Ex = new Image(getClass().getResourceAsStream("../x.jpg"));
	private final Image Oh = new Image(getClass().getResourceAsStream("../o.jpg"));

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		VBox root = new VBox(10);
		root.setPadding(new Insets(20));
		primaryStage.setScene(new Scene(root, 950, 1000));
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setResizable(false);
		ObservableList<Node> rootList = root.getChildren();

		// Put a top bar with stuff on it
		HBox topBar = new HBox(10);
		topBar.setPadding(new Insets(15, 12, 15, 12));
		topBar.setSpacing(10);
		topBar.setStyle("-fx-background-color: #336699;");

		//Set Turn and scoreboard
		/**Text turnLabel = new Text();
		turnLabel.setText(game.getTurn());
		
		Text scoreO = new Text();
		turnLabel.setText(game.getTurn(Symbol.CIRCLE));
		
		Text scoreX = new Text();
		turnLabel.setText(game.getScore(Symbol.CROSS));*/
		
		// Set reset button
		Button buttonRes = new Button("Play Again!");
		buttonRes.setPrefSize(100, 20);
		buttonRes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				game.reset();
			}
		});
		topBar.getChildren().add(buttonRes);
		rootList.add(topBar);

		// set tiles and behavior
		initTiles(rootList);

		primaryStage.show();
	}

	public void initTiles(ObservableList<Node> rootList) {
		// Making tile buttons
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
						Image symbol = null;
						game.claimTile(row, col);
						if (game.getTile(row, col) == Symbol.CROSS) {
							symbol = Ex;
						} else if (game.getTile(row, col) == Symbol.CIRCLE) {
							symbol = Oh;
						}
						Button tile = (Button) event.getSource();
						if (symbol != null) {
							ImageView I = new ImageView(symbol);
							I.setFitHeight(280);
							I.setFitWidth(280);
							tile.setGraphic(I);
						}
					}
				}.init(i, j));

				rowHold.getChildren().add(temp);
				tileArray[i][j] = temp;
			}
			rootList.add(rowHold);
		}
	}

}
