<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view >
	<jsp:include page="/subview/header.jsp" flush="true"/>

	<div id="menu"></div>
	<div id="content">
		<%--<h:form id="BankAcces" target="test" >
			<h:panelGrid columns="2" cellpadding="22">
				<h:outputText value="Gebruikersnaam" />
				<h:inputText id="j_username" />
				<h:outputText value="Wachtwoord" />
				<h:inputSecret id="j_password" />

				<h:commandButton action="j_security_check" value="Inloggen" />
			</h:panelGrid>
		</h:form>--%>
		<form action="j_security_check" method="get">
            <table cellpadding="0" cellspacing="0">
                <tr>
                    <td><label for="j_username">Login</label></td>
                    <td><input type="text" name="j_username" /></td>
                </tr>
                <tr>
                    <td><label for="j_password">Wachtwoord</label></td>
                    <td><input type="password" name="j_password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input value="Login" type="submit" /> <input value="Exit" type="reset" /></td>
                </tr>
            </table>
		</form>
	</div>
	<div id="login"></div>
	</div>
	<jsp:include page="subview/footer.jsp" flush="true"/>
</f:view>