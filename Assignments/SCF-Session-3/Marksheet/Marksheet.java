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

	/**
	 * Finds average grade of all students.
	 * @return average that is average grade of all students
	 */
	
	public void checkInput(float[] grade, int totalStudents)
	{
		if(totalStudents < 0)
			throw new AssertionError("Enter positive number");
		
		for(int i = 0; i < totalStudents; i++)
		{
			if(grade[i] < 0)
				throw new AssertionError("Enter positive number");
		}
	}
	public float avgGrade(float[] grade, int totalStudents)
	{
		int i;
		float totalScore = 0, average;
		checkInput(grade, totalStudents);
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
	public float maxGrade(float[] grade, int totalStudents)
	{
		float max = 0;
		int i;
		checkInput(grade, totalStudents);
		
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
	public float minGrade(float[] grade, int totalStudents)
	{
		float min = grade[0];
		checkInput(grade, totalStudents);
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
	public float studentsPass(float[] grade, int totalStudents)
	{
		float totalPass = 0, percentPass;
		checkInput(grade, totalStudents);
			
		for(int i = 0; i < totalStudents; i++)
		{
			if(grade[i] >= 40)
				totalPass++;
		}
			
		percentPass = (totalPass / totalStudents) * 100;
		return percentPass;
	}
}
