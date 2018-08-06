package counsellingProcess;

import java.util.List;

/**
 * a class used to store information about a college student applying for a counselling program
 * @author Ishita_Mathur
 *
 */
public class Student 
{
	private final String name;
	private final List<String> listOfPreference;
	private String allotedProgram;

	public Student(String name, List<String> listOfPreference) {
		this.name = name;
		this.listOfPreference = listOfPreference;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getListOfPreference() {
		return listOfPreference;
	}
	
	public String getAllotedProgram() {
		return allotedProgram;
	}

	public void setAllotedProgram(String allotedProgram) {
		this.allotedProgram = allotedProgram;
	}

}
