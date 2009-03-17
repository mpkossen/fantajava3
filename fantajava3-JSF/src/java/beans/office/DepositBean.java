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

import efg.jpa.bank.AccountOffice;
import efg.jpa.bank.BankException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class DepositBean extends AccountOfficeBean {

	private String bedrag;

	/*****************************************************************************
	 * Construction
	 ****************************************************************************/
	public DepositBean() {
	}

	public String getBedrag() {
		return bedrag;
	}

	public void setBedrag(String bedrag) {
		this.bedrag = bedrag;
	}

	/*************************************************************************************/
	public void geldStorten() {
		System.out.println("DepositBean.geldStorten(" + bedrag + ")");

		try {
			AccountOffice accountOffice = getAccountOffice();
			accountOffice.transfer(null, Double.parseDouble(bedrag));
			setMessage("Transactie is opgeslagen. (€" + bedrag + " is gestort op rekeningnummer " + accountOffice.getDetails()[0] + ")");
			setBedrag("");
		} catch (BankException ex) {
			setMessage("Transactie is mislukt");
		}
	}
}
