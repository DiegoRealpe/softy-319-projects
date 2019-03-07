package gui;

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
        primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setResizable(false);
		
		
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
