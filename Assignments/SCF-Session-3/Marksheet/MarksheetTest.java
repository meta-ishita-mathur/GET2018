package Marksheet;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarksheetTest
{
	Marksheet object = new Marksheet();
	
	/**
	 * For n, i.e. number of students is negative
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testingNumberOfStudentsNegative()
	{
		object.checkInput(new float[] {20.0f, 30.0f, 40.0f}, -3);
	}

	/**
	 * For grades, i.e. if any of grade is negative
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void testingGradeNegative()
	{
		object.checkInput(new float[] {20.0f, -30.0f, 40.0f}, 3);
	}

	/**
	 * To calculate average of all grades
	 */
	@org.junit.Test
	public void testingAverageOfGrades()
	{
		float average = object.avgGrade(new float[] {20.0f, 30.0f, 40.0f}, 3);
		assertEquals(30.0, average, 0.1);
	}

	/**
	 * To calculate maximum of all grades
	 */
	@org.junit.Test
	public void testingMaximumOfGrades()
	{
		float result = object.maxGrade(new float[] {20.0f, 30.0f, 40.0f}, 3);
		assertEquals(40.0, result, 0.1);
	}

	/**
	 * To calculate minimum of all grades
	 */
	@org.junit.Test
	public void testingMinimumOfGrades()
	{
		float result = object.minGrade(new float[] {20.0f, 30.0f, 40.0f}, 3);
		assertEquals(20.0, result, 0.1);
	}

	/**
	 * To calculate percentage of students passed
	 */
	@org.junit.Test
	public void testingPassedPercentage()
	{
		float result = object.studentsPass(new float[] {20.0f, 30.0f, 40.0f}, 3);
		assertEquals(33.33, result, 0.1);
	}

}
