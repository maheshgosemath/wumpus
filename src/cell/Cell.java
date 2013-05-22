/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cell;

import java.util.ArrayList;

/**
 *
 * @author MahiRaj Gosemath
 */
public class Cell {
    
    private ArrayList<CellContent> content;
    private Position points;
//    private HashSet<Cell> neighbours;
    
    public Cell(int x, int y)
    {
        points=new Position();
        points.setX(x);
        points.setY(y);
//        setNeighboursPositions();
    }
    
    public void setCellStatus(CellContent cellContent)
    {
        content.add(cellContent);
    }
    
    public ArrayList getCellContent()
    {
        return content;
    }
    
//    private void setNeighboursPositions()
//    {
//        setTopNeighbourPosition(1,0);
//        setBottomNeighbourPosition(-1,0);
//        setLeftNeighbourPosition(-1,0);
//        setRightNeighbourPosition(1,0);
//    }
//    
//    public void setTopNeighbourPosition(int offsetX, int offsetY){
//        if(this.points.getX()+offsetX<4){
//            neighbours.add(new Cell(this.points.getX()+offsetX, offsetY));
//        }
//    }
//    
//    public void setBottomNeighbourPosition(int offsetX, int offsetY){
//        if(this.points.getX()+offsetX>=0){
//            neighbours.add(new Cell(this.points.getX()+offsetX, offsetY));
//        }
//    }
//    
//    public void setLeftNeighbourPosition(int offsetX, int offsetY){
//        if(this.points.getY()+offsetY<4){
//            neighbours.add(new Cell(this.points.getX(), this.points.getY()+offsetY));
//        }
//    }
//    
//    public void setRightNeighbourPosition(int offsetX, int offsetY){
//        if(this.points.getY()+offsetY>=0){
//            neighbours.add(new Cell(offsetX, this.points.getX()+offsetY));
//        }
//    }
//    
}
