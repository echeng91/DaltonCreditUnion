package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DCU_USERS database table.
 * 
 */
@Entity
@Table(name="DCU_USERS")
@NamedQuery(name="DcuUser.findAll", query="SELECT d FROM DcuUser d")
public class DcuUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String firstname;

	private String lastname;

	private String username;

	private String userpass;

	//bi-directional many-to-one association to DcuAccount
	@OneToMany(mappedBy="dcuUser")
	private List<DcuAccount> dcuAccounts;

	public DcuUser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public List<DcuAccount> getDcuAccounts() {
		return this.dcuAccounts;
	}

	public void setDcuAccounts(List<DcuAccount> dcuAccounts) {
		this.dcuAccounts = dcuAccounts;
	}

	public DcuAccount addDcuAccount(DcuAccount dcuAccount) {
		getDcuAccounts().add(dcuAccount);
		dcuAccount.setDcuUser(this);

		return dcuAccount;
	}

	public DcuAccount removeDcuAccount(DcuAccount dcuAccount) {
		getDcuAccounts().remove(dcuAccount);
		dcuAccount.setDcuUser(null);

		return dcuAccount;
	}

}