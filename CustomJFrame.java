import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

/*
 * Uses the JFrame class to create its own frame when the constuctor is called in the main file.
 * This class is the main code of the whole program that runs all of the option the users have too 
 * using the action listener.
 */
public class CustomJFrame extends JFrame {
	
	//initializing all labels
	private JLabel headingLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel phoneNumberLabel;
	private JLabel emailLabel;
	private JLabel genderLabel;
	private JLabel dietaryLabel;
	private JLabel waterLabel;
	private JLabel mealsLabel;
	private JLabel checkBoxLabel;
	private JLabel walkLabel;
	private JLabel weightLabel;
	
	//initializing all text fields
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField emailTextField;
	
	//radio button group where you can only pick 1 option
	private JRadioButton maleRadioButton; 
	private JRadioButton femaleRadioButton; 
	private JRadioButton preferRadioButton;
	private ButtonGroup radioButtonGroup;

	//a little number iterator starting at 15 and you can move up or down
	private JSpinner waterIntakeSpinner;
	
	//slider with a number line below it represeting the slider values
	private JSlider mealSlider;
	
	//multiple choice check box, you can select multiple check boxes
	private JCheckBox wheatCheckBox;
	private JCheckBox sugarCheckBox;
	private JCheckBox dairyCheckBox;
	
	//clicking it bring down a choice of options written below, and you can only choose one
	private String[] walkOptions = {"Less than 1 Mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles", "More than 3 miles"};
	private JComboBox walkComboBox;
	
	//formatted text field to only take integers
	private JFormattedTextField weightFormattedTextField;
	
	//utility buttons
	private JButton clearButton;
	private JButton submitButton;
	
	//allows printing out to output file
	private FileHandler fileHandler = new FileHandler();
	
	/*
	 * This constructor uses the variabels initialized previously and organizes them 
	 * into a frame using the GridBag layout manager. The constructor also uses the 
	 * GridBagConstrints to organize an aesthetically pleasing GUI.
	 */
	public CustomJFrame()
	{
		//gbc is how you can specify where you want components in a GUI using GridBag layout manager
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);//constructs margins for the components
        gbc.anchor = GridBagConstraints.NORTHWEST;// alligns the components to the north west corner
        
        //this key word creates the frame when this constructor is called
		this.setLayout(new GridBagLayout());//specifys using GridBag
		this.setTitle("Dietary Survey");
		
		/*
		 * the following lines of code will be creating and positioning all components
		 * of the GUI. The order is label then input field, so for each label below the next 
		 * component listed will be its pairing input field.
		 */
	
		//Subheading 1 label
		headingLabel = new JLabel("Personal Information");
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(headingLabel, gbc);
		
		//first name label
		firstNameLabel = new JLabel("First Name: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(firstNameLabel, gbc); 
		
		//first name text field
		firstNameTextField = new JTextField(20); 
		gbc.gridx = 1;
		gbc.gridx = 1; 
		this.add(firstNameTextField, gbc); 

		//last name label
		lastNameLabel = new JLabel("Last Name: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lastNameLabel, gbc);
		
		//last name text field
		lastNameTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(lastNameTextField, gbc);
		
		//phone number label
		phoneNumberLabel = new JLabel("Phone Number: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(phoneNumberLabel, gbc);
		
		//phone number text field
		phoneNumberTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 3;
		this.add(phoneNumberTextField, gbc);
		
		//email label
		emailLabel = new JLabel("Email: ");
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(emailLabel, gbc);
		
		//email text field
		emailTextField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 4;
		this.add(emailTextField, gbc);
		
		//gender label
		genderLabel = new JLabel("Sex: ");
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(genderLabel, gbc);
		
		//gender input fields
		maleRadioButton = new JRadioButton("Male");
		gbc.gridx = 1;
		gbc.gridy = 5;
		this.add(maleRadioButton, gbc);
		femaleRadioButton = new JRadioButton("Female");
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.add(femaleRadioButton, gbc);
		preferRadioButton = new JRadioButton("Prefer not to say");
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(preferRadioButton, gbc);
		
		//creates a radio button group to ensure only one input is selected for gender
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		
		//Subheading 2 label
		dietaryLabel = new JLabel("Dietary Questions");
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(dietaryLabel, gbc);
		
		//water intake label
		waterLabel = new JLabel("How many cups of water on average do you drink a day?");
		gbc.gridx = 0;
		gbc.gridy = 9;    
		gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
		this.add(waterLabel, gbc);
		
		//water intake input method
		waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));
		gbc.gridx = 0;
        gbc.gridy = 10;
		this.add(waterIntakeSpinner, gbc);
		
		//meals quetstion label
		mealsLabel = new JLabel("How many meals on average do you eat per day?");
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(mealsLabel, gbc);
		
		//meals question input method
		mealSlider = new JSlider(0, 10, 3);
		gbc.gridx = 0;
		gbc.gridy = 12;
		//configues the slider to show a number representation below the slider values
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintLabels(true);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setMinorTickSpacing(1);
		this.add(mealSlider, gbc);
		
		//check box question label
		checkBoxLabel = new JLabel("Do any of these meals regularly contain: ");
		gbc.gridx = 0;
		gbc.gridy = 13;
		this.add(checkBoxLabel, gbc);
		
		//check boxes input methods organized neatly in accordance to the rest of the components
		wheatCheckBox = new JCheckBox("Wheat", false);
		sugarCheckBox = new JCheckBox("Sugar", false);
		dairyCheckBox = new JCheckBox("Dairy", false);
		
		JPanel checkBoxes = new JPanel();
		checkBoxes.add(wheatCheckBox);
		checkBoxes.add(sugarCheckBox);
		checkBoxes.add(dairyCheckBox);
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.gridwidth = 3; 
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(checkBoxes, gbc);
		
		//walking question label
		walkLabel = new JLabel("On average, how many miles do you walk in a day?");
		gbc.gridx = 0;
		gbc.gridy = 15;
		this.add(walkLabel, gbc);
		
		//walking question input method
		walkComboBox = new JComboBox(walkOptions);
		gbc.gridx = 0;
		gbc.gridy = 16;
		this.add(walkComboBox, gbc);
		
		//weight question label
		weightLabel = new JLabel("How much do you weigh?");
		gbc.gridx = 0;
		gbc.gridy = 17;
		this.add(weightLabel, gbc);
		
		//weight question input method
		//The number formatter ensures that the FormattedTextField can only take integers
		//it will not let the user type in numbers in this field
        NumberFormatter integerFormat = new NumberFormatter(NumberFormat.getIntegerInstance());
        integerFormat.setAllowsInvalid(false);//specifys nothing but integers
		weightFormattedTextField = new JFormattedTextField(integerFormat); 
		weightFormattedTextField.setColumns(15);
		gbc.gridx = 0;
		gbc.gridy = 18;
		this.add(weightFormattedTextField, gbc);
		
		//creates instance of the listener to instruct the submit and clear buttons to act accordingly
		InnerActionListener listener = new InnerActionListener();
		
		//clear button that clears all input field without printing the inputs into the output file
		clearButton = new JButton("Clear");
		clearButton.setBackground(Color.YELLOW);
		clearButton.setBorderPainted(false);
        clearButton.setOpaque(true);
        clearButton.addActionListener(e -> listener.clearForm());//calls clear form instead of the actionPreformed
		gbc.gridy = 19; 
		gbc.anchor = GridBagConstraints.SOUTHWEST; 
		this.add(clearButton, gbc);

		//submit button that clears the form and also submits the user answers to the output form
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.GREEN);
		submitButton.setBorderPainted(false);
        submitButton.setOpaque(true);
        submitButton.addActionListener(listener);//by default actionPreformed is called
		gbc.gridy = 19; 
		gbc.anchor = GridBagConstraints.SOUTHEAST; 
		this.add(submitButton, gbc);

		//sets the defult settings of the frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
        this.setSize(this.getWidth() + 40, this.getHeight() + 40);
		this.setVisible(true);
	}
	
	/*
	 * The InnerActionListener is a custom action listener class that implements the 
	 * java given ActionListener class. The goal of this class is to program the actions that occur
	 * when the user presses the submit or cear button.
	 */
	public class InnerActionListener implements ActionListener{

		/*
		 * This is the what happens when the user presses the submit button. The 
		 * class records all of the values entered by the user and creates a comma 
		 * seperated string to call the FileHandler writeData method on. Doing this
		 * prints the user data onto the  survey results file, then the form is cleared 
		 * using clearForm() to prepare for the next user.
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//gets data from text fields
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			String email = emailTextField.getText();
			String sex = null; 
			
			//checks which radio button is selected
			if(maleRadioButton.isSelected())
			{
				sex = maleRadioButton.getText();
			}
			else if (femaleRadioButton.isSelected())
			{
				sex = femaleRadioButton.getText();
			}
			else if (preferRadioButton.isSelected())
			{
				sex = preferRadioButton.getText();
			}
			
			//changes spinner value into a string to print out with rest of data
			String waterIntake = String.valueOf(waterIntakeSpinner.getValue());
			
			//changes the slider value into a string to print out with rest of data
			String meals = String.valueOf(mealSlider.getValue());
			
			//sets each data value to false before checking for which one is checked off by the user
			String wheat = "FALSE";
			String sugar = "FALSE";
			String dairy = "False";
			if(wheatCheckBox.isSelected()) { wheat = "TRUE"; }//if a value is selscted then the string is set to TRUE
			if(sugarCheckBox.isSelected()) { sugar = "TRUE"; }
			if(dairyCheckBox.isSelected()) { dairy = "TRUE"; }
			
			//changes the ComboBox value into a string to print out with rest of data
			String miles = String.valueOf(walkComboBox.getSelectedItem());
			
			//changes the integer data from weight into a string to print out with rest of the data
			String weight = String.valueOf(weightFormattedTextField.getValue());
			
			//gets the current date when the user submitted the form to print with survey results
			Date current = new Date();
			SimpleDateFormat newFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			String currentDate = newFormat.format(current);
			 
			//comma seperated string that is sent to fileHandler to print the data into the output file
			String data = currentDate + "," + firstName + "," + lastName + "," + phoneNumber + "," + email + "," + sex + "," + waterIntake + "," + meals + "," + wheat + "," + sugar + "," + dairy + "," + miles + "," + weight; 
			
			fileHandler.writeResults(data);
			
			clearForm(); 
		}
		
		/*
		 * When the method is called, it clears all text fields and MCQ choices 
		 * to prepare for a new user
		 */
		private void clearForm()
		{
			//uses respective clear methods for wach type of input method
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			emailTextField.setText("");
			phoneNumberTextField.setText("");
			radioButtonGroup.clearSelection();
			waterIntakeSpinner.setValue(15);
			mealSlider.setValue(3);
			wheatCheckBox.setSelected(false);
			sugarCheckBox.setSelected(false);
			dairyCheckBox.setSelected(false);
			walkComboBox.setSelectedItem(walkOptions[0]);
			weightFormattedTextField.setValue(null);
		}
		
	}
	
}
