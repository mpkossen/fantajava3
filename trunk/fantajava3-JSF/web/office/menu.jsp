<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<h:panelGrid border="0" columns="1" id="menu">
		<h:outputLink value="OfficeManager.faces">Transacties</h:outputLink>
		<h:outputLink value="Deposit.faces">Storten</h:outputLink>
		<h:outputLink value="Withdraw.faces">Opnemen</h:outputLink>
		<h:outputLink value="Transfer.faces">Overmaken</h:outputLink>
	</h:panelGrid>
</f:view>
