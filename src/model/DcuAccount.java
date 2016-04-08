package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DCU_ACCOUNTS database table.
 * 
 */
@Entity
@Table(name="DCU_ACCOUNTS")
@NamedQuery(name="DcuAccount.findAll", query="SELECT d FROM DcuAccount d")
public class DcuAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long accid;

	private String acctype;

	private BigDecimal active;

	private BigDecimal balance;

	//bi-directional many-to-one association to DcuUser
	@ManyToOne
	@JoinColumn(name="USERID")
	private DcuUser dcuUser;

	//bi-directional many-to-one association to DcuTransaction
	@OneToMany(mappedBy="dcuAccount")
	private List<DcuTransaction> dcuTransactions;

	public DcuAccount() {
	}

	public long getAccid() {
		return this.accid;
	}

	public void setAccid(long accid) {
		this.accid = accid;
	}

	public String getAcctype() {
		return this.acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public BigDecimal getActive() {
		return this.active;
	}

	public void setActive(BigDecimal active) {
		this.active = active;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public DcuUser getDcuUser() {
		return this.dcuUser;
	}

	public void setDcuUser(DcuUser dcuUser) {
		this.dcuUser = dcuUser;
	}

	public List<DcuTransaction> getDcuTransactions() {
		return this.dcuTransactions;
	}

	public void setDcuTransactions(List<DcuTransaction> dcuTransactions) {
		this.dcuTransactions = dcuTransactions;
	}

	public DcuTransaction addDcuTransaction(DcuTransaction dcuTransaction) {
		getDcuTransactions().add(dcuTransaction);
		dcuTransaction.setDcuAccount(this);

		return dcuTransaction;
	}

	public DcuTransaction removeDcuTransaction(DcuTransaction dcuTransaction) {
		getDcuTransactions().remove(dcuTransaction);
		dcuTransaction.setDcuAccount(null);

		return dcuTransaction;
	}

}