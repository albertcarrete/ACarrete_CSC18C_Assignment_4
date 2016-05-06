/*
 * ================================================
 * Author: 		Albert Carrete
 * Class: 		CSC-18C
 * Project: 	Assignment 5 
 * ================================================
 * Eratosthenes With Queues
 * 
 * 1. 	Create a queue named queueOfIntegers, enqueue 
 * 		it with consecutive integers 2 through n.
 * 2. 	Create an empty queue to store primes, perhaps 
 * 		named queueOfPrimes.
 * 3. 	Do
 * 4. 	Get the next prime number, p, by removing the 
 * 		first value in queueOfNumbers.
 * 5. 	Enqueue the value of p into queue of primes. 
 * 6. 	Create a new queue and fill this queue by doing 
 * 		the following:
 * 			- While queueOfNumbers is not empty, dequeue
 * 			the front number, if it is not divisible by
 * 			p then enequeue this number to newQueue 
 * 			(queueOfPrimes.back() is our current prime
 * 			number)
 * 8.	Assign the queueOfNumbers object with the newly created queue object
 * 9. 	While (queueOfPrimes.back() < sqrt(n))
 * 10.	Display the primes, which are all the values in the queueOfPrimes object.
 * */


public class assignment4Test {

	public static void main(String[] args) {
		
		computeTo(1000);
		
		
	}
	
	public static void computeTo(int n){
		
		// Create queueOfIntegers & queueOfPrimes
		Queue<Integer> queueOfIntegers 	= new Queue<Integer>();
		Queue<Integer> queueOfPrimes 	= new Queue<Integer>();
		
		// Max value to compute to
		int max = n;
		int count = 0;
		
		if(n < 2 ){
			throw new IllegalArgumentException("n needs to be greater than 2");
		}
		
		// Create a queue named queueOfIntegers, enqueue it with consecutive
		// integers 2 through n
		for(int i = 2; i <= n; i++){
			queueOfIntegers.enqueue(i);
		}
		System.out.print("Content of: queueOfIntegers: ");
		queueOfIntegers.display();

		Queue<Integer> queueTemp = new Queue<Integer>();				
		Integer p;	
		// 

		do{
			// 4. Get the next prime number, p, by removing the first value in queueOfIntegers
			p = queueOfIntegers.dequeue();
			
			System.out.println("Dequeuing a prime number: " + p);
			// 5. Enqueue the value of p into queueOfPrimes
			queueOfPrimes.enqueue(p);

//			System.out.print("BEFORE Content of: queueOfPrimes:");
//			queueOfPrimes.display();
//			System.out.print("BEFORE Content of: queueOfIntegers:");
//			queueOfIntegers.display();
						
			// 6. Create a new queue and fill the queue by using a while loop
			queueTemp = new Queue<Integer>();			
			while(!queueOfIntegers.isEmpty()){
				
				int front = queueOfIntegers.dequeue();
				
//				System.out.print("Dividing " + p + " into " + front + ": ");
				if((front%p) != 0){
//					System.out.print("Not divisible");
					queueTemp.enqueue(front);
				}
//				System.out.println("");
			}
			
			queueOfIntegers = queueTemp;
			
			// Print out the contents of queueOfPrimes and Integers
			System.out.print("Content of: queueOfPrimes:");
			queueOfPrimes.display();
			System.out.print("Content of: queueOfIntegers:");
			queueOfIntegers.display();
						
		}while(queueOfPrimes.back() < Math.sqrt(n));
		
		
		while(!queueTemp.isEmpty()){
			p = queueTemp.dequeue();
			queueOfPrimes.enqueue(p);
		}
		System.out.print("Content of: queueOfPrimes:");

		queueOfPrimes.display();	
		queueTemp.display();

		
		
		
	}

}
