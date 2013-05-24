/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MahiRaj Gosemath
 */

public class GameBoard {
    
    private static GameBoard board=new GameBoard();
    private ArrayList<Cell> cells;
    private ArrayList<Cell> neighbours;
    private Cell cellGrid[][];
    private int width=4;
    private int heigth=4;
    Random random=new Random();
    
    public static GameBoard getBoard() {
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
    
    public void initGameBoard() {
        cells=new ArrayList<>();
        cellGrid=new Cell[width][heigth];
        for(int i=0;i<width;i++) {
            for(int j=0;j<heigth;j++) {
                cellGrid[i][j]=new Cell(i,j);
                cellGrid[i][j].setCellStatus(CellContent.NONE);
                cells.add(cellGrid[i][j]);
            }
        }
        addWumpus();
        addPit();
        addGold();
        
    }
    
    public void addWumpus() {
        Cell cell = cells.get(random.nextInt(16));
        if(!(cell.getCellContent().contains(CellContent.PIT)&&(cell.getCellContent().contains(CellContent.GLITTER)))){
            if(cell.getCellContent().contains(CellContent.NONE)){
                    cell.getCellContent().remove(CellContent.NONE);
            }
            cell.setCellStatus(CellContent.WUMPUS);
            addStenchToNeighbours(cell);
        }else{
        }
    }
    
    public void addPit() {
        Cell cell = cells.get(random.nextInt(16));
        if(!(cell.getCellContent().contains(CellContent.WUMPUS)&&(cell.getCellContent().contains(CellContent.GLITTER)))){
            if(cell.getCellContent().contains(CellContent.NONE)){
                    cell.getCellContent().remove(CellContent.NONE);
            }
            cell.setCellStatus(CellContent.PIT);
            addBreezeToNeighbours(cell);
        }else{
        }
    }
    
    public void addGold() {
        Cell cell = cells.get(random.nextInt(16));
        if(!(cell.getCellContent().contains(CellContent.PIT)&&(cell.getCellContent().contains(CellContent.WUMPUS)))){
            if(cell.getCellContent().contains(CellContent.NONE)){
                 cell.getCellContent().remove(CellContent.NONE);
            }
            cell.setCellStatus(CellContent.GOLD);
            addGlitterToNeighbours(cell);
        }else{
        }
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    private void addStenchToNeighbours(Cell cell) {
        neighbours=cell.getNeighbours();
        for(Cell neighbourCell : neighbours){
            if(neighbourCell!=null){
                if(neighbourCell.getCellContent().contains(CellContent.NONE)){
                    neighbourCell.getCellContent().remove(CellContent.NONE);
                }
                if(!neighbourCell.getCellContent().contains(CellContent.STENCH)){
                    neighbourCell.getCellContent().add(CellContent.STENCH);
                }
            }
        }
    }
    
    private void addBreezeToNeighbours(Cell cell) {
        neighbours=cell.getNeighbours();
        for(Cell neighbourCell : neighbours){
            if(neighbourCell!=null){
                if(neighbourCell.getCellContent().contains(CellContent.NONE)){
                    neighbourCell.getCellContent().remove(CellContent.NONE);
                }
                if(!neighbourCell.getCellContent().contains(CellContent.BREEZE)){
                    neighbourCell.getCellContent().add(CellContent.BREEZE);
                }
            }
        }
    }
    
    private void addGlitterToNeighbours(Cell cell) {
        neighbours=cell.getNeighbours();
        for(Cell neighbourCell : neighbours){
            if(neighbourCell!=null){
                if(neighbourCell.getCellContent().contains(CellContent.NONE)){
                    neighbourCell.getCellContent().remove(CellContent.NONE);
                }
                if(!neighbourCell.getCellContent().contains(CellContent.GLITTER)){
                    neighbourCell.getCellContent().add(CellContent.GLITTER);
                }
            }
        }
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }
    
}
