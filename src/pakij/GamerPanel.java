package pakij;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class GamerPanel extends JPanel {



    //Image gamerImage;
    BufferedImage gamerImage;
    Dimension size;

    ArrayList<File> imageList;

    int currentImage;

    int height;
    int width;

    public GamerPanel() {


        imageList = new ArrayList<>();
        imageList.add(new File("images/img1.png"));
        imageList.add(new File("images/img2.png"));
        imageList.add(new File("images/img3.png"));
        imageList.add(new File("images/img4.png"));
        imageList.add(new File("images/oof.png"));

        currentImage = 0;

        setImage();


    }

    public void setImage(int urgeTier) {
        this.currentImage = urgeTier;
        setImage();
    }

    public void setImage(){
        try {
            gamerImage = ImageIO.read(imageList.get(currentImage));
            this.setPreferredSize(new Dimension(gamerImage.getWidth(), gamerImage.getHeight()));
        } catch (Exception e){
            System.out.println("oh hecc");
        }
    }

    @Override
    public void paint(Graphics g) {

        //int x = (getWidth() - size.width)/2;
        //int y = (getHeight() - size.height)/2;
        g.drawImage(gamerImage, 0,0,this);

    }
}
