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
