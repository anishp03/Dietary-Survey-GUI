import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * The FileHandler allows outputting of the survey results file. This file records
 * the data given by the users when they press the submit button.
 */
public class FileHandler {

	private String surveyFile; 
	private FileWriter fileOutput;
	PrintWriter printWriter;
	
	/*
	 * Creates the output file and prints the header
	 */
	public FileHandler()
	{
		surveyFile = "survey_results.csv";
		try {
			fileOutput = new FileWriter(surveyFile, true);//true allows apending the document
		} catch (IOException e) {
			e.printStackTrace();
		}
		printWriter = new PrintWriter(fileOutput);//wrapped FileWriter with PrintWriter
		
		printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight");
	}
	
	/*
	 * Writes the results onto the output file using the imported String parameter from the calling method
	 */
	public void writeResults(String surveyData)
	{
		printWriter.println(surveyData);
		printWriter.flush();//forces print writer to print right after getting the data, instead of holding data in memory
		
	}
	
}
