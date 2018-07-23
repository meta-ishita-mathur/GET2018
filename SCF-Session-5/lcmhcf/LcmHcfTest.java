package lcmhcf;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcmHcfTest 
{
	LcmHcf lcmHcfObject = new LcmHcf();
	
	@Test
	public void lcmTest() 
	{
		int lcmOutput = lcmHcfObject.lcm(24, 60);
		assertEquals(120, lcmOutput);
		
		int hcfOutput = lcmHcfObject.hcf(24, 60);
		assertEquals(12, hcfOutput);

	}
	
	@org.junit.Test(expected = AssertionError.class)
	public void testExceptionLcm()
	{
		int lcmOutput = lcmHcfObject.lcm(-2, 0);
		assertEquals(0, lcmOutput);
	}
	
	@Test(expected = AssertionError.class)
	public void testExceptionHcf()
	{
		int hcfOutput = lcmHcfObject.hcf(0, 0);
		assertEquals(0, hcfOutput);
	}

}
