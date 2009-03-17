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
public interface AccountOfficeIF
{
	void close();
	String[] getDetails();
	String[][] getPendingTransacties();
	void sayHello();
	void sync();
	@Override
	String toString();
	String transfer(String number, double amount) throws BankException;
}
