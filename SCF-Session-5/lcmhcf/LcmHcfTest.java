package lcmhcf;

import static org.junit.Assert.*;
import org.junit.Test;

public class LcmHcfTest 
{
	LcmHcf lcmHcfObject = new LcmHcf();
	
	@Test
	public void lcmTest() 
	{
		int lcmOutput = lcmHcfObject.leastCommonMultiple(24, 60);
		assertEquals(120, lcmOutput);
	}
	
	@Test
	public void hcfTest()
	{
		int hcfOutput = lcmHcfObject.highestCommonFactor(24, 60);
		assertEquals(12, hcfOutput);
	}
	
	@Test
	public void testExceptionLcm()
	{
		try
		{
			lcmHcfObject.leastCommonMultiple(-2, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Enter positive number", error.getMessage());
		}
	}
	
	@Test
	public void testExceptionHcf()
	{
		try
		{
			lcmHcfObject.highestCommonFactor(0, 0);
		}
		catch(AssertionError error)
		{
			assertEquals("Enter positive number", error.getMessage());
		}
	}
}
