public class PriorityQueue {

	final int MAX_N = 1000;
	private double[] times = new double[MAX_N];
	private int[] tameia = new int[MAX_N];
	private double[] arrivalTimes = new double[MAX_N];
	private int lastIndex;

	public PriorityQueue() {
		lastIndex = 0;
		for(int i = 0; i < MAX_N; i++) {
			times[i] = Double.MAX_VALUE;
			tameia[i] = Integer.MAX_VALUE;
			arrivalTimes[i] = Double.MAX_VALUE;
		}
	}

	public void add(double time, int tameioIndex, double arrivalTime) {
		int index = lastIndex++;
		times[index] = time;
		tameia[index] = tameioIndex;
		arrivalTimes[index] = arrivalTime;

		while(times[(index-1)/2] > times[index]){

			double tempDouble;
			int tempInt;

			tempDouble = arrivalTimes[index];
			arrivalTimes[index] = arrivalTimes[(index-1)/2];
			arrivalTimes[(index-1)/2] = tempDouble;

			tempDouble = times[index];
			times[index] = times[(index-1)/2];
			times[(index-1)/2] = tempDouble;

			tempInt = tameia[index];
			tameia[index] = tameia[(index-1)/2];
			tameia[(index-1)/2] = tempInt;

			index = (index-1)/2;
		}
	}

	public void pop() {
		int index = 0;
		double tempDouble;
		int tempInt;

		lastIndex--;

		tempDouble = times[index];
		times[index] = times[lastIndex];
		times[lastIndex] = tempDouble;

		tempDouble = arrivalTimes[index];
		arrivalTimes[index] = arrivalTimes[lastIndex];
		arrivalTimes[lastIndex] = tempDouble;

		tempInt = tameia[index];
		tameia[index] = tameia[lastIndex];
		tameia[lastIndex] = tempInt;

		times[lastIndex] = Double.MAX_VALUE;
		tameia[lastIndex] = Integer.MAX_VALUE;
		arrivalTimes[lastIndex] = Double.MAX_VALUE;

		while(Math.min(times[index*2+1], times[index*2+2]) < times[index]) {
			if(times[index*2+1] < times[index*2+2]){
				tempDouble = times[index*2+1];
				times[index*2+1] = times[index];
				times[index] = tempDouble;

				tempDouble = arrivalTimes[index*2+1];
				arrivalTimes[index*2+1] = arrivalTimes[index];
				arrivalTimes[index] = tempDouble;

				tempInt = tameia[index];
				tameia[index] = tameia[index*2+1];
				tameia[index*2+1] = tempInt;

				index = index*2 + 1;
			}
			else{
				tempDouble = times[index*2+2];
				times[index*2+2] = times[index];
				times[index] = tempDouble;

				tempDouble = arrivalTimes[index*2+2];
				arrivalTimes[index*2+2] = arrivalTimes[index];
				arrivalTimes[index] = tempDouble;

				tempInt = tameia[index];
				tameia[index] = tameia[index*2+2];
				tameia[index*2+2] = tempInt;

				index = index*2 + 2;
			}
		}
	}

	public double getTop() {
		return times[0];
	}

	public int getTopTameio() {
		return tameia[0];
	}

	public double getTopArrivalTime() {
		return arrivalTimes[0];
	}
}
