<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<div id="login">
	Welkom <h:outputText value="#{AccountOfficeBean.name}"/> <br />
	uw rekeningnummer is <h:outputText value="#{AccountOfficeBean.rekeningNummer}" /><br />
	uw saldo is &euro;<h:outputText value="#{AccountOfficeBean.saldo}" />
</div>
