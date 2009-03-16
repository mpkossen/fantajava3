

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<jsp:include page="/subview/header.jsp" flush="true"/>

	<jsp:include page="/manager/menu.jsp" flush="true" />

	<jsp:include page="/manager/login.jsp" flush="true" />

	<div id="content">
		<h:form id="status">
			<h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="Welkom in de status pagina" />
				<h:outputText value="Hier kunt u de status van de bank veranderen!" />
			</h:panelGrid>

                        <h:panelGrid columns="1" cellspacing="15">
				<h:outputText value="#{AccountManagerBean.status}" />
			</h:panelGrid>

			<h:panelGrid columns="3" cellspacing="15">
                            <h:commandButton action="#{AccountManagerBean.open}" value="Open" />
                            <h:commandButton action="#{AccountManagerBean.close}" value="Close" />
                            <h:commandButton action="#{AccountManagerBean.logout}" value="Loguit" />
			</h:panelGrid>
		</h:form>
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true"/>
</f:view>
