package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tablica extends JFrame {
    private Komórka [][] k;

    public Tablica(int a, int b) {
        this.k = new Komórka [a][b] ;
    }

    public void add(Komórka k, int a, int b)
    {
        this.k[a][b] = k;
    }

    public Komórka getK(int a, int b) {
        return k[a][b];
    }

    public void pierwsze_wypelnienie (List<Integer> Popyt, List<Integer> Podaż)
    {
        List<Integer> Popyt_pom = Popyt;
        List<Integer> Podaż_pom = Podaż;
        int wymiar = Podaż.size()*Popyt.size();
        int dostawa;

        for (int i=0; i<Podaż.size(); i++)
        {
            for (int j=0; j< Popyt.size(); j++)
            {
                if(Podaż_pom.get(i) == 0 || Popyt_pom.get(j) == 0)
                    dostawa =0;
                else
                {
                    if(Podaż_pom.get(i) < Popyt_pom.get(j))
                    {
                        dostawa = Podaż_pom.get(i);
                        Podaż_pom.set(i,0);
                        Popyt_pom.set(j, Popyt_pom.get(j)-dostawa);
                    }
                    else
                    {
                        dostawa = Popyt_pom.get(j);
                        Popyt_pom.set(j,0);
                        Podaż_pom.set(i, Podaż_pom.get(i)-dostawa);
                    }
                }
                k[j][i].setDostawa(dostawa);
            }
        }

    }
    public boolean optmalizuj(List<Integer> Popyt, List<Integer> Podaż)
    {
        boolean optymalne = false;
        double alpha [] = new double[Podaż.size()];
        double beta [] = new double[Popyt.size()];
        for(int i =0; i< Popyt.size(); i++)
            beta[i] = -5000;
        for(int i =0; i< Podaż.size(); i++)
            alpha[i] = -5000;
        alpha[0] = 0;
        // obliczanie zmienny dualnych
        while(true)  {
            for (int i = 0; i < Podaż.size(); i++) {
                if (alpha[i] != -5000) {
                    for (int j = 0; j < Popyt.size(); j++) {
                        if (beta[j] == -5000 && k[j][i].getDostawa() != 0)
                            beta[j] = k[j][i].getZysk() - alpha[i];
                    }
                }
            }
            for (int i = 0; i < Popyt.size(); i++) {
                if (beta[i] != -5000) {
                    for (int j = 0; j < Podaż.size(); j++) {
                        if (alpha[j] == -5000 && k[i][j].getDostawa() != 0)
                            alpha[j] = k[i][j].getZysk() - beta[i];
                    }
                }
            }

            int s = 0;
            for (int i = 0; i < Podaż.size(); i++) {
                if (alpha[i] != -5000) {
                    s++;
                }
            }
            for (int i = 0; i < Popyt.size(); i++) {
                if (beta[i] != -5000) {
                    s++;
                }
            }
            if(s == Podaż.size()+ Popyt.size())
                break;
        }

        //oblcizanie zmiennych kryterialnych
        double delta [][] = new double [Podaż.size()][Popyt.size()];
        for(int i =0 ; i< Popyt.size(); i++)
        {
            for(int j=0; j< Podaż.size(); j++)
            {
                if(k[i][j].getDostawa()==0)
                {
                    delta[j][i] = k[i][j].getZysk() - alpha[j] - beta[i];
                }
                else
                    delta[j][i] = -5000;
            }
        }

        //Sprawdzanie czy aktualne rozwiązanie jest optymalne
        optymalne = true;
        for(int i =0 ; i< Podaż.size(); i++)
        {
            for(int j=0; j< Popyt.size(); j++)
            {
                System.out.print(delta[i][j] + "\t");
                if(delta[i][j] > 0)
                    optymalne = false;
            }
        }
        System.out.print(optymalne);
        //Wybór tras do zmiany
        if(optymalne == false)
        {
            System.out.println("  optymalizuje  ");
            double max =0.0;
            int i_max = 0;
            int j_max = 0;
            for(int i =0 ; i< Popyt.size(); i++)
            {
                for(int j=0; j< Podaż.size(); j++)
                {
                    if(delta[j][i] > max) {
                        max = delta[j][i];
                        System.out.println("Max: " + max);
                        i_max = j;
                        j_max = i;
                    }
                }
            }

            List <Integer> i_pom = new ArrayList<>();
            List <Integer> j_pom = new ArrayList<>();

            for(int i=0; i< Podaż.size(); i++)
                if(k[j_max][i].getDostawa() != 0)
                {i_pom.add(i);}
            for(int j=0; j< Popyt.size(); j++)
                if(k[j][i_max].getDostawa() != 0)
                {j_pom.add(j);}


            int i_2 = 0; // współżędne komórki w której jako drugiej będzie zwiększać wartość
            int j_2 = 0;
            for(int i = 0; i<i_pom.size();i++)
            {
                for(int j = 0; j<j_pom.size(); j++)
                {
                    if(k[i_pom.get(i)][j_pom.get(j)].getDostawa() != 0)
                    {
                        i_2 = i;
                        j_2 = j;
                        break;
                    }
                }
            }
            //outputTable.insertRow(outputTable.getRowCount(), new Object[]{j_max, i_max, j_2, i_2});

            System.out.println(j_max + " " + i_max + " - " + j_2 + " " + i_2);
            int min = k[j_2][i_2].getDostawa();
            if(k[j_max][i_2].getDostawa() < min)
                min = k[j_max][i_2].getDostawa();
            if(k[j_2][i_max].getDostawa() < min)
                min = k[j_2][i_max].getDostawa();

            k[j_max][i_max].setDostawa(min);
            k[j_2][i_2].setDostawa(k[j_2][i_2].getDostawa() + min);
            k[j_2][i_max].setDostawa(k[j_2][i_max].getDostawa() - min);
            k[j_max][i_2].setDostawa(k[j_max][i_2].getDostawa() - min);

            /*JFrame o = new JFrame();
            o.setSize(1400, 400);
            o.add(new JScrollPane(outputTbl));
            o.setVisible(true);*/
        }

        return optymalne;
    }
}
