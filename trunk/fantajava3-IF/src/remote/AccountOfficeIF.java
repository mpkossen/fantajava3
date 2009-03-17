/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package remote;

import common.BankException;

/**
 *
 * @author mistermartin75
 */
public interface AccountOfficeIF {

		/**
	 * close()
	 */
	void close();

	/**
	 * customer - getDetails()
	 */
	String[] getDetails();

	/**
	 * customer - getPendingTransactions()
	 */
	String[][] getPendingTransacties();

	void sayHello();

	/**
	 * sync()
	 */
	void sync();

	@Override
	String toString();

	/**
	 * customer - transfer()
	 */
	String transfer(String number, double amount) throws BankException;
}
