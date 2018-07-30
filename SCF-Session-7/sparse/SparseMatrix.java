package sparse;
/**
 * Computes operation on sparse matrix like transpose, checks symmetric, computes addition and multiply
 * 
 * @author Ishita Mathur
 *
 */
public final class SparseMatrix 
{
	/*Stores the compact matrix*/
	private final int[][] compactMatrix;
	private final int matrixSize, dimensionCol, dimensionRow;
	
	/**
	 * Returns the size of compact matrix
	 * @param matrix
	 * @return size of matrix
	 */
	private int getSize(int[][] matrix) 
	{
		int count = 0;
		for (int row = 0; row < matrix.length; row++)
		{
			for (int col = 0; col < matrix[0].length; col++)
			{
				if (matrix[row][col] != 0)
					count++;
			}
		}
		return count;
	}
	
	/**
	 * Stores the original matrix in compact matrix which does not have zero
	 * @param matrix
	 */
	public SparseMatrix(int[][] matrix)
	{
		if (matrix.length == 0)
			throw new AssertionError("input matrix is null");
		
		int index = 0;
		matrixSize = getSize(matrix);
		compactMatrix = new int[3][matrixSize];
		dimensionRow = matrix.length;
		dimensionCol = matrix[0].length;
		
		for (int row = 0; row < matrix.length; row++)
		{
			for (int col = 0; col < matrix[0].length; col++)
			{
				if (matrix[row][col] != 0)
				{
					compactMatrix[0][index] = row;
					compactMatrix[1][index] = col;
					compactMatrix[2][index] = matrix[row][col];
					index++;
				}
			}
		}
	}

	/**
	 * converts back compact matrix to sparse matrix
	 * @param compactArray
	 * @param row
	 * @param col
	 * @return sparse matrix
	 */
	private int[][] convertToSparse(int[][] compactArray, int row, int col)
	{
		int[][] sparseArray = new int[row][col];
		
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				sparseArray[i][j] = 0;
			}
		}
		
		for (int i = 0; i < compactArray[0].length; i++)
		{
			sparseArray[compactArray[0][i]][compactArray[1][i]] = compactArray[2][i];
		}
		return sparseArray;
	}
	
	/**
	 * sorts the transpose matrix in increasing order if row and column
	 * @param transposeMatrix
	 */
	private void sort(int[][] transposeMatrix) 
	{
		int temp;
		
		for (int i = 0; i < transposeMatrix[0].length; i++)
		{
			for (int j = i + 1; j < transposeMatrix[0].length; j++)
			{
				if (transposeMatrix[0][i] > transposeMatrix[0][j])
				{
					temp = transposeMatrix[0][i];
					transposeMatrix[0][i] = transposeMatrix[0][j];
					transposeMatrix[0][j] = temp;

					temp = transposeMatrix[1][i];
					transposeMatrix[1][i] = transposeMatrix[1][j];
					transposeMatrix[1][j] = temp;

					temp = transposeMatrix[2][i];
					transposeMatrix[2][i] = transposeMatrix[2][j];
					transposeMatrix[2][j] = temp;

				}
				
				else
				{
					if (transposeMatrix[0][i] == transposeMatrix[0][j])
					{
						if (transposeMatrix[1][i] > transposeMatrix[1][j])
						{
							temp = transposeMatrix[0][i];
							transposeMatrix[0][i] = transposeMatrix[0][j];
							transposeMatrix[0][j] = temp;

							temp = transposeMatrix[1][i];
							transposeMatrix[1][i] = transposeMatrix[1][j];
							transposeMatrix[1][j] = temp;

							temp = transposeMatrix[2][i];
							transposeMatrix[2][i] = transposeMatrix[2][j];
							transposeMatrix[2][j] = temp;
						}
					}
				}
			}
		}
	}
	
	/**
	 * computes transpose of matrix
	 * @return sparse matrix
	 */
	public int[][] getTranspose()
	{
		int[][] transposeMatrix;
		transposeMatrix = new int[3][matrixSize];
		
		for (int index = 0; index < matrixSize; index++)
		{
			transposeMatrix[0][index] = compactMatrix[1][index];
			transposeMatrix[1][index] = compactMatrix[0][index];
			transposeMatrix[2][index] = compactMatrix[2][index];
		}
		sort(transposeMatrix);
		
		return convertToSparse(transposeMatrix, dimensionCol, dimensionRow);
	}
	 
	/**
	 * checks if a matrix is symmetric
	 * @return true or false
	 */
	public boolean isSymmetric()
	{
		int[][] transposeMatrix = new int[3][matrixSize];
		
		if (this.dimensionRow != this.dimensionCol)
			return false;
		
		for (int index = 0; index < matrixSize; index++)
		{
			transposeMatrix[0][index] = compactMatrix[1][index];
			transposeMatrix[1][index] = compactMatrix[0][index];
			transposeMatrix[2][index] = compactMatrix[2][index];
		}
		sort(transposeMatrix);
		
		for (int i = 0; i < transposeMatrix[0].length; i++)
		{
			if (transposeMatrix[0][i] != compactMatrix[0][i]
					|| transposeMatrix[1][i] != compactMatrix[1][i]
					|| transposeMatrix[2][i] != compactMatrix[2][i])
				return false;
		}
		return true;
	}

	/**
	 * computes multiplication of two matrix
	 * @param firstMatrix
	 * @param secondMatrix
	 * @return multiplied matrix
	 */
	public int[][] multiplyMatrix(SparseMatrix firstMatrix, SparseMatrix secondMatrix)
	{
		int[][] multiplyMatrix = new int[firstMatrix.dimensionRow][secondMatrix.dimensionCol];
		
		if(firstMatrix.dimensionCol != secondMatrix.dimensionRow || firstMatrix.dimensionRow != secondMatrix.dimensionCol)
			throw new AssertionError("can't multiply matrix dimension mismatch");
		
		for (int i = 0; i < firstMatrix.dimensionRow; i++)
		{
			for (int j = 0; j < secondMatrix.dimensionCol; j++)
			{
				multiplyMatrix[i][j] = 0;
			}
		}
		
		for (int i = 0; i < firstMatrix.compactMatrix[0].length; i++)
		{
			for (int j = 0; j < secondMatrix.compactMatrix[0].length; j++)
			{
				if (firstMatrix.compactMatrix[1][i] == secondMatrix.compactMatrix[0][j])
					multiplyMatrix[firstMatrix.compactMatrix[0][i]][secondMatrix.compactMatrix[1][j]] += (firstMatrix.compactMatrix[2][i] * secondMatrix.compactMatrix[2][j]);
			}
		}
		return multiplyMatrix;
	}
	
	/**
	 * computes addition of two matrix
	 * @param s
	 * @return sum of two matrix in sparse form
	 */
	public int[][] addMatrix(SparseMatrix sparse)
	{
		int sumMatrixSize = this.matrixSize + sparse.matrixSize;
		int[][] sumMatrix = new int[3][sumMatrixSize];
		int index1 = 0, index2 = 0, indexSum = 0;
		
		while (index1 < this.matrixSize && index2 < sparse.matrixSize)
		{
			if (this.compactMatrix[0][index1] < sparse.compactMatrix[0][index2])
			{
				sumMatrix[0][indexSum] = this.compactMatrix[0][index1];
				sumMatrix[1][indexSum] = this.compactMatrix[1][index1];
				sumMatrix[2][indexSum] = this.compactMatrix[2][index1];
				indexSum++;
				index1++;
			}
			
			else if (this.compactMatrix[0][index1] > sparse.compactMatrix[0][index2])
			{
				sumMatrix[0][indexSum] = sparse.compactMatrix[0][index2];
				sumMatrix[1][indexSum] = sparse.compactMatrix[1][index2];
				sumMatrix[2][indexSum] = sparse.compactMatrix[2][index2];
				indexSum++;
				index2++;
			}
			
			else
			{
				if (this.compactMatrix[1][index1] < sparse.compactMatrix[1][index2])
				{
					sumMatrix[0][indexSum] = this.compactMatrix[0][index1];
					sumMatrix[1][indexSum] = this.compactMatrix[1][index1];
					sumMatrix[2][indexSum] = this.compactMatrix[2][index1];
					indexSum++;
					index1++;
				}
				
				else if (this.compactMatrix[1][index1] > sparse.compactMatrix[1][index2])
				{
					sumMatrix[0][indexSum] = sparse.compactMatrix[0][index2];
					sumMatrix[1][indexSum] = sparse.compactMatrix[1][index2];
					sumMatrix[2][indexSum] = sparse.compactMatrix[2][index2];
					indexSum++;
					index2++;
				}
				
				else
				{
					sumMatrix[0][indexSum] = sparse.compactMatrix[0][index2];
					sumMatrix[1][indexSum] = sparse.compactMatrix[1][index2];
					sumMatrix[2][indexSum] = this.compactMatrix[2][index1]
							+ sparse.compactMatrix[2][index2];
					indexSum++;
					index1++;
					index2++;
				}
			}
		}
		
		while (index1 < this.matrixSize)
		{
			sumMatrix[0][indexSum] = this.compactMatrix[0][index1];
			sumMatrix[1][indexSum] = this.compactMatrix[1][index1];
			sumMatrix[2][indexSum] = this.compactMatrix[2][index1];
			indexSum++;
			index1++;
		}
		
		while (index2 < sparse.matrixSize)
		{
			sumMatrix[0][indexSum] = sparse.compactMatrix[0][index2];
			sumMatrix[1][indexSum] = sparse.compactMatrix[1][index2];
			sumMatrix[2][indexSum] = sparse.compactMatrix[2][index2];
			indexSum++;
			index2++;
		}
		return convertToSparse(sumMatrix, dimensionRow, dimensionCol);
	}
}