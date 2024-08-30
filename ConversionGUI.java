import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ConversionGUI implements ActionListener {
    //declare instance variables
    JFrame mainFrame;
    JPanel mainPanel;
    JButton convertButton;
    List<String> conversionOptions;
    List<JRadioButton> radioButtons;
    ButtonGroup buttonGroup;
    JTextField userEntry;
    JLabel resultText;

/*
    This constructs the ConversionGUI object (the graphical user interface object
    that the user sees and interacts with)
 */
    public ConversionGUI()
    {
        //initialize the instance variables
        mainFrame = new JFrame("ConversionGUI");
        mainPanel = new JPanel();
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        conversionOptions = setConversionOptions();
        buttonGroup = new ButtonGroup();
        radioButtons = buildRadioButtons();
        userEntry = new JTextField();
        resultText = new JLabel();

        // position the GUI components
        mainPanel.setLayout(null);
        int x = 10;
        int y = 10;
        for (JRadioButton rbutton : radioButtons)
        {
            rbutton.setBounds(x,y,200,20);
            y += 20;
        }
        userEntry.setBounds(x,y,100,30);
        y += 30;

        convertButton.setBounds(x,y,100,30);
        y+= 30;

        resultText.setBounds(x,y,400,30);

        //add everything to the JPanel

        for(JRadioButton rbutton: radioButtons)
        {
            mainPanel.add(rbutton);
        }
        mainPanel.add(userEntry);
        mainPanel.add(convertButton);
        mainPanel.add(resultText);

        //add the mainPanel to the contentPane of the mainFrame
        mainFrame.getContentPane().add(mainPanel);

    }
    /*
        The buildRadioButtons() method makes a JRadioButton
        out of each item in the conversionOptions list, and adds the RadioButton to the
        RadioButton List.
     */
    private ArrayList buildRadioButtons()
    {
        ArrayList<JRadioButton> buttons = new ArrayList();
        for (String conversionOption: conversionOptions)
        {
            JRadioButton button = new JRadioButton(conversionOption);
            buttons.add(button);
            buttonGroup.add(button);
        }
        return buttons;
    }

    /*
    the getSelectedButton() method returns a reference to the button that is currently selected
    that way we can check which button is selected when doing a conversion.
  */
    public JRadioButton getSelectedButton()
    {
        for (JRadioButton rbutton: radioButtons)
        {
            if (rbutton.isSelected())
                return rbutton;
        }
        //if no radio button is selected
        return null;
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private void createAndShowGUI() {
        //Create and set up the window.
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Size and display the window.
        mainFrame.setSize(400,600);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        ConversionGUI gui = new ConversionGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });
    }
    /*
        this method is called when the convertButton is clicked.
     */
    public void actionPerformed(ActionEvent e)
    {
        try{
            doConversion();
        }
        catch(Exception ex)
        {
            resultText.setText("");
            userEntry.setText("");
        }

    }
    /*
    This method returns a list of the conversion options that will be implemented.
    The list of option names is used to build JRadioButtons in the GUI
    and is the option names are also used in the doConversion() method to identify
    which conversion to perform.
     */
    public List setConversionOptions()
    {
       List menuOfOptions =  Arrays.asList(
                "1. Celsius to Fahrenheit",
                "2. Fahrenheit to Celsius",
                "3. Feet to Meters",
                "4. Meters to Feet",
                "5. Ounces to Milliliters",
                "6. Milliliters to Ounces",
                "7.",
                "8.",
                "9.",
                "10"
        );
       return menuOfOptions;
    }
    public void doConversion()
    {
        if (getSelectedButton().getText().contains("1."))
        {
            String userText = userEntry.getText();
            double celsius = Double.parseDouble(userText);
            double fahrenheit = celsius * (9.0 / 5.0) + 32;
            resultText.setText(celsius + " degrees celsius is " + fahrenheit + " degrees fahrenheit");
            //you can also include html code to change the display of the text.  Try commenting out (adding // in front of) the line above, and un-commenting (removing the //) the line below.
            //resultText.setText(" degrees celsius is  degrees fahrenheit");
        }
        if (getSelectedButton().getText().contains("2."))
        {
            resultText.setText("converted");
        }
    }
}