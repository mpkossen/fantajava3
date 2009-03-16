<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true" />

	<jsp:include page="/office/menu.jsp" flush="true" />

	<jsp:include page="/office/login.jsp"  flush="true" />

	<div id="content">
		<h:panelGrid columns="1" cellpadding="15">
			<h:outputText>Uw nog niet verzonden transacties</h:outputText>
			<h:outputText value="#{AccountOfficeBean.message}" />
		</h:panelGrid>

		<h:dataTable  value="#{AccountOfficeBean.transactions}" var="t" cellpadding="10"  border="1" >
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
		<h:form id="sendTransactions">
			<h:commandButton action="#{AccountOfficeBean.doTransactions}" value="Transacties versturen" />
                        <h:commandButton action="#{AccountOfficeBean.logout}" value="Loguit" />
		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true" />
</f:view>
