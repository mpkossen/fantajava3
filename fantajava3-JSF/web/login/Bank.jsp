

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <title><h:outputText value="#{CommonBean.head}"/></title>
	    <link href="css/style.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body>
	    <div class="topdiv"></div>
	    <div class="sidebar"></div>
	    
	    <div class="body">
		Inloggen gelukt, U word over enkele ogenblikken naar de juiste pagina geleid.
		<h:panelGrid id="panel-manager" columns="1"
			     rendered="#{CommonBean.displayManager}">  
		    <meta http-equiv="Refresh" content="3; URL=../manager/AccountManager.faces" />
		</h:panelGrid>
		
		<h:panelGrid id="panel-office" columns="1"
			     rendered="#{CommonBean.displayOffice}">
		    <meta http-equiv="Refresh" content="3; URL=../office/OfficeManager.faces" />
		</h:panelGrid>
	    </div>
	</body>
    </html>
</f:view>
