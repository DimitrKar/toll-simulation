public class Main{

	public static void main(String[] args){

		double[][] avgTimes = {{15, 15}, {15, 15}, {15, 15}, {15, 15}, {15, 15}};
		double[][] constantTimes = {{0, 0}, {2, 2}, {5, 5}, {10, 10}, {15, 15}};
		double lamdaAmaxia = 6;
		int[] N = {2, 2, 2, 2, 2};
		double synolikosXronos = 70*24*60*60;
		for(int i = 0; i < N.length; i++){
			Simulation simulation = new Simulation(N[i], constantTimes[i], avgTimes[i], lamdaAmaxia, synolikosXronos, true);
			simulation.runSimulation();
		}

	}
}