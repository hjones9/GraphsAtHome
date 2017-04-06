/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphsathome;


import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author Hailey
 */
public class GraphsAtHome extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter your first x coordinate");
        int x1 = scan.nextInt();
        System.out.println("Please enter your first y coordinate");
        int y1 = scan.nextInt();

        System.out.println("Please enter your second x coordinate");
        int x2 = scan.nextInt();
        System.out.println("Please enter your second y coordinate");
        int y2 = scan.nextInt();

        int deltaX = x1 - x2;
        int deltaY = y1 - y2;

        int m = deltaY/deltaX;

        int b = y1 - (x1 * m);

        //I think these don't accept negatives...
        System.out.println(m);
        System.out.println(b);

        int width = 600;

        Group root = new Group();
        Canvas canvas = new Canvas(width, width);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        //makes the base lines of the graph
        gc.moveTo(0, width/2);
        gc.lineTo(width, width/2);
        gc.stroke();
        
        
        gc.moveTo(width/2, 0);
        gc.lineTo(width/2, width);
        gc.stroke();
        
        //labels base lines
        gc.strokeText("x", 0, width/2 +10);
        gc.strokeText("y", width/2 -10, 10);
        
        //adds line BUT NOT 
        x1 = x1*100;
        y1 = y1*100;
        y2 = y2*100;
        x2 = x2*100;
       
        gc.moveTo(width/2 +x1, width/2 -y1);
        gc.lineTo(width/2 + x2, width/2 -y2);
        gc.stroke();
        
        root.getChildren().add(canvas);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
