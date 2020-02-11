package pakij;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

    GamerFrame frame;

    public ButtonHandler(GamerFrame theFrame){
        frame = theFrame;
    }

    private boolean checkEnergy(){
        if (frame.gamer.canTheGamerDoAnything()){
            return true;
        } else{
            if (checkFood()) {
                JOptionPane.showMessageDialog(frame,
                        "You have run out of energy!\nEat some food to regain energy!\n",
                        "out of energy",
                        JOptionPane.WARNING_MESSAGE);
            }
            return false;
        }
    }

    private boolean checkFood(){
        if (frame.gamer.isThisCommunism()){
            return true;
        } else{
            JOptionPane.showMessageDialog(frame,
                    "Welp, you're out of food and out of energy.\nAll you can do now is procrastinate, and wait for the end.",
                    "Fs in chat",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (!frame.gamer.doIPressFYet()) {

            if (e.getSource() == frame.workButton) {
                if (checkEnergy()) {
                    frame.gamer.work();
                    frame.lifeGoesOn();
                }
            } else if (e.getSource() == frame.buyButton) {
                if (frame.gamer.isThisStonks()) {
                    frame.gamer.buy();
                    frame.lifeGoesOn();
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "can't buy stuff without money bruh moment.",
                            "ur poor lol",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else if (e.getSource() == frame.vidyaButton) {
                if (checkEnergy()) {
                    frame.gamer.vidyagaem();
                    frame.lifeGoesOn();
                }
            } else if (e.getSource() == frame.eatButton) {
                if (frame.gamer.isThisCommunism()) {
                    frame.gamer.eat();
                    frame.lifeGoesOn();
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "You have run out of food!\nBuy some food so you can eat it!",
                            "out of food",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else if (e.getSource() == frame.nothingButton) {
                frame.lifeGoesOn();
            }
        }

    }
}
