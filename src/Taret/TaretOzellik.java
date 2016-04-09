
package Taret;

import java.awt.Color;
import javax.swing.JLabel;
 
public abstract class TaretOzellik extends JLabel{
    private int parca1X;        private int parca1Y;
    private int parca2X;        private int parca2Y;
    private int parca3X;        private int parca3Y;
    private int parca4X;        private int parca4Y;
    private int parca5X;        private int parca5Y;
    private int parca6X;        private int parca6Y;

      public Color renk;
    
      public TaretOzellik(){
          renk=new Color(00,00,00);
    }   
      public void sagHareket(){
        setParca1Y(getParca1Y() + 1);
        setParca2Y(getParca2Y() + 1);
        setParca3Y(getParca3Y() + 1);
        setParca4Y(getParca4Y() + 1);
        setParca5Y(getParca5Y() + 1);
        setParca6Y(getParca6Y() + 1);
    }
    
    public void solHareket(){
        setParca1Y(getParca1Y() - 1);
        setParca2Y(getParca2Y() - 1);
        setParca3Y(getParca3Y() - 1);
        setParca4Y(getParca4Y() - 1);
        setParca5Y(getParca5Y() - 1);
        setParca6Y(getParca6Y() - 1);
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

    public int getParca5X() {
        return parca5X;
    }

    public void setParca5X(int parca5X) {
        this.parca5X = parca5X;
    }

    public int getParca6X() {
        return parca6X;
    }

    public void setParca6X(int parca6X) {
        this.parca6X = parca6X;
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

    public int getParca5Y() {
        return parca5Y;
    }

    public void setParca5Y(int parca5Y) {
        this.parca5Y = parca5Y;
    }

    public int getParca6Y() {
        return parca6Y;
    }

    public void setParca6Y(int parca6Y) {
        this.parca6Y = parca6Y;
    }

}
    

