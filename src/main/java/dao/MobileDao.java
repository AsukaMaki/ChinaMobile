package dao;



import java.util.List;

import vo.*;

public interface MobileDao {
	public Operator login(String userId,String password);
	public void newOperator(Operator o);
	public List<Operator> getOperatorIds();
	public void initMobile(Mobile[] ms);
	public List<Charge> getAllCharges();
	public List<Object[]> getAllChargeRules();
	public void alterCharge(Charge c);
	public void setChargeRule(ChargeRule cr);
	public Customer getCustomer(String id_type,String id_number);
	public void newCustomer(Customer c);
	public void getAllNumbers(PageInfo info);
	public void newUser(User u);
	public void alterMobile(String mobile_number);
}
