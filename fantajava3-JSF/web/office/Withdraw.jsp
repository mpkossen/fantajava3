<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true" />

	<jsp:include page="/office/menu.jsp" flush="true" />

	<jsp:include page="/office/login.jsp" flush="true" />

	<div id="content">
		<h:form id="geldOpnemen">
			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="Welkom in opnemen pagina" />
				<h:outputText value="Vul uw bedrag in en klik op Geld opnemen" />
			</h:panelGrid>

			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="#{WithdrawBean.message}" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="15">

				<h:outputText>Saldo</h:outputText>
				<h:panelGrid columns="2">
					&euro;<h:outputLabel value="#{WithdrawBean.saldo}"/>
				</h:panelGrid>
				<h:outputText>Bedrag</h:outputText>
				<h:panelGrid columns="2">
					<h:inputText value="#{WithdrawBean.bedrag}" id="bedrag" validator="#{WithdrawBean.bedragInputValidator}" />
					<h:message for="bedrag" showDetail="false" showSummary="true"/>
				</h:panelGrid>
				<h:outputText value="" />
				<h:commandButton action="#{WithdrawBean.geldOpnemen}" value="Opnemen" />
			</h:panelGrid>

		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true" />

</f:view>
