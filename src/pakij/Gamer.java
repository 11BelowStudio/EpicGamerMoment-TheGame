package pakij;

import javax.swing.*;

public class Gamer {
    private double urgeToSayTheGamerWord;
    private int gamerCoins;
    private int food;
    private double energy;
    private String gamertag;
    private int gender; //is this forced representation in my vidyagaems??? smh my head

    private int minutesSinceSayingGamerWord;

    private double urgeScale;

    GamerFrame frame;


    public Gamer(){
        this.urgeToSayTheGamerWord = 0;
        this.gamerCoins = 5;
        this.food = 10;
        this.energy = 50;
        this.minutesSinceSayingGamerWord = 0;
        this.urgeScale = 0;

    }

    public Gamer(String whatName, int isThisPolitical, GamerFrame theFrame) {
        this();
        this.gamertag = whatName;
        this.gender = isThisPolitical;
        this.frame = theFrame;
    }

    public int getUrgeTier(){
        if (this.urgeToSayTheGamerWord < 25){
            return 0;
        } else if (this.urgeToSayTheGamerWord < 50){
            return 1;
        } else if (this.urgeToSayTheGamerWord < 75){
            return 2;
        } else if (this.urgeToSayTheGamerWord < 100){
            return 3;
        } else{
            return 4;
        }
    }


    public boolean doIPressFYet(){
        return (urgeToSayTheGamerWord >= 100);
        //if the gamer's urge to say the gamer word is over 100, that's it, they've said the gamer word.
        //press F to pay respects
    }

    public boolean canTheGamerDoAnything(){
        return (energy > 0); //cant do anything without energy bruh moment
    }

    public boolean isThisCommunism(){
        return (food > 0); //cant eat without food bruh moment
    }

    public boolean isThisStonks(){
        return (gamerCoins > 0); //this isn't stonks if there's no monet bruh moment
    }



    public void work(){

        updateMoney(RNG.randRange(1,5) * RNG.randRange(1,2));
        updateEnergy(-(RNG.randRange(1,5) * RNG.randRange(1,3)));


    }

    public void buy(){

        updateFood((int)(RNG.randRange(1,4) * RNG.randRange(1.0,2.0)));
        updateMoney(RNG.randRange(-5,-1) * RNG.randRange(1,2));
        updateEnergy(RNG.randRange(-4,-1) * RNG.randRange(1,3));

    }

    public void vidyagaem(){

        updateUrge(RNG.randRange(-5,-1) * RNG.randRange(1,5));
        updateEnergy(RNG.randRange(-5,-2) * RNG.randRange(1,3));
        urgeScale = 0;

    }

    public void eat(){
        updateFood(-1);
        updateEnergy(RNG.randRange(1,5) * RNG.randRange(1,5));

    }

    public void updateUrge(double urgeChange){
        urgeToSayTheGamerWord += urgeChange;
        if (urgeToSayTheGamerWord < 0){
            urgeToSayTheGamerWord = 0;
        } else if (urgeToSayTheGamerWord > 100){
            urgeToSayTheGamerWord = 100;
        }
    }

    public void updateUrge(){
        urgeToSayTheGamerWord *= (1 + urgeScale);
        urgeScale += 0.1;
        updateUrge(1);
    }

    public void updateMoney (int moneyChange){
        gamerCoins += moneyChange;
        if (gamerCoins < 0){
            gamerCoins = 0;
        }
    }

    public void updateFood (int foodChange){
        food += foodChange;
        if (food < 0){
            food = 0;
        }
    }

    public void updateEnergy (double energyChange){
        energy += energyChange;
        if (energy < 0){
            energy = 0;
        }
    }

    public void itsBeenOneMinute(){
        minutesSinceSayingGamerWord += 1;
        if (minutesSinceSayingGamerWord > 1440){
            String message = "Congratulations!</p><p></p><p style='width: 400px;'>You have survived an entire day of not saying the Gamer Word! Unfortunately, as the theme for this game jam was 'A day in the life', " +
                    "you're kinda not supposed to survive for more than a day. Therefore, I have taken the liberty of resetting the time you have survived for to 0 minutes.</p>" +
                    "<p></p><p>You are welcome. ^_^</p>";
            JOptionPane.showMessageDialog(frame,
                    "<html><body><p style='width: 400px;'>"+message+"</p></body></html>",
                    "congrats",
                    JOptionPane.ERROR_MESSAGE);
            minutesSinceSayingGamerWord = 0;
            //its only one day in the life ecks dee
        }
    }

    public double getUrge() {
        return urgeToSayTheGamerWord;
    }

    public int getMoney() {
        return gamerCoins;
    }

    public int getFood() {
        return food;
    }

    public double getEnergy() {
        return energy;
    }

    public String getName() {
        return gamertag;
    }

    public String whatGender(){
        if (gender == 0){
            return "Gamer";
        } else{
            return "Political";
        }
    }

    public void setName(String name){
        this.gamertag = name;
    }

    public int timeSurvived(){
        return minutesSinceSayingGamerWord;
    }

    public String stringTimeSurvived(){
        return String.valueOf(minutesSinceSayingGamerWord);
    }

    @Override
    public String toString() {
        String whatHappen = gamertag + ", the bravest " + whatGender() + " of all time, lived in a society for "+ minutesSinceSayingGamerWord +" minutes before saying 'Ploopy'. Fs in chat";
        return whatHappen;
    }
}
