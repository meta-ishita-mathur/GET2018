package counsellingProcess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataSructure.Queue;
import dataSructure.LinkedListImplementationOfQueue;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * this class is used to implement the counselling process of a college
 * @author Ishita_Mathur
 */
public class CounsellingProcess
{
	/**
	 * this method creates an excel sheet containing the student names along with the name of program allocated to them
	 * programs are allocated based on the preference of students and the capacity of the programs
	 * @param studentListSheet location of the excel file containing the list of students along with their preferences
	 * @param programListSheet location of the excel sheet containing the list of programs along with their capacity
	 * @param noOfStudents
	 * @param noOfPrograms
	 * @return a map containing the allocated programs for each student
	 */
	public static Map<String, String> allotProgramToStudents(String studentListSheet, String programListSheet, int noOfStudents, int noOfPrograms) 
	{
		Map<String, String> allocationMap = new HashMap<String, String>(); //map to store the allocated program for each student

		if(studentListSheet == null || programListSheet == null)
			throw new AssertionError("Wrong input!");

		try {

			Workbook listOfPrograms = Workbook.getWorkbook(new java.io.File(programListSheet));
			Workbook listOfStudents = Workbook.getWorkbook(new java.io.File(studentListSheet));

			Map<String, Integer> programMap = new HashMap<>(); //map to store the program names and available capacities

			Sheet programSheet = listOfPrograms.getSheet(0);
			Sheet studentSheet = listOfStudents.getSheet(0);

			//reading data about the programs from excel sheet and storing into the map
			for(int i = 1; i <= noOfPrograms; i++)
			{
				programMap.put(programSheet.getCell("A" + i).getContents(), Integer.parseInt(programSheet.getCell("B" + i).getContents()));
			}

			Queue<Student> studentQueue = new LinkedListImplementationOfQueue<>(); //queue to store the list of students

			//reading data about the students from excel sheet and storing into the queue
			for(int i = 1; i <= noOfStudents; i++)
			{
				List<String> listOfPreference = new ArrayList<>();

				for(char j = 'B'; j <= 'F'; j++)
				{
					String colName = "" + j;
					listOfPreference.add(studentSheet.getCell(colName + i).getContents());
				}

				studentQueue.enqueue(new Student(studentSheet.getCell("A" + i).getContents(), listOfPreference));
			}

			//allocating programs to students and storing in allocation map
			for(int i = 1; i <= noOfStudents; i++)
			{
				Student student = studentQueue.dequeue();

				for(String preference: student.getListOfPreference())
				{
					int capacityOfProgram = programMap.get(preference);
					if(capacityOfProgram != 0)
					{
						student.setAllotedProgram(preference);
						programMap.put(preference, capacityOfProgram - 1);
						break;
					}
				}

				allocationMap.put(student.getName(), student.getAllotedProgram());

			}

			exportToXls(allocationMap); //creating the Excel file
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}

		return allocationMap; //return the allocation map
	}


	/**
	 * this method creates a new Excel file with the data present in the input map
	 * @param allocationMap
	 */
	public static void exportToXls(Map<String, String> allocationMap)
	{
		try
		{
			WritableWorkbook studentWorkbook = Workbook.createWorkbook(new File("studentWorkbook.xls")); //creating a new workbook
			WritableSheet studentWorkbookSheet = studentWorkbook.createSheet("sheet1", 0); //creating a new sheet

			//adding data to the newly created workbook
			for(int i = 1; i <= allocationMap.size(); i++)
			{                
				for(String studentName: allocationMap.keySet())
				{

					Label l1 = new Label(0, i, studentName);
					studentWorkbookSheet.addCell(l1);

					Label l2 = new Label(1, i, allocationMap.get(studentName));
					studentWorkbookSheet.addCell(l2);
				}

			}

			studentWorkbook.write();
			studentWorkbook.close();      
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}

	}

}
