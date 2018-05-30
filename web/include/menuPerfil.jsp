<%-- 
    Document   : menuPerfil
    Created on : 17-may-2018, 19:30:41
    Author     : Alvaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header id="menu">
    <nav>
        <div id="izq">
            <h:form>
                <h:commandLink action="perfil">
                    <h:graphicImage value="/img/logo.png" />
                </h:commandLink>
            </h:form>
        </div>
        <div id="centro">
            <p>${sessionScope.usuActivo.nombre} ${sessionScope.usuActivo.apellidos}</p>
        </div>
        <div id="der">
            <h:graphicImage value="/img/perfil/no-image.png" />
            <div id="menuPer">
                <div id="menuSuperior">
                    <c:choose>
                        <c:when test = "${sessionScope.tipoUsuario eq 'atleta'}">
                            <p>${sessionScope.usuActivo.nombre}</p>
                            <p>${sessionScope.usuActivo.deporte}</p>
                        </div>
                        <div id="menuInferior">
                            <ul>
                                <li><h:form><h:commandLink action="atleta/inicio">Inicio</h:commandLink></h:form></li>
                                <li><h:form><h:commandLink action="atleta/perfil">Mi Perfil</h:commandLink></h:form></li>
                                <li><h:form><h:commandLink action="atleta/plan">Mi Plan</h:commandLink></h:form></li>
                                <li><h:form><h:commandLink action="atleta/chat">Chat</h:commandLink></h:form></li>
                                <li><h:form><h:commandLink action="atleta/ajustes">Ajustes</h:commandLink></h:form></</li>
                                <li><h:form><h:commandLink action="#{login.logout()}">Salir</h:commandLink></h:form></li>
                            </ul>
                                </div>
                    </c:when>
                    <c:when test = "${sessionScope.tipoUsuario eq 'preparador'}">
                        <p>${sessionScope.usuActivo.nombre}</p>
                        <p>Preparador</p>
                    </div>
                    <div id="menuInferior">
                        <ul>
                            <li><h:form><h:commandLink action="preparador/inicio">Inicio</h:commandLink></h:form></li>
                            <li><h:form><h:commandLink action="preparador/perfil">Mi Perfil</h:commandLink></h:form></li>
                            <li><h:form><h:commandLink action="preparador/atletas">Mis Atletas</h:commandLink></h:form></li>
                            <li><h:form><h:commandLink action="preparador/chat">Chat</h:commandLink></h:form></li>
                            <li><h:form><h:commandLink action="preparador/ajustes">Ajustes</h:commandLink></h:form></li>
                            <li><h:form><h:commandLink action="#{login.logout()}">Salir</h:commandLink></h:form></li>
                        </ul>
                    </div>

                </c:when>
            </c:choose>
        </div>
        </div>
    </nav>
</header>