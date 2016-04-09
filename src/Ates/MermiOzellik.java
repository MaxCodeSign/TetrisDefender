
package Ates;

import java.awt.Color;
import javax.swing.JLabel;

public abstract class MermiOzellik extends JLabel{
    
    public Color renk;
    public MermiOzellik(){
        renk =Color.BLACK;
    }
    
    private int Parca1X;
    private int Parca1Y;
   
    public void hareketM(){
        setParca1X(getParca1X()-1);
     
     }        
        
    public int getParca1X() {
        return Parca1X;
    }

    public void setParca1X(int Parca1X) {
        this.Parca1X = Parca1X;
    }

    public int getParca1Y() {
        return Parca1Y;
    }

    public void setParca1Y(int Parca1Y) {
        this.Parca1Y = Parca1Y;
    }
  
}
