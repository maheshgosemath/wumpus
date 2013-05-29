/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.javamumbaigroup.cell;

/**
 *
 * @author bansidhai
 */
import java.util.ArrayList;

/**
 *
 * @author MahiRaj Gosemath
 */
public class Cell {
    
    private ArrayList<CellContent> content;
    private ArrayList<Cell> neighbours;
    private Position points;
    
    public Cell(int x, int y)
    {
        points=new Position();
        points.setX(x);
        points.setY(y);
        content=new ArrayList();
        neighbours=new ArrayList();
    }
    
    public void setCellStatus(CellContent cellContent)
    {
        content.add(cellContent);
    }
    
    public ArrayList getCellContent()
    {
        return content;
    }
    
    public ArrayList getNeighbours(){
        neighbours.add(getNeighbour(0, 1));
        neighbours.add(getNeighbour(0, -1));
        neighbours.add(getNeighbour(1, 0));
        neighbours.add(getNeighbour(-1, 0));
        return neighbours;
    }
    
    public Cell getNeighbour(int offsetX, int offsetY){
        Cell cell=getCellAtPosition(this.points.getX()+offsetX, this.points.getY()+offsetY);
        return cell;
    }
    
    public Cell getCellAtPosition(int x, int y){
        GameBoard gameBoard=GameBoard.getBoard();
        for(Cell cell : gameBoard.getCellGrid()){
            if(cell.points.getX()==x){
                if(cell.points.getY()==y){
                    return cell;
                }
            }
        }
        return null;
    }
    
}
