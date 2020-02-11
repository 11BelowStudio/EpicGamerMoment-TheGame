package pakij;

import javax.swing.*;

public class AttributeLabel extends JLabel {

    String labelText;

    public AttributeLabel(String attributeName){
        this.labelText = attributeName;
        this.setText(labelText);
    }

    public AttributeLabel(String attributeName, int value){
        this(attributeName);
        showValue(value);
    }

    public AttributeLabel(String attributeName, double value){
        this(attributeName);
        showValue(value);
    }

    public AttributeLabel(String attributeName, String value){
        this(attributeName);
        showValue(value);
    }

    public void showValue(int value){
        this.setText(labelText + value);
    }

    public void showValue(double value){
        this.setText(labelText + (String.format("%.2f",value)));
    }

    public void showValue(String value){
        this.setText(labelText + value);
    }
}
