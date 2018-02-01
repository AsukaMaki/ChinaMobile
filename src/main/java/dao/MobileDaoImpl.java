package dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;

import vo.Charge;
import vo.ChargeRule;
import vo.Mobile;
import vo.Operator;

public class MobileDaoImpl implements MobileDao {
	
	
	@Override
	@Transactional
	public void newOperator(Operator o) {
		
		Dao.executeSql("insert into toperator values(?,?,?,?)", o.getOperator_id(),o.getOperator_name(),o.getOperator_pwd(),o.getIs_admin());
	}

	@Override
	@Transactional
	public void initMobile(Mobile[] ms) {
		
		for(int i=0;i<ms.length;i++){
			Dao.executeSql("insert into tmobiles values(?,?,null,?)", ms[i].getMobile_number(),ms[i].getMobile_type(),ms[i].getIs_available());
		}
	}

	@Override
	@Transactional
	public void alterCharge(Charge c) {
		
		Dao.executeSql("update tcharge set charge=? where charge_code=?", c.getCharge(),c.getCharge_code());
	}
	
	@Override
	@Transactional
	public void setChargeRule(ChargeRule cr) {
		
		List list=Dao.query("select * from tcharge_rule where func_id=?",cr.getFunc_id());
		if(list!=null){
			Dao.executeSql("delete from tcharge_rule where func_id=?", cr.getFunc_id());
		}
		for(int i=0;i<cr.getCharge_code().length;i++){
			Dao.executeSql("insert into tcharge_rule values(?,?,?)", cr.getFunc_id(),cr.getCharge_code()[i],cr.getFunc_name());
		}
	}

	@Override
	@Transactional
	public List<Operator> getOperatorIds() {
		
		return Dao.query("select * from toperator", Operator.class);
	}

}
