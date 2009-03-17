// TODO: AccountOfficeIF, AccountManagerIF en MyPrincipal zorgen nog voor problemen, fixen.
package jaas;

import java.security.Principal;
import java.util.Map;
import java.util.Set;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;


public class ABCBankLoginModule implements LoginModule {

	// initial state
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	private Set<Principal> principals = null;
	private Map sharedState = null;
	private Map options = null;

	// the authentication status
	private boolean succeeded = false;
	private boolean commitSucceeded = false;

	// roles, callerPrincipal
	private MyGroup roles = null;
	private MyGroup callerPrincipal = null;

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
		System.out.println("ABCBankLoginModule.initialize()");
		this.subject = subject;
		principals = subject.getPrincipals();
		System.out.println("principals=" + principals);
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException {
		System.out.println("ABCBankLoginModule.login()");
		boolean ret = false;

		NameCallback nc = new NameCallback("User name: ", "guest");
		PasswordCallback pc = new PasswordCallback("Password: ", false);
		Callback callbacks[] = {nc, pc};
		try {
			callbackHandler.handle(callbacks);
		} catch (Exception e) {
			System.out.println(e);
			throw new LoginException(e.getMessage());
		}

		String username = nc.getName();
		String password = new String(pc.getPassword());
		pc.clearPassword();
		System.out.println("username=" + username);
		System.out.println("password=" + password);

		String salt = System.currentTimeMillis() + "";
		String pincode = password;
		roles = new MyGroup("Roles");
		try {
			AccountManagerIF am = new AccountManagerIF(username, pincode, salt);
			roles.addMember(new MyPrincipal("beheerders"));
			callerPrincipal = new MyGroup("CallerPrincipal");
			callerPrincipal.addMember(new MyPrincipal(username, am, this));
			ret = succeeded = true;
		} catch (Exception be) {
			try {
				System.out.println("Deze inlogger is geen AccountManager");
				AccountOfficeIF ao = new AccountOfficeIF(username, pincode, salt);
				roles.addMember(new MyPrincipal("klanten"));
				callerPrincipal = new MyGroup("CallerPrincipal");
				callerPrincipal.addMember(new MyPrincipal(username, ao, this));
				ret = succeeded = true;
			} catch (Exception ex) {
				abort();
				System.out.println("Deze inlogger is ook geen AccountOffice");
			}
		}


//		String[] myroles = abcBankAdmin.check(username, password);
//		if (myroles.length > 0) {
//			roles = new MyGroup("Roles");
//			for (String role : myroles) {
//				System.out.println("role: " + role);
//				roles.addMember(new MyPrincipal(role));
//			}
//			callerPrincipal = new MyGroup("CallerPrincipal");
//			callerPrincipal.addMember(new MyPrincipal(username));
//			ret = succeeded = true;
//		}

//		ret = libraryAdmin.check(username, password);
//		System.out.println("check: " + ret);
//		if (abcBankAdmin.check(username, password)) {
//			roles = new MyGroup("Roles");
//			roles.addMember(new MyPrincipal("beheerders"));
//			callerPrincipal = new MyGroup("CallerPrincipal");
//			callerPrincipal.addMember(new MyPrincipal(username));
//			ret = succeeded = true;
//		}
		System.out.println("ABCBankLoginModule.login(): " + ret);
		return ret;
	}

	public boolean commit() throws LoginException {
		System.out.println("ABCBankLoginModule.commit()");
		boolean ret = false;
		System.out.println(callerPrincipal.toString());
		if (succeeded) {
//			subject.getPrincipals().add(roles);
			principals.add(roles);
			principals.add(callerPrincipal);
			ret = commitSucceeded = true;
		}
		System.out.println("ABCBankLoginModule.commit(): " + ret);
		return ret;
	}

	/*************************************************************************\
	abort
	\*************************************************************************/
	public boolean abort() {
		boolean ret = true;
		succeeded = false;
		if (commitSucceeded) {
			ret = ret && logout();
			commitSucceeded = false;
		}
		System.out.println("LibraryLoginModule.abort(): " + ret);
		return ret;
	}

	/*************************************************************************\
	logout
	\*************************************************************************/
        	public boolean logout()
	{
		boolean ret = principals.remove(roles);
		ret = ret && principals.remove(callerPrincipal);
		System.out.println("BankLoginModule.logout(): " + ret);

		return ret;
	}
}