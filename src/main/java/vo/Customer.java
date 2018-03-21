package vo;

import java.util.Date;

public class Customer {
	private int customer_id;
	private String id_type;
	private String id_number;
	private String customer_name;
	private Date customer_birthday;
	private String customer_sex;
	private String customer_address;
	
	
	public Customer(int customer_id, String id_type, String id_number, String customer_name, Date customer_birthday,
			String customer_sex, String customer_address) {
		super();
		this.customer_id = customer_id;
		this.id_type = id_type;
		this.id_number = id_number;
		this.customer_name = customer_name;
		this.customer_birthday = customer_birthday;
		this.customer_sex = customer_sex;
		this.customer_address = customer_address;
	}
	
	public Customer() {
	}
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public Date getCustomer_birthday() {
		return customer_birthday;
	}
	public void setCustomer_birthday(Date customer_birthday) {
		this.customer_birthday = customer_birthday;
	}
	
	public String getCustomer_sex() {
		return customer_sex;
	}
	public void setCustomer_sex(String customer_sex) {
		this.customer_sex = customer_sex;
	}
	
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	
}
