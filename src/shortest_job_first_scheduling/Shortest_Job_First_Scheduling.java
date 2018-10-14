package shortest_job_first_scheduling;

import java.util.Arrays;
import java.util.Scanner;

import shortest_job_first_scheduling_requirements.Shortest_Job_First_Scheduling_Requirements;

public class Shortest_Job_First_Scheduling {

	
	public static void main(String[] args) throws Exception
	{
		int counter_BurstTime;
		int counter_OrderInput;
		int process_Number = 0;
		
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter process no: ");
		process_Number = input.nextInt();
		
		int burst_Time[] = new int[process_Number+1];
		int copy_Shorted_Burst_Time[] = new int[process_Number+1];
		int process_OrderQueue[] = new int[process_Number+1];
		
		
		System.out.println("\nEnter processes burst time: \n");
		
		for( counter_BurstTime = 1; counter_BurstTime <= process_Number; counter_BurstTime++ )
		{
			System.out.printf("Process %d burst time: ", counter_BurstTime);
			burst_Time[counter_BurstTime] = input.nextInt();
		}
		
//		for( counter_BurstTime = 1; counter_BurstTime <= process_Number; counter_BurstTime++ )
//		{
//			
//			System.out.print(" " + burst_Time[counter_BurstTime]);
//		}
		
		//System.out.println(process_Number);
		
		
		copy_Shorted_Burst_Time = burst_Time;
		
		Arrays.sort(copy_Shorted_Burst_Time);
		
		System.out.println("\nAssigning priority against shortest burst time..\n");
		
		process_OrderQueue = copy_Shorted_Burst_Time;
		
//		for( counter_OrderInput = 1; counter_OrderInput <= process_Number; counter_OrderInput++ )
//		{
//			process_OrderQueue[counter_OrderInput] = counter_OrderInput;
//		}
		
		
//		for( counter_OrderInput = 1; counter_OrderInput <= process_Number; counter_OrderInput++ )
//		{
//			System.out.print(" " + process_OrderQueue[counter_OrderInput]);
//		}
		
		
		Shortest_Job_First_Scheduling_Requirements object_SJFS = new Shortest_Job_First_Scheduling_Requirements(process_Number, burst_Time, process_OrderQueue);
		
		object_SJFS.Grant_Chart();
		object_SJFS.Times();
		
		
		
	} //End of Main() Method;
	
} //End of public class Shortest_Job_First_Scheduling;
