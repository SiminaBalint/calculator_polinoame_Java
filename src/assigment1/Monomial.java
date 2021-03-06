package assigment1;

public class Monomial {
	private int power;
	private float coef;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public float getCoef() {
		return this.coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public Monomial(int power, float coef) {
		this.power = power;
		this.coef = coef;
	}

}
