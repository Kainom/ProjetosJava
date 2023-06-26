/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
// Escolha facultativa,optei por uma classe particular apenas para tratar o banco de dados e suas aplicações //
public class BancoDeDados {

    public static int usuarios(JTextField txtNome, JFormattedTextField txtfCpf, // testa o cadastro //
            JPasswordField password,
            JTextField txtEmail, JRadioButton jrSexoM, JComboBox jcPesoM,
            JComboBox jcPesoF, JSpinner idade, JComboBox jcAltura) {
        int teste = 0, idad = 0;
        String sex, senh, altura, peso, sql, url, pais;

        url = "jdbc:mysql://127.0.0.1/cadastro";
        pais = Paises.paises.getSelectedItem().toString();         //varíaveis intermediárias para passar ao banco de dados //
        idad = 2023 - Integer.parseInt(idade.getValue().toString());
        senh = new String(password.getPassword());
        sex = (jrSexoM.isSelected()) ? "Masculino" : "Feminino";
        altura = jcAltura.getSelectedItem().toString();
        peso = (sex.equals("Masculino")) ? jcPesoM.getSelectedItem().toString() : jcPesoF.getSelectedItem().toString();

        try {
            Connection conexao = DriverManager.getConnection(url, "root", "LuadeSangue123");
            PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM usuario");
            ResultSet resultado = pesquisa.executeQuery();
            while (resultado.next()) {
                // testa se estes campos já foram utilizados anteriormente em outro cadastro //
                teste = (txtNome.getText().equals(resultado.getString("s_nome_usuario"))) ? teste + 1 : teste;
                teste = (txtfCpf.getText().equals(resultado.getString("s_cpf_usuario"))) ? teste + 1 : teste;
                teste = (txtEmail.getText().equals(resultado.getString("s_email_usuario"))) ? teste + 1 : teste;
                teste = (senh.equals(resultado.getString("s_senha_usuario"))) ? teste + 1 : teste;

                if (teste > 0) { // qualquer um dos campos já inválida o cadastro //
                    return 1;
                }

            }
            // inserção dos campos no banco de dados // // o nome não foi a melhor escolha,mas decidi manter a escolha padronizado do sql // 
            sql = "insert into usuario(s_nome_usuario,i_idade_usuario ,s_sexo_usuario ,s_peso_usuario,s_altura_usuario,s_pais_usuario,s_cpf_usuario,s_email_usuario,s_senha_usuario) values('" + txtNome.getText() + "'," + idad + ",'" + sex + "','" + peso + "','" + altura + "','" + pais + "','" + txtfCpf.getText() + "','" + txtEmail.getText() + "','" + senh + "')";
            PreparedStatement inserir = conexao.prepareStatement(sql);
            inserir.executeUpdate();

        } catch (SQLException erro) {
            System.out.println("ERROR NO BANCO");
            return 1;
        } finally {
        }

        return 0;
    }

    public static int usuarios(JTextField nome, String senha) { // testa se o login é válido  //
        String url = "jdbc:mysql://127.0.0.1/cadastro";
        int teste = 0;
        try {
            Connection conexao = DriverManager.getConnection(url, "root", "LuadeSangue123");
            PreparedStatement select = conexao.prepareStatement("Select * from usuario where s_nome_usuario = '" + nome.getText() + "'"); // puxa o select diretamente do nome colocado no campo //
            ResultSet consulta = select.executeQuery();
            while (consulta.next()) {
                teste = (nome.getText().equals(consulta.getString("s_nome_usuario"))) ? 2 : 0; //  tesa o nome,2 é a validade do nome,irá ser utilizado para saber se o usuário errou somento o nome 
                teste = (senha.equals(consulta.getString("s_senha_usuario"))) ? ++teste : teste; // senelhante ao de cima,diferenciando pela validade 1 da senha
            }

        } catch (Exception banco) {
            System.out.println("ERRO NO BANCO");
        } finally {
        }

        return teste;
    }

    public static JTable usuarios(JTextField nome) {   // configura a JTable mostrada na classe categoria // 
        DefaultTableModel tabela = new DefaultTableModel();

        int i = 0;
        String url = "jdbc:mysql://127.0.0.1/cadastro";
        String categoria = null;
        String peso = null;
        String sex = null;
        tabela.addColumn("Nome");     // não coloquei todos os campos na tabela,optei pelo mais necessários // 
        tabela.addColumn("Idade");
        tabela.addColumn("Nacionalidade");
        tabela.addColumn("Categoria");
        tabela.addColumn("Altura");
        tabela.addColumn("Sexo");

        try {

            Connection conexao = DriverManager.getConnection(url, "root", "LuadeSangue123");
            PreparedStatement select = conexao.prepareStatement("Select * from usuario where s_nome_usuario = '" + nome.getText() + "'"); // select para encontrar o peso do usuario //
            ResultSet consulta = select.executeQuery();
            while (consulta.next()) { // consulta para buscas o peso e o sexo do usuario //
                peso = consulta.getString("s_peso_usuario");
                sex = consulta.getString("s_sexo_usuario");
            }
            //pesos masculinos //              //pesos femininos //
            if (peso.equals("Abaixo de 85kg") || peso.equals(" Abaixo de 65kg")) {
                categoria = "Leve";
            } else if (peso.equals("85-100kg") || peso.equals("65-73kg")) {
                categoria = "Médio";
            } else if (peso.equals("100-115kg") || peso.equals("73-80kg")) {
                categoria = "Meio-Pesado";
            } else if (peso.equals("Acima de 115kg") || peso.equals("Acima de 80kg")) {
                categoria = "Pesado";
            }

            PreparedStatement select2 = conexao.prepareStatement("Select * from usuario where s_peso_usuario = '" + peso + "'"); // consulta para buscar usuários que possuem o mesmo pesso //
            ResultSet consulta2 = select2.executeQuery();

            while (consulta2.next()) {

                String nome1 = new String(consulta2.getString("s_nome_usuario"));
                String idade = new String(consulta2.getString("i_idade_usuario"));
                String pais = new String(consulta2.getString("s_pais_usuario"));
                String altura = new String(consulta2.getString("s_altura_usuario"));

                Object dados[] = {nome1, idade, pais, categoria, altura, sex};  // definição da jtable // 
                tabela.insertRow(i, dados);
                i++;
            }
        } catch (Exception erro) {
            System.out.println("ERRO NO BANCO2");
        } finally {}

        JTable jrRelacao = new JTable(tabela);
        return jrRelacao;
    }

}
