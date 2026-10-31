public class Queue{

	private int first;
	private int last;
	private double[] arrivalTimes = new double[1000];

	public Queue(){
		first = 0;
		last = 0;
	}

	public void add(double arrivalTime){
		arrivalTimes[last] = arrivalTime;
		last = (last + 1) % 1000;
	}

	public void remove(){
		first = (first + 1) % 1000;
	}

	public double getFirst(){
		return arrivalTimes[first];
	}
}