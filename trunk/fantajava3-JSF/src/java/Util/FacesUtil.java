package Util;

import java.util.TreeSet;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class FacesUtil
{
	private FacesUtil()
	{
	}	//Hide constructor

	public static String getAttribute(ActionEvent event, String name)
	{
		return (String) event.getComponent().getAttributes().get(name);
	}

	public static Object getSessionMapValue(String key)
	{
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	public static void setSessionMapValue(String key, Object value)
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	}

}
