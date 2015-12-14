<%-- 
    Document   : gererabonne
    Created on : 27-Apr-2015, 6:34:15 PM
    Author     : abdo
--%>
<%@page import="model.Abonne"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                                                <li class="dropdown">
                                                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                                                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                                                                        </a>
                                                                        <ul class="dropdown-menu dropdown-user">
                                                                            <li><a href="profil"><i class="fa fa-user fa-fw"></i> Mon compte</a>
                                                                            </li>
                                                                            <li><a href="profil"><i class="fa fa-gear fa-fw"></i> Mes annonces</a>
                                                                            </li>
                                                                            <li><a href="profil"><i class="fa fa-gear fa-fw"></i> Annonces sauvegardées</a>
                                                                            </li>
                                                                            <li><a href="profil"><i class="fa fa-gear fa-fw"></i> Recherche sauvegardée</a>       
                                                                            </li>
                                                                             <li class="divider"></li>
                                                                            <li><a href="profil"><i class="fa fa-gear fa-fw"></i> Reglages</a>
                                                                            </li>
                                                                            <li><a href="deconexion"><i class="fa fa-gear fa-fw"></i> Deconnexion</a>
                                                                            </li>                                                                                                                                                    
                                                                        </ul>
                                                                        <!-- /.dropdown-user -->
                                                                </li>
                                                                <li><%=nom %></li>
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
							<a href="accueil"><img src="image/logo.png" alt="" /></a>
						</div>				
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">	                                                               
                                                                <li><a href="accueil"> <i class="glyphicon glyphicon-home" aria-hidden="true"></i>Accueil</a></li>
								<li><a href="recherche"><i class="glyphicon glyphicon-search" aria-hidden="true"></i> Recherche des annonces</a></li>               
								<li><a href="deposerAnno"> <i class="glyphicon glyphicon-list" aria-hidden="true"></i>Deposer Votre annonce</a></li> 
                                                                <li><a href="bordAdmin"><i class="fa fa-dashboard fa-fw" aria-hidden="true"></i>Bord-Admin</a></li>
                                                                <li><a href="statistique"><i class="fa fa-bar-chart-o fa-fw" aria-hidden="true"></i>Statistique</a></li>
								<!-- Small modal -->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
</header><!--/header-->
<div class="container">
    <br><br>
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

<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <% if(request.getAttribute("confadmin")!=null){%>
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification </strong>avec succe.
        </div>
        <%}%>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Liste des abonnes
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <c:forEach var="a" items="${requestScope.mapbienabonne}" varStatus="status">
                                <div class="panel panel-default"><!--Debut Traitement------------------>
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#${a.key.id}" title="Consulter Annonces"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> <br>${a.key.nom} ${a.key.prenom} <span style="color:#FE980F;"><c:choose><c:when test="${a.key.active==true}">(Activer)</c:when><c:otherwise>(Desactiver)</c:otherwise></c:choose></span> - Type: ${a.key.abonneType}</a> <span> | </span> ${a.key.email}
                                            <c:choose>
                                                <c:when test="${a.key.active==false}"><a class="cart_quantity_delete" href="activerAbonne?d=${a.key.id}" title="Activer Abonne"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a></c:when>
                                                <c:otherwise><a class="cart_quantity_delete" href="desactiverAbonne?d=${a.key.id}" title="Desactiver Abonne"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:otherwise>
                                            </c:choose>                                                                                     
                                            <a class="cart_quantity_delete" href="supUser?s=${a.key.id}" title="Suprimmer Abonne"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                        </h4>
                                    </div>
                                        <div id="${a.key.id}" class="panel-collapse collapse">
                                        <div class="panel-body">
        <section id="cart_items">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Listes des annonces</td>
							<td class="description"></td>
							<td class="price">Type</td>
							<td class="quantity">Ville</td>
							<td class="total">Prix</td>
							<td class="total">Action</td>
                                                       
						</tr>
					</thead>
                                        <tbody>
                                            <c:forEach var="b" items="${a.value}">
						<tr>
							<td class="cart_product">
                                                            <p style="color:#FE980F;"><c:choose><c:when test="${b.active == true}">(Activer par l'abonne)</c:when><c:otherwise>(Desactiver par l'abonne)</c:otherwise></c:choose></p>
                                                            <p style="color:#FE980F;"><c:choose><c:when test="${b.activeAdmin == true}">(Activer par l'admin)</c:when><c:otherwise>(Desactiver par l'admin)</c:otherwise></c:choose></p>
							</td>
							<td class="cart_description">
								<p><fmt:formatDate type="date" value="${b.dateModif}" /></p>
                                                                <p>${b.titre}</p>
                                                                <p><c:choose>
                                                                        <c:when test="${b.class.name.equals('model.Studio')}"><c:out value="Studio"/></c:when> 
                                                                       <c:when test="${b.class.name.equals('model.Appartement')}"><c:out value="Appartement"/></c:when> 
                                                                       <c:when test="${b.class.name.equals('model.Villa')}"><c:out value="Villa"/></c:when> 
                                                                       <c:when test="${b.class.name.equals('model.Depot')}"><c:out value="Depot"/></c:when>
                                                                       <c:when test="${b.class.name.equals('model.Terain')}"><c:out value="Terain"/></c:when> 
                                                                       <c:otherwise><c:out value="Bien"/></c:otherwise>    
                                                                    </c:choose></p>
							</td>
							<td class="cart_price">
								<p>${b.type.typeAnnonce}</p>                                                               
							</td>
							<td class="cart_quantity">
                                                            <p>${b.gov}</p>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${b.prix}</p>
							</td>                                                       
							<td class="cart_delete">
                                                                <a class="cart_quantity_delete" href="annonce?ann=${b.id}" title="consulter"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></a>                                                              
                                                                <c:choose>
                                                                    <c:when test="${b.activeAdmin == true}"><a class="cart_quantity_delete" href="desactiverAnnonceAdmin?d=${b.id}" title="Desactiver Annonce"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></c:when>
                                                                    <c:otherwise><a class="cart_quantity_delete" href="activerAnnonceAdmin?d=${b.id}" title="Activer Annonce"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a></c:otherwise>
                                                                </c:choose>  
                                                                <a class="cart_quantity_delete" href="supAnnonce?s=${b.id}" title="Suprimmer Annonce"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
							</td>
						</tr>
                                            </c:forEach>
					</tbody>
				</table>                           
                            </div>
    </section>   
                                        </div>
                                    </div>
                                </div><!--fin traitement   ----------------------->
                                </c:forEach>
                                
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
</div>
    <br/><br/><br/><br/><br/><br/><br/>
 <footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>E</span>-immobilier</h2>
							<p>ILS ONT VENDU ENTRE PARTICULIERS</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="annonceType?typ=VENTE&mod=">
									<div class="iframe-img">
										<img src="image/vente.jpg" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Vente</p>
								<h2></h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="annonceType?typ=LOCATION&mod=">
									<div class="iframe-img">
										<img src="image/location.jpg" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Location</p>
								<h2></h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="annonceType?typ=COLOCATION&mod=">
									<div class="iframe-img">
										<img src="image/colocation.jpg" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Colocation</p>
								<h2></h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="annonceType?typ=LOCATIONVACANCES&mod=">
									<div class="iframe-img">
										<img src="image/locvacance.jpg" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Location Vacance</p>
								<h2></h2>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="image/map.png" alt="" />
							<p>NOTRE SÉLECTION DE BIENS IMMOBILIERS DU JOUR</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © </p>
					<p class="pull-right">Designed by <span><a target="_blank" href="#"></a></span></p>
				</div>
			</div>
		</div>	
	</footer><!--/Footer--> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>