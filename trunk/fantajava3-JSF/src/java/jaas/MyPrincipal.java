/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaas;

import java.io.Serializable;
import java.security.Principal;
import remote.AccountOfficeIF;
import remote.AccountManagerIF;


public class MyPrincipal implements Principal, Serializable {

	private AccountManagerIF am;
	private AccountOfficeIF ao;
	protected String name;
        private ABCBankLoginModule blm;

	public MyPrincipal(String name) {
		System.out.println("MyPrincipal wordt gemaakt");
		this.name = name;
	}

	public MyPrincipal(String name, AccountManagerIF am,  ABCBankLoginModule blm) {
		this(name);
		this.am = am;
                this.blm = blm;
	}

	public MyPrincipal(String name, AccountOfficeIF ao,  ABCBankLoginModule blm) {
		this(name);
		this.ao = ao;
                this.blm = blm;
	}


	public boolean logout(){
		return blm.logout();
	}

	public String getName() {
		return name;
	}

	public AccountManagerIF getAccountManager() {
		return am;
	}

	public AccountOfficeIF getAccountOffice() {
		return ao;
	}

	@Override
	public boolean equals(Object o) {
		boolean ret = false;
		if (o != null) {
			if (o instanceof MyPrincipal) {
				MyPrincipal other = (MyPrincipal) o;
				if (this.name.equals(other.name)) {
					ret = true;
				}
			}
		}
		//System.out.print("MyPrincipal("+name+").equals("+o+"): "+ret);
		return ret;
	}

	public String toString() {
		String ret = "MyPrincipal {\n";
		ret += "name: " + name + "\n}";
		return ret;
	}
}