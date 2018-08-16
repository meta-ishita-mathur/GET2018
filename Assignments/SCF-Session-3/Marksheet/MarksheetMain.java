package Marksheet;

import java.util.Scanner;

/**
 * Contains all the methods to calculate average, maximum &
 * minimum grades & the percent of students passed.
 *
 * @author Ishita_Mathur
 */
class Marksheet
{
	int totalStudents; //assume totalStudents > 0
	float[] grade; //assume grade >= 0.00 && grade <= 100.00
	
	public int getTotalStudents()
	{
		return totalStudents;
	}
	
	public void setTotalStudents(int totalStudents)
	{
		this.totalStudents = totalStudents;
	}
	
	public float[] getGrade()
	{
		return grade;
	}
	
	public void setGrade(float[] grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Finds average grade of all students.
	 * @return average that is average grade of all students
	 */
	public float avgGrade() throws ArithmeticException
	{
		int i;
		float totalScore = 0, average;
		for(i = 0; i < totalStudents; i++)
		{
			totalScore += grade[i];
		}
		average = totalScore / totalStudents;
		return average;
	}
	
	/**
	 * Finds maximum grade from all grades of students.
	 * @return max that is the maximum grade
	 */
	public float maxGrade() throws ArithmeticException
	{
		float max = 0;
		int i;
		for( i = 0; i < totalStudents; i++)
		{
			if(max < grade[i])
				max = grade[i];
		}
		return max;
	}
	
	/**
	 * Finds minimum grade from all grades of students.
	 * @return min that is the minimum grade
	 */
	public float minGrade() throws ArithmeticException
	{
		float min = grade[0];
		for(int i = 0; i < totalStudents; i++)
		{
			if(min > grade[i])
				min = grade[i];
		}
		return min;
	}
	
	/**
	 * Finds percentage of students that passed. Pass is grade>=40.
	 * @return percentPass that is the percentage of student passed
	 */
	public float studentsPass() throws ArithmeticException 
	{
		float totalPass = 0, percentPass;
		
		for(int i = 0; i < totalStudents; i++)
		{
			if(grade[i] >= 40)
				totalPass++;
		}
		
		percentPass = (totalPass / totalStudents) * 100;
		return percentPass;
	}
}
public class MarksheetMain 
{
	public static void main(String[] args)
	{
		int choice, totalStudents;
		float grade[];
		
		Scanner sc = new Scanner(System.in);
		Marksheet marksheet = new Marksheet();
		
		System.out.println("Enter the total number of students:");
		totalStudents = sc.nextInt();
		
		marksheet.setTotalStudents(totalStudents); 
		
		grade = new float[totalStudents];
		
		marksheet.setGrade(grade);
		
		System.out.println("Enter the grades of students:");
		for(int i = 0; i < totalStudents; i++)
		{
			grade[i] = sc.nextFloat();
		}
		
		do
		{
			System.out.print("MENU\n1. Average of all grades\n2. Maximum of all grades\n3. Minimum of all grades\n");
			System.out.print("4. Percentage of students passed\n5. Exit\nEnter your choice:");
			choice = sc.nextInt();
			
			try
			{
				switch(choice)
				{
					case 1: System.out.printf("Average is %.2f\n", marksheet.avgGrade()); //printing till two decimal places
						break;
						
					case 2: System.out.printf("Maximum is %.2f\n", marksheet.maxGrade());
						break;
						
					case 3: System.out.printf("Minimum is %.2f\n", marksheet.minGrade());
						break;
						
					case 4: System.out.printf("Percentage of pass student is %.2f\n", marksheet.studentsPass());
						break;
						
					case 5: break;
				
					default: System.out.println("Wrong input!! Try again!!");
				}
			}
			
			catch(ArithmeticException exception)
			{
				System.out.println("Arithmetic exception encountered");
			}		
		}while(choice != 5);
	}
}
