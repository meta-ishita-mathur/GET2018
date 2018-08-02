package dataSructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStack
{
	ArrayImplementationOfStack stackUsingArray = new ArrayImplementationOfStack(5);
	LinkedListImplementationOfStack stackUsingLinkedList = new LinkedListImplementationOfStack();
	
	@Test
	public void testPushArray()
	{
		stackUsingArray.push(3);
		stackUsingArray.push(6);
		assertEquals(6, stackUsingArray.peek());
	}
	
	@Test
	public void testPopArray()
	{
		stackUsingArray.push(3);
		stackUsingArray.push(6);
		assertEquals(6, stackUsingArray.pop());
		assertEquals(3, stackUsingArray.peek());
	}
	
	@Test
	public void testPushArrayIfFull()
	{
		try
		{
			stackUsingArray.push(3);
			stackUsingArray.push(6);
			stackUsingArray.push(5);
			stackUsingArray.push(7);
			stackUsingArray.push(2);
			stackUsingArray.push(9);
		}
		
		catch(AssertionError e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void testPopAllArray()
	{
		try{
		stackUsingArray.push(3);
		stackUsingArray.push(6);
		stackUsingArray.pop();
		stackUsingArray.pop();
		stackUsingArray.pop();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}
	
	@Test
	public void testPeekEmptyArray()
	{
		try{
		stackUsingArray.push(3);
		stackUsingArray.push(6);
		stackUsingArray.pop();
		stackUsingArray.pop();
		stackUsingArray.peek();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}
	
	@Test
	public void testPushLinkedList()
	{
		stackUsingLinkedList.push(3);
		stackUsingLinkedList.push(6);
		assertEquals(6, stackUsingLinkedList.peek());
	}
	
	@Test
	public void testPopLinkedList()
	{
		stackUsingLinkedList.push(3);
		stackUsingLinkedList.push(6);
		assertEquals(6, stackUsingLinkedList.pop());
		assertEquals(3, stackUsingLinkedList.peek());
	}
	
	@Test
	public void testPopAllLinkedList()
	{
		try
		{
			stackUsingLinkedList.push(3);
			stackUsingLinkedList.push(6);
			stackUsingLinkedList.pop();
			stackUsingLinkedList.pop();
			stackUsingLinkedList.pop();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}
	
	@Test
	public void testPeekEmptyLinkedList()
	{
		try
		{
			stackUsingLinkedList.push(3);
			stackUsingLinkedList.push(6);
			stackUsingLinkedList.pop();
			stackUsingLinkedList.pop();
			stackUsingLinkedList.peek();
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}	
	}
}