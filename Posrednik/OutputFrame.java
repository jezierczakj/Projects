package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class OutputFrame extends JFrame {
    OutputFrame(List<List<Double>>  koszty_transportu) {
        DefaultTableModel outputTable = new DefaultTableModel();
        JTable outputTbl = new JTable(outputTable);
        outputTable.addColumn("");
        for (int i = 0; i < MFrame.iloscspom; i ++ ) {
            outputTable.addColumn("Dostawca" + i);
        }
        switch(MFrame.iloscspom) {
            case 1:
                for (int i = 0; i < MFrame.ilosckpom; i++) {
                    outputTable.insertRow(outputTbl.getRowCount(), new Object[]{"Odbiorca " + i, DeliveryFrame.costList.get(i)});
                }
                break;
            case 2:
                for (int i = 0; i < MFrame.ilosckpom; i++) {
                    outputTable.insertRow(outputTbl.getRowCount(), new Object[]{"Odbiorca " + i, DeliveryFrame.costList.get(2 * i), DeliveryFrame.costList.get(2 * i + 1)});
                }
                break;
            case 3:
                for (int i = 0; i < MFrame.ilosckpom; i++) {
                    outputTable.insertRow(outputTbl.getRowCount(), new Object[]{"Odbiorca " + i, DeliveryFrame.costList.get(3 * i), DeliveryFrame.costList.get(3 * i + 1), DeliveryFrame.costList.get(3 * i + 2)});
                }
                break;
            case 4:
                for (int i = 0; i < MFrame.ilosckpom; i++) {
                    outputTable.insertRow(outputTbl.getRowCount(), new Object[]{"Odbiorca " + i, DeliveryFrame.costList.get(4 * i), DeliveryFrame.costList.get(4 * i + 1), DeliveryFrame.costList.get(4 * i + 2), DeliveryFrame.costList.get(4 * i + 3)});
                }
                break;
            case 5:
                for (int i = 0; i < MFrame.ilosckpom; i++) {
                    outputTable.insertRow(outputTbl.getRowCount(), new Object[]{"Odbiorca " + i, DeliveryFrame.costList.get(5 * i), DeliveryFrame.costList.get(5 * i + 1), DeliveryFrame.costList.get(5 * i + 2), DeliveryFrame.costList.get(5 * i + 3), DeliveryFrame.costList.get(5 * i + 4)});
                }
                break;
        }
        JFrame o = new JFrame();
        o.setSize(400, 200);
        o.add(new JScrollPane(outputTbl));
        o.setVisible(true);
    }
}
