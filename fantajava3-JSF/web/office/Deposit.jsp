<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true" />

	<jsp:include page="/office/menu.jsp" flush="true" />

	<jsp:include page="/office/login.jsp" flush="true" />

	<div id="content">
		<h:form id="geldStorten">

			<%--<h:panelGrid columns="1" cellpadding="22">

				<h1><h:outputText value=" #{DepositB.errorMessage}" /></h1>
			</h:panelGrid>--%>


			<h:panelGrid columns="1" cellpadding="15" >
				<h:outputText value="Welkom in storten pagina" />
				<h:outputText value="#{DepositBean.message}" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellspacing="15">
				<h:outputText value="Bedrag" />
				<h:panelGrid columns="2">
					<h:inputText id="bedrag" value="#{DepositBean.bedrag}" required="true" validator="#{DepositBean.bedragInputValidator}"/>
					<h:message for="bedrag" showDetail="false" showSummary="true"/>
				</h:panelGrid>
				<h:outputText value="" />
				<h:commandButton action="#{DepositBean.geldStorten}" value="Storten" />

			</h:panelGrid>
		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true" />
</f:view>
