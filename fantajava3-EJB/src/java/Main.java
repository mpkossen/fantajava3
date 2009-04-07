
import session.AccountManager;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mistermartin75
 */
public class Main {
	public static void main(String[] args) {
		AccountManager am = new AccountManager();
		System.out.println("status" + am.getStatus());
	}
}
