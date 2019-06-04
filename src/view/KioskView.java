package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class KioskView {

    private static Executor executor;
    
    public KioskView(){
        JFrame frame = new JFrame("Kiosk Prototype");

        frame.setUndecorated(true);
        //frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);
        frame.validate();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

        executor = Executors.newSingleThreadExecutor();

        JButton close = new JButton("Exit");
        close.setBounds(0, 0, 75, 25);
        frame.add(close);

        close.addMouseListener(
        new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                executor.execute(() -> System.exit(0));
            }
        });
    }
}