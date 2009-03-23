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

public class WithdrawBean extends AccountOfficeBean {

	private String bedrag;

	public WithdrawBean() {
	}

	public String getBedrag() {
		System.out.println("WithdrawBean.getBedrag()");
		return bedrag;
	}

	public void setBedrag(String bedrag) {
		System.out.println("WithdrawBean.setBedrag(String bedrag)");
		this.bedrag = bedrag;
	}

	public void geldOpnemen() {
		System.out.println("WithdrawBean.geldOpnemen(" + bedrag + ")");

		try {
			AccountOfficeIF accountOffice = getAccountOffice();
			accountOffice.transfer(null, Double.parseDouble(bedrag) * -1);
			setMessage("Transactie is opgeslagen (€" + bedrag + " is opgenomen van rekeningnummer " + accountOffice.getDetails()[0] + ")");
			setBedrag("");
		} catch (NumberFormatException nfe) {
			setMessage("Bedrag moet ingevoerd worden");
		} catch (BankException ex) {
			setMessage("Transactie is mislukt");
		}
	}
}
