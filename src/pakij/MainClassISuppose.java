package pakij;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainClassISuppose {

    GamerFrame gameFrame;

    JFrame titleFrame;

    JButton startButton;

    public MainClassISuppose(){

        titleScreen();

    }

    public void titleScreen(){

        titleFrame = new JFrame();

        titleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        titleFrame.setTitle("epic gamer moment - the game");

        titleFrame.setLayout(new BorderLayout());

        titleFrame.add(new TitlePanel(), BorderLayout.NORTH);

        startButton = new JButton("Enter into Society");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTheGame();
            }
        });

        titleFrame.add(startButton,BorderLayout.SOUTH);

        titleFrame.revalidate();

        titleFrame.pack();

        titleFrame.setVisible(true);

    }

    public void startTheGame(){
        gameFrame = new GamerFrame(this);
        titleFrame.dispose();
    }

    public void gameOverYeah(){

        JOptionPane.showMessageDialog(gameFrame, "GAME OVER\n" + gameFrame.gamer.toString(), "GAME OVER YEAH",JOptionPane.PLAIN_MESSAGE);

        ArrayList<String> thisList = new ArrayList<String>();
        thisList.add(gameFrame.gamer.stringTimeSurvived());
        thisList.add(gameFrame.gamer.toString());

        String line = null;

        File aFile = new File("SuperSecretFiles/GamerFile.txt");


        try{
            FileReader fr = new FileReader("SuperSecretFiles/GamerFile.txt");
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            System.out.println(line);

        } catch (FileNotFoundException e){
            System.out.println("did u delete the high score file? smh my head");
            try{
                aFile.createNewFile();
            } catch (Exception exc){
                System.out.println("couldn't make a new high score file, Fs in chat");
            }
        } catch (Exception ex){
            System.out.println("yeah something weird happened");
            ex.printStackTrace();
        }

        try{
            if ((line == null) || (Integer.parseInt(line) < gameFrame.gamer.timeSurvived())){
                Path file = Paths.get("SuperSecretFiles/GamerFile.txt");
                Files.write(file, thisList, Charset.forName("UTF-8"));
                line = gameFrame.gamer.toString();
            } else{
                FileReader fr = new FileReader("SuperSecretFiles/GamerFile.txt");
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                line = br.readLine();
            }
        } catch (Exception e){
            System.out.println("i crie everytiem");
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(gameFrame, "High score\n" + line, "high score panel", JOptionPane.PLAIN_MESSAGE);

        gameFrame.dispose();

        titleScreen();

    }

    public static void main(String args[]){
        System.out.println("epic gamer moment");

        MainClassISuppose main = new MainClassISuppose();

        System.out.println("aight start playing the game smh my head");

    }
}
