/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import java.awt.Dimension;
import javax.swing.JComboBox;


// Classe com o único objetivo de fornecer os paises do Continente Americano // 

public class Paises {
    
    public static JComboBox<String> paises = new JComboBox<>();
    
    public Paises() {         // Passa o valor para o atribudo da classe sem precisar chamar o método //
        addPaises();         
    }
    
    public static void addPaises() { // Permito a opção de chamar o método com public e static sem a necessidade de um objeto//
        paises.setPreferredSize(new Dimension(200, 20));
        String pais[] = {
            "Canadá",
            "Estados Unidos",
            "México",
            "Antígua e Barbuda",
            "Bahamas",
            "Barbados",
            "Belize",
            "Costa Rica",
            "Cuba",
            "Dominica",
            "El Salvador",
            "Granada",
            "Guatemala",
            "Haiti",
            "Honduras",
            "Jamaica",
            "Nicarágua",
            "Panamá",
            "República Dominicana",
            "Santa Lúcia",
            "São Cristóvão e Névis",
            "São Vicente e Granadinas",
            "Trinidad e Tobago",
            "Argentina",
            "Bolívia",
            "Brasil",
            "Chile",
            "Colômbia",
            "Equador",
            "Guiana",
            "Guiana Francesa",
            "Paraguai",
            "Peru",
            "Suriname",
            "Uruguai",
            "Venezuela"
        };
        for (String teste : pais) { // adicionando todos o paises no JCombo // 
            paises.addItem(teste);
        }
       paises.setSelectedIndex(25); // Brasil selecionado como pais inicial //
    }
    
    
    // métodos de invisibilidade da classe // 
    
    public static void invisivel() { 
        paises.setVisible(false);
    }
    
    public static void visivel() {
        paises.setVisible(true);
    }
    
}
