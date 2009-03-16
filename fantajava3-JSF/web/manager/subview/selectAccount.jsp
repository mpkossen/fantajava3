<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<h:form id="selectAccount">
	<h:panelGrid columns="1" cellpadding="15">
		<h:outputText value="#{AccountManagerBean.message}" />
	</h:panelGrid>
	<h:panelGrid columns="2" cellpadding="15">
		<h:outputText value="Account nummer" />
		<h:inputText id="account_number" value="#{AccountManagerBean.accountNumber}" />
		<h:commandButton action="#{AccountManagerBean.selectAccount}" value="Selecteer account" />
	</h:panelGrid>
</h:form>