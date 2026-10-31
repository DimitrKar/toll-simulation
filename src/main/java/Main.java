public class Main {

	public static void main(String[] args) {
		
		//to plithos ton tameion se kathe test case
		int[] N = {2, 2, 2, 2, 1};

		//O xronos ejipiretisis se ena tameio dinetai apo ton typo c+v
		//c o statheros xronos ejipiretisis (constantTimes)
		//v o metavlitos xronos ejipiretisis (avgTimes)
		double[][] avgTimes = {{15, 15}, {15, 15}, {15, 15}, {15, 15}, {7.5}}; 
		double[][] constantTimes = {{0, 0}, {2, 2}, {5, 5}, {10, 10}, {5}};

		//O rithmos emfanisis amaxion
		double lamdaAmaxia = 6;

		//O synolikos xronos ektelesis kathe test case se deyterolepta
		double synolikosXronos = 70*24*60*60;

		for (int i = 0; i < N.length; i++) {
			Simulation simulation = new Simulation(N[i], constantTimes[i], avgTimes[i], lamdaAmaxia, synolikosXronos, true);
			simulation.runSimulation();
		}

	}
}