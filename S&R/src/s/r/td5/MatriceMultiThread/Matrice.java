/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.td5.MatriceMultiThread;

/**
 *
 * @author fasalles
 */
public class Matrice extends Thread{
    private int column;
    private int row;
    
    public Matrice(int col, int row)
    {
        this.column = col;
        this.row = row;
    }
}
