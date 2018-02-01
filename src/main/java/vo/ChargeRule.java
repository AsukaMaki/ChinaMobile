package vo;

public class ChargeRule {
	private String func_id;
	private String[] charge_code;
	private String func_name;
	
	
	public ChargeRule(String func_id, String[] charge_code, String func_name) {
		this.func_id = func_id;
		this.charge_code = charge_code;
		this.func_name = func_name;
	}
	
	public ChargeRule(String func_id, String[] charge_code) {
		this.func_id = func_id;
		this.charge_code = charge_code;
		if(func_id.equals("O")){
			this.func_name ="¿ª»§";
		}
	}
	public ChargeRule() {
	}
	
	
	public String getFunc_id() {
		return func_id;
	}
	public void setFunc_id(String func_id) {
		this.func_id = func_id;
	}
	
	public String[] getCharge_code() {
		return charge_code;
	}
	public void setCharge_code(String[] charge_code) {
		this.charge_code = charge_code;
	}

	public String getFunc_name() {
		return func_name;
	}
	public void setFunc_name(String func_name) {
		this.func_name = func_name;
	}
	
}
