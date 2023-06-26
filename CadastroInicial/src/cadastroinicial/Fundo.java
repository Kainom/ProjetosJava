/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroinicial;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// clase que me permite setar uma imagem como um painel central //
public class Fundo extends JPanel {

    protected ImageIcon icon;

    public Fundo(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = this.icon.getImage();
        g.drawImage(img, 0, 0, this);
    }

    
  
}
