<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true"/>

	<jsp:include page="/manager/menu.jsp" flush="true" />

	<jsp:include page="/manager/login.jsp" flush="true" />

	<div id="content">
		<h:form id="newAccount">
			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="Welkom in de nieuw account pagina" />
				<h:outputText value="Vul de gegevens in en klik op Opslaan" />
			</h:panelGrid>

			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="#{NewAccountBean.message}" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="15">
				<h:outputText value= "Naam:"/>
				<h:panelGrid columns="3">
					<h:inputText  value="#{NewAccountBean.naam}" required="true" id="naam"  />
					<h:message for="naam" showDetail="false" showSummary="true"/>
				</h:panelGrid>

				<h:outputText value="Pincode" />

				<h:panelGrid columns="3">
					<h:inputSecret  value="#{NewAccountBean.pincode}" id="pincode" required="true" />
					<h:message for="pincode" showDetail="false" showSummary="true"/>
				</h:panelGrid>

                                <h:outputText value="Limiet" />

				<h:panelGrid columns="3">
					<h:inputText  value="#{NewAccountBean.limiet}" id="limiet" required="true" />
					<h:message for="limiet" showDetail="false" showSummary="true"/>
				</h:panelGrid>
				<h:outputText value="" />
				<h:commandButton action="#{NewAccountBean.opslaan}" value="Opslaan" />
			</h:panelGrid>
		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true"/>
</f:view>