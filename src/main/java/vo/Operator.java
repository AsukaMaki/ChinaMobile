package vo;

public class Operator {
	private String operator_id;
	private String operator_name;
	private String operator_pwd;
	private int is_admin;
	
	
	public Operator(String operator_id, String operator_name, String operator_pwd, int is_admin) {
		this.operator_id = operator_id;
		this.operator_name = operator_name;
		this.operator_pwd = operator_pwd;
		this.is_admin = is_admin;
	}
	
	public Operator() {
	}
	
	
	public String getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}
	
	public String getOperator_name() {
		return operator_name;
	}
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	
	public String getOperator_pwd() {
		return operator_pwd;
	}
	public void setOperator_pwd(String operator_pwd) {
		this.operator_pwd = operator_pwd;
	}
	
	public int getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	
}
