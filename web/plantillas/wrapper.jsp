<%-- 
    Document   : wrapper
    Created on : 31/05/2016, 05:44:19 PM
    Author     : Jaime Ambrosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>

        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" id="divMenu" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search" align="center" >
                    <img src="../img/user.png" alt="" class="img-thumbnail" /><br>
                   <span class="label label-default">Jaime Ambrosio mallqui mallqui mallqui</span>
                    
                </li>
                <li>
                    <a href="#" data-content="paneles/p-inicio.jsp" id="pInicio" ><span class="glyphicon glyphicon-home"  ></span>  Inicio</a>
                    <ul class="nav nav-second-level"></ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-hourglass" id="pSimuladorAfp" ></span> Simulador AFP<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Panels and Wells</a>
                        </li>
                        <li>
                            <a href="#">Buttons</a>
                        </li>
                        <li>
                            <a href="#">Notifications</a>
                        </li>
                        <li>
                            <a href="#">Typography</a>
                        </li>
                        <li>
                            <a href="#"> Icons</a>
                        </li>
                        <li>
                            <a href="#">Grid</a>
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
                <!--MI CUENTA-->
                <li> 
                    <a href="#" id="miCuenta"><span class="glyphicon glyphicon-cog"  ></span> Mi cuenta<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#pMiPerfil" data-content="paneles/p-miperfil.jsp" data-constructor=" p_miperfil();" id="pMiPerfil" ><span class="glyphicon glyphicon-user" ></span> Mi perfil</a>
                        </li>
                        <li>
                            <a href="#"><span class="glyphicon glyphicon-off" ></span> Cerrar sesion</a>
                        </li>
                        <li>
                            <a href="#"  onclick="prueba();"><span class="glyphicon glyphicon-off" ></span> Prueba modal</a>
                        </li>
                        <li>
                            <a href="#" data-content="paneles/p-prueba.jsp" data-constructor="p_prueba();" ><span class="glyphicon glyphicon-off" ></span> Prueba</a>
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
