<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true" />

	<jsp:include page="/office/menu.jsp" flush="true" />

	<jsp:include page="/office/login.jsp" flush="true" />

	<div id="content">
		<h:form id="overboeken">
			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="Welkom in overboeken pagina" />
				<h:outputText value="Vul de rekeningnummer en bedrag in en klik op Geld overboeken" />
			</h:panelGrid>

			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="#{TransferBean.message}" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="15">
				<h:outputText>Uw saldo</h:outputText>
				<h:panelGrid columns="2">
					&euro;<h:outputLabel value="#{WithdrawBean.saldo}"/>
				</h:panelGrid>
				<h:outputText value= "Naar Rekeningnummer"/>
				<h:panelGrid columns="2">
					<h:inputText  value="#{TransferBean.reknrNaar}" required="true" id="reknrNaar"  />
					<h:message for="reknrNaar" showDetail="false" showSummary="true"/>
				</h:panelGrid>

				<h:outputText value="Bedrag" />

				<h:panelGrid columns="2">
					<h:inputText  value="#{TransferBean.bedrag}" id="bedrag" required="true" validator="#{TransferBean.bedragInputValidator}" />
					<h:message for="bedrag" showDetail="false" showSummary="true"/>
				</h:panelGrid>
				<h:outputText value="" />
				<h:commandButton action="#{TransferBean.overboeken}" value="Overboeken" />
			</h:panelGrid>
		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true" />
</f:view>
