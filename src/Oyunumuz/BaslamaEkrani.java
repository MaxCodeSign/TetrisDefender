package Oyunumuz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaslamaEkrani extends JFrame {
        ImageIcon baslatma, cikis, arkaplan;
        JPanel buttonPanel;
        JButton basla, cik;
        JLabel resimLabel; 
    @SuppressWarnings("Convert2Lambda")
    public BaslamaEkrani() {
        

        setSize(700, 660);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);//Pencerenin başlığını kaldırma
        setResizable(false);
        setMinimumSize(null);
        arkaplan = new ImageIcon(getClass().getResource("plan.jpg"));
        resimLabel = new JLabel(arkaplan);
        resimLabel.setBounds(0, -1, 700, 660);
        baslatma = new ImageIcon(getClass().getResource("basla.png"));
        cikis = new ImageIcon(getClass().getResource("exit.png"));

        basla = new JButton();
        basla.setContentAreaFilled(false);//Buton arkaplanını iptal etme
        basla.setBorderPainted(false);
        basla.setBounds(0, 130, 320, 70);
        basla.setIcon(baslatma);
        basla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();//Frame'i kapatıyor (gizliyor)
                OyunTest oyunaGec = new OyunTest();
                oyunaGec.setVisible(true);

            }

        });

        cik = new JButton();
        cik.setOpaque(false);
        cik.setContentAreaFilled(false);//Buton arkaplanını iptal etme
        cik.setBorderPainted(false);
        cik.setBounds(5, 210, 310, 80);
        cik.setIcon(cikis);
        cik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        buttonPanel = new JPanel();
        buttonPanel.setBounds(200, 200, 350, 400);
        buttonPanel.setLayout(null);
        buttonPanel.setOpaque(false);
        buttonPanel.add(basla);
        buttonPanel.add(cik);

        add(buttonPanel);
        add(resimLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
