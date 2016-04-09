package Oyunumuz;

import Taret.*;
import Ates.*;
import TetrisBlok.*;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;

public class OyunPanel extends javax.swing.JPanel {

    private final int satir = 30;
    private final int sutun = 30;
    JLabel tetrisDizisi[][] = new JLabel[satir][sutun];
    TaretOzellik taretimiz = new TaretKoordinat();
    MermiOzellik mermi;
    BlokOzellik Blok ;
    public static Color RK;

    @SuppressWarnings("OverridableMethodCallInConstructor")//Derleyici Ekledi
    public  OyunPanel() {
        baslangic();
        Blok = sekilUretici();
        mermi = MermiUret();
        MermininKonumu();
        BlogunKonumu();
    }  
    //MermiUretiyor ve Kordinatlarini Taretin Kordinatlarindan aliyor
    public MermiOzellik MermiUret() {
        mermi = new Mermi();
        mermi.setParca1X(taretimiz.getParca1X());
        mermi.setParca1Y(taretimiz.getParca1Y());
        return mermi;
    }
    //Random Gelen Sekilin RAndom Kordinatını Atıyoruz Y ekseninde
    public BlokOzellik sekilUretici() {

        int i = (new Random().nextInt(19));
        /*Burada RAndom Gelen sayıya göre Bir Blok Seciliyor --> SOnra Bu Blokun
         Çıkaçağı yer Belirleniyor ...... 
         */
        switch (i) {
            case 0:
                Blok = new Kare();
                break;
            case 1:
                Blok = new Cubuk();
                break;
            case 2:
                Blok = new Cubuk2();
                break;
            case 3:
                Blok = new Z();
                break;
            case 4:
                Blok = new Z2();
                break;
            case 5:
                Blok = new Z3();
                break;
            case 6:
                Blok = new Z4();
                break;
            case 7:
                Blok = new T();
                break;
            case 8:
                Blok = new T2();
                break;
            case 9:
                Blok = new T3();
                break;
            case 10:
                Blok = new T4();
                break;
            case 11:
                Blok = new L();
                break;
            case 12:
                Blok = new L2();
                break;
            case 13:
                Blok = new L3();
                break;
            case 14:
                Blok = new L4();
                break;
            case 15:
                Blok = new TersL();
                break;
            case 16:
                Blok = new TersL2();
                break;
            case 17:
                Blok = new TersL3();
                break;
            case 18:
                Blok = new TersL4();
                break;

        }
        /*Burada Blok'un Y Ekseninde Kordinatlarını Blok'un geçici kordinatlarını
        alarak Yeni Kordinat Oluşturulur Yani Çıkaçağı Yeri Belirlenir
         */
        int RD = (new Random().nextInt(25) + 3);
        int ilkdeger = Blok.getParca1Y();
        Blok.setParca1Y(RD);
        if (ilkdeger == Blok.getParca2Y()) {
            Blok.setParca2Y(RD);
        } else {
            Blok.setParca2Y(RD - 1);
            ilkdeger = ilkdeger - 1;
            RD = RD - 1;
        }
        if (ilkdeger == Blok.getParca3Y()) {
            Blok.setParca3Y(RD);
        } else {
            Blok.setParca3Y(RD - 1);
            ilkdeger = ilkdeger - 1;
            RD = RD - 1;
        }
        if (ilkdeger == Blok.getParca4Y()) {
            Blok.setParca4Y(RD);
        } else {
            Blok.setParca4Y(RD - 1);
        }

        return Blok;

    }
    //Random bir Renk Uretiyor ve Arkaplanin Renkini Degisiyor
    public void RenkKontrol() {
        RK = new Color((int) (Math.random() * 200), (int) (Math.random() * 200), (int) (Math.random() * 200));
       
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                tetrisDizisi[i][j].setBackground(RK);
            }
        }

    }
    //OyunPanelini (Izgarayı) Olusturuyor
    public void baslangic() {
        setLayout(new GridLayout(satir, sutun, 2, 2));
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                tetrisDizisi[i][j] = new JLabel();
                tetrisDizisi[i][j].setOpaque(true);
                tetrisDizisi[i][j].setBackground(RK);
                add(tetrisDizisi[i][j]);
            }
        }
        setBounds(0, -10, 600, 650);
    }
    //TaretinKonumu
    public void TaretinKonumu() {
        tetrisDizisi[taretimiz.getParca1X()][taretimiz.getParca1Y()].setBackground(taretimiz.renk);
        tetrisDizisi[taretimiz.getParca2X()][taretimiz.getParca2Y()].setBackground(taretimiz.renk);
        tetrisDizisi[taretimiz.getParca3X()][taretimiz.getParca3Y()].setBackground(taretimiz.renk);
        tetrisDizisi[taretimiz.getParca4X()][taretimiz.getParca4Y()].setBackground(taretimiz.renk);
        tetrisDizisi[taretimiz.getParca5X()][taretimiz.getParca5Y()].setBackground(taretimiz.renk);
        tetrisDizisi[taretimiz.getParca6X()][taretimiz.getParca6Y()].setBackground(taretimiz.renk);
    }
    //Merminin Konumu
    public void MermininKonumu() {
        tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()].setBackground(mermi.renk);
    }
    //Blogun Konumu 
    public void BlogunKonumu() {
        tetrisDizisi[Blok.getParca1X()][Blok.getParca1Y()].setBackground(Blok.renk);
        tetrisDizisi[Blok.getParca2X()][Blok.getParca2Y()].setBackground(Blok.renk);
        tetrisDizisi[Blok.getParca3X()][Blok.getParca3Y()].setBackground(Blok.renk);
        tetrisDizisi[Blok.getParca4X()][Blok.getParca4Y()].setBackground(Blok.renk);
    }
    //Bir önceki Görüntüsünü Siliyor 
    public void GolgeTemizleTaret() {
        tetrisDizisi[taretimiz.getParca1X()][taretimiz.getParca1Y()].setBackground(RK);
        tetrisDizisi[taretimiz.getParca2X()][taretimiz.getParca2Y()].setBackground(RK);
        tetrisDizisi[taretimiz.getParca3X()][taretimiz.getParca3Y()].setBackground(RK);
        tetrisDizisi[taretimiz.getParca4X()][taretimiz.getParca4Y()].setBackground(RK);
        tetrisDizisi[taretimiz.getParca5X()][taretimiz.getParca5Y()].setBackground(RK);
        tetrisDizisi[taretimiz.getParca6X()][taretimiz.getParca6Y()].setBackground(RK);
    }
    //Bir önceki Görüntüsünü Siliyor 
    public void GolgeTemizleMermi() {
        tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()].setBackground(RK);
    }
    //Bir önceki Görüntüsünü Siliyor 
    public void GolgeTemizleBlok() {
        tetrisDizisi[Blok.getParca1X()][Blok.getParca1Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca2X()][Blok.getParca2Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca3X()][Blok.getParca3Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca4X()][Blok.getParca4Y()].setBackground(RK);
    }
    //Blok ile Merminin Kordinatlarıini Kontrol Ediyor Eger Esit ise true deger döndürüyor
    public boolean BlokCarptiMi() {
        if (tetrisDizisi[Blok.getParca1X()][Blok.getParca1Y()] == tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()]
                || tetrisDizisi[Blok.getParca2X()][Blok.getParca2Y()] == tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()]
                || tetrisDizisi[Blok.getParca3X()][Blok.getParca3Y()] == tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()]
                || tetrisDizisi[Blok.getParca4X()][Blok.getParca4Y()] == tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()]) {
            if(OyunTest.k.isRunning()==true){OyunTest.k.stop();}
            return true;
        } else {
            return false;
        }
    }
    /*Burada Blokla merminin kordinatları birbitine eşit olduğu durumda
    Blok ve mermi renki beyaz Oluyo böylece ekrandan çıkıyo :) */
    public void BlokYoket() {
        tetrisDizisi[Blok.getParca1X()][Blok.getParca1Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca2X()][Blok.getParca2Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca3X()][Blok.getParca3Y()].setBackground(RK);
        tetrisDizisi[Blok.getParca4X()][Blok.getParca4Y()].setBackground(RK);
        tetrisDizisi[mermi.getParca1X()][mermi.getParca1Y()].setBackground(RK);
        
    } 
    //Taretin panelden cikip cikmadigini kontrol ediyor
    public boolean duvarKontrolSag() {
        if (taretimiz.getParca1Y() == sutun - 1 || taretimiz.getParca2Y() == sutun - 1
                || taretimiz.getParca3Y() == sutun - 1 || taretimiz.getParca4Y() == sutun - 1) {
            return false;
        } else {
            return true;
        }
    }
    //Taretin panelden cikip cikmadigini kontrol ediyor
    public boolean duvarKontrolSol() {
        if (taretimiz.getParca1Y() == 0 || taretimiz.getParca2Y() == 0
                || taretimiz.getParca3Y() == 0 || taretimiz.getParca4Y() == 0) {
            return false;
        } else {
            return true;
        }
    }
    //Merminin Panelden cikip cikmadigini kontrol ediyor
    public boolean MhareketKontrol() {
        if (mermi.getParca1X() == 0) { 
           GolgeTemizleMermi();
            return false;
        } else {
            return true;
        }
    }
    //Blogun Zemine Ulasıp Ulasmadigini Kontrol Ediyor
    public boolean BHareketKontrol() {
        if (Blok.getParca1X() == satir - 1 || Blok.getParca2X() == satir - 1 || Blok.getParca3X() == satir - 1 || Blok.getParca4X() == satir - 1) {

            return true;
        } else {
            return false;
        }
    }
}
