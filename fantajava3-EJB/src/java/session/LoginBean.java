/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import common.BankException;
import common.Database;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.persistence.*;
import remote.LoginIF;

/**
 *
 * @author Bami
 */
@Stateless(mappedName = "Login")
@Remote(LoginIF.class)
public class LoginBean implements LoginIF {

	private static final EntityManager entityManager = Database.getEntityManager("AccountManager");

	public String getBankStatus() throws BankException {
		Query query = entityManager.createQuery("FROM Status s");
		return "fuck";
	}

	public void Login(String username, String password, String salt) throws BankException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void Logout() throws BankException {
		throw new UnsupportedOperationException("Not supported yet.");
	}



}
