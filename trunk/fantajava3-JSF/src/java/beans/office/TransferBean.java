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

public class TransferBean extends AccountOfficeBean {
	
	private String reknrNaar;
	private String bedrag;

	/*****************************************************************************
	 * Construction
	 ****************************************************************************/
	public TransferBean() {
		// setMessage("ABC BANK - Geld Storten");
	}

	public String getReknrNaar() {
		return reknrNaar;
	}

	public String getBedrag() {
		System.out.println("TransferBean.getBedrag()");
		return bedrag;
	}

	public void setReknrNaar(String reknr_naar) {
		this.reknrNaar = reknr_naar;
	}

	public void setBedrag(String bedrag) {
		System.out.println("TransferBean.setBedrag(String bedrag)");
		this.bedrag = bedrag;
	}

	public void overboeken() {
		System.out.println("TransferBean.overboeken(" + reknrNaar + ", " + bedrag + ")");

		try {
			AccountOffice accountOffice = getAccountOffice();
			accountOffice.transfer(reknrNaar, Double.parseDouble(bedrag));
			setMessage("Transactie is opgeslagen (€" + bedrag + " is overgeboekt naar rekeningnummer " + reknrNaar + ")");
			setBedrag("");
			setReknrNaar("");
		} catch (BankException ex) {
			setMessage("Transactie is mislukt");
		}
	}
}
