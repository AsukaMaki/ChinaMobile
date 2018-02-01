package dao;



import java.util.List;

import vo.*;

public interface MobileDao {
	public void newOperator(Operator o);
	public List<Operator> getOperatorIds();
	public void initMobile(Mobile[] ms);
	public void alterCharge(Charge c);
	public void setChargeRule(ChargeRule cr);
}
