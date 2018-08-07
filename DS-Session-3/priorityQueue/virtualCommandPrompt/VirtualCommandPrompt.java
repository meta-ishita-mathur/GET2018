package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VirtualCommandPrompt {

	static List<Directory> listOfDirectory = new ArrayList<Directory>();
	static String path = ".\\";
	
	public static void virtualCommandPrompt()
	{
		Directory root = new Directory("R:", new Date());
		listOfDirectory.add(root);
		Scanner scanner = new Scanner(System.in);
		System.out.println("***Welcome to Virtual Command Prompt***");
		String signature = "R:\\";
		System.out.print(signature + ">");
		Directory currentDirectory = root;
		
		while(true)
		{
			String commandLine = scanner.nextLine();
			String[] commandWords = commandLine.split(" ");
			
			switch(commandWords[0])
			{
			
			case "mkdir" : Directory newDirectory = new Directory(commandWords[1], new Date());
						   listOfDirectory.add(newDirectory);
						   currentDirectory.getListOfSubDirectory().add(newDirectory);
						   System.out.print(signature + ">");
						   break;
						   
			case "cd"    : if(search(currentDirectory, commandWords[1]))
						   {
								for(Directory directory: listOfDirectory)
								{
									if(directory.getName().equals(commandWords[1]))
									{
										currentDirectory = directory;
										if(signature.charAt(signature.length() - 1) != '\\')
											signature += "\\";
										signature += currentDirectory.getName();
										break;
									}
								}
						   }
						   else
						   {
							   System.out.println(signature + "> No such directory exists");
						   }
						   System.out.print(signature + ">");
						   break;
						   
			case "bk"     : String[] directories = signature.split("\\\\");
							for(Directory directory: listOfDirectory)
							{
								if(directory.getName().equals(directories[directories.length - 2]))
									currentDirectory = directory;
							}
			                signature = "R:";
							for(int i = 1; i < directories.length - 1; i++)
							{
								signature += "\\" + directories[i];
							}
							System.out.print(signature + ">");
							break;
							
			case "ls"     : for(Directory subDirectory: currentDirectory.getListOfSubDirectory())
							{
								System.out.println(subDirectory.getDateOfCreation() + " " + subDirectory.getName());
							}
							System.out.println(currentDirectory.getListOfSubDirectory().size() + " Folder(s)");
							break;
							
			case "find"   : path = ".\\";
							String directoryPath = findPath(currentDirectory, commandWords[1]);
							if(directoryPath != null)
							{
								StringBuilder pathToFind = new StringBuilder(directoryPath);
								pathToFind.deleteCharAt(pathToFind.length() - 1);
								System.out.println(pathToFind);
							}
							else
								System.out.println(signature + ">Directory not found");
							System.out.print(signature + ">");
							break;
							
			case "tree"    :System.out.println(".");
							printTree(currentDirectory);
							break;
		
			case "exit"   : System.exit(0); 
				
			}
			
		}
		
		
	}
	
	public static boolean search(Directory currentDirectory, String directoryToBeSearched)
	{
		boolean found = false;
		
		if(currentDirectory.getName().equals(directoryToBeSearched))
		{
			found = true;
		}
		else
		{
			for(Directory directory: currentDirectory.getListOfSubDirectory())
			{
					if(search(directory, directoryToBeSearched))
					{
						found = true;
						break;
					}
			}
			
		}
		return found;
	}
	
	
	public static String findPath(Directory currentDirectory, String directoryToBeSearched)
	{
		boolean found = false;
		//System.out.println(currentDirectory.getName());
		if(currentDirectory.getName().equals(directoryToBeSearched))
		{
			found = true;
		}
		else
		{
			for(Directory directory: currentDirectory.getListOfSubDirectory())
			{
				path += directory.getName() + "\\";
				
				if(findPath(directory, directoryToBeSearched) != null)
				{
					found = true;
					break;
				}
				else
				{
					String[] directories = path.split("\\\\");
	                path = ".\\";
					for(int i = 1; i < directories.length - 2; i++)
					{
						path += "\\" + directories[i];
					}
				}
			}
			
		}
		
		if(found)
		{
			return path;
		}
		else 
			return null;
	}
	
	
	public static void printTree(Directory currentDirectory)
	{
		for(Directory subDirectory: currentDirectory.getListOfSubDirectory())
		{
			System.out.println("\u2514" + subDirectory.getName());
			printTree(subDirectory);
		}
		
	}
}
