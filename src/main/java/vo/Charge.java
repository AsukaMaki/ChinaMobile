package vo;

public class Charge {
	private String charge_code;
	private String charge_name;
	private double charge;
	
	
	public Charge(String charge_code, String charge_name, double charge) {
		this.charge_code = charge_code;
		this.charge_name = charge_name;
		this.charge = charge;
	}

	public Charge() {
	}
	
	
	public String getCharge_code() {
		return charge_code;
	}
	public void setCharge_code(String charge_code) {
		this.charge_code = charge_code;
	}
	
	public String getCharge_name() {
		return charge_name;
	}
	public void setCharge_name(String charge_name) {
		this.charge_name = charge_name;
	}
	
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
}
