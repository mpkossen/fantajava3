package beans.manager;

import beans.CommonBean;
import beans.Connector;
import jaas.MyPrincipal;
import javax.faces.context.*;
import javax.servlet.http.HttpSession;
import remote.AccountManagerIF;


public class AccountManagerBean extends CommonBean {

	private static final String STARTFORM = "/manager/subview/selectAccount.jsp";
	private AccountManagerIF accountManager;
	private String form = STARTFORM;
	private String accountNumber,  limiet,  naam;

	public AccountManagerBean() {
		System.out.println("AccountManagerBean()");
	}

	protected AccountManagerIF getAccountManager() {
		return Connector.getAccountManager();
	}

	public String[] getAccount(String number) {
		return getAccountManager().getAccount(number);
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getForm() {
		return form;
	}

	/**
	 * @return the limiet
	 */
	public String getLimiet() {
		return limiet;
	}

	/**
	 * @param limiet the limiet to set
	 */
	public void setLimiet(String limiet) {
		this.limiet = limiet;
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

	public String[][] getTransactions() {
		return accountManager.getTransactions(accountNumber);
	}

        public String getStatus() {
           return ( "De status van de " + accountManager.getStatus());
			//return "nigger";
        }

        public void open() {
             getAccountManager().setOpen(true);
        }

        public void close() {
            getAccountManager().setOpen(false);
        }

        public void logout() {
            System.out.println("loguit");
               MyPrincipal mp = (MyPrincipal) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
               mp.logout();
               HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
               s.invalidate();
               try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect("../login/Bank.faces");
                } catch (Exception e) { }
               
        }

	public void selectAccount() {
		try {
			setMessage("U selecteerde account nummer: " + accountNumber);
			String[] account = getAccountManager().getAccount(accountNumber);
			setNaam(account[0]);
			setLimiet(account[3]);
			setForm("/manager/subview/EditAccount.jsp");
		} catch (NullPointerException npe) {
			setMessage("Dit account bestaat niet");
		}
	}

	public void terug() {
		setForm(STARTFORM);
		setAccountNumber("");
	}
}
