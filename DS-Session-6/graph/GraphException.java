package graph;

/**
 * This is custom Exception class for Graph
 * @author Ishita_Mathur
 *
 */
@SuppressWarnings("serial")
public class GraphException extends Exception
{
	private String message;

	public GraphException(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}
}