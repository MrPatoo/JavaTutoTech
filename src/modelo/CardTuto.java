/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class CardTuto extends JPanel{
     public CardTuto() {
        setLayout(new GridLayout(0, 1, 10, 10)); // Un diseño de grid con una sola columna
        Tutoria tuto = new Tutoria();
        ArrayList<String> tutoname = tuto.getTuto();
        
        for (String name : tutoname) {
            add(createTutoCard(name));
        }
    }

    private JPanel createTutoCard(String name) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JLabel nameLabel = new JLabel(name);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        card.add(nameLabel, BorderLayout.CENTER);

        return card;
    }
}
