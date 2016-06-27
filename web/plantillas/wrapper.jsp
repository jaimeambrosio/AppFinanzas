<%-- 
    Document   : wrapper
    Created on : 31/05/2016, 05:44:19 PM
    Author     : Jaime Ambrosio
--%>

<%@page import="fina.usuario.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuarioLogeado = (Usuario) request.getSession().getAttribute("usuarioLogeado");
%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <a class="navbar-brand" href="inicio.jsp">
            Simulador financiero AFP 
        </a>

    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

        <li class="dropdown"></li>
        
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" id="divMenu" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search" align="center" >
                    <img src="<%=usuarioLogeado.getFotoBase64()%>" alt="" class="img-thumbnail" /><br>
                    <span class="label label-default"><%=usuarioLogeado.getNombres() + " " + usuarioLogeado.getApellidos()%></span>

                </li>
                <li>
                    <a href="#" data-link="paneles/p-inicio.jsp" id="pInicio"><span class="glyphicon glyphicon-home"  ></span>  Inicio</a>
                    <ul class="nav nav-second-level"></ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-hourglass" id="pSimuladorAfp" ></span> Simulador AFP<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#" data-link="paneles/p-simular.jsp" data-constructor="p_simular();">Simular</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-refresh"  id="mConversiones" ></span> Conversiones<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Second Level Item</a>
                        </li>
                        <li>
                            <a href="#">Third Level <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Item</a>
                                </li>
                            </ul>
                            <!-- /.nav-third-level -->
                        </li>
                    </ul>
                </li>
                <li> 
                    <a href="#" id=""><span class="glyphicon glyphicon-list-alt"  ></span> Mantenimiento<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        
                        <li>
                            <a href="#" data-link="paneles/p-usuarios.jsp" data-constructor="p_usuarios();" id="pUsuarios" ><span class="glyphicon glyphicon-list" ></span> Usuarios</a>
                        </li>
                        <li>
                            <a href="#" data-link="paneles/p-tipofondoxafp.jsp" data-constructor="p_tipofondoxafp();" id="pTipoFondoXAfp" ><span class="glyphicon glyphicon-oil" ></span> Tipo de fondo por AFP</a>
                        </li>
                        <li>
                            <a href="#" data-link="paneles/p-tipocomisionxafp.jsp" data-constructor="p_tipocomisionxafp();" id="pTipoComisionXAfp" ><span class="glyphicon glyphicon-tint" ></span> Tipo comision por AFP</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <!--MI CUENTA-->
                <li> 
                    <a href="#" id="miCuenta"><span class="glyphicon glyphicon-cog"  ></span> Mi cuenta<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#" data-link="paneles/p-miperfil.jsp" data-constructor="p_miperfil();" id="pMiPerfil" ><span class="glyphicon glyphicon-user" ></span> Mi perfil</a>
                        </li>
                        
                        <li>
                            <a href="../usuarioServlet?accion=CERRARSESION"><span class="glyphicon glyphicon-off" ></span> Cerrar sesion</a>
                        </li>
                        <li>
                            <a href="#"  onclick="prueba();"  ><span class="glyphicon glyphicon-off" ></span> Prueba modal</a>
                        </li>
                        <li>
                            <a href="#" data-link="paneles/p-prueba.jsp" data-constructor="p_prueba();" data-pass="1" ><span class="glyphicon glyphicon-off" ></span> Prueba</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>
