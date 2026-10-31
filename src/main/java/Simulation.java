import java.util.Random;

public class Simulation{

	private CarGenerator cars;
	private Tameio[] tameia;
	private int N;
	private double synolikosXronos;
	private boolean rand;

	public Simulation(int N, double[] constantTime, double[] avgTime, double lamdaCars, double synolikosXronos, boolean rand){
		this.N = N;
		tameia = new Tameio[N];
		for(int i = 0; i < N; i++){
			tameia[i] = new Tameio(constantTime[i], avgTime[i], synolikosXronos);
		}
		cars = new CarGenerator(lamdaCars);
		this.synolikosXronos = synolikosXronos;
		this.rand = rand;
	}

	public void runSimulation(){

		double averageXronosAnamonis = 0;
		int carsTotal = 0;

		double time = 0;
		PriorityQueue serviceTimes = new PriorityQueue();

		double nextCarArrival = time + cars.getNextCar();

		time = nextCarArrival;
		carsTotal++;
		int tameioChoice;
		if(rand == true){
			tameioChoice = ChooseTameioRandom();
		}
		else{
			tameioChoice = ChooseTameio();
		}
		double serviceTime = time + tameia[tameioChoice].getServiceTime();
		serviceTimes.add(serviceTime, tameioChoice, time);
		tameia[tameioChoice].addCar(time);

		nextCarArrival = time + cars.getNextCar();

		int serviceTameio;

		while(time < synolikosXronos){ //posa deyterolepta tha trexei
			if(nextCarArrival < serviceTimes.getTop()){
				time = nextCarArrival;
				carsTotal++;
				if(rand == true){
					tameioChoice = ChooseTameioRandom();
				}
				else{
					tameioChoice = ChooseTameio();
				}

				tameia[tameioChoice].addCar(time);

				if(tameia[tameioChoice].getQueue() == 1){
					serviceTime = time + tameia[tameioChoice].getServiceTime();
					serviceTimes.add(serviceTime, tameioChoice, time);
				}

				nextCarArrival = time + cars.getNextCar();
			}
			else{
				time = serviceTimes.getTop();
				serviceTameio = serviceTimes.getTopTameio();
				double arrivalTime = serviceTimes.getTopArrivalTime();
				serviceTimes.pop();

				averageXronosAnamonis += tameia[serviceTameio].removeCar(time);

				if(tameia[serviceTameio].getQueue() > 0){
					serviceTime = time + tameia[serviceTameio].getServiceTime();
					serviceTimes.add(serviceTime, serviceTameio, time);
				}
			}


		}

		System.out.println("APOTELESMATA");

		for(int i = 0; i < N; i++){
			System.out.println("Tameio " + i + " : " + tameia[i].getAverageQueue());
		}

		averageXronosAnamonis /= carsTotal;

		System.out.println("Average xronos anamonis : " + averageXronosAnamonis);
		System.out.println();

	}

	private int ChooseTameio(){
		int min = Integer.MAX_VALUE;
		int counter = 0;
		int[] minTameio = new int[N];

		for(int i = 0; i < N; i++){
			if(tameia[i].getQueue() < min){
				min = tameia[i].getQueue();
				counter = 1;
				minTameio[0] = i;
			}
			else if(tameia[i].getQueue() == min){
				minTameio[counter] = i;
				counter++;
			}
		}

		if(counter > 1){
			Random random = new Random();
			int tameio = random.nextInt(counter);
			return minTameio[tameio];
		}

		return minTameio[0];
	}

	private int ChooseTameioRandom(){
		Random random = new Random();
		int tameio = random.nextInt(N);
		return tameio;
	}

}
