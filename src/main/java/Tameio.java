public class Tameio{

	private double l; //To Lamda dinetai se amaxia ana lepto
	private double constantTime;
	private double avgTime;
	private Poisson poisson;
	private int queue;
	private double lastTime;
	private double averageQueue;
	private double synolikosXronos;

	Queue allArrivalTimes = new Queue();

	public Tameio(double constantTime, double avgTime, double synolikosXronos){
		this.constantTime = constantTime;
		this.avgTime = avgTime;
		l = 60/(avgTime - constantTime);
		poisson = new Poisson(l);
		queue = 0;
		lastTime = 0;
		averageQueue = 0;
		this.synolikosXronos = synolikosXronos;
	}

	public void setLamda(double l){
		this.l = l;
		poisson.setLamda(l);
	}

	public double getLamda(){
		return l;
	}

	public double getServiceTime(){
		return constantTime + poisson.waitTime()*60; //epistrephontai deuterolepta
	}

	public int getQueue(){
		return queue;
	}

	public void addCar(double time){
		allArrivalTimes.add(time);
		averageQueue += (time - lastTime)/synolikosXronos * queue;
		queue++;
		lastTime = time;
	}

	public double removeCar(double time){
		double waitTime = time - allArrivalTimes.getFirst();
		allArrivalTimes.remove();
		averageQueue += (time - lastTime)/synolikosXronos * queue;
		queue--;
		lastTime = time;
		return waitTime;
	}

	public double getAverageQueue(){
		return averageQueue;
	}

}