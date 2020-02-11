package pakij;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class TitlePanel extends JPanel {



    //Image gamerImage;
    BufferedImage titleImage;
    Dimension size;



    public TitlePanel() {


        try {
            titleImage = ImageIO.read(new File("images/titleImage.png"));
            this.setPreferredSize(new Dimension(titleImage.getWidth(), titleImage.getHeight()));
        } catch (Exception e){
            System.out.println("oh hecc");
        }
    }

    @Override
    public void paint(Graphics g) {

        //int x = (getWidth() - size.width)/2;
        //int y = (getHeight() - size.height)/2;
        g.drawImage(titleImage, 0,0,this);

    }
}
