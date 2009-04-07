/*
 *
 * HAS BEEN MOVED
 * HAS BEEN MOVED
 * HAS BEEN MOVED
 * HAS BEEN MOVED
 * HAS BEEN MOVED
 *
 */


package beans.office;

import beans.CommonBean;
import beans.Connector;
import remote.AccountOfficeIF;
import jaas.MyPrincipal;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;


public class AccountOfficeBean extends CommonBean {

	private AccountOfficeIF accountOffice;

	public AccountOfficeBean() {
		System.out.println("AccountOfficeBean()");
	}

	protected AccountOfficeIF getAccountOffice() {
		return Connector.getAccountOffice();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return getAccountOffice().getDetails()[0];
	}

	/**
	 * @return the rekeningNummer
	 */
	public String getRekeningNummer() {
		return getAccountOffice().getDetails()[1];
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return Double.parseDouble(getAccountOffice().getDetails()[2]);
	}

	/**
	 * @return the limiet
	 */
	public double getLimiet() {
		return Double.parseDouble(getAccountOffice().getDetails()[3]);
	}

	public void doTransactions() {
		accountOffice.sync();
		setMessage("Transacties zijn voltooid.");
	}

	/**
	 *
	 * @return Transactions
	 */
	public String[][] getTransactions() {
		System.out.println("getTransactions");
		String[][] tmp = accountOffice.getPendingTransacties();
		for (String[] a : tmp) {
			for (String b : a) {
				System.out.println(b);
			}
		}
		return getAccountOffice().getPendingTransacties();
	}

	public void bedragInputValidator(FacesContext ctx, UIComponent cmp, Object val) {
		System.out.println("AccountOfficeBean.bedragInputValidator(" + val + ")");
		try {
			if (((String) val).equals("")) {
				throw new ValidatorException(new FacesMessage("Bedrag moet ingevuld worden"));
			} else {
				Double value = Double.parseDouble((String) val);
				if (value <= 0) {
					throw new ValidatorException(new FacesMessage("Bedrag moet positief zijn"));
				}
			}
		} catch (NumberFormatException nfe) {
			throw new ValidatorException(new FacesMessage("Bedrag moet een nummer zijn"));
		}
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

	public void rekeningInputValidator(FacesContext ctx, UIComponent cmp, Object val) {
//		try {
//			Double value = Double.parseDouble((String) val);
//			if (value <= 0) {
//				throw new ValidatorException(new FacesMessage("Bedrag moet positief zijn"));
//			}
//		} catch (NumberFormatException nfe) {
//			throw new ValidatorException(new FacesMessage("Bedrag moet een nummer zijn"));
//		}
	}
}
