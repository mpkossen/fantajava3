/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.manager;

import beans.CommonBean;
import beans.Connector;
import common.BankException;
import jaas.MyPrincipal;
import java.lang.reflect.Method;
import javax.faces.context.FacesContext;
import remote.AccountManagerIF;

public class NewAccountBean extends CommonBean
{
	private String naam,  pincode;
	private Double limiet;

	public NewAccountBean()
	{
		System.out.println("NewAccountBean");
		limiet = 10000.00;
	}

	protected AccountManagerIF getAccountManager()
	{
		return Connector.getAccountManager();
	}

	/**
	 * @return the limiet
	 */
	public String getLimiet()
	{
		return limiet+"";
	}

	/**
	 * @param limiet the limiet to set
	 */
	public void setLimiet(String limiet)
	{
		try
		{
			this.limiet = Double.parseDouble(limiet);
		}
		catch (NumberFormatException nfe)
		{
			setMessage("Limiet moet een nummer zijn");
		}
	}

	/**
	 * @return the naam
	 */
	public String getNaam()
	{
		return naam;
	}

	/**
	 * @param naam the naam to set
	 */
	public void setNaam(String naam)
	{
		System.out.println("Set naam: "+naam);
		this.naam = naam;
	}

	public String getPincode()
	{
		return pincode;
	}

	public void setPincode(String pincode)
	{
		System.out.println("Set pincode: "+pincode);
		this.pincode = pincode;
	}

	public void opslaan()
	{
		AccountManagerIF a;
		try
		{
			System.out.println("opslaan");
			a = getAccountManager();
			System.out.println(a.getClass());
			for(Method m : a.getClass().getDeclaredMethods()){
				System.out.println(m.getName());
			}
			setMessage("Account is succesvol gemaakt, en "+getAccountManager().newAccount(limiet, naam, pincode));
			System.out.println("After message");
			setNaam("");
			setPincode("");
		}
		catch (BankException ex)
		{
			setMessage("Nieuw account aanmaken is mislukt");
		}
	}

}
