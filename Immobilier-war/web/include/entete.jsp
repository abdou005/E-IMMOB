<%@page import="model.Personne"%>
<%@page import="java.util.List"%>
<%@page import="model.AnnonceBien"%>
<%@page import="model.Terain"%>
<%@page import="model.Depot"%>
<%@page import="model.Villa"%>
<%@page import="model.Studio"%>
<%@page import="model.Appartement"%>
<%@page import="model.Type"%>
<%@page import="model.Abonne"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>E-Immobilier</title>
    <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet" >
    <link type="text/css" href="css/font-awesome.min.css" rel="stylesheet">
    <link type="text/css" href="css/prettyPhoto.css" rel="stylesheet">
    <link type="text/css" href="css/price-range.css" rel="stylesheet">
    <link type="text/css" href="css/animate.css" rel="stylesheet">
    <link type="text/css" href="css/main.css" rel="stylesheet">
    <link type="text/css" href="css/responsive.css" rel="stylesheet">
    <script src="js/jquery.js"></script>    
    <script type="text/javascript" src="form/formValidation.js"></script>
    <script type="text/javascript" src="form/bootstrap.js"></script>
    <script type="text/javascript" src="assets/jssor.js"></script>
    <script type="text/javascript" src="assets/jssor.slider.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">  
</head><!--/head-->
<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
                                                             <% if(request.getSession().getAttribute("usersession")!=null){ 
                                                                Abonne abonne = (Abonne)request.getSession().getAttribute("usersession"); 
                                                                String nom =abonne.getNom(); 
                                                                System.out.println(abonne.getNom());                                                                  
                                                                %> 
                                                                <li><%=nom %></li>
                                                                <li class="dropdown">
                                                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                                                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                                                                        </a>
                                                                        <ul class="dropdown-menu dropdown-user">
                                                                            <li><a href="profil"><i class="fa fa-user fa-fw"></i> Mon compte</a>
                                                                            </li>
                                                                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Mes annonces</a>
                                                                            </li>
                                                                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Annonces sauvegardées</a>
                                                                            </li>
                                                                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Recherche sauvegardée</a>       
                                                                            </li>
                                                                             <li class="divider"></li>
                                                                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Reglages</a>
                                                                            </li>
                                                                            <li><a href="deconexion"><i class="fa fa-gear fa-fw"></i> Deconnexion</a>
                                                                            </li>                                                                                                                                                    
                                                                        </ul>
                                                                        <!-- /.dropdown-user -->
                                                                </li>
                                                                <% }%>	
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="accueil"><img src="img/logo.png" alt="" /></a>
						</div>				
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">								
								<li><a href="recherche"><i class="glyphicon glyphicon-search" aria-hidden="true"></i> Recherche des annonces</a></li>
                                                                <% if(request.getSession().getAttribute("usersession")==null){ %>
								<li><a href="#" data-toggle="modal" data-target=".bs-example-modal-sm"> <i class="fa fa-lock" aria-hidden="true"></i>Se connecter</a></li>
								
                                                                <li><a href="inscription"><i class="glyphicon glyphicon-user" aria-hidden="true"></i> Créer compte</a></li> 
                                                                <% }%>
								<li><a href="deposerAnno"> <i class="glyphicon glyphicon-list" aria-hidden="true"></i>Deposer Votre annonce</a></li>
                                                                 
								<!-- Small modal -->
                                                                                                                           

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->	
 <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-9">
                <div class="login-form"><!--login form-->
                     <h2>Connectez-vous à votre compte</h2>
                        <form id="defaultconForm" method="post" class="form-horizontal" action="connexionUser">
                            <div class="form-group">      
                                 <div class="col-sm-9">
                                  <input type="text" class="form-control" name="email" placeholder="Email Address"/>
                                  </div>
                             </div>
                             <div class="form-group">
                                  <div class="col-sm-9">
                                   <input type="password" class="form-control" name="password" placeholder="Password"/>
                                   </div>
                             </div>                                                               
                             <span>
                                <input type="checkbox" class="checkbox"> 
                                  Garder ma session active
                              </span>
                            <div class="form-group">
                               <div class="col-sm-9 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Submit</button>
                                </div>
                            </div>
                        </form>
                </div>
            </div>
        </div>
    </div>
  </div>
</div>
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="accueil" class="active">Accueil</a></li>
								<li class="dropdown"><a href="annonceType?typ=VENTE&mod=">Vente<i class="fa fa-angle-down"></i></a>
                                                                    <ul role="menu" class="sub-menu">                                                              
                                                                        <li><a href="annonceType?typ=VENTE&mod=Appartement">Appartement</a></li>
                                                                        <li><a href="annonceType?typ=VENTE&mod=Villa">Villa</a></li>
                                                                        <li><a href="annonceType?typ=VENTE&mod=Studio">Studio</a></li> 
                                                                        <li><a href="annonceType?typ=VENTE&mod=Depot">Depot</a></li> 
                                                                        <li><a href="annonceType?typ=VENTE&mod=Terain">Terain</a></li> 
                                                                        
                                                                    </ul>
                                                                </li> 
								<li class="dropdown"><a href="annonceType?typ=LOCATION&mod=">Location<i class="fa fa-angle-down"></i></a>
                                                                    <ul role="menu" class="sub-menu">
                                                                        <li><a href="annonceType?typ=LOCATION&mod=Appartement">Appartement</a></li>
                                                                        <li><a href="annonceType?typ=LOCATION&mod=Villa">Villa</a></li>
                                                                        <li><a href="annonceType?typ=LOCATION&mod=Studio">Studio</a></li>
                                                                        <li><a href="annonceType?typ=LOCATION&mod=Depot">Depot</a></li>
                                                                        <li><a href="annonceType?typ=LOCATION&mod=Terain">Terain</a></li>
                                                                    </ul>
                                                                </li> 
								<li class="dropdown"><a href="annonceType?typ=COLOCATION&mod=">Colocation<i class="fa fa-angle-down"></i></a>
                                                                    <ul role="menu" class="sub-menu">
                                                                        <li><a href="annonceType?typ=COLOCATION&mod=Appartement">Appartement</a></li>
                                                                        <li><a href="annonceType?typ=COLOCATION&mod=Villa">Villa</a></li>
                                                                        <li><a href="annonceType?typ=COLOCATION&mod=Studio">Studio</a></li>
                                                                    </ul>
                                                                </li>
                                                                <li class="dropdown"><a href="annonceType?typ=LOCATIONVACANCES&mod=">Location Vacances<i class="fa fa-angle-down"></i></a>
                                                                    <ul role="menu" class="sub-menu">
                                                                        <li><a href="annonceType?typ=LOCATIONVACANCES&mod=Appartement">Appartement</a></li>
                                                                        <li><a href="annonceType?typ=LOCATIONVACANCES&mod=Villa">Villa</a></li>
                                                                        <li><a href="annonceType?typ=LOCATIONVACANCES&mod=Studio">Studio</a></li>
                                                                    </ul>
                                                                </li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
                                                    <form method="post" action="rechercheMC">
                                                        <input type="text" placeholder="Recherche" name="mc"/>
                                                    </form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->       