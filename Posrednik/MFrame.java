package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MFrame extends JFrame {
    static int ilosck, iloscs, ilosckpom, iloscspom;
    private JTable mainTable;

    MFrame() throws IOException, InterruptedException {
        JButton btnSet = new JButton("set");

        final JTextField buyQ = new JTextField("ilosc_dostawcow");
        final JTextField sellQ = new JTextField("ilosc_odbiorcow");

        btnSet.setBounds(140, 50, 100, 25);
        buyQ.setBounds(20, 50, 100, 25);
        sellQ.setBounds(20, 100, 100, 25);
        add(btnSet);
        add(buyQ);
        add(sellQ);
        add(new JScrollPane(mainTable));
        btnSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ilosck = Integer.parseInt(buyQ.getText());
                iloscs = Integer.parseInt(sellQ.getText());
                ilosckpom = ilosck;
                iloscspom = iloscs;
                JButton btnAdd = new JButton("Add");
                btnAdd.setBounds(140, 50, 100, 25);
                add(btnAdd);
                Calculate c = new Calculate(ilosck, iloscs);
                c.numberb();
                c.numbers();
                try {
                    DataFrame dataFrame = new DataFrame();
                    dataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dataFrame.setVisible(true);
                    dataFrame.setSize(new Dimension(300, 400));
                    dataFrame.setTitle("Costs");
                    dataFrame.setLocationRelativeTo(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

    }
}
