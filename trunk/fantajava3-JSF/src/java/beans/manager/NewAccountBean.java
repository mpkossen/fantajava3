/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.manager;

import beans.CommonBean;
import efg.jpa.bank.AccountManager;
import efg.jpa.bank.BankException;
import jaas.MyPrincipal;
import javax.faces.context.FacesContext;


public class NewAccountBean extends CommonBean {

	private AccountManager accountManager;
	private String naam,  pincode;
	private Double limiet;

	public NewAccountBean() {
		System.out.println("NewAccountBean");
                limiet = 10000.00;
	}

	protected AccountManager getAccountManager() {
		System.out.println("getAccountManager()");
		if (accountManager == null) {
			MyPrincipal mp =
					(MyPrincipal) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			return accountManager = mp.getAccountManager();
		} else {
			return accountManager;
		}
	}

	/**
	 * @return the limiet
	 */
	public String getLimiet() {
		return limiet + "";
	}

	/**
	 * @param limiet the limiet to set
	 */
	public void setLimiet(String limiet) {
		try {
			this.limiet = Double.parseDouble(limiet);
		} catch (NumberFormatException nfe) {
			setMessage("Limiet moet een nummer zijn");
		}
	}

	/**
	 * @return the naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam the naam to set
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void opslaan() {
		try {
			setMessage("Account is succesvol gemaakt, en " + getAccountManager().newAccount(limiet, naam, pincode));
                        setNaam("");
                        setPincode("");
		} catch (BankException ex) {
			setMessage("Nieuw account aanmaken is mislukt");
		}
	}
}
