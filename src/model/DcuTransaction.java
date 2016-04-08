package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DCU_TRANSACTIONS database table.
 * 
 */
@Entity
@Table(name="DCU_TRANSACTIONS")
@NamedQuery(name="DcuTransaction.findAll", query="SELECT d FROM DcuTransaction d")
public class DcuTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long transid;

	private BigDecimal amount;

	private String transtype;

	//bi-directional many-to-one association to DcuAccount
	@ManyToOne
	@JoinColumn(name="ACCID")
	private DcuAccount dcuAccount;

	public DcuTransaction() {
	}

	public long getTransid() {
		return this.transid;
	}

	public void setTransid(long transid) {
		this.transid = transid;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTranstype() {
		return this.transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public DcuAccount getDcuAccount() {
		return this.dcuAccount;
	}

	public void setDcuAccount(DcuAccount dcuAccount) {
		this.dcuAccount = dcuAccount;
	}

}