package bank.com;

import java.util.List;

public interface account_detailsDao {
	public int insert(account_details a);
	public account_details getAccount_no(int account_no);
	public List<account_details> getAllaccount_details();
	public void update(account_details a);
	public void delete(int account_no);
	public void select(int account_no);

}
