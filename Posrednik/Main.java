package com.company;


import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException, InterruptedException {

        MFrame m = new MFrame();
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
        m.setSize(new Dimension(400, 200));
        m.setTitle("Posrednik");
        m.setLocationRelativeTo(null);

    }

}

