package bank.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_detail")
public class account_details {
	@Id
	@Column(name="Account_Number")
	private int account_no;
	@Column(name="Name")
	private String name;
	@Column(name="Address")
	private String address;
	@Column(name="Branch_name")
	private String branch_namae;
	@Column(name="Total_Balance")
	private int total=0;
	@Column(name="Deposited_Amount")
	private int depo;
	@Column(name="Withdrwal_Amount")
	private int withdrwal;
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBranch_namae() {
		return branch_namae;
	}
	public void setBranch_namae(String branch_namae) {
		this.branch_namae = branch_namae;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getDepo() {
		return depo;
	}
	public void setDepo(int depo) {
		this.depo = depo;
	}
	public int getWithdrwal() {
		return withdrwal;
	}
	public void setWithdrwal(int withdrwal) {
		this.withdrwal = withdrwal;
	}
	public account_details(int account_no, String name, String address, String branch_namae, int total, int depo,
			int withdrwal) {
		super();
		this.account_no = account_no;
		this.name = name;
		this.address = address;
		this.branch_namae = branch_namae;
		this.total = total;
		this.depo = depo;
		this.withdrwal = withdrwal;
	}
	public account_details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "account_details [account_no=" + account_no + ", name=" + name + ", address=" + address
				+ ", branch_namae=" + branch_namae + ", total=" + total + ", depo=" + depo + ", withdrwal=" + withdrwal
				+ "]";
	}
	

}
