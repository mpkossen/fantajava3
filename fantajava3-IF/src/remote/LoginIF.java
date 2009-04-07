/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package remote;

import common.BankException;


/**
 *
 * @author Bami
 */
public interface LoginIF {
	public String getBankStatus() throws BankException;
	public void Login(String username, String password, String salt) throws BankException;
	public void Logout() throws BankException;
}
