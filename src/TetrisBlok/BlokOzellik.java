
package TetrisBlok;
import java.awt.Color;
import javax.swing.JLabel;


public abstract class BlokOzellik extends JLabel{
    private int parca1X, parca2X, parca3X, parca4X, parca1Y, parca2Y, parca3Y, parca4Y;

    public Color renk;
    
    public BlokOzellik(){
        renk = new Color((int)(Math.random()*240), (int)(Math.random()*240), (int)(Math.random()*240));
    }

    public void hareket(){
        setParca1X(getParca1X() + 1);
        setParca2X(getParca2X() + 1);
        setParca3X(getParca3X() + 1);
        setParca4X(getParca4X() + 1);
    }
    
    public int getParca1X() {
        return parca1X;
    }

    public void setParca1X(int parca1X) {
        this.parca1X = parca1X;
    }

    public int getParca2X() {
        return parca2X;
    }

    public void setParca2X(int parca2X) {
        this.parca2X = parca2X;
    }

    public int getParca3X() {
        return parca3X;
    }

    public void setParca3X(int parca3X) {
        this.parca3X = parca3X;
    }

    public int getParca4X() {
        return parca4X;
    }

    public void setParca4X(int parca4X) {
        this.parca4X = parca4X;
    }

    public int getParca1Y() {
        return parca1Y;
    }

    public void setParca1Y(int parca1Y) {
        this.parca1Y = parca1Y;
    }

    public int getParca2Y() {
        return parca2Y;
    }

    public void setParca2Y(int parca2Y) {
        this.parca2Y = parca2Y;
    }

    public int getParca3Y() {
        return parca3Y;
    }

    public void setParca3Y(int parca3Y) {
        this.parca3Y = parca3Y;
    }

    public int getParca4Y() {
        return parca4Y;
    }

    public void setParca4Y(int parca4Y) {
        this.parca4Y = parca4Y;
    }
}
