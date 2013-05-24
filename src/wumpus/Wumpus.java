/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import cell.Cell;
import cell.GameBoard;

/**
 *
 * @author MahiRaj Gosemath
 */
public class Wumpus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameBoard gameBoard=GameBoard.getBoard();
        gameBoard.initGameBoard();
        Cell cellGrid[][]=gameBoard.getCellGrid();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(cellGrid[i][j].getCellContent()+" ");
            }
            System.out.println();
        }
    }
}
