<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>


<h:dataTable value="#{AccountListB.list}" var="dataItem">
    <h:column>
        <f:facet name="header">
            <h:outputText value="ID" />
        </f:facet>
        <h:outputText value="#{dataItem.number}" />
    </h:column>

    <h:column>
        <f:facet name="header">
            <h:outputText value="Balance" />
        </f:facet>
        <h:outputText value="#{dataItem.balance}" />
    </h:column>
</h:dataTable>