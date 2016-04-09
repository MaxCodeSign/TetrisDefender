package Oyunumuz;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OyunTest extends JFrame {   
    int yenioyunKontrol;
    boolean AtesEtKontrol =false;
    static int gerisayim = 30;
    int skor = 0,level = 1,Can = 3,sam = 5,Oyunhizi=200;//sam(Skor artma miktari)  
    Timer oyunSure = new Timer();
    OyunPanel tetrisPanel;
    JPanel DurumPanel;
    JLabel gerisayimLbl, score, can, Level, arkaplan;
    static javax.swing.Timer k;
 
    //Oyun ve Durum Panelleri Olusturuluyor -->basla() metodu cagiriliyor
    public OyunTest() {
        setTitle("Tetris Defender");
        tetrisPanel = new OyunPanel();
        this.add(tetrisPanel);
        DurumPanel();
        this.setSize(800, 660);
        this.setResizable(false);
        this.setMinimumSize(null);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.requestFocus();
        setLayout(null);
        Basla();
        //Klavyeye Basilip Basilmadigini Algiliyor
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        
    }
    //DurumPanele Sure,Can,Skor,Level 'i Ekliyor
    private void DurumPanel(){
        gerisayimLbl = new JLabel("<html><font color=white>Süre : </font></html>");
        gerisayimLbl.setFont(new Font("helvetica", Font.PLAIN, 20));
        gerisayimLbl.setBounds(10, 50, 150, 20);
        
        score = new JLabel("<html><font color=white>Skor : 0</font></html>");
        score.setBounds(10, 90, 150, 20);
        score.setFont(new Font("helvetica", Font.PLAIN, 20));
        
        can = new JLabel("<html><font color=white>Can : 3</font></html>");
        can.setBounds(10, 130, 150, 20);
        can.setFont(new Font("helvetica", Font.PLAIN, 20));
        
        Level = new JLabel("<html><font color=white>Level : 1</font></html>");
        Level.setBounds(10, 10, 150, 20);
        Level.setFont(new Font("helvetica", Font.PLAIN, 20));
        
        DurumPanel = new JPanel();
        DurumPanel.setBounds(600, 0, 200, 660);
        DurumPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
        
        arkaplan = new JLabel();
        arkaplan.setIcon(new ImageIcon(getClass().getResource("arkaplan.jpg")));
        arkaplan.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0, 0, 0)));
        arkaplan.setBounds(0, 0, 200, 660);
        
        DurumPanel.setLayout(null);
        
        DurumPanel.add(gerisayimLbl);
        DurumPanel.add(score);
        DurumPanel.add(can);
        DurumPanel.add(Level);
        DurumPanel.add(arkaplan);
        add(DurumPanel);
        
    }
    //GeriSayim Yapiyor eger gerisayim=0 Olursa LevelKontrol Metodunu Cagiriyor
    public void Zaman() {
        TimerTask gorev = new TimerTask() {
            @Override
            public void run() {
                gerisayim--;
                gerisayimLbl.setText("<html><font color=white>Süre : " + String.valueOf(gerisayim) + "</font></html>");
                if (gerisayim == 0) {
                    LevelKontrol();
                }
            }
        };
        oyunSure.schedule(gorev, 0, 1000);

    }
    //Oyunhizini ,sam(Skor Artma Miktari)Degistiriyor,Level 'i +1 artiriyor
    //Arkaplani Degistiriyor gerisayimi 30 'dan tekrar baslatiyor
    public void LevelKontrol() {
        this.Oyunhizi = Oyunhizi - 25;
        t.setDelay(Oyunhizi);
        sam = sam + 5;
        tetrisPanel.RenkKontrol();
        level++;
        Level.setText("<html><font color=white>Level :" + String.valueOf(level) + "</font></html>");
        OyunTest.gerisayim = 30;
    }
    //Taretin Konumunu Kontrol Ediyor
    public void KontrolTaret() {
        tetrisPanel.TaretinKonumu();

    }
    //Merminin Konumunu Kontrol Ediyor
    public void KontrolMermi() {
        tetrisPanel.MermininKonumu();
        if (tetrisPanel.MhareketKontrol()) {
            tetrisPanel.MermininKonumu();
            //tetrisPanel.GolgeTemizleMermi(); //Olsada Olur Olmasada
        }
    }
    //Blogun Konumunu Kontrol Ediyor Eger Blok Zemine Carparsa Can 1 Azaliyor
    //Her  zemine Ulastiginda KontrolOyunBittimi() Metodunu cagiriyor sonra Can'i 1 Azaltiyor
    //OyunBitmemisse sekiluretici Metoduyla Yeni Blok Olusturuluyor
    public void KontrolBlok() {
        tetrisPanel.BlogunKonumu();
        if (tetrisPanel.BHareketKontrol()) {
            tetrisPanel.BlogunKonumu();
            tetrisPanel.BlokYoket();          
            KontrolOyunBittimi();
            tetrisPanel.Blok = tetrisPanel.sekilUretici();
            Can--;
            can.setText("<html><font color=white>Can : " + String.valueOf(Can)+"</font></html>");

        }

    }
    //Can = 0 olursa yenioyun 'u Cagiriyor 
    public void KontrolOyunBittimi() {
        if (this.Can == 0) {
            yeniOyun();
        }
    }
    //Bloklat truee donerse BlokYoket metodu cagiriliyor ve skor artiyor
    public void PatlamaKontrol() {
        if (tetrisPanel.BlokCarptiMi() == true) {
            
            tetrisPanel.BlokYoket();
            skor = skor + sam;
            score.setText("<html><font color=white>Skor : " + String.valueOf(skor)+"</font></html>");
            tetrisPanel.Blok = tetrisPanel.sekilUretici();
           
        }

    }
    //AtesEt -->
    public void AtesEt(){
      k= new javax.swing.Timer(10, (ActionEvent e) -> {
          {  
              if(tetrisPanel.MhareketKontrol()==true){    
              tetrisPanel.GolgeTemizleMermi();
              tetrisPanel.mermi.hareketM();
              KontrolMermi();
              tetrisPanel.MermininKonumu();
              PatlamaKontrol();
          }
           
          }
      });
      }
    //Blok hareketini ve golgesinitemizliyor,Blok ve Taretin konumunu Kontrol Ediyor 
    javax.swing.Timer t;
    private void Basla() {
        Zaman();
        t = new javax.swing.Timer(Oyunhizi, (ActionEvent e) -> {
            tetrisPanel.GolgeTemizleBlok();
            tetrisPanel.Blok.hareket();
            KontrolBlok();
            KontrolTaret();//En başta taretin koordinatlarını boyamak için yazdık
        });
        t.start();
    }
    //Klavye tuslari ile taretin Sag sol Hareketi Ve Ates Etme
    public void formKeyPressed(java.awt.event.KeyEvent evt) {
        
        switch(evt.getKeyCode()){
            //Sola hareket ediyor ve Golgesini Temizliyor 
            case  KeyEvent.VK_A:
                if( tetrisPanel.duvarKontrolSol()){
                 tetrisPanel.GolgeTemizleTaret();
                 tetrisPanel.taretimiz.solHareket();
                 KontrolTaret();  
                }
                break;
            //Sola hareket ediyor ve Golgesini Temizliyor     
            case  KeyEvent.VK_LEFT:
                if( tetrisPanel.duvarKontrolSol()){
                 tetrisPanel.GolgeTemizleTaret();
                 tetrisPanel.taretimiz.solHareket();
                 KontrolTaret();  
                }
                break;
            //Saga hareket ediyor ve Golgesini Temizliyor 
            case  KeyEvent.VK_D:
                 if( tetrisPanel.duvarKontrolSag()){
                 tetrisPanel.GolgeTemizleTaret();
                 tetrisPanel.taretimiz.sagHareket();
                 KontrolTaret();  }
                break;
            //Saga hareket ediyor ve Golgesini Temizliyor        
            case  KeyEvent.VK_RIGHT:
                if( tetrisPanel.duvarKontrolSag()){
                 tetrisPanel.GolgeTemizleTaret();
                 tetrisPanel.taretimiz.sagHareket();
                 KontrolTaret(); }
                break;
            //Ates ediyor  ve bir onceki golgesini siliyor    
            case KeyEvent.VK_SPACE:
                     if(AtesEtKontrol==false){
                        tetrisPanel.GolgeTemizleMermi();  
                        tetrisPanel.mermi = tetrisPanel.MermiUret(); 
                         AtesEt();
                         k.start();
                         AtesEtKontrol=true;
                     }else{
                         k.stop();
                        tetrisPanel.GolgeTemizleMermi(); 
                        tetrisPanel.mermi = tetrisPanel.MermiUret();
                         AtesEt();
                         k.restart();
                         k.start();
                     }
                    break;
 
            
        }
                
    }
    //Can,Skor,Sure,Oyunhizi,Level ilk degerlerini aliyor
    public void DurumlariGuncelle(){
        can.setText("<html><font color=white>Can : 3</font></html>");
        score.setText("<html><font color=white>Skor : 0</font></html>");
        gerisayimLbl.setText("<html><font color=white>Süre : 30</font></html>");
        Can = 4;
        skor = 0;
        Oyunhizi = 200;
        t.setDelay(Oyunhizi);
        level = 1;
        Level.setText("<html><font color=white>Level : 1</font></html>"+ String.valueOf(level));
        sam = 5;
        gerisayim = 30;
    }
    //Ekrana Oyun bitti mesaji veriyor --> Bir Daha Oyna Yes-No
    public void EkranaMesajVer(){
          yenioyunKontrol = JOptionPane.showConfirmDialog(rootPane, "Daha İyi Bir Skor İçin Bir Daha Oyna", "Oyun Bitti!", JOptionPane.YES_NO_OPTION);
       
        switch (yenioyunKontrol) {
            case JOptionPane.YES_OPTION:;
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
            default:
                System.exit(0);
        }
    }
    //YeniOyun
    public void yeniOyun() {
        t.stop(); 
        EkranaMesajVer();
        DurumlariGuncelle();
        if (yenioyunKontrol == 0) {
            tetrisPanel.RenkKontrol();
            tetrisPanel.Blok = tetrisPanel.sekilUretici();
            t.start();
        }
    }
    //Baslangic Ekranini Cagiriyor
    @SuppressWarnings("Convert2Lambda")//Derleyici Ekledi
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BaslamaEkrani().setVisible(true);
            }
        });
    }

}
