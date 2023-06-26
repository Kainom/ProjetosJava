/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
// Classe com o objetivo de validar os campos do cadastro // 
public class ValidaTeste {

    public static long validarNome(JTextField nome) {
        long teste;
        int i = 0;
        char caracteres[] = nome.getText().toCharArray(); // transformando string em vetor de char // 

        if (nome.getText().length() > 32) {
            return 1;
        }

        try {
            teste = Long.parseLong(nome.getText());  // se houver somente numeros não entra no catch e recebe logo o retorno 1 de erro //
        } catch (NumberFormatException erro) {
            for (char t : caracteres) {
                if (t == '&') {
                    return 1;            // uma das 3 formas de limitar os caracteres // 
                } else if (t == '0') {   // Para critérios de uma boa prática,é interessante padronizar tal teste //
                    return 1;            // Contudo,afim de testas as 3 possibilidade eu as fiz // 
                } else if (t == '1') {
                    return 1;
                } else if (t == '2') {
                    return 1;
                } else if (t == '3') {
                    return 1;
                } else if (t == '4') {
                    return 1;
                } else if (t == '5') {
                    return 1;
                } else if (t == '6') {
                    return 1;
                } else if (t == '7') {
                    return 1;
                } else if (t == '8') {
                    return 1;
                } else if (t == '9') {
                    return 1;
                } else if (t == '@') {
                    return 1;
                } else if (t == '#') {
                    return 1;
                } else if (t == '*') {
                    return 1;
                } else if (t == '!') {
                    return 1;
                } else if (t == '%') {
                    return 1;
                } else if (t == '[') {
                    return 1;
                } else if (t == ']') {
                    return 1;
                } else if (t == '§') {
                    return 1;
                } else if (t == '&') {
                    return 1;
                } else if (t == '(') {
                    return 1;
                } else if (t == ')') {
                    return 1;
                } else if (t == '-') {
                    return 1;
                } else if (t == '_') {
                    return 1;
                } else if (t == '=') {
                    return 1;
                } else if (t == '{') {
                    return 1;
                } else if (t == '}') {
                    return 1;
                } else if (t == '¹') {
                    return 1;
                } else if (t == '²') {
                    return 1;
                } else if (t == '³') {
                    return 1;
                } else if (t == '$') {
                    return 1;
                } else if (t == '£') {
                    return 1;
                } else if (t == '¢') {
                    return 1;
                } else if (t == '¬') {
                    return 1;
                } else if (t == ';') {
                    return 1;
                } else if (t == ',') {
                    return 1;
                } else if (t == '.') {
                    return 1;
                } else if (t == '<') {
                    return 1;
                } else if (t == '>') {
                    return 1;
                } else if (t == ':') {
                    return 1;
                } else if (t == '?') {
                    return 1;
                } else if (t == '/') {
                    return 1;
                } else if (t == '°') {
                    return 1;
                } else if (t == '|') {
                    return 1;
                } else if (t == '\\') {
                    return 1;
                } else if (t == 'ª') {
                    return 1;
                } else if (t == '"') {
                    return 1;
                } else if (t == '^') {
                    return 1;
                } else if (t == '~') {
                    return 1;
                }
            }
            return 0;
        }
        return 1;
    }

    public static int validarEmail(JTextField email) {
        int teste = 0, contador = 0, cont = 0, pontos = 0, abs = 0;
        char caracteres[] = email.getText().toCharArray();

        if (email.getText().length() > 32) { // o Email não pode ser maior que 32 //
            return 1;
        }

        for (int i = 0; i < 3; i++) {  // impede numeros nos 3 primeiros caracteres // 
            if (caracteres[i] >= 48 && caracteres[i] <= 57) { // representação dos números em ascii //
                return 1;
            }
            if (caracteres[i] == 64 || caracteres[i] == 46) {  // impede os caracteres . e @ nos 3 primeiros//
                return 1;                                      // representação desses caracteres em ascii //
            }
        }

        for (char t : caracteres) {             // Lógica semelhante ao validarNome,mas com switch //
            switch (t) {                      // Permite ponto e  @  não permite espaço // 
                case '#':
                    return 1;
                case '*':
                    return 1;
                case '!':
                    return 1;
                case '%':
                    return 1;
                case '[':
                    return 1;
                case ']':
                    return 1;
                case '§':
                    return 1;
                case '&':
                    return 1;
                case '(':
                    return 1;
                case ')':
                    return 1;
                case '-':
                    return 1;
                case '_':
                    return 1;
                case '=':
                    return 1;
                case '{':
                    return 1;
                case '}':
                    return 1;
                case '¹':
                    return 1;
                case '²':
                    return 1;
                case '³':
                    return 1;
                case '$':
                    return 1;
                case '£':
                    return 1;
                case '¢':
                    return 1;
                case '¬':
                    return 1;
                case ';':
                    return 1;
                case ',':
                    return 1;

                case '<':
                    return 1;
                case '>':
                    return 1;
                case ':':
                    return 1;
                case '?':
                    return 1;
                case '/':
                    return 1;
                case '°':
                    return 1;
                case '|':
                    return 1;
                case '\\':
                    return 1;
                case 'ª':
                    return 1;
                case '"':
                    return 1;
                case '^':
                    return 1;
                case '~':
                    return 1;
                case ' ':
                    return 1;
                default:
                    break;

            }
        }
        for (int c = 0; c < caracteres.length; c++) { // testa os pontos e @ //
            if (caracteres[c] == '@') { // testa se há mais de um @ // 
                abs++;
            }
            pontos = (caracteres[c] == '.' && caracteres[c + 1] == '.') ? ++pontos : pontos; // teste se existem pontos em sequência // 

            if (abs >= 2 || pontos > 0) {
                return 1;
            }
        }

        try { // se o usuário colocar  @ após o ponto o vetor vai lançar uma excption  //
            for (int at = 0; at < caracteres.length; at++) {  // verifica se existe @ antes de . //

                if (caracteres[at] == '@') {                  // verifica a quantidade de caracteres entre @ e . //
                    contador = at;
                    cont = 0;
                    while (caracteres[contador + 1] != '.') { // enquanto nao chegar no ponto repete // 
                        contador++;
                        cont++; // quantidade de caracteres entre o @ e o ponto //
                    }
                    if (cont <= 2) {   // retorna erro caso haja menos de 3 caracteres entre o @ e o .//
                        teste = 1;
                        break;
                    }

                }

            }
        } catch (ArrayIndexOutOfBoundsException erro) {
            email.setText("error");
        }

        // o email precisa possuir pelo menos uma dessas 3 possibilidades.
        int acerto = 0;
        for (int l = 0; l < 4; l++) {  // for que testa os 3 possiveis casos do email // 
            switch (l) {
                case 1: // .com //
                    for (int j = 0; j < caracteres.length; j++) {
                        if (caracteres[caracteres.length - 1] == 'm') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 2] == 'o') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 3] == 'c') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 4] == '.') {
                            acerto++;
                        }
                        if (teste != 0) {  //testa se ha caracters entre . e  @ //       
                            return 1;
                        }
                        if (acerto == 4) { // testa todos os caractes estão em ordem e presentes // 
                            return 0;
                        }
                    }
                    break;

                case 2: // .br //
                    for (int j = 0; j < caracteres.length; j++) {
                        if (caracteres[caracteres.length - 1] == 'b') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 2] == 'r') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 3] == '.') {
                            acerto++;
                        }
                        if (teste != 0) {
                            return 1;
                        }
                        if (acerto == 3) {
                            return 0;
                        }
                    }
                    break;
                case 3:
                    for (int j = 0; j < caracteres.length; j++) {
                        if (caracteres[caracteres.length - 1] == 'b') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 2] == 'r') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 3] == '.') {
                            acerto++;
                        }

                        if (caracteres[caracteres.length - 4] == 'm') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 5] == 'o') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 6] == 'c') {
                            acerto++;
                        }
                        if (caracteres[caracteres.length - 7] == '.') {
                            acerto++;
                        }

                        if (teste != 0) {
                            return 1;
                        }
                        if (acerto == 7) {
                            return 0;
                        }

                    }
                    break;

                case 4: // Nenhum dos três o que por sua vez inválida o email // 
                    return 1;
            }
        }
        return 0;
    }

    public static int validaSenha(JPasswordField senha) {
        int teste = 0;
        String password = new String(senha.getPassword());
        char caracteres[] = password.toCharArray();
        if (password.length() <= 4 || password.length() > 20) { // a senha precisa estar nessa janela de tamanho //
            return 1;
        }                                                    // terceira e ultima forma de se impedir os caracteres,sendo a mais prática na minha concepção
        for (int i = 0; i < caracteres.length - 1; i++) {        // todos os caracteres especiais referentes a tabela ASCII
            teste = (caracteres[i] >= 32 && caracteres[i] <= 47) ? ++teste : teste;
            teste = (caracteres[i] >= 58 && caracteres[i] <= 64) ? ++teste : teste;
            teste = (caracteres[i] >= 91 && caracteres[i] <= 96) ? ++teste : teste;
            teste = (caracteres[i] >= 122 && caracteres[i] <= 126) ? ++teste : teste;

        }
        if (teste != 0) {
            return 1;
        }

        return 0;
    }

}
