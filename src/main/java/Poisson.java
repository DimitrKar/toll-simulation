import java.util.Random;

public class Poisson{

	private double l; //O rithmos tis diadikasias poisson
	private Random random = new Random(); //H tyxaia metavliti tis diadikasias

	public Poisson(double l){ //O constructor
		this.l = l;
	}

	public double waitTime(){
		double waitTime;

		double P = random.nextDouble(); //H tyxaia pithanotita tou xronou anamonis gia epomeni epityxia

		/*
			F(x) = 1 - e^(-lx) <=> (F(x) = P)
			P = 1 - e^(-lx) <=>
			e^(-lx) = 1 - P <=>
			-lx = ln(1 - P) <=>
			x = -ln(1 - P)/l
		*/

		waitTime = - Math.log(1-P)/l; //O xronos anamonis pou antistoixei stin tyxaia pithanotita P

		return waitTime;
	}

	public void setLamda(double l){
		this.l = l;
	}

}