package sparse;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseTest 
{
	SparseMatrix sparse = new SparseMatrix(new int[][]{{0, 0, 0, 1}, 
            {0, 0, 1, 0}, 
            {0, 2, 0, 0}, 
            {0, 0, 3, 0}, 
            {0, 0, 5, 0}});
	
	@Test
	public void transposeTest() 
	{
		int[][] transpose = sparse.getTranspose();
		assertArrayEquals(new int[][]{{0, 0, 0, 0, 0},
				{0, 0, 2, 0 ,0}, 
				{0, 1, 0, 3, 5}, 
				{1, 0, 0, 0, 0}}, transpose);
		 
	}
	
	@Test
	public void addTest() 
	{
		SparseMatrix firstObject = new SparseMatrix(new int[][]{{0, 0, 0, 2},
	            {0, 0, 2, 0}, 
	            {0, 2, 1, 0}, 
	            {1, 0, 3, 0}, 
	            {1, 0, 5, 0}});
		int[][] add = sparse.addMatrix(firstObject);
		assertArrayEquals(new int[][]{{0, 0, 0, 3},
				{0, 0, 3, 0},
				{0, 4, 1, 0},
				{1, 0, 6, 0},
				{1, 0, 10, 0}}, add);
	}
	
	@Test
	public void multiplyTest()
	{
		SparseMatrix firstObject = new SparseMatrix(new int[][]{{0, 0, 0, 2},
	            {0, 0, 2, 0},
	            {0, 2, 1, 0},
	            {1, 0, 3, 0}});
		
		SparseMatrix secondObject = new SparseMatrix(new int[][]{{0, 0, 0, 1},
	            {0, 0, 1, 0},
	            {0, 2, 0, 0},
	            {0, 0, 3, 0}});
		
		int[][] multiply = sparse.multiplyMatrix(firstObject, secondObject);
		assertArrayEquals(new int[][]{{0, 0, 6, 0},
				{0, 4, 0, 0},
				{0, 2, 2, 0},
				{0, 6, 0, 1}}, multiply);
	}
	
	@Test
	public void symmetricFalseTest()
	{
		SparseMatrix sparse = new SparseMatrix(new int[][]{{0, 0, 0, 1},
	            {0, 0, 1, 0},
	            {0, 2, 0, 0},
	            {0, 0, 3, 0},
	            {0, 0, 5, 0}});
		
		boolean symmetric = sparse.isSymmetric();
		assertEquals(false, symmetric);
	}
	
	@Test
	public void symmetricTrueTest()
	{
		SparseMatrix sparse = new SparseMatrix(new int[][]{{0, 0, 0, 1},
	            {0, 0, 2, 0},
	            {0, 2, 0, 3},
	            {1, 0, 3, 0}});
		
		boolean symmetric = sparse.isSymmetric();
		assertEquals(true, symmetric);
	}
	
	@Test(expected = AssertionError.class)
	public void emptyMatrix()
	{
		SparseMatrix sparse = new SparseMatrix(new int[][]{});
	}
	
	@Test(expected = AssertionError.class)
	public void cantMultiply()
	{
		SparseMatrix firstObject = new SparseMatrix(new int[][]{{0, 0, 6, 0},
				{0, 4, 0, 0},
				{0, 2, 2, 0},
				{0, 6, 0, 1}});
		int[][] multiply = sparse.multiplyMatrix(firstObject, sparse);
	}
}