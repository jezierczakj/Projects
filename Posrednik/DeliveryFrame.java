package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.Calculate.koszty_transportu;

public class DeliveryFrame extends JFrame {
    private JTable dTbl;
    static List <Double> costList = new ArrayList();
    DeliveryFrame() throws IOException{
        JButton btnAdd = new JButton("Add");
        final JTextField delivery = new JTextField("Koszt_Dostawy");
        final JTextField left = new JTextField("Podaj koszt dla 0 komorki");

        btnAdd.setBounds(140, 100, 100, 25);
        delivery.setBounds(20, 100, 100, 25);
        left.setBounds(20, 50, 300, 25);
        add(btnAdd);
        add(delivery);
        add(left);
        add(new JScrollPane(dTbl));

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(costList.size() < MFrame.ilosckpom * MFrame.iloscspom) {
                    costList.add(Double.parseDouble(delivery.getText()));
                    left.setText("Podaj koszt dla " + costList.size() + " komorki");
                    List<String> lsit = new ArrayList();
                    lsit.add(delivery.getText());
                    System.out.println(costList);
                }
                else {
                    Calculate calculate = new Calculate(MFrame.ilosck, MFrame.iloscs);
                    calculate.deliveryCost();

                    OutputFrame outputFrame = new OutputFrame(koszty_transportu);
                    outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    outputFrame.setVisible(true);
                    outputFrame.setSize(new Dimension(400, 200));
                    outputFrame.setTitle("Output");
                    outputFrame.setLocationRelativeTo(null);
                    calculate.Calcul();
                }
            }
        });


    }
}
