<%@page import="model.Personne"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.Abonne"%>
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
							<a href="accueil"><img src="image/logo.png" alt="" /></a>
						</div>				
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">								
                                                                <li><a href="accueil"> <i class="glyphicon glyphicon-home" aria-hidden="true"></i>Accueil</a></li>
								<li><a href="recherche"><i class="glyphicon glyphicon-search" aria-hidden="true"></i> Recherche des annonces</a></li> 
                                                                 <% if(request.getSession().getAttribute("usersession")==null){ %>
								<li><a href="#" data-toggle="modal" data-target=".bs-example-modal-sm"> <i class="fa fa-lock" aria-hidden="true"></i>Se connecter</a></li>
                                                                <li><a href="inscription"><i class="glyphicon glyphicon-user" aria-hidden="true"></i> Créer compte</a></li> 
                                                                <% }%>
								<li><a href="deposerAnno"> <i class="glyphicon glyphicon-list" aria-hidden="true"></i>Deposer Votre annonce</a></li> 
                                                                <% if(request.getSession().getAttribute("usersession")!=null){ 
                                                                Abonne abonne = (Abonne)request.getSession().getAttribute("usersession");
                                                                if(abonne.isAdmin()){
                                                                %>
                                                                <li><a href="bordAdmin"><i class="fa fa-dashboard fa-fw" aria-hidden="true"></i>Bord-Admin</a></li>
                                                                <li><a href="statistique"><i class="fa fa-bar-chart-o fa-fw" aria-hidden="true"></i>Statistique</a></li>
                                                                <%}}%>
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
                                                        <input type="text" name="rechmc" placeholder="Recherche"/>
                                                    </form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->     
<!--slider debut-->
	<!--<section id="slider">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Free E-Commerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Free Ecommerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div>
								<div class="col-sm-6">
									<img src="images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>			
				</div>
			</div>
		</div>
	</section>-->
        <!--/ fin slider-->
	
<section>
    <div class="container"> 
    <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <c:if test="${! empty deposermsg}">
         <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>!! </strong> ${deposermsg}
        </div>   
        </c:if>
        <c:if test="${! empty msgsauv}">
         <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>!! </strong> ${msgsauv}
        </div>   
        </c:if>
    </div>
    <div class="col-sm-2"></div>   
    </div>
		
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Habitable
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
                                                                                    <li><a href="getAnnonceCat?cat=appr">Appartement<font color="#FE980F">(${applicationScope.appsize})</font></a></li>
                                                                                    <li><a href="getAnnonceCat?cat=vill">Villa<font color="#FE980F">(${applicationScope.vilsize})</font></a></li>
                                                                                    <li><a href="getAnnonceCat?cat=stu">Studio<font color="#FE980F">(${applicationScope.stusize})</font></a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#mens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                                                                        Terain<font color="#FE980F">(${applicationScope.tersize})</font>
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
                                                                                    <li><a href="getAnnonceCat?cat=tour">Zone touristique<font color="#FE980F">(${applicationScope.tertoursize})</font></a></li>
                                                                                        <li><a href="getAnnonceCat?cat=agric">Zone agricole<font color="#FE980F">(${applicationScope.teragrisize})</font></a></li>
                                                                                        <li><a href="getAnnonceCat?cat=trvill">Zone villa<font color="#FE980F">(${applicationScope.tervilsize})</font></a></li>
                                                                                        <li><a href="getAnnonceCat?cat=inds">Zone industrielle<font color="#FE980F">(${applicationScope.terindssize})</font></a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
                                                                    <h4 class="panel-title"><a href="getAnnonceCat?cat=dep">Depot<font color="#FE980F">(${applicationScope.depsize})</font></a></h4>
								</div>
							</div>
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Region</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
                                                                    <c:forEach var="entry" items="${applicationScope.govannoncemap}" >
                                                                    <li><a href="getAnnonceGov?deleg=${entry.key}"> <span class="pull-right"><font color="#FE980F">(${entry.value})</font></span>${entry.key}</a></li>
                                                                    </c:forEach>						
								</ul>
							</div>
						</div><!--/brands_products-->
                                                <div class="brands_products">
                                                <div class="col-sm-12"><br>
                                                <iframe src="http://www.facebook.com/plugins/likebox.php?href=https://www.facebook.com/rapidestore1&amp;width=300&amp;connections=4&amp;stream=false&amp;header=false&amp;height=" scrolling="no" frameborder="0" style="border:none; width:100%; height:241px; overflow:hidden;" allowtransparency="true">
                                                </iframe>
                                                </div>
                                                </div>
					</div>
				</div>				
				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<h2 class="title text-center">Dernière annonce </h2>
                                                <c:forEach var="b" items="${applicationScope.accueillist}">
                                                <div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
                                                                                    <c:choose>
                                                                                    <c:when test="${empty b.value}">
                                                                                        <img src="image/photoDefaut.jpg" alt="" width="200" height="200">
                                                                                    </c:when> 
                                                                                    <c:otherwise>  
                                                                                        <c:forEach var="i" items="${b.value}" begin="0" end="0">
                                                                                            <img src="MesImage/${i.url}" alt="" width="200" height="200">
                                                                                        </c:forEach>
                                                                                    </c:otherwise>  
                                                                                    </c:choose>
											<h2>${b.key.prix}</h2>
											<p>${b.key.type.typeAnnonce}</p> 
                                                                                        <p><fmt:formatDate type="date" value="${b.key.dateModif}" /></p>
                                                                                        <p>${b.key.class.name}</p> 
											<a href="#" class="btn btn-default add-to-cart"><i class="glyphicon glyphicon-list"></i>Consulter</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">							
												<p>${b.key.gov}<strong> - </strong>${b.key.deleg.region} </p>
												<a href="annonce?ann=${b.key.id}" class="btn btn-default add-to-cart"><i class="glyphicon glyphicon-list"></i>Consulter</a>
											</div>
										</div>
								</div>              
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
                                                                            <c:if test="${!empty sessionScope.usersession}">
                                                                                <li><a href="sauvgardeBien?ann=${b.key.id}"><i class="fa fa-plus-square"></i>Favoris</a></li>   
                                                                            </c:if>
                                                                                <li><a href="http://www.facebook.com/sharer.php?u=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.key.id}&t=Votre%20message%20ici." target="_blank"><i class="fa fa-plus-square"></i>Partager sur Facebook</a></li>                    
									</ul>
								</div>
							</div>
						</div>	
                                                </c:forEach>
					</div> 
                                                <ul class="pagination">
                                        		<li><a href="#">Previous</a></li>
                                                        <c:forEach var="v" begin="1" end="${applicationScope.nbpage}"> 
							<li><a href="pagination?p=${v}">${v}</a></li>
                                                        </c:forEach>
							<li><a href="#">Next</a></li>
						</ul>
                                <div class="recommended_items">
						<h2 class="title text-center">Propositions</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
                                                            <div class="item active">
                                                            <c:forEach var="b" items="${applicationScope.listbiendemande}" begin="0" end="2">									
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">							
                                                                                                        <c:choose>
                                                                                                        <c:when test="${empty b.value}">
                                                                                                            <img src="image/photoDefaut.jpg" alt="" width="100" height="150"/>
                                                                                                        </c:when> 
                                                                                                        <c:otherwise>  
                                                                                                            <c:forEach var="i" items="${b.value}" begin="0" end="0">
                                                                                                                <img src="MesImage/${i.url}" alt="" width="100" height="150"/>
                                                                                                            </c:forEach>
                                                                                                        </c:otherwise>  
                                                                                                        </c:choose>
													<h2>${b.key.prix}</h2>
                                                                                                        <p>${b.key.type.typeAnnonce}</p>
													<a href=annonce?ann=${b.key.id}" class="btn btn-default add-to-cart"><i class="glyphicon glyphicon-list"></i>Consulter</a>
												</div>												
											</div>
										</div>
									</div>                                                                								
                                                                </c:forEach>  
                                                                </div>
                                                            <div class="item">
                                                            <c:forEach var="b" items="${applicationScope.listbiendemande}" begin="3">									
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">							
                                                                                                        <c:choose>
                                                                                                        <c:when test="${empty b.value}">
                                                                                                            <img src="image/photoDefaut.jpg" alt="" width="100" height="150"/>
                                                                                                        </c:when> 
                                                                                                        <c:otherwise>  
                                                                                                            <c:forEach var="i" items="${b.value}" begin="0" end="0">
                                                                                                                <img src="MesImage/${i.url}" alt="" width="100" height="150"/>
                                                                                                            </c:forEach>
                                                                                                        </c:otherwise>  
                                                                                                        </c:choose>
													<h2>${b.key.prix}</h2>
                                                                                                        <p>${b.key.type.typeAnnonce}</p>
													<a href="annonce?ann=${b.key.id}" class="btn btn-default add-to-cart"><i class="glyphicon glyphicon-list"></i>Consulter</a>
												</div>												
											</div>
										</div>
									</div>								
                                                            </c:forEach>
                                                            </div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div>
			</div>
		</div>
               </div>
	</section>
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
        <script src="form/formconnexion.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>                                                                