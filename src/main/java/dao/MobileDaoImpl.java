package dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;

import vo.Charge;
import vo.ChargeRule;
import vo.Customer;
import vo.Mobile;
import vo.Operator;
import vo.PageInfo;
import vo.User;

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

	@Override
	@Transactional
	public Customer getCustomer(String id_type, String id_number) {
		
		return Dao.queryOne("select * from tcustomer where id_type=? and id_number=?", Customer.class, id_type,id_number);
	}

	@Override
	public void newCustomer(Customer c) {
		
		Customer cus=getCustomer(c.getId_type(),c.getId_number());
		if(cus==null) {
			Dao.executeSql("insert into tcustomer values(null,?,?,?,?,?,?)",c.getId_type(),c.getId_number(),c.getCustomer_name(),c.getCustomer_birthday(),c.getCustomer_sex(),c.getCustomer_address());
		}
	}

	@Override
	@Transactional
	public void getAllNumbers(PageInfo info) {
		
		Object[] obj=Dao.queryOne("select count(*) from tmobiles where is_available='Y'");
		int recordCount=((Long)obj[0]).intValue();
		info.setRecordCount(recordCount);
		
		List<Mobile> numbers=Dao.query("select * from tmobiles where is_available='Y' limit ?,?", Mobile.class, (info.getCurrentPage()-1)*info.getPageSize(),info.getPageSize());
		info.setList(numbers);
	}

	@Override
	@Transactional
	public void newUser(User u) {
		
		Dao.executeSql("insert into tuser values(null,?,?,?,?,'Y')", u.getMobile_number(),u.getRoaming_status(),u.getCom_level(),u.getCustomer_id());
	}

	@Override
	@Transactional
	public List<Charge> getAllCharges() {
		
		return Dao.query("select * from tcharge", Charge.class);
	}

	@Override
	@Transactional
	public List<Object[]> getAllChargeRules() {
		
		return Dao.query("select DISTINCT FUNC_ID,FUNC_NAME  from tcharge_rule");
	}

	@Override
	@Transactional
	public Operator login(String userId, String password) {
		
		return Dao.queryOne("select * from toperator where operator_id=? and operator_pwd=?", Operator.class, userId,password);
	}

	@Override
	public void alterMobile(String mobile_number) {
		
		Dao.executeSql("update tmobiles set is_available='N' where mobile_number=?", mobile_number);
	}

}
