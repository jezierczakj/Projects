package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculate extends JFrame{
    Scanner in = new Scanner(System.in);
    static List<List<Double>> koszty_transportu = new ArrayList<List<Double>>();
    static List<Double> koszty_zakupu = new ArrayList<>();
    static List<Double> koszty_sprzedazy = new ArrayList<>();
    static List<Integer> Popyt = new ArrayList<>();
    static List<Integer> Podaz = new ArrayList<>();
    static int pop = 0;
    static int pod = 0;
    static Tablica transport;
    Integer ilosc_kosztow_zakupu, ilosc_kosztow_sprzedazy;

    Calculate(int ilosc_kosztow_zakupu, int ilosc_kosztow_sprzedazy){
        this.ilosc_kosztow_zakupu = ilosc_kosztow_zakupu;
        this.ilosc_kosztow_sprzedazy = ilosc_kosztow_sprzedazy;
    }
    public int numberb() {
        ilosc_kosztow_zakupu = MFrame.ilosck;
        return ilosc_kosztow_zakupu;
    }
    public int numbers(){
        ilosc_kosztow_sprzedazy = MFrame.iloscs;
        System.out.println("Ilosc kosztow: " + MFrame.ilosck + "\nIlosc sprzedazy: " + MFrame.iloscs);
        return ilosc_kosztow_sprzedazy;
    }
    public void costs(double bc, int bq) {
        koszty_sprzedazy.add(bc);
        Popyt.add(bq);
        System.out.println(Popyt);
    }
    public void costb(double sc, int sq){
        koszty_zakupu.add(sc);
        Podaz.add(sq);
        System.out.println(Podaz);

        /////////////
    }
    public void deliveryCost() {

        int pomi = 0;
        for (int i = 0; i < Podaz.size(); i++)
            pod += Podaz.get(i);


        for (int i = 0; i < Popyt.size(); i++)
            pop += Popyt.get(i);

        if(pop != pod)
        {
            Podaz.add(pop);
            Popyt.add(pod);
        }

        double pom_tab [][] = new double[2][3];
        pom_tab[0][0] = 8;
        pom_tab[0][1] = 14;
        pom_tab[0][2] = 17;
        pom_tab[1][0] = 12;
        pom_tab[1][1] = 9;
        pom_tab[1][2] = 19;
        for (int i = 0; i < koszty_zakupu.size(); i++) {
            List<Double> pom = new ArrayList<Double>();
            for (int j = 0; j < koszty_sprzedazy.size(); j++) {
                //System.out.println("Podaj koszty transportu do odbiorcy nr. " + j + " od dostawcy nr. " + i + "\n");
                double k = DeliveryFrame.costList.get(pomi);
                //double k = pom_tab[i][j];
                pom.add(k);
                pomi++;
            }
            koszty_transportu.add(pom);
            System.out.println(koszty_transportu);
        }
    }
    public void UnitCost(){
        transport = new Tablica(Popyt.size(), Podaz.size());                //zyski jednostkowe
        for (int i = 0; i < koszty_zakupu.size(); i++) {
            for (int j = 0; j < koszty_sprzedazy.size(); j++) {
                transport.add(new Komórka(koszty_sprzedazy.get(j) - koszty_zakupu.get(i) - koszty_transportu.get(i).get(j)), j, i);
            }
        }
        if (pod != pop)
        {
            for (int i = 0; i < Podaz.size(); i++)
                transport.add(new Komórka(0), koszty_sprzedazy.size(), i);
            for (int i = 0; i < Popyt.size(); i++)
                transport.add(new Komórka(0), i, koszty_zakupu.size());
        }

    }
    public void Calcul()
    {
        DefaultTableModel outputTable = new DefaultTableModel();
        JTable outputTbl = new JTable(outputTable);
        outputTable.addColumn("Odbiorca");
        outputTable.addColumn("Nadawca");
        outputTable.addColumn("ZyskOptymalny + DostawaOptymalna");
        UnitCost();
        transport.pierwsze_wypelnienie(Popyt, Podaz);
        for (int i = 0; i < MFrame.iloscspom + 1; i++) {
            for (int j = 0; j < MFrame.ilosckpom + 1; j++) {
                Komórka k = transport.getK(i, j);
                outputTable.insertRow(outputTable.getRowCount(), new Object[]{i, j, k});

            }
            System.out.println("\n");
        }
        boolean pom = false;
        int licznik =0;
        while(true)
        {
            pom = transport.optmalizuj(Popyt, Podaz);
            licznik++;
            System.out.println(licznik);
            if(licznik == 20 || pom == true) // dodatkowy warunek stopu jakby wpadł w pętlę nieskończoną
                break;
        }
        double zysk =0;
        for(int i=0;i<Podaz.size();i++)
        {
            for(int j=0;j< Popyt.size(); j++)
            {
                zysk += transport.getK(j,i).zysk();
            }
        }
        System.out.println(zysk);
        outputTable.insertRow(outputTable.getRowCount(), new Object[]{"-","-", "-", "-"});
        outputTable.insertRow(outputTable.getRowCount(), new Object[]{"Zysk: ", zysk});

        JFrame o = new JFrame();
        o.setSize(1400, 400);
        o.add(new JScrollPane(outputTbl));
        o.setVisible(true);
    }
}