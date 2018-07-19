package FCFS;

import java.util.Scanner;

class Fcfs
{
	
	int[] findWaitingTime (int processes, int inputTimes[][])
	{
		int[] serviceTime, waitingTime;
		
		serviceTime = new int[processes];
		serviceTime[0] = 0;
		waitingTime = new int[processes];
		waitingTime[0] = 0; //waiting time for first process is 0
		
		for(int i = 1; i < processes; i++)
		{
			if(inputTimes[i - 1][0] <= serviceTime[i - 1])
				serviceTime[i] = serviceTime[i - 1] + inputTimes[i - 1][1];
			else
				serviceTime[i] = inputTimes[i - 1][0] + inputTimes[i - 1][1];
			
			waitingTime[i] = serviceTime[i] - inputTimes[i][0];
			
			if(waitingTime[i] < 0)
				waitingTime[i] = 0;
		}
		return waitingTime;
	}
	
	int[] findTurnAroundTime (int processes, int inputTimes[][])
	{
		int[] turnAroundTime, waitingTime1;
		
		turnAroundTime = new int[processes];
		
		waitingTime1 = findWaitingTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			turnAroundTime[i] = inputTimes[i][1] + waitingTime1[i];
		}
		
		return turnAroundTime;
	}
	
	int[] findCompletionTime (int processes, int inputTimes[][])
	{
		int[] completionTime, turnAroundTime1; 
		
		completionTime = new int[processes];
		
		turnAroundTime1 = findTurnAroundTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			completionTime[i] = turnAroundTime1[i] + inputTimes[i][0];
		}
		return completionTime;
	}
	
	float findAvgWT (int processes, int inputTimes[][])
	{
		int totalWT = 0;
		float avgWT;
		int waitingTime1[] = findWaitingTime(processes, inputTimes);
		
		for(int i = 0; i < processes; i++)
		{
			totalWT = totalWT + waitingTime1[i];	
		}
		
		avgWT = totalWT/processes;
		return avgWT;
	}
	
	int maxWT (int processes, int inputTimes[][])
	{
		int[] waitingTime1;
		int max;
		
		waitingTime1 = findWaitingTime(processes, inputTimes);
		max = waitingTime1[0];
		
		for(int i = 1; i < processes; i++)
		{
			if(max < waitingTime1[i])
				max = waitingTime1[i];
		}
		return max;
	}
	
	int[][] sortArray(int processes, int inputTimes[][])
	{
		for(int i = 0; i < processes; i++)
		{
			for(int j = i; j < processes; j++)
			{
				if(inputTimes[i][0] > inputTimes[j][0])
				{
					int temp = inputTimes[i][0];
					inputTimes[i][0] = inputTimes[j][0];
					inputTimes[j][0] = temp;
					
					int temp1 = inputTimes[i][1];
					inputTimes[i][1] = inputTimes[j][1];
					inputTimes[j][1] = temp1;
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
		int[] ct, wt, tat;
		float avgwt;
		int max, processes;
		
		Scanner sc = new Scanner(System.in);	
		Fcfs fcfs = new Fcfs();
		
		System.out.println("Enter number of processes: ");
		processes = sc.nextInt();
		
		inputTimes = new int[processes][2];
		
		System.out.println("Enter the arrival time and burst time :");
		
		for(int i = 0; i < processes; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				inputTimes[i][j] = sc.nextInt();
			}
		}
		
		inputTimes = fcfs.sortArray(processes, inputTimes);
		
		System.out.println("Arrival Time\t\tBurst Time\t\tCompletion Time\t\tWaiting Time\t\tTurn Around Time\t\t");
		ct = fcfs.findCompletionTime(processes, inputTimes);
		
		wt = fcfs.findWaitingTime(processes, inputTimes);
		
		tat = fcfs.findTurnAroundTime(processes, inputTimes);
		for(int i = 0; i < processes; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				System.out.print(inputTimes[i][j] + "\t\t");
			}
			System.out.print(ct[i] + "\t\t");
			System.out.print(wt[i] + "\t\t");
			System.out.print(tat[i]);
			System.out.println();
		}
		
		
		System.out.println("Average waiting Time:");
		avgwt = fcfs.findAvgWT(processes, inputTimes);
		
		System.out.println(avgwt);
		
		System.out.println("Maximum Waiting Time:");
		max = fcfs.maxWT(processes, inputTimes);
		
		System.out.print(max);
	}

}
