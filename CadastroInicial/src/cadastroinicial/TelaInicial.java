package cadastroinicial;

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class TelaInicial extends JFrame implements ActionListener {

    Fundo fundo;
    ImageIcon icon, img, sumo, sumo2;
    JLabel lblLogin, lblCadastro, lblSumo1, lblSumo2, lblLiga, lblLiga2;
    JPanel jpElement, jpSumo, jpSumo2;
    JButton btnLogin, btnCadastro;

    public TelaInicial() {
        janela();

    }

    private void janela() {
        icon = new ImageIcon(getClass().getResource("/imagens/blackFundo.png"));
        img = new ImageIcon(getClass().getResource("/imagens/seta.png"));
        sumo = new ImageIcon(getClass().getResource("/imagens/sumo.jpg"));
        sumo2 = new ImageIcon(getClass().getResource("/imagens/sumo2.jpg"));

        fundo = new Fundo(icon);
        jpElement = new JPanel();
        jpSumo = new JPanel();
        jpSumo2 = new JPanel();
        btnLogin = new JButton(img);
        btnCadastro = new JButton(img);
        lblLogin = new JLabel("LOGIN");
        lblCadastro = new JLabel("CADASTRO");
        lblSumo1 = new JLabel(sumo);
        lblSumo2 = new JLabel(sumo2);
        lblLiga = new JLabel("LIGA DE SUMÔ");
        lblLiga2 = new JLabel("LIGA DE SUMÔ");

        this.add(fundo);
        this.setSize(1000, 500);
        this.setTitle("BEM VINDO");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.lblLiga.setForeground(Color.cyan);
        this.lblLiga.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.lblLiga2.setForeground(Color.cyan);
        this.lblLiga2.setFont(new Font("Arial Black", Font.PLAIN, 16));

        this.jpSumo.setPreferredSize(new Dimension(300, 500));
        this.jpSumo.setBackground(Color.red);
        this.jpSumo.add(this.lblSumo1);
        this.jpSumo.add(this.lblLiga);
        this.jpSumo.setOpaque(false);

        this.jpSumo2.setPreferredSize(new Dimension(300, 500));
        this.jpSumo2.setBackground(Color.cyan);
        this.jpSumo2.add(this.lblSumo2);
        this.jpSumo2.add(this.lblLiga2);
        this.jpSumo2.setOpaque(false);

        this.jpElement.setPreferredSize(new Dimension(300, 600));
        this.jpElement.setBackground(Color.darkGray);
        jpElement.setOpaque(false);

        this.fundo.add(this.jpSumo);
        this.fundo.add(this.jpElement);
        this.fundo.add(this.jpSumo2);

        this.lblLogin.setPreferredSize(new Dimension(150, 200));
        this.lblLogin.setForeground(Color.CYAN);
        this.lblLogin.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.btnLogin.setPreferredSize(new Dimension(120, 40));
        this.btnLogin.setOpaque(false);

        this.lblCadastro.setPreferredSize(new Dimension(150, 50));
        this.lblCadastro.setForeground(Color.CYAN);
        this.lblCadastro.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.btnCadastro.setPreferredSize(new Dimension(120, 40));
        this.btnCadastro.setOpaque(false);

        this.jpElement.add(this.lblLogin);
        this.jpElement.add(this.btnLogin);
        this.jpElement.add(this.lblCadastro);
        this.jpElement.add(this.btnCadastro);

        this.btnLogin.addActionListener(this);
        this.btnCadastro.addActionListener(this);
    }

    public void actionPerformed(ActionEvent escolha) {
        if (escolha.getSource() == this.btnLogin) {
            new Login().setVisible(true); // inicializa a janela do lblLogin //
            this.dispose(); // finaliza a janela inicial  //

        } else if (escolha.getSource() == this.btnCadastro) {
            new CadastroCod().setVisible(true); //inicializa a janela do lblCadastro //
            this.dispose(); // finaliza a janela da tela inicial //
        }
    }

}
