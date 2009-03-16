<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
	<jsp:include page="/subview/header.jsp" flush="true"/>

	<jsp:include page="/manager/menu.jsp" flush="true" />

	<jsp:include page="/manager/login.jsp" flush="true" />

	<div id="content">
		<h:panelGrid columns="2" cellspacing="15">
			<h:outputText value="Accounts beheren" />
		</h:panelGrid>
		<jsp:include page="#{AccountManagerBean.form}" flush="true" />
	</div>

	<jsp:include page="/subview/footer.jsp" flush="true"/>
</f:view>