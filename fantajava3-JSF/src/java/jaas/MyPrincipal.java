/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaas;

import efg.jpa.bank.AccountManager;
import efg.jpa.bank.AccountOffice;
import java.io.Serializable;
import java.security.Principal;


public class MyPrincipal implements Principal, Serializable {

	private AccountManager am;
	private AccountOffice ao;
	protected String name;
        private ABCBankLoginModule blm;

	public MyPrincipal(String name) {
		System.out.println("MyPrincipal wordt gemaakt");
		this.name = name;
	}

	public MyPrincipal(String name, AccountManager am,  ABCBankLoginModule blm) {
		this(name);
		this.am = am;
                this.blm = blm;
	}

	public MyPrincipal(String name, AccountOffice ao,  ABCBankLoginModule blm) {
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

	public AccountManager getAccountManager() {
		return am;
	}

	public AccountOffice getAccountOffice() {
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