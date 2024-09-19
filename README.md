# ConversionGUI

This Lab is similar to the Conversions Lab, but this time a Graphical User Interface is being used to capture user input, and display the output.  That means, the user will be using `JRadioButton` objects to select which conversion they want to do,  they will by typing the value they want to convert into a `JTextField` object (named `userEntry`), and they will see the result of the conversion on a `JLabel` object (named `resultText`).  Utilizing these objects changes how we write the code a little bit (we use dot notation to call `.getText()` and `.setText()` for example) , although the code to perform the mathematical conversions will stay the same.

Complete the `public List setConversionOptions()` method.  This method is used to write the text (Like Fahrenheit to Celsius for example) onto the `JRadioButton` objects.

Then, complete the `public void doConversion()` method.  Here is where you will check to see which `JRadioButton` has been selected, get the text from the `JTextField`, use it to perform the mathematical conversion, and write the result onto the `JLabel` object.