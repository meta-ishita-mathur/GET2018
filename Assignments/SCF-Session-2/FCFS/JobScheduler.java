package FCFS;
import java.util.Scanner;

class FirstComeFirstServe 
{
	int arrivalTime = 0, burstTime = 1;
	public int[] findWaitingTime (int processes, int inputTimes[][])
	{
		int[] serviceTime, waitingTime;		
		serviceTime = new int[processes];
		serviceTime[0] = 0;
		waitingTime = new int[processes];
		waitingTime[0] = 0; //waiting time for first process is 0
		
		for(int i = 1; i < processes; i++)
		{
			if(inputTimes[i - 1][arrivalTime] <= serviceTime[i - 1])
				serviceTime[i] = serviceTime[i - 1] + inputTimes[i - 1][burstTime];
			else
				serviceTime[i] = inputTimes[i - 1][arrivalTime] + inputTimes[i - 1][burstTime];
			
			waitingTime[i] = serviceTime[i] - inputTimes[i][arrivalTime];
			
			if(waitingTime[i] < 0)
				waitingTime[i] = 0;
		}
		return waitingTime;
	}
	
	public int[] findTurnAroundTime (int processes, int inputTimes[][])
	{
		int[] turnAroundTime, waitingTime;
		turnAroundTime = new int[processes];
		waitingTime = findWaitingTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			turnAroundTime[i] = inputTimes[i][burstTime] + waitingTime[i];
		}
		
		return turnAroundTime;
	}
	
	public int[] findCompletionTime (int processes, int inputTimes[][])
	{
		int[] completionTime, turnAroundTime; 
		completionTime = new int[processes];
		turnAroundTime = findTurnAroundTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			completionTime[i] = turnAroundTime[i] + inputTimes[i][arrivalTime];
		}
		return completionTime;
	}
	
	public float findAvgWaitingTime (int processes, int inputTimes[][])
	{
		int totalWaitingTime = 0;
		float avgWaitingTime;
		int waitingTime[] = findWaitingTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			totalWaitingTime = totalWaitingTime + waitingTime[i];	
		}
		
		avgWaitingTime = totalWaitingTime/processes;
		return avgWaitingTime;
	}
	
	public int maxWaitingTime (int processes, int inputTimes[][])
	{
		int[] waitingTime;
		int max;
		
		waitingTime = findWaitingTime(processes, inputTimes);
		max = waitingTime[0];
		
		for(int i = 1; i < processes; i++)
		{
			if(max < waitingTime[i])
				max = waitingTime[i];
		}
		return max;
	}
	
	public int[][] sortArray(int processes, int inputTimes[][])
	{
		for(int i = 0; i < processes; i++)
		{
			for(int j = i; j < processes; j++)
			{
				if(inputTimes[i][arrivalTime] > inputTimes[j][arrivalTime])
				{
					int arrivalTemp = inputTimes[i][arrivalTime];
					inputTimes[i][arrivalTime] = inputTimes[j][arrivalTime];
					inputTimes[j][arrivalTime] = arrivalTemp;
					
					int burstTemp = inputTimes[i][burstTime];
					inputTimes[i][burstTime] = inputTimes[j][burstTime];
					inputTimes[j][burstTime] = burstTemp;
				}
			}
		}
		return inputTimes;
	}
}

public class JobScheduler 
{
	public static void main(String[] args)
	{
		int[][] inputTimes;
		int[] completionTime, waitingTime, turnAroundTime;
		float avgWaitingTime;
		int max, processes, fixColumn = 2;
		
		Scanner sc = new Scanner(System.in);	
		FirstComeFirstServe fcfs = new FirstComeFirstServe();
		
		System.out.println("Enter number of processes: ");
		processes = sc.nextInt();	
		inputTimes = new int[processes][fixColumn];
		
		System.out.println("Enter the arrival time and burst time :");
		
		for(int i = 0; i < processes; i++)
		{
			for(int j = 0; j < fixColumn; j++)
			{
				inputTimes[i][j] = sc.nextInt();
			}
		}
		
		inputTimes = fcfs.sortArray(processes, inputTimes);
		
		System.out.println("Arrival Time\t\tBurst Time\t\tCompletion Time\t\tWaiting Time\t\tTurn Around Time\t\t");
		completionTime = fcfs.findCompletionTime(processes, inputTimes);
		
		waitingTime = fcfs.findWaitingTime(processes, inputTimes);
		
		turnAroundTime = fcfs.findTurnAroundTime(processes, inputTimes);
		for(int i = 0; i < processes; i++)
		{
			for(int j = 0; j < fixColumn; j++)
			{
				System.out.print(inputTimes[i][j] + "\t\t\t");
			}
			System.out.print(completionTime[i] + "\t\t\t");
			System.out.print(waitingTime[i] + "\t\t\t");
			System.out.println(turnAroundTime[i]);
		}
		
		
		System.out.println("Average waiting Time:");
		avgWaitingTime = fcfs.findAvgWaitingTime(processes, inputTimes);
		System.out.println(avgWaitingTime);
		System.out.println("Maximum Waiting Time:");
		max = fcfs.maxWaitingTime(processes, inputTimes);
		System.out.print(max);
	}
}
