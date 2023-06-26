/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Categoria extends JFrame implements ActionListener {

    JButton volta, sair;
    JPanel jpCategoria,jpVolta;
    Fundo fundo;
    ImageIcon icon, img;
    JLabel lblCompetidor;
    JTable jrRelacao;
    public Categoria(JTextField nome) {
        janelaDados(nome);
    }

    public void janelaDados(JTextField nome)  {
        icon = new ImageIcon(getClass().getResource("/imagens/blackFundo.png"));
        img = new ImageIcon(getClass().getResource("/imagens/seta2.png"));
        fundo = new Fundo(icon);
        jpCategoria = new JPanel();
        jpVolta = new JPanel();
        lblCompetidor = new JLabel("COMPETIDORES");
        jrRelacao = new JTable();
        volta = new JButton(img);
        
        fundo.setLayout(new FlowLayout(FlowLayout.LEFT,100,0));
        
        this.add(this.fundo);
        this.setSize(1000, 500);
        this.setTitle("RELAÇÃO");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.jpVolta.setPreferredSize(new Dimension(80,300));
        this.jpVolta.setBackground(Color.BLACK);
        this.jpVolta.setLayout(new BorderLayout());
        this.jpVolta.setOpaque(false);
        
        this.jpCategoria.setPreferredSize(new Dimension(500, 600));
        this.jpCategoria.setBackground(Color.darkGray);
         this.jpCategoria.setOpaque(false);
        
        this.fundo.add(this.jpVolta);
        this.fundo.add(this.jpCategoria);

        this.lblCompetidor.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.lblCompetidor.setForeground(Color.cyan);

        this.jrRelacao = BancoDeDados.usuarios(nome);
        this.jrRelacao.setEnabled(false);
        this.jrRelacao.setBackground(Color.black);
        this.jrRelacao.setForeground(Color.cyan);
        this.jrRelacao.setPreferredScrollableViewportSize(new Dimension(500,600));
        this.jpCategoria.add(this.lblCompetidor);
        this.jpCategoria.add(new JScrollPane(this.jrRelacao));
        
        this.volta.setPreferredSize(new Dimension(80,40));
        this.volta.setOpaque(false);
        this.jpVolta.add(this.volta,BorderLayout.SOUTH);
        
        this.volta.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent voltar) {
        this.dispose();
        new TelaInicial();

    }


}
