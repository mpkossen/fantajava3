/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.context.FacesContext;


public class CommonBean {

	private String head = "ABC-Bank";
	private String message;

	public CommonBean() {
		System.out.println("CommonBean()");
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	  public boolean getDisplayManager() {
	System.out.println("BankBean.getDisplayManager()");
	return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("beheerders");
    }

    public boolean getDisplayOffice() {
	System.out.println("BankBean.getDisplayOffice()");
	return FacesContext.getCurrentInstance().getExternalContext().isUserInRole("klanten");
    }

}
