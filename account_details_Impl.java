package bank.com;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class account_details_Impl {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	//-------------------------------
	@Transactional(readOnly=false)
	public int insert(account_details a) {
		int i=(Integer) this.hibernateTemplate.save(a);
		return i;
	}

	public account_details getAccount_no(int account_no) {
		account_details ac=hibernateTemplate.get(account_details.class,account_no);
		return ac;
	}

	public List<account_details> getAllaccount_details() {
		List<account_details> list = hibernateTemplate.loadAll(account_details.class);
		return list;
	}
	
	@Transactional
	public void update(account_details a) {
		hibernateTemplate.update(a);
		
	}
	@Transactional
	public void delete(int account_no) {
		account_details ac = hibernateTemplate.get(account_details.class,account_no);
		
	}

	public void select(int account_no) {
		account_details ac1= hibernateTemplate.get(account_details.class,account_no);
		
	}
}
