<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<h:panelGrid columns="1" id="menu">
		<h:outputLink value="AccountManager.faces">Accounts beheren</h:outputLink>
                <h:outputLink value="NewAccount.faces">Nieuw Account</h:outputLink>
                <h:outputLink value="Status.faces">Verander Status</h:outputLink>
	</h:panelGrid>
</f:view>