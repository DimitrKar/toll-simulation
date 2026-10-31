/*

Edo tha einai h klasi poy tha dimiourgei amaxia gia na einai ola sygkentromena ta stoixeia enos amaxiou

*/

public class Car{

	private double arrivalTime;
	private double patience;
	private double lpatience;
	private Poisson poisson;

	public Car(){

	}

}

public class Main{

	public static void main(String[] args){

		double[] avgTimes = {5, 5, 5};
		double[] constantTimes = {2, 3, 2};
		double lamdaAmaxia = 6;
		int N = 3;
		double synolikosXronos = 70*24*60*60;
			Simulation simulation = new Simulation(N[i], constantTimes[i], avgTimes[i], lamdaAmaxia, synolikosXronos);
			simulation.runSimulation();
		}

	}
}