/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.javamumbaigroup.cell;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bansidhai
 */
public class CellTest {
    
    public CellTest() {
    }
    
    /**
     * Test of getCellAtPosition method, of class Cell.
     */
    @Test
    public void testGetCellAtPosition() {
        System.out.println("getCellAtPosition");
        GameBoard gameBoard=GameBoard.getBoard();
        int x = 0;
        int y = 1;
        ArrayList<Cell> cellGrid=gameBoard.setHeigth(8).setWidth(8).initGameBoard().getCells();
        Cell instance=cellGrid.get(0);
        Cell expResult = cellGrid.get(1);
        Cell result = instance.getCellAtPosition(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}