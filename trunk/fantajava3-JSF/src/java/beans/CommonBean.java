/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import remote.AccountManagerIF;
import remote.AccountOfficeIF;


public class CommonBean {

	private static final long serialVersionUID = 1L;
	private String usr = "eric";
	private String pwd = "";
	private AccountManagerIF accountmanager = Connector.getAccountManager();
	private AccountOfficeIF accountOffice = Connector.getAccountOffice();

	/*@EJB(name="AccountManagerRef")
	public void setMyAccountManager(AccountManagerIF newAccountManager) {
		System.out.println("CommonBean.setMyAccountManager("+ newAccountManager +")");
		accountmanager = newAccountManager;
	}

	@EJB(name="AccountOfficeRef")
	public void setMyAccountOffice(AccountOfficeIF newAccountOffice) {
		System.out.println("CommonBean.setMyAccountOffice("+ newAccountOffice +")");
		accountOffice = newAccountOffice;
	}*/

	private String head = "ABC-Bank";
	private String message;

	/*@EJB(mappedName="jnp://145.89.124.209:1099/AccountManager/remote")
	private AccountManagerIF accountManager = null;

	@EJB(mappedName="jnp://145.89.124.209s:1099/AccountOffice/remote")
	private AccountOfficeIF accountOffice = null;*/

	public CommonBean() {
		System.out.println("CommonBean()");
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean getDisplayManager() {
	System.out.println("BankBean.getDisplayManager()");
	return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("beheerders");
    }

    public boolean getDisplayOffice() {
	System.out.println("BankBean.getDisplayOffice()");
	return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("klanten");
    }

}
