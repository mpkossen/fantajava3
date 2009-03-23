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
	private AccountManagerIF accountmanager = null;
	private AccountOfficeIF accountOffice = null;

	@EJB(name = "ejb/AccountManagerRef")
	public void setMyLibraryAdmin(AccountManagerIF newAccountManager) {
		accountmanager = newAccountManager;
	}

	@EJB(name = "ejb/AccountOfficeRef")
	public void setMyLibraryManager(AccountOfficeIF newAccountOffice) {
		accountOffice = newAccountOffice;
	}

	private String head = "ABC-Bank";
	private String message;

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
