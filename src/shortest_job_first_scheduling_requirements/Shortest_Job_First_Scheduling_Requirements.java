package shortest_job_first_scheduling_requirements;

public class Shortest_Job_First_Scheduling_Requirements {
	

	int process_Number;
	int[] burst_Time;
	int[] process_OrderQueue;
	int[] waiting_Time;
	int[] turnAround_Time;
	int priority[];
	int avgWaiting_Time;
	int avgTurnAround_Time;
	//int sum_Of_AvgWaitingTime = 0;
	int sum_Of_WaitingTime;
	
	public Shortest_Job_First_Scheduling_Requirements(int process_Number2, int[] burst_Time2, int[] process_OrderQueue2)
	{
		process_Number = process_Number2;
		
		burst_Time = burst_Time2;
		
		process_OrderQueue = process_OrderQueue2;
	}
	
	
	void Order_Prioritization()
	{
		for( int i = 1; i<= process_Number; i++)
		{
			//code
		}
	}
	
	
	
	public void Grant_Chart( )
	{
		int count_GrantChart;
		int count_InnerGrantChart;
		int sum_Of_Burst_Time;
		int temp=1;
		int index = 0;
		
		turnAround_Time = new int[process_Number+1];
		
		System.out.println("\nGrant Chart: ");
		
		for( count_GrantChart = 1; count_GrantChart <= process_Number; count_GrantChart++ )
		{
			sum_Of_Burst_Time = 0;
			
			
			
			for(int i = 1; i <= count_GrantChart; i++)
			{
				temp = process_OrderQueue[i];
				
				for(int j = 1; j <= process_Number; j++ )
				{
					if( temp == burst_Time[j] )
					{
						index = j;
					}
				}
				
				sum_Of_Burst_Time = sum_Of_Burst_Time + burst_Time[index];
				
			}

			
			System.out.printf("P%d", process_OrderQueue[count_GrantChart]);
			
			for( count_InnerGrantChart = 1; count_InnerGrantChart <= sum_Of_Burst_Time; count_InnerGrantChart++ )
			{
				System.out.print(".");	
				 
			}
			
			
			turnAround_Time[count_GrantChart] = turnAround_Time[count_GrantChart-1] + sum_Of_Burst_Time;  //Calculating Turn Around Time;
			
			if(count_GrantChart < process_Number)
			{
				sum_Of_WaitingTime = sum_Of_WaitingTime + sum_Of_Burst_Time;
				//System.out.println("W: "+ sum_Of_WaitingTime + "P:"+count_GrantChart);
			}
				
			
		} //End of Outer For() Loop;
		

		
		
	} //End of public void Grant_Chart();
	
	
	
	
	public void Times()
	{
		int temp=1;
		int index = 0;
		int counter_AvgWaiting;
		int sum_Of_WaitingTime_2;
		//int sum_Of_AvgWaitingTime = 0;
		int sum_Of_AvgTurnAroundTime;
		
		System.out.println("\n\nWaiting Time(s): ");
		
		waiting_Time = new int[process_Number+1];
		
		
		//Calculating plain Waiting Time
		for( int i = 1; i <= process_Number; i++ )
		{
			sum_Of_WaitingTime_2 = 0;
			
			for( int j = 1; j <= i; j++ )
			{
				temp = process_OrderQueue[j];
				
				for(int k = 1; k <= process_Number; k++ )
				{
					if( temp == burst_Time[k] )
					{
						index = k;
					}
				}
				
				sum_Of_WaitingTime_2 = sum_Of_WaitingTime_2 + burst_Time[index];
				
			}
			
			waiting_Time[i] = sum_Of_WaitingTime_2;
			
		} //End of Outer For();
		
		
		
		//Calculating Average Waiting Time
//		for( counter_AvgWaiting = 1; counter_AvgWaiting <= process_Number; counter_AvgWaiting++ )
//		{
//			sum_Of_AvgWaitingTime = sum_Of_AvgWaitingTime + waiting_Time[counter_AvgWaiting];
//			
//		}
		

		avgWaiting_Time = sum_Of_WaitingTime / process_Number;
		
		
		//Calculating Average TurnAround Time
		sum_Of_AvgTurnAroundTime = 0;
		for( int i = 1; i <= process_Number; i++ )
		{
			
			
			sum_Of_AvgTurnAroundTime = sum_Of_AvgTurnAroundTime + turnAround_Time[i];
		}
		
		avgTurnAround_Time = sum_Of_AvgTurnAroundTime / process_Number;
		
		
		
		//Printing all Time Data
		System.out.println("Waiting\tTurnaround\tAvg. Waiting\tAvg.Turn Around");
		for( int i = 1; i <= process_Number; i++ )
		{
			System.out.println(waiting_Time[i] + "\t" + turnAround_Time[i]+ "\t\t" + avgWaiting_Time + "\t\t" + avgTurnAround_Time);
		}
		
	} //End of public void Waiting_Time();
}
