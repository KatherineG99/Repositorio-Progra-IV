
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession sesion = request.getSession();
    String usuario;
    RequestDispatcher rd;

    if (session.getAttribute("usuario") != null) {
        usuario = session.getAttribute("usuario").toString();
    } else {
        response.sendRedirect("Login.jsp");
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bower_components/bootstrap/dist/css/bootstrap_1.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Software Developer's</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>


        <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
              page. However, you can choose any other skin. Make sure you
              apply the skin class to the body tag so the changes take effect. -->
        <link rel="stylesheet" href="css/skins/skin-black.min.css">
        <link href="css/skins/skin-black.min.css" rel="stylesheet"/>
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">



    </head>
    <body class="hold-transition skin-black sidebar-mini">
        <div class="wrapper">

            <!-- Main Header -->
            <header class="main-header">
                <a href="#" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>S</b>DS</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Sistema </b>de desarrollo de Software</span>
                </a>

                <!-- Header Navbar -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">


                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">

                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">

                    <!-- Sidebar user panel (optional) -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/icon.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Bienvenido, ${usuario}  </p>
                            <!-- Status -->
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>

                    <!-- search form (Optional) -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->

                    <!-- Sidebar Menu -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">Trabajadores</li>
                        <!-- Optionally, you can add icons to the links -->
                        <li class="active"><a href="adminlte.jsp"><i class="fa fa-link"></i> <span>Inicio</span></a></li>
                        <li class="treeview">
                            <a href="#"><i class="glyphicon glyphicon-th-large"></i> <span>Registros</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="proyecto?action=mostrar"><i class="fa fa-archive"></i>Proyectos</a></li>
                                <li><a href="trabajador?action=mostrar"><i class="fa fa-tags"></i>Trabajadores</a></li>
                                <li><a href="InsertarUsuario.jsp"><i class="fa fa-cube"></i>Usuarios</a></li>
                                <li><a href="empresa?action=mostrar"><i class="fa fa-users"></i>Clientes</a></li>
                                <li><a href="profesion?action=mostrar"><i class="fa fa-book"></i>Profesiones</a></li>

                            </ul>
                        </li>

                        <li>
                            <a href="https://github.com/KatherineG99/Repositorio-Progra-IV.git"><i class="fa fa-github"></i><span>Repositorio</span></a>
                        </li>
                        <li class="treeview">
                            <a href="adminlte.jsp"><i class="fa fa-user-circle"></i> <span>${usuario}</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="usuarios?action=logout"><i class="fa fa-user-circle-o"></i>Cerrar Session</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- /.sidebar-menu -->
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Bienvenido de nuevo ${usuario}
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Trabajadores</li>
                        <li class="active">Mostrar</li>
                    </ol>
                </section>

                <section class="content">

                    <div class="container-fluid">
                        <div class="row">
                            <div class="m12 s12 s6 m6 l6 l12">
                                <h2 class="center black-text flow-text">Trabajadores</h2>
                                <br>
                                <a class="btn btn-microsoft" href="trabajador?action=insertall"><i class="fa fa-plus"></i>   Registrar Trabajadores</a>
                                <br>
                                <br>
                                <table class="table table-responsive table-hover table-striped">
                                    <thead class="table-dark">
                                        <tr>
                                            <th>Id trabajadores</th>
                                            <th>Id Profesion</th>
                                            <th>Nombre</th>
                                            <th>Apellidos</th>
                                            <th >Dui</th>
                                            <th >Horas trabajadas</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lista}" var="trab">
                                            <tr>
                                                <td>${trab.idtrabajador}</td>
                                                <td>${trab.idprofesion.idprofesion}</td>
                                                <td>${trab.nombre}</td>
                                                <td>${trab.apellidos}</td>
                                                <td>${trab.dui}</td>
                                                <td>${trab.horastrabaja}</td>
                                                <td >
                                                    <a class="btn btn-tumblr" href="trabajador?action=borrar&idtrabajador=${trab.idtrabajador}"><i class="fa fa-trash"></i></a>
                                                
                                                    <a class="btn btn-pinterest" href="trabajador?action=seleccionarByid&idtrabajador=${trab.idtrabajador}"><i class="fa fa-archive"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <br>

                            </div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Main Footer -->
            <footer class="main-footer">
                <!-- To the right -->
                <div class="pull-right hidden-xs">
                    A tu disposicion
                </div>
                <!-- Default to the left -->
                <strong>Copyright &copy; 2020 <a href="#">SDS</a>.</strong> Todos los derechos reservados.
            </footer>

            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- REQUIRED JS SCRIPTS -->

        <!-- jQuery 3 -->
        <script src="bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- AdminLTE App -->
        <script src="js/adminlte.min.js"></script>




    </body>
</html>

