public class CarGenerator{

	private double l; //To Lamda dinetai se amaxia
	private Poisson poisson;

	public CarGenerator(double l){
		this.l = l;
		poisson = new Poisson(l);
	}

	public void setLamda(double l){
		this.l = l;
		poisson.setLamda(l);
	}

	public double getLamda(){
		return l;
	}

	public double getNextCar(){
		return poisson.waitTime()*60; //epistrephontai deuterolepta
	}

}
