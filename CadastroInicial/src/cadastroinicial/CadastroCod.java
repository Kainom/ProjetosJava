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
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author User
 */
public class CadastroCod extends JFrame implements ActionListener, ChangeListener {

    private int tentativas = 0;
    ImageIcon icon;
    ImageIcon img;
    ImageIcon volta;
    Fundo fundo;  // Objeto que cria uma painel central que cobra a JFrame //
    JPanel jpDados, jpVolta;
    JLabel lblNome;
    JLabel lblSexo;
    JLabel lblPeso;
    JLabel lblNascimento;
    JLabel lblAltura;
    JLabel lblIdade;
    JLabel lblNacionalidade;
    JLabel lblCpf;
    JLabel lblEmail;
    JLabel lblSenha;
    MaskFormatter cpf;
    JTextField txtNome;
    JFormattedTextField txtfCpf;
    JTextField txtEmail;
    JPasswordField txtpSenha;
    JRadioButton jrMasculino;
    JRadioButton jrFeminino;
    JComboBox<String> jcPesoM;
    JComboBox<String> jcPesoF;
    JComboBox<String> jcAltura;
    ButtonGroup grupo;                          // Permite-me marcar apenas um nos RadioButton // 
    SpinnerModel value;
    JSpinner spinner;
    JButton bntConfirma;
    JButton bntVolta;

    public CadastroCod() {
        configurarJanela();
        configurarJPanelDados();
    }

    public void configurarJanela() {
        icon = new ImageIcon(getClass().getResource("/imagens/blackFundo.png"));
        fundo = new Fundo(icon);
        this.fundo.setLayout(new FlowLayout(FlowLayout.LEFT, 120, 0));
        this.add(fundo);
        this.setSize(1000, 500);
        this.setTitle("Cadastro");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void configurarJPanelDados() {   // todos os componentes adicionados no painel //
        jpDados = new JPanel(new FlowLayout());
        jpVolta = new JPanel();
        grupo = new ButtonGroup();
        Paises.addPaises();

        this.jpDados.setLayout(new FlowLayout(FlowLayout.LEFT, 18, 25));
        this.jpDados.setPreferredSize(new Dimension(330, 500));
        this.jpDados.setBackground(Color.darkGray);
        this.jpDados.setOpaque(false);

        this.jpVolta.setPreferredSize(new Dimension(80, 370));
        this.jpVolta.setBackground(Color.darkGray);
        this.jpVolta.setLayout(new BorderLayout());

        this.jpVolta.setOpaque(false);

        this.fundo.add(this.jpVolta);
        this.fundo.add(this.jpDados);
        this.dados();  // chamada dos componentes //
        this.jpVolta.add(this.bntVolta, BorderLayout.SOUTH);
        this.grupo.add(this.jrMasculino);
        this.grupo.add(this.jrFeminino);
        this.jpDados.add(this.lblNome);
        this.jpDados.add(this.txtNome);
        this.jpDados.add(this.lblSexo);
        this.jpDados.add(this.jrMasculino);
        this.jpDados.add(this.jrFeminino);
        this.jpDados.add(this.lblPeso);
        this.jpDados.add(this.jcPesoM);
        this.jpDados.add(this.jcPesoF);
        this.jpDados.add(this.lblAltura);
        this.jpDados.add(this.jcAltura);
        this.jpDados.add(this.lblNascimento);
        this.jpDados.add(this.spinner);
        this.jpDados.add(this.lblIdade);
        this.jpDados.add(this.lblNacionalidade);
        this.jpDados.add(Paises.paises);
        this.jpDados.add(this.lblCpf);
        this.jpDados.add(this.txtfCpf);
        this.jpDados.add(this.lblEmail);
        this.jpDados.add(this.txtEmail);
        this.jpDados.add(this.lblSenha);
        this.jpDados.add(this.txtpSenha);
        this.jpDados.add(this.bntConfirma);

        // seta invisibilidade de todos os componentes abaixo do sexo e do nome  para false no inicio do cadastro //
        Paises.invisivel();
        this.bntConfirma.setVisible(false);
        this.lblSenha.setVisible(false);
        this.txtpSenha.setVisible(false);
        this.lblEmail.setVisible(false);
        this.txtEmail.setVisible(false);
        this.lblNacionalidade.setVisible(false);
        this.txtfCpf.setVisible(false);
        this.lblCpf.setVisible(false);
        this.lblAltura.setVisible(false);
        this.jcAltura.setVisible(false);
        this.lblNascimento.setVisible(false);
        this.lblIdade.setVisible(false);
        this.spinner.setVisible(false);
        this.lblPeso.setVisible(false);
        this.jcPesoM.setVisible(false);
        this.jcPesoF.setVisible(false);
        this.jrMasculino.addActionListener(this);
        this.jrFeminino.addActionListener(this);
        this.spinner.addChangeListener(this);
        this.bntConfirma.addActionListener(this::event);
        this.bntVolta.addActionListener((ActionEvent botao) -> this.event(botao));
    }

    public void dados() {    // todos os componentes definidos //
        lblNome = new JLabel();
        lblSexo = new JLabel();
        lblPeso = new JLabel();
        lblNascimento = new JLabel();
        lblAltura = new JLabel();
        lblIdade = new JLabel();
        lblNacionalidade = new JLabel();
        lblCpf = new JLabel();
        lblEmail = new JLabel();
        lblSenha = new JLabel();
        txtpSenha = new JPasswordField();
        txtNome = new JTextField();
        txtEmail = new JTextField();
        jrMasculino = new JRadioButton("Masculino");
        jrFeminino = new JRadioButton("Feminino");
        jcPesoM = new JComboBox<>();
        jcPesoF = new JComboBox<>();
        jcAltura = new JComboBox<>();
        value = new SpinnerNumberModel(2005, 1983, 2005, 1);
        spinner = new JSpinner(value);
        img = new ImageIcon(getClass().getResource("/imagens/confirm.jpg"));
        volta = new ImageIcon(getClass().getResource("/imagens/seta2.png"));
        bntConfirma = new JButton(img);
        bntVolta = new JButton(volta);

        try {
            cpf = new MaskFormatter("###.###.###-##");

        } catch (ParseException erro) {
            System.out.println("ERRO de formatação");
        }

        txtfCpf = new JFormattedTextField(cpf);

        this.txtNome.setPreferredSize(new Dimension(207, 25));
        this.txtNome.setFont(new Font("Arial Black", Font.PLAIN, 12));

        this.lblNome.setText("Nome:");
        this.lblNome.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblNome.setForeground(Color.cyan);
        this.txtNome.setPreferredSize(new Dimension(207, 25));
        this.txtNome.setFont(new Font("Arial Black", Font.PLAIN, 12));

        this.lblSexo.setText("Sexo:");
        this.lblSexo.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblSexo.setForeground(Color.cyan);
        
        this.jrMasculino.setOpaque(false);
        this.jrMasculino.setBackground(Color.darkGray);
        this.jrMasculino.setForeground(Color.white);
        
        this.jrFeminino.setOpaque(false);
        this.jrFeminino.setBackground(Color.darkGray);
        this.jrFeminino.setForeground(Color.white);

        this.lblPeso.setText("Peso:  ");
        this.lblPeso.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblPeso.setForeground(Color.cyan);

        this.jcPesoM.setPreferredSize(new Dimension(200, 20));
        this.jcPesoM.addItem("");
        this.jcPesoM.addItem("Abaixo de 85kg");
        this.jcPesoM.addItem("85-100kg");
        this.jcPesoM.addItem("100-115kg");
        this.jcPesoM.addItem("Acima de 115kg");
        this.jcPesoM.setSelectedIndex(0);

        this.jcPesoF.setPreferredSize(new Dimension(200, 20));
        this.jcPesoF.addItem("");
        this.jcPesoF.addItem("Abaixo de 65kg");
        this.jcPesoF.addItem("65-73kg");
        this.jcPesoF.addItem("73-80kg");
        this.jcPesoF.addItem("Acima de 80kg");
        this.jcPesoF.setSelectedIndex(0);

        this.lblAltura.setText("Altura:");
        this.lblAltura.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblAltura.setForeground(Color.cyan);
        this.jcAltura.setPreferredSize(new Dimension(200, 20));
        this.jcAltura.addItem("");
        this.jcAltura.addItem("1.50 - 1.60");
        this.jcAltura.addItem("1.60 - 1.70");
        this.jcAltura.addItem("1.70 - 1.80");
        this.jcAltura.addItem("Mais de 1.80");
        this.jcAltura.setSelectedIndex(0);

        this.lblNascimento.setText("Idade: ");
        this.lblNascimento.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblNascimento.setForeground(Color.cyan);
        this.lblIdade.setText("18 Anos");
        this.lblIdade.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblIdade.setForeground(Color.white);
        this.spinner.setPreferredSize(new Dimension(120, 20));

        this.lblNacionalidade.setText("País:   ");
        this.lblNacionalidade.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblNacionalidade.setForeground(Color.cyan);

        this.lblCpf.setText("CPF:   ");
        this.lblCpf.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblCpf.setForeground(Color.cyan);
        this.txtfCpf.setPreferredSize(new Dimension(207, 25));
        this.txtfCpf.setFont(new Font("Arial Black", Font.PLAIN, 12));

        this.lblEmail.setText("Email:");
        this.lblEmail.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblEmail.setForeground(Color.cyan);
        this.txtEmail.setPreferredSize(new Dimension(207, 25));
        this.txtEmail.setFont(new Font("Arial Black", Font.PLAIN, 12));

        this.lblSenha.setText("Senha:");
        this.lblSenha.setFont(new Font("Arial Black", Font.BOLD, 14));
        this.lblSenha.setForeground(Color.cyan);
        this.txtpSenha.setPreferredSize(new Dimension(145, 25));
        this.txtpSenha.setFont(new Font("Arial Black", Font.PLAIN, 12));

        this.bntConfirma.setPreferredSize(new Dimension(43, 20));
        this.bntConfirma.setFont(new Font("Arial Black", Font.ITALIC, 11));
        this.bntConfirma.setOpaque(false);

        this.bntVolta.setPreferredSize(new Dimension(30, 40));
        this.bntVolta.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent sexo) {
        // torna todos os componentes abaixo visiveis após a escolha de um sexo // 
        Paises.visivel();
        this.bntConfirma.setVisible(true);
        this.lblSenha.setVisible(true);
        this.txtpSenha.setVisible(true);
        this.lblEmail.setVisible(true);
        this.txtEmail.setVisible(true);
        this.lblNacionalidade.setVisible(true);
        this.txtfCpf.setVisible(true);
        this.lblCpf.setVisible(true);
        this.lblAltura.setVisible(true);
        this.jcAltura.setVisible(true);
        this.lblNascimento.setVisible(true);
        this.lblIdade.setVisible(true);
        this.spinner.setVisible(true);
        this.lblPeso.setVisible(true);

        if (this.jrMasculino.isSelected()) { // torna visivel a pesagem masculina se o botão selecionado for referente //
            this.jcPesoF.setVisible(false);
            this.jcPesoM.setVisible(true);
        } else {
            this.jcPesoM.setVisible(false); // o mesmo so que para a pesagem feminina //
            this.jcPesoF.setVisible(true);
        }
    }

    @Override
    public void stateChanged(ChangeEvent idade) { // lbl que se movimenta com  o spinner //
        this.lblIdade.setText(Integer.toString(2023 - Integer.parseInt(spinner.getValue().toString())) + " Anos");
    }

    public int ValidaCampos() {
        // return 1 para erro e 0 para acerto //

        // cpf // 
        if (this.txtfCpf.getText().equals("   .   .   -  ")) {   // signfica que o cpf é vazio // 
            return 1;
        }
        // nome //
        if (this.txtNome.getText().length() <= 2) {   // o tamanho do campo deve ser maior do que 2 //
            this.txtNome.setText("");
            return 1;

        } else if (ValidaTeste.validarNome(this.txtNome) == 1) { // chama o método static capaz de validar o nome //
            this.txtNome.setText(""); // esvazia o nome caso haja erro //
            return 1;
        }
        // peso // 
        if (this.jcPesoM.getSelectedIndex() == 0 && this.jcPesoF.getSelectedIndex() == 0) { // verifica se o peso foi selecionado no feminino ou masculino //
            return 1;
        }

        // altura //
        if (this.jcAltura.getSelectedIndex() == 0) { // verifica se a altura foi selecionada //
            return 1;
        }

        //Email//
        if (this.txtEmail.getText().length() < 6) { // o campo precisa possuir pelo menos 6 caracteres //
            this.txtEmail.setText("Mínimo 6 caracteres");
            return 1;

        } else if (ValidaTeste.validarEmail(this.txtEmail) == 1) { // método responsável por validar o email //
            this.txtEmail.setText("Email inválido");
            return 1;
        }

        // senha //
        if (ValidaTeste.validaSenha(this.txtpSenha) == 1) { // método responsável por validar a senha //
            this.txtpSenha.setText("");
            return 1;
        }

        return 0;
    }

    private void event(ActionEvent botao) {
       

        int test = 0;
        if (botao.getSource().equals(this.bntConfirma)) {
            test = ValidaCampos();
            if (test == 0) { // testa validade dos campos //
                test = BancoDeDados.usuarios(txtNome, txtfCpf, txtpSenha, txtEmail, jrMasculino, jcPesoM, jcPesoF, spinner, jcAltura); // testa se existe usuários com repetição de campos específicos.Caso não,armazena os campos //
            }
            if (test != 1) { // testa se houve repetição //
                new TelaInicial(); // volta para tela inicial após completar o login//
                this.dispose();    // finaliza a tela do cadastro //
            } else {
                this.tentativas = ++tentativas; // 3 possíveis tentativas até a mensagem de erro aparecer // 
                System.out.println(this.tentativas);
                if (this.tentativas == 3) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR PREENCHA CORRETAMENTE ", "Muitas Tentativas", JOptionPane.WARNING_MESSAGE);
                    this.tentativas = 0;
                }
            }
        } else if (botao.getSource().equals(this.bntVolta)) { // botão para voltar a tela inicial //
            this.dispose();
            new TelaInicial();
        }
    }

}
