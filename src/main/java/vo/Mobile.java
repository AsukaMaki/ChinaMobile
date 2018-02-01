package vo;

public class Mobile {
	private String mobile_number;
	private String mobile_type;
	private String is_available;
	
	
	public Mobile(String mobile_number, String mobile_type, String is_available) {
		super();
		this.mobile_number = mobile_number;
		this.mobile_type = mobile_type;
		this.is_available = is_available;
	}
	
	public Mobile() {
		super();
	}
	
	
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getMobile_type() {
		return mobile_type;
	}
	public void setMobile_type(String mobile_type) {
		this.mobile_type = mobile_type;
	}
	
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}
	
}
