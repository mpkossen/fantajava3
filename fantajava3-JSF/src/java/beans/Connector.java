/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author mistermartin75
 */
import javax.naming.InitialContext;
import javax.naming.NamingException;
import remote.AccountManagerIF;
import remote.AccountOfficeIF;

public class Connector
{
	private static final String ACCOUNT_MANAGER = "java:comp/env/AccountManagerRef";
	private static final String ACCOUNT_OFFICE = "java:comp/env/AccountOfficeRef";
	private static InitialContext ctx = null;
	private static AccountManagerIF accountManager = null;
	private static AccountOfficeIF accountOffice = null;

	private static InitialContext getInitialContext() throws NamingException {
		System.out.println("Connector.getInitialContext()");
		if (ctx != null) {
			return ctx;
		}
		try {
			ctx = new InitialContext();
			return ctx;
		} catch (NamingException e) {
			System.err.println("connection-error: " + e.getMessage());
		}
		return null;
	}

	public static AccountManagerIF getAccountManager() {
		System.out.println("Connector.getAccountManager $");
		if (accountManager != null) {
			return accountManager;
		}
		try {
			ctx = getInitialContext();
			if (ctx != null) {
				Object obj = ctx.lookup(ACCOUNT_MANAGER);

				Class[] cls = obj.getClass().getInterfaces();
				for (int i = 0; i < cls.length; i++)
				{
					System.out.println("CLS[" + i + "] " + cls[i].getName());
				}

				System.out.println("[OBJECT] " + obj.getClass().getName());
				accountManager = (AccountManagerIF) obj;
				return accountManager;
			}
		} catch (NamingException e) {
			System.err.println("connection-error: " + e.getMessage());
		}
		return null;
	}

	public static AccountOfficeIF getAccountOffice() {
		System.out.println("Connector.getAccountOffice");
		if (accountOffice != null) {
			return accountOffice;
		}
		try {
			ctx = getInitialContext();
			if (ctx != null) {
				accountOffice = (AccountOfficeIF) ctx.lookup(ACCOUNT_OFFICE);
				return accountOffice;
			}
		} catch (NamingException e) {
			System.err.println("connection-error: " + e.getMessage());
		}
		return null;
	}
}