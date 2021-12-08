

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="bower_components/bootstrap/dist/css/bootstrap_1.css" rel="stylesheet" />
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Software Developer's</title>
        <!-- Tell the browser to be responsive to screen width -->
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
                <a href="adminlte.jsp" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>S</b>DS</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Sistema </b>de desarrollo de Software</span>
                </a>


            </header>

            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Registro
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Inicio</a></li>
                        <li class="active">Usuario</li>
                        <li class="active">Registro</li>
                    </ol>
                </section>

                <section class="content">

                    <!-- Content Wrapper. Contains page content -->
                    <div class="card-body">
                        <div class="content-wrapper">
                            <div class="container">
                                <div class="row">
                                    <div class="m12 s12 s6 m6 l6 l12">
                                        <br>
                                        <form action="usuarios?action=Registrar" method="POST">
                                            <label>Usuario: </label>
                                            <input type="text" class="form-control" name="usuario" >
                                            <br>    
                                            <label>Clave: </label>
                                            <input type="text" class="form-control" name="clave" >
                                            <br>
                                            <label>Correo: </label>
                                            <input type="text" class="form-control" name="correo" >
                                            <button class="btn btn-microsoft" type="submit">
                                                Registrar
                                            </button>
                                        </form>
                                        <br>
                                        <label class="text-darken-">${msj}</label>
                                        <br>
                                        <a class=" btn btn-danger" href="Login.jsp">Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
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


