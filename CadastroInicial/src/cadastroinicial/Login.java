/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Login extends JFrame implements ActionListener {

    private int tentativas;
    Fundo fundo;
    ImageIcon icon, img, volta;
    JPanel jpnLogin;
    JLabel lblSenha, lblUsuario;
    JTextField txtUsuario;
    JPasswordField txtpSenha;
    JButton bntClick, bntVolta;

    public Login() {
        login();

    }

    public void login() {
        icon = new ImageIcon(getClass().getResource("/imagens/blackFundo.png"));
        img = new ImageIcon(getClass().getResource("/imagens/seta.png"));
        volta = new ImageIcon(getClass().getResource("/imagens/seta2.png"));
        fundo = new Fundo(icon);
        jpnLogin = new JPanel();
        lblUsuario = new JLabel("USUARIO:");
        lblSenha = new JLabel("SENHA");
        txtUsuario = new JTextField();
        txtpSenha = new JPasswordField();
        bntClick = new JButton(img);
        bntVolta = new JButton(volta);

        this.add(this.fundo);
        this.setTitle("LOGIN");
        this.setSize(1000, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setVisible(true);

        this.jpnLogin.setPreferredSize(new Dimension(400, 600));
        this.jpnLogin.setBackground(Color.black);
        this.jpnLogin.setOpaque(false);
        this.fundo.add(this.jpnLogin);

        this.lblUsuario.setForeground(Color.cyan);
        this.lblUsuario.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.lblUsuario.setPreferredSize(new Dimension(150, 200));
        this.txtUsuario.setPreferredSize(new Dimension(207, 25));
        this.txtUsuario.setFont(new Font("Arial black", Font.BOLD, 12));

        this.lblSenha.setForeground(Color.cyan);
        this.lblSenha.setFont(new Font("Arial Black", Font.PLAIN, 16));
        this.lblSenha.setPreferredSize(new Dimension(150, 170));
        this.txtpSenha.setFont(new Font("Arial Black", Font.BOLD, 12));
        this.txtpSenha.setPreferredSize(new Dimension(207, 25));

        this.bntClick.setPreferredSize(new Dimension(120, 40));
        this.bntClick.setOpaque(false);
        this.bntVolta.setPreferredSize(new Dimension(120, 40));
        this.bntVolta.setOpaque(false);

        this.jpnLogin.add(this.lblUsuario);
        this.jpnLogin.add(this.txtUsuario);
        this.jpnLogin.add(this.lblSenha);
        this.jpnLogin.add(this.txtpSenha);
        this.jpnLogin.add(this.bntVolta);
        this.jpnLogin.add(this.bntClick);


        this.bntVolta.addActionListener(this);
        this.bntClick.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String senha = new String(this.txtpSenha.getPassword()); //converte o Password para string //
        int validade = 0;
        if (event.getSource() == this.bntVolta) { //bnt de volta 
            this.dispose();
            new TelaInicial();

        } else if (event.getSource() == this.bntClick) {
            validade = BancoDeDados.usuarios(this.txtUsuario, senha);
            if (validade == 3) { // 3 é a soma da validade da senha(1) e do usuario(2);
                this.dispose();
                new Categoria(this.txtUsuario);
            } else {
                this.tentativas++; // 3 tentativas até Aparece a mensagem //
                if (this.tentativas == 3) {
                    if (validade == 2) {  // 2 significa que a senha é incorreta  //
                        JOptionPane.showMessageDialog(rootPane, "Senha Incorreta", "Tente Novamente", JOptionPane.WARNING_MESSAGE);
                    } else {// significa que o usuário e a senha são incorretos // 
                        JOptionPane.showMessageDialog(rootPane, "Usuario e senha incorretos", "Tente Novamente", JOptionPane.WARNING_MESSAGE);

                    }
                    this.tentativas = 0;
                }

            }
        }

    }
}
