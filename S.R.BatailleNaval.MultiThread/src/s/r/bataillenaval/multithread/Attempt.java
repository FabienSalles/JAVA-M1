/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package s.r.bataillenaval.multithread;

import java.io.Serializable;

/**
 *
 * @author fsalles
 */
public class Attempt implements Serializable
{
    private static final long serialVersionUID = -123434563295707824L;
    private int posX;
    private int posY;
    
    public Attempt()
    {
        
    }
    
    public Attempt(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
    
    public int getPosX()
    {
        return posX;
    }

    public int getPosY()
    {
        return posY;
    }
    
    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }
    
    @Override
    public String toString() {
        return "(" + posX + "," + posY + ")";
    }
    
    
}
