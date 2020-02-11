package pakij;


import javax.swing.*;
import java.awt.*;

public class GamerFrame extends JFrame {

    MainClassISuppose main;

    Gamer gamer;

    JPanel labelPanel;

    AttributeLabel nameLabel;
    AttributeLabel timeLabel;
    AttributeLabel urgeLabel;
    AttributeLabel moneyLabel;
    AttributeLabel foodLabel;
    AttributeLabel energyLabel;

    GamerPanel epicGamerPanel;

    //GamerCanvas gamerCanvas;

    JPanel buttonPanel;

    ButtonHandler bh;

    JButton workButton;
    JButton buyButton;
    JButton vidyaButton;
    JButton eatButton;
    JButton nothingButton;


    public GamerFrame(MainClassISuppose main){


        this.main = main;

        String gamerName = JOptionPane.showInputDialog(this,
                "Enter your gamertag",
                "");

        if (gamerName.isEmpty()){
            gamerName = "an generic gamertag";
        }



        String[] genders = {"Gamer", "Political"};

        int gender = JOptionPane.showOptionDialog(this,
                "What gender are you?\nAre you a Gamer? Or are you Political?",
                "i just wanna play bideo bame",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, genders, genders[0]);

        /*

        int gender = JOptionPane.showConfirmDialog(this,"What gender are you?");
        switch (gender){
            case.JOptionPane.YES_OPTION
        }*/

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("now that's what's called a pro gamer move");
        this.setLayout(new BorderLayout());


        gamer = new Gamer(gamerName,gender,this); //le epic gamer has arrived


        //aight time to set stuff up

        //le labels have arrived
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2,3));
        nameLabel = new AttributeLabel("Gamertag: ",gamer.getName());
        timeLabel = new AttributeLabel("Minutes spent not saying The Gamer Word: ",gamer.timeSurvived());
        urgeLabel = new AttributeLabel("Urge to say The Gamer Word: ",gamer.getUrge());
        moneyLabel = new AttributeLabel("GamerCoins: ", gamer.getMoney());
        foodLabel = new AttributeLabel("GamerFuel: ", gamer.getFood());
        energyLabel = new AttributeLabel("GamerEnergy: ", gamer.getEnergy());

        labelPanel.add(nameLabel);
        labelPanel.add(timeLabel);
        labelPanel.add(urgeLabel);
        labelPanel.add(moneyLabel);
        labelPanel.add(foodLabel);
        labelPanel.add(energyLabel);

        this.add(labelPanel,BorderLayout.NORTH);

        //le buttons have arrived
        buttonPanel = new JPanel();
        workButton = new JButton("Work for GamerCoins");
        buyButton = new JButton("Use GamerCoins to get GamerFuel");
        vidyaButton = new JButton("PLAY V I D Y A G A E M");
        eatButton = new JButton("Consume GamerFuel to get GamerEnergy");
        nothingButton = new JButton("Procrastinate");

        bh = new ButtonHandler(this);

        epicGamerPanel = new GamerPanel();

        //epicGamerPanel.add(gamerCanvas);
        this.add(epicGamerPanel, BorderLayout.CENTER);

        workButton.addActionListener(bh);
        buyButton.addActionListener(bh);
        vidyaButton.addActionListener(bh);
        eatButton.addActionListener(bh);
        nothingButton.addActionListener(bh);

        buttonPanel.add(workButton);
        buttonPanel.add(buyButton);
        buttonPanel.add(vidyaButton);
        buttonPanel.add(eatButton);
        buttonPanel.add(nothingButton);

        this.add(buttonPanel, BorderLayout.SOUTH);


        this.revalidate();

        this.pack();

        this.setVisible(true);

    }

    public void lifeGoesOn(){

        gamer.updateUrge();

        urgeLabel.showValue(gamer.getUrge());
        moneyLabel.showValue(gamer.getMoney());
        foodLabel.showValue(gamer.getFood());
        energyLabel.showValue(gamer.getEnergy());

        epicGamerPanel.setImage(gamer.getUrgeTier());

        this.repaint();

        if(gamer.doIPressFYet()){
            main.gameOverYeah();
        } else {
            gamer.itsBeenOneMinute();
            timeLabel.showValue(gamer.timeSurvived());
        }

    }
}
