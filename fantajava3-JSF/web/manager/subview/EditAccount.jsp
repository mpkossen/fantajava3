<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<h:form>
	<h:panelGrid columns="1" cellspacing="15">
		<h:commandButton action="#{AccountManagerBean.terug}" value="Terug" />
		<h:outputText value="#{AccountBean.accountNumber}" />
	</h:panelGrid>
</h:form>
<h:panelGrid columns="2" cellpadding="10">
	<h:outputText value="Naam" />
	<h:outputText id="naam" value="#{AccountManagerBean.naam}" />
	<h:outputText value="Limiet" />
	<h:outputText id="limiet" value="#{AccountManagerBean.limiet}" />
</h:panelGrid>

<h:panelGrid columns="1" cellspacing="15">
	De transacties van dit account:
</h:panelGrid>

<h:dataTable  value="#{AccountManagerBean.transactions}" var="t" cellpadding="10"  border="1" >
	<h:column>
		<f:facet name="header"><h:outputText>Transactie nummer</h:outputText></f:facet>
		<h:outputText value="#{t[0]}"/>
	</h:column>
	<h:column>
		<f:facet name="header"><h:outputText>Van rekeningnummer</h:outputText> </f:facet>
		<h:outputText value="#{t[1]}"/>
	</h:column>
	<h:column>
		<f:facet name="header"><h:outputText>Naar rekeningnummer</h:outputText> </f:facet>
		<h:outputText value="#{t[2]}"/>
	</h:column>
	<h:column>
		<f:facet name="header"><h:outputText>Bedrag</h:outputText> </f:facet>
		<h:outputText value="#{t[3]}"/>
	</h:column>
</h:dataTable>