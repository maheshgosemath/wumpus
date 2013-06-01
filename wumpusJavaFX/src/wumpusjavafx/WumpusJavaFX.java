/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpusjavafx;


import in.javamumbaigroup.cell.Cell;
import in.javamumbaigroup.cell.CellContent;
import in.javamumbaigroup.cell.GameBoard;
import in.javamumbaigroup.cell.Position;
import in.javamumbaigroup.player.Player;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author bansidhai
 */
public class WumpusJavaFX extends Application {
    
    private ArrayList<Cell> cells;
    private GameBoard gameBoard=GameBoard.getBoard().setWidth(8).setHeigth(8).initGameBoard();
    private Player player;
    private Position position;
    private ArrayList<CellContent> content;
    private int x=20, y=20;
    
    @Override
    public void start(Stage primaryStage) {
        
        cells=gameBoard.getCells();
        player=new Player(cells.get(0));
        position=new Position();
        
        ImageView image = ImageViewBuilder.create()
        .image(new Image(getClass().getResourceAsStream("board.png")))
            .fitWidth(320)
            .fitHeight(320)
        .build();
        final Paint paint[]={Color.GREEN, Color.ORANGE, Color.YELLOW, Color.BROWN, Color.BLACK, Color.RED, Color.GOLD};
        final Circle circle=new Circle(x, y, 10);
        circle.setFill(paint[0]);
        
        Scene scene = SceneBuilder.create()
                .width(320)
                .height(320)
                .root(
                    GroupBuilder.create()
                        .children(image, circle)
                        .build()
                 )
        .build();
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent t){
                
                if(t.getCode()==KeyCode.A){
                    position.setX(-1);position.setY(0);
                    System.out.println(position);
                    player.movePlayer(position);
                }
                if(t.getCode()==KeyCode.S){
                    position.setX(0);position.setY(1);
                    System.out.println(position);
                    player.movePlayer(position);
                }
                if(t.getCode()==KeyCode.W){
                    position.setX(0);position.setY(-1);
                    System.out.println(position);
                    player.movePlayer(position);
                }
                if(t.getCode()==KeyCode.D){
                    position.setX(1);position.setY(0);
                    System.out.println(position);
                    player.movePlayer(position);
                }
                x=position.getX()*40;
                y=position.getY()*40;
                if(circle.getCenterX()+x>0&&circle.getCenterX()+x<320){
                    if(circle.getCenterY()+y>0&&circle.getCenterY()+y<320){
                        circle.setCenterX(circle.getCenterX()+x);
                        circle.setCenterY(circle.getCenterY()+y);
                    }
                }
                content=player.getCurrentCell().getCellContent();
                if(content.contains(CellContent.BREEZE)){
                    circle.setFill(paint[3]);
                }
                if(content.contains(CellContent.STENCH)){
                    circle.setFill(paint[1]);
                }
                if(content.contains(CellContent.GLITTER)){
                    circle.setFill(paint[2]);
                }
                if(content.contains(CellContent.GOLD)){
                    circle.setFill(paint[6]);
                }
                if(content.contains(CellContent.WUMPUS)){
                    circle.setFill(paint[4]);
                }
                if(content.contains(CellContent.PIT)){
                    circle.setFill(paint[5]);
                }
                if(content.contains(CellContent.NONE)){
                    circle.setFill(paint[0]);
                }
            }
        });
                
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
