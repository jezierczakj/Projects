package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DataFrame extends JFrame {
    private JTable dataTable;

    DataFrame() throws IOException {
        Calculate calculate = new Calculate(MFrame.ilosck, MFrame.iloscs);
        JButton btnAdd = new JButton("Add");
        final JTextField text = new JTextField("Ilosc sprzedazy: " + MFrame.iloscs + " Ilosc kupna: " + MFrame.ilosck);
        final JTextField buyQ = new JTextField("Podaz");
        final JTextField buyC = new JTextField("Koszt_Kupna");
        final JTextField sellQ = new JTextField("Popyt");
        final JTextField sellC = new JTextField("Koszt_sprzedazy");

        btnAdd.setBounds(45, 250, 200, 25);
        text.setBounds(45, 20, 200, 25);
        buyQ.setBounds(45, 60, 200, 25);
        buyC.setBounds(45, 110, 200, 25);
        sellQ.setBounds(45, 160, 200, 25);
        sellC.setBounds(45, 210, 200, 25);
        add(btnAdd);
        add(text);
        add(buyC);
        add(buyQ);
        add(sellC);
        add(sellQ);
        add(new JScrollPane(dataTable));
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MFrame.iloscs > 0){
                    calculate.costs(Double.parseDouble(sellC.getText()), Integer.parseInt(sellQ.getText()));
                    MFrame.iloscs--;
                }
                if(MFrame.ilosck > 0){
                calculate.costb(Double.parseDouble(buyC.getText()), Integer.parseInt(buyQ.getText()));
                MFrame.ilosck--;
                }
                text.setText("Ilosc sprzedazy: " + MFrame.iloscs + " Ilosc kupna: " + MFrame.ilosck);
                if(MFrame.iloscs <= 0 && MFrame.ilosck <= 0) {
                    try {
                        DeliveryFrame deliveryFrame = new DeliveryFrame();
                        deliveryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        deliveryFrame.setVisible(true);
                        deliveryFrame.setSize(new Dimension(400, 200));
                        deliveryFrame.setTitle("Delivery");
                        deliveryFrame.setLocationRelativeTo(null);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}