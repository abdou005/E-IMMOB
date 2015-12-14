<%-- 
    Document   : statistique
    Created on : 1-May-2015, 2:30:49 AM
    Author     : abdo
--%>

<%@page import="model.Abonne"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Admin Statistique Immobilier</title>
    <!-- Bootstrap Core CSS -->
    <link href="stat/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="stat/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="stat/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="stat/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>   
<div id="wrapper">   
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="bordAdmin">Bord Admin</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="color: #FE980F;">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <% if(request.getSession().getAttribute("usersession")!=null){ 
                                                                Abonne abonne = (Abonne)request.getSession().getAttribute("usersession"); 
                                                                String nom =abonne.getNom(); 
                                                                System.out.println(abonne.getNom());                                                                  
                                                                %> 
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="profil"><i class="fa fa-user fa-fw"></i> Mon compte</a>
                        </li>
                        <li><a href="profil"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="deconexion"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                     <li><%=nom %></li>
                    <% }%>	
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
        </nav>
                    <br/><br>
                    <div class="container">
            <div class="row">
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${sessionScope.admcomm}</div>
                                        <div>Commentaires</div>
                                    </div>
                                </div>
                            </div>
                            <a href="bordAdmin" style="color:#FE980F;">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${sessionScope.admannonce}</div>
                                        <div>Annonces</div>
                                    </div>
                                </div>
                            </div>
                            <a href="bordAdmin" style="color:#FE980F;">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                        
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${sessionScope.admabonne}</div>
                                        <div>Abonnes</div>
                                    </div>
                                </div>
                            </div>
                            <a href="gererAbonne" style="color:#FE980F;">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
    </div> 
                    
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12" style="display: none;">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Line Chart Example
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="flot-chart">
                                <div class="flot-chart-content" id="flot-line-chart"></div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Nombre des annonces par type
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="flot-chart">
                                <div class="flot-chart-content" id="flot-pie-chart"></div>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                 <form method="post" action="#">
                        <input type="hidden"  class="vente" value="${requestScope.vente}"/>
                        <input type="hidden" class="loc" value="${requestScope.loc}"/>
                        <input type="hidden" class="locva" value="${requestScope.locvac}"/>
                        <input type="hidden" class="coloc" value="${requestScope.coloc}"/>                       
                    </form>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->   
        <!-- /#page-wrapper -->
</div>
</div>
    <!-- /#wrapper -->    
        <!-- jQuery -->
    <script src="stat/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="stat/bootstrap.min.js"></script>
    <!-- Flot Charts JavaScript -->
    <script src="stat/jquery.flot.js"></script>
    <script src="stat/jquery.flot.pie.js"></script>
    <script src="stat/jquery.flot.tooltip.min.js"></script>
    <script src="stat/flot-data.js"></script>
</body>

</html>
