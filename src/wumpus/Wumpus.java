/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import cell.Cell;
import cell.GameBoard;
import java.util.ArrayList;

/**
 *
 * @author MahiRaj Gosemath
 */
public class Wumpus {
    private static int count=0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameBoard gameBoard=GameBoard.getBoard();
        ArrayList<Cell> cellGrid=gameBoard.setWidth(8)
                                .setHeigth(8)
                                .initGameBoard()
                                .getCellGrid();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(cellGrid.get(count).getCellContent()+" ");
                count++;
            }
            System.out.println();
        }
    }
}
