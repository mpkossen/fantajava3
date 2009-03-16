/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.session;

import javax.ejb.Stateless;

/**
 *
 * @author mistermartin75
 */
@Stateless
public class AccountOfficeBean implements AccountOfficeRemote {
    
    /*
	 * This is a test method
	 */
	public void sayHello()
	{
		System.out.println("Hello world!");
	}
 
}
