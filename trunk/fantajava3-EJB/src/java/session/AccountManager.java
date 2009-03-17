/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import common.BankException;
import common.Database;
import entity.Account;
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import remote.AccountManagerIF;

@Stateless
@Remote
public class AccountManager implements AccountManagerIF {
	//TODO ik heb hier alle klassen uitgesloopt, maar staat in txt bestandje op mn pc

	/*****************************************************************************
	 * Static - Attributes
	 ****************************************************************************/
	public static final String ob = "abc-bank is open and busy";
	public static final String cb = "abc-bank is closed and busy";
	public static final String oi = "abc-bank is open and idle";
	public static final String ci = "abc-bank is closed and idle";
	private static final EntityManager entityManager = Database.getEntityManager("AccountManager");

	public String[] getAccount(String number) {
		System.out.println("Accountmanager.getAccount(" + number + ")");
		Account account = entityManager.find(Account.class, number);
		return account.details();
	}

	public String[][] getTransactions(String number) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public String newAccount(double newLimit, String newName, String newPincode) throws BankException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public String setOpen(boolean b) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
