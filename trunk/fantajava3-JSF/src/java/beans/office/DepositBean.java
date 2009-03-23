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

import common.BankException;
import remote.AccountOfficeIF;

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
			AccountOfficeIF accountOffice = getAccountOffice();
			accountOffice.transfer(null, Double.parseDouble(bedrag));
			setMessage("Transactie is opgeslagen. (€" + bedrag + " is gestort op rekeningnummer " + accountOffice.getDetails()[0] + ")");
			setBedrag("");
		} catch (BankException ex) {
			setMessage("Transactie is mislukt");
		}
	}
}
