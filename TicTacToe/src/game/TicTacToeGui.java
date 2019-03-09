package game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TicTacToeGui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 800, 800));
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setResizable(false);
		
		TicTacToeGame game = new TicTacToeGame();
		Button[][] tileArray = new Button[3][3];
		for (int i = 0; i < tileArray.length; i++) {
			for (int j = 0; j < tileArray.length; j++) {
				Button temp = new Button();
				temp.setLayoutX(i*100);
				temp.setLayoutY(j*100);
				tileArray[i][j] = temp;
			}
		}
		
		
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	System.out.println("Hello World!");
            }
        });
        
        
        
        root.getChildren().add(btn);
        primaryStage.show();
	}

}
