/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author MahiRaj Gosemath
 */

public class GameBoard {
    
    private static GameBoard board;
    private ArrayList<Cell> cells;
    private int width=4;
    private int heigth=4;
    Random random=new Random();
    
    public static GameBoard getBoard()
    {
        board.initGameBoard();
        return board;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
    
    public void initGameBoard()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                cells.add(new Cell(i,j));
            }
        }
        addWumpus();
        addPit();
        addGold();
        
    }
    
    public void addWumpus()
    {
        Cell cell = cells.get(random.nextInt(16));
        if(!(cell.getCellContent().contains(CellContent.PIT)||(cell.getCellContent().contains(CellContent.PIT)))){
            cell.setCellStatus(CellContent.WUMPUS);
        }
    }
    
    public void addPit()
    {
        Cell cell = cells.get(random.nextInt(16));
        cell.setCellStatus(CellContent.PIT);
    }
    
    public void addGold()
    {
        Cell cell = cells.get(random.nextInt(16));
        cell.setCellStatus(CellContent.GOLD);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cells);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameBoard other = (GameBoard) obj;
        if (!Objects.equals(this.cells, other.cells)) {
            return false;
        }
        return true;
    }
    
}
