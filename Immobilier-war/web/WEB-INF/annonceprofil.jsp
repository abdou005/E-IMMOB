<%@page import="model.Terain"%>
<%@page import="model.Depot"%>
<%@page import="model.Villa"%>
<%@page import="model.Studio"%>
<%@page import="model.Appartement"%>
<%@page import="model.AnnonceBien"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><fmt:formatDate type="date" value="${b.dateModif}" />
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
<style type="text/css">
	.sticky-container{
		/*background-color: #333;*/
		padding: 0px;
		margin: 0px;
		position: fixed;
		right: -119px;
		top:130px;
		width: 200px;

	}

	.sticky li{
		list-style-type: none;
		background-color: #333;
		color: #efefef;
		height: 43px;
		padding: 0px;
		margin: 0px 0px 1px 0px;
		-webkit-transition:all 0.25s ease-in-out;
		-moz-transition:all 0.25s ease-in-out;
		-o-transition:all 0.25s ease-in-out;
		transition:all 0.25s ease-in-out;
		cursor: pointer;
		filter: url("data:image/svg+xml;utf8,<svg xmlns=\'http://www.w3.org/2000/svg\'><filter id=\'grayscale\'><feColorMatrix type=\'matrix\' values=\'0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0.3333 0.3333 0.3333 0 0 0 0 0 1 0\'/></filter></svg>#grayscale"); 
                filter: gray; 
                -webkit-filter: grayscale(100%); 

	}

	.sticky li:hover{
		margin-left: -115px;
		/*-webkit-transform: translateX(-115px);
		-moz-transform: translateX(-115px);
		-o-transform: translateX(-115px);
		-ms-transform: translateX(-115px);
		transform:translateX(-115px);*/
		/*background-color: #8e44ad;*/
		filter: url("data:image/svg+xml;utf8,<svg xmlns=\'http://www.w3.org/2000/svg\'><filter id=\'grayscale\'><feColorMatrix type=\'matrix\' values=\'1 0 0 0 0, 0 1 0 0 0, 0 0 1 0 0, 0 0 0 1 0\'/></filter></svg>#grayscale");
                -webkit-filter: grayscale(0%);
	}

	.sticky li img{
		float: left;
		margin: 5px 5px;
		margin-right: 10px;

	}

	.sticky li p{
		padding: 0px;
		margin: 0px;
		text-transform: uppercase;
		line-height: 43px;

	}

	/** fork icon**/
	.fork{
		position: absolute;
		top:0px;
		left: 0px;
	}
	</style>
<style> 
        .captionOrange, .captionBlack
        {
            color: #fff;
            font-size: 20px;
            line-height: 30px;
            text-align: center;
            border-radius: 4px;
        }
        .captionOrange
        {
            background: #EB5100;
            background-color: rgba(235, 81, 0, 0.6);
        }
        .captionBlack
        {
        	font-size:16px;
            background: #000;
            background-color: rgba(0, 0, 0, 0.4);
        }
        a.captionOrange, A.captionOrange:active, A.captionOrange:visited
        {
        	color: #ffffff;
        	text-decoration: none;
        }
        a.captionOrange:hover
        {
            color: #eb5100;
            text-decoration: underline;
            background-color: #eeeeee;
            background-color: rgba(238, 238, 238, 0.7);
        }
        .bricon
        {
            background: url(../img/browser-icons.png);
        }
</style>
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
                                                                String nom = abonne.getNom();
                                                                System.out.println(nom);  
                                                                %> 
                                                                <li><%=nom %></li>
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
                                                                        <li><a href="annonceType?typ=VENTE&mod=Studio">Studio</a></li>                                                                       </li> 
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
                                                    <form method="post" action="#">
                                                        <input type="text" placeholder="Recherche"/>
                                                    </form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
<section>
<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
             <% if(request.getAttribute("confmodif")!=null){%>
         <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification Annonce</strong> avec succe.
        </div>   
        <%} %> 
         </div> 
    <div class="col-sm-2"></div>   
</div>
		<div class="sticky-container">
		<ul class="sticky">
			<li>
                            <a href="http://www.facebook.com/sharer.php?u=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}&t=Votre%20message%20ici." target="_blank"><img width="32" height="32" title="" alt="" src="image/fb1.png" /></a>
				<p>Facebook</p>
			</li>
			<li>
                            <a href="https://twitter.com/share?url=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}" target="_blank"><img width="32" height="32" title="" alt="" src="image/tw1.png" /></a>
				<p>Twitter</p>
			</li>
			<li>
                            <a href=https://plus.google.com/share?url=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}&hl=fr" target="_blank"><img width="32" height="32" title="" alt="" src="image/plus.png" /></a>
				<p>Google+</p>
			</li>
			<li>
                            <a href="http://www.linkedin.com/shareArticle?mini=true&url=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}&title=E-IMMOBILIER" target="_blank"><img width="32" height="32" title="" alt="" src="image/li1.png" /></a>
				<p>Linkedin</p>
			</li>
			<li>
                            <a href="http://www.aliasdmc.fr/share.php?url=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}" target="_blank"><img width="32" height="32" title="" alt="" src="image/rss1.png" /></a>
				<p>RSS</p>
			</li>
		</ul>
	</div>
		<div class="container">                                           
                         <div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
                                            <c:set var="b" value="${sessionScope.bienprofil}"/>                                          
                                            <% Abonne ab = (Abonne)request.getSession().getAttribute("usersession");%>
						<!--category-productsr-->
                                                    <h4 align="center"><font face="georgia" color="#FE980F">Description</font></h4>
                                                    <hr/>
                                                    <form method="" action="">
                                                        <div class="col-sm-12">
                                                            <p><strong>Type :</strong> <%=ab.getAbonneType() %> </p>
                                                        </div>                                                       
                                                        <div class="col-sm-12">
                                                             <p><strong>Tel :</strong> <%=ab.getTel1() %><strong> - </strong><%=ab.getPrenom() %></p>
                                                        </div>                                                       
                                                        <div class="col-sm-12">
                                                            <p>${b.gov}<strong>-</strong>${b.deleg.region}</p>
                                                        </div>                                                        
                                                        <div class="col-sm-10">
                                                            <!--<button type="submit" class="btn btn-outline btn-primary btn-lg btn-block">Envoye un message</button>-->
                                                        </div>
                                                    </form>							
					<!--/category-products-->
					</div>
				</div>				
				<div class="col-sm-9 padding-right"> 
                                    <div class="features_items">
                                        <div style="display: block; margin: 20px auto 0 auto; margin-top: 2px; padding: 10px 5px 5px 10px; width: 96%; max-width:940px; min-width: 240px; border: 1px solid #ccc; background-color: #fff; box-shadow: 2px 2px 10px 2px #dddddd; -webkit-box-shadow: 0px 0px 5px 0px #dddddd; ">
                                       <!-- Jssor Slider Begin -->
                                       <!-- You can move inline styles to css file or css block. -->
                                           <div id="slider1_container" style="position: relative; margin: 0px 5px 5px 0px; float: left; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
                                               <!-- Slides Container -->
                                               <div u="slides" style="cursor: move; position: absolute; left: 0px; top: 0px; width: 600px; height: 300px; overflow: hidden;">
                                                      <c:choose>
                                                                                    <c:when test="${empty sessionScope.imagesprofil}">
                                                                                        <div><img u="image" src="image/photoDefaut.jpg" />
                                                                                            <div u="caption" t="CLIP|L" style="position:absolute;left:100px;top:80px;width:110px;height:40px;font-size:36px;color:#fff;line-height:40px;">Glissez</div>  
                                                                                            <div u="caption" t="CLIP|L" style="position:absolute;left:230px;top:80px;width:120px;height:40px;font-size:36px;color:#fff;line-height:40px;">S-V-P!</div> 
                                                                                         </div> 
                                                                                    </c:when> 
                                                                                    <c:otherwise>  
                                                                                        <c:forEach var="v" items="${sessionScope.imagesprofil}">
                                                                                            <div><img u="image" src="MesImage/${v.url}" />
                                                                                            <a class="cart_quantity_delete" href="supImage?img=${v.id}&an=${v.bien.id}" title="Suprimmer image" style="position:absolute;left:4px;top:4px;"><span class="glyphicon glyphicon-trash" aria-hidden="true" style="color:#FE980F;"></span></a>
                                                                                           
                                                                                            <a class="cart_quantity_delete" href="uploadImg?an=${v.bien.id}" title="Ajouter des images" style="position:absolute;right:4px;top:4px;"><span class="glyphicon glyphicon-picture" aria-hidden="true" style="color:#FE980F;"></span></a>
                                                                                                <div u="caption" t="CLIP|L" style="position:absolute;left:100px;top:80px;width:110px;height:40px;font-size:36px;color:#fff;line-height:40px;">Glissez</div>  
                                                                                                <div u="caption" t="CLIP|L" style="position:absolute;left:230px;top:80px;width:120px;height:40px;font-size:36px;color:#fff;line-height:40px;">S-V-P!</div> 
                                                                                            </div>
                                                                                        </c:forEach>
                                                                                    </c:otherwise>  
                                                      </c:choose> 
                                               </div>
                                               <!-- Trigger -->
                                           </div>
                                           <!-- Jssor Slider End -->
                                           <c:forEach var="v"  items="${sessionScope.imagesprofil}" begin="0" end="0"> 
                                           <img src="MesImage/${v.url}" style="float: left; margin-right: 5px; width: 50px; height: 50px;" />
                                           </c:forEach>
                                           <p><strong>${b.type.typeAnnonce}</strong></p>
                                           <p><fmt:formatDate type="date" value="${b.dateModif}" /></p>
                                           <p><strong>${b.titre}</strong></p>
                                           <p><strong>${b.prix}</strong></p>
                                           <p>${b.description}</p>
                                           <p> Superficier total :<font  color="#FE980F">${b.superficieTotal}(m2)</font></p>
                                           <p>Titre Bleu :<font  color="#FE980F">${b.titreBleau}</font></p> 
                                <%if(request.getSession().getAttribute("bienprofil")!=null){
                                          AnnonceBien annonce = (AnnonceBien)request.getSession().getAttribute("bienprofil");
                                            if(annonce.getClass().getName().equals("model.Appartement")){                                            
                                              Appartement appart = (Appartement) annonce;
                                              %>
                                                <p><strong>Habitable :</strong> Apartement</p>
                                                <p>Superficier habitable :<font  color="#FE980F"><%=appart.getSuperficieHabitable() %>(m2)</font></p>
                                                <p>Annee de construction :<font  color="#FE980F"><%=appart.getAnneeConstruction() %></font></p>
                                                <p>Nombre de piece :<font  color="#FE980F"><%=appart.getNbrDePiece() %></font></p>
                                                <p>Nombre de Salon :<font  color="#FE980F"><%=appart.getSalon() %></font></p>
                                                <p>Nombre de Chambre :<font  color="#FE980F"><%=appart.getChambre() %></font></p>
                                                <p>Nombre de salle de bain :<font  color="#FE980F"><%=appart.getSalleDeBain() %></font></p>
                                                <p>WC :<font  color="#FE980F"><%=appart.getWc() %></font></p>
                                                <p>Balcon :<font  color="#FE980F"><%=appart.isBalcon() %></font></p>
                                                <p>Climatiseur :<font  color="#FE980F"><%=appart.isClimatisation() %></font></p>
                                                <p>Chauffage :<font  color="#FE980F"><%=appart.isChauffage() %></font></p>
                                                <p>Numero Etage :<font  color="#FE980F"><%=appart.getNumEtage() %></font></p>
                                                <p>Assenceur :<font  color="#FE980F"><%=appart.isAssenceur() %></font></p>
                                                <p>Parking :<font  color="#FE980F"><%=appart.isParking() %></font></p>
                                                <p>Sandik :<font  color="#FE980F"><%=appart.isSandic() %></font></p>
                                          
                                           <%}
                                            if(annonce.getClass().getName().equals("model.Studio")){
                                               Studio studio = (Studio) annonce;
                                             %>
                                           <p><strong>Habitable :</strong> Studio</p>
                                                <p>Superficier habitable :<font  color="#FE980F"><%=studio.getSuperficieHabitable() %>(m2)</font></p>
                                                <p>Annee de construction :<font  color="#FE980F"><%=studio.getAnneeConstruction() %></font></p>
                                                <p>Nombre de piece :<font  color="#FE980F"><%=studio.getNbrDePiece() %></font></p>
                                                <p>Nombre de Salon :<font  color="#FE980F"><%=studio.getSalon() %></font></p>
                                                <p>Nombre de Chambre :<font  color="#FE980F"><%=studio.getChambre() %></font></p>
                                                <p>Nombre de salle de bain :<font  color="#FE980F"><%=studio.getSalleDeBain() %></font></p>
                                                <p>WC :<font  color="#FE980F"><%=studio.getWc() %></font></p>
                                                <p>Balcon :<font  color="#FE980F"><%=studio.isBalcon() %></font></p>
                                                <p>Climatiseur :<font  color="#FE980F"><%=studio.isClimatisation() %></font></p>
                                                <p>Chauffage :<font  color="#FE980F"><%=studio.isChauffage() %></font></p>
                                                
                                           <% }
                                            if(annonce.getClass().getName().equals("model.Villa")){
                                                Villa villa = (Villa) annonce;
                                             %>
                                            <p><strong>Habitable :</strong> Villa</p>
                                                <p>Superficier habitable :<font  color="#FE980F"><%=villa.getSuperficieHabitable() %>(m2)</font></p>
                                                <p>Annee de construction :<font  color="#FE980F"><%=villa.getAnneeConstruction() %></font></p>
                                                <p>Nombre de piece :<font  color="#FE980F"><%=villa.getNbrDePiece() %></font></p>
                                                <p>Nombre de Salon :<font  color="#FE980F"><%=villa.getSalon() %></font></p>
                                                <p>Nombre de Chambre :<font  color="#FE980F"><%=villa.getChambre() %></font></p>
                                                <p>Nombre de salle de bain :<font  color="#FE980F"><%=villa.getSalleDeBain() %></font></p>
                                                <p>WC :<font  color="#FE980F"><%=villa.getWc() %></font></p>
                                                <p>Balcon :<font  color="#FE980F"><%=villa.isBalcon() %></font></p>
                                                <p>Climatiseur :<font  color="#FE980F"><%=villa.isClimatisation() %></font></p>
                                                <p>Chauffage :<font  color="#FE980F"><%=villa.isChauffage() %></font></p>  
                                                <p>Nombre d'etage :<font  color="#FE980F"><%=villa.getNbrEtage() %></font></p>
                                                <p>Jardin :<font color="#FE980F"><%=villa.isJardin() %></font></p>
                                                <p>Garage :<font  color="#FE980F"><%=villa.isGarage() %></font></p>  
                                                <p>Piscine :<font  color="#FE980F"><%=villa.isPiscine() %></font></p>
                                            <%}
                                            if(annonce.getClass().getName().equals("model.Depot")){
                                                Depot depot = (Depot) annonce;
                                              %>
                                            <p><strong>Depot :</strong></p>
                                            <p>Superficier couvert :<font color="#FE980F"><%=depot.getSuperficieCouvert() %></font></p> 
                                            <p>Annee de construction couvert :<font color="#FE980F"><%=depot.getAnneeConstruction() %></font></p>
                                            
                                           <%}
                                            if(annonce.getClass().getName().equals("model.Terain")){
                                               
                                                Terain terain = (Terain) annonce;
                                             %>                                        
                                            <p><strong>Terrain :</strong></p>
                                            <p>Zonne : <font  color="#FE980F"><%=terain.getTerainType() %></font></p>   
                                             
                                            <%}
                                }%>
                                <br><br>
                                        </div> 
                                     </div>
                                </div> 
                        </div>
                        <br>
                        <div class="row">
                            
                               <div class="socials-share">
                                    <table><tr><td><a href="https://twitter.com/share?url=http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}" class="twitter-share-button" data-count="vertical" data-via="InfoWebMaster" target="_blank">Tweet</a>
                                                    <script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script></td>
                                            <td><g:plusone size="tall"></g:plusone></td>
                                        <td><script type="text/javascript" src="//platform.linkedin.com/in.js"></script><script type="in/share" data-counter="top"></script></td>
                                        <td>
                                           <a name="fb_share" type="box_count" share_url="http://127.0.0.1:8080/Immobilier-war/annonce?ann=${b.id}" target="_blank"></a>
                                                   <script src="http://static.ak.fbcdn.net/connect.php/js/FB.Share" type="text/javascript"></script> 
                                        </td></tr></table>

                                                    
                                                    
                                                     
				</div>                    
                                <div class="rating-area">
						<ul class="ratings">
							<li class="rate-this">Nombre d'impression</li>
							<li>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
							</li>
							<li class="color">(${b.nbimpr})</li>
						</ul>
						<ul class="tag">
							<li>TAG:</li>
							<li><a class="color" href="">Vente <span>/</span></a></li>
							<li><a class="color" href="">Location <span>/</span></a></li>
							<li><a class="color" href="">Colocation</a></li>
						</ul>
				</div>                                 
                                <div class="response-area">
                                    <h2>${requestScope.nbrcommentprofil} Commentaires</h2>
                                    <c:forEach var="c" items="${requestScope.commbienprofil}"> 				
						<ul class="media-list">
                                                    <c:choose>
                                                        <c:when test="${c.abonne == null}">
                                                        <li class="media">
								
								<a class="pull-left" href="#">
								</a>
								<div class="media-body">
									<ul class="sinlge-post-meta">
										<li><i class="fa fa-user"></i>${c.nomuser}</li>
										<li><i class="fa fa-clock-o"></i> <fmt:formatDate type="time" value="${c.date}" /></li>
										<li><i class="fa fa-calendar"></i><fmt:formatDate type="date" value="${c.date}" /></li>
									</ul>
                                                                    <p> ${c.contenu}</p>
                                                                    <a class="btn btn-primary" href="supCommentaire?com=${c.id}&bienid=${b.id}"><i class="fa fa-reply"></i>Supprimer</a>
								</div>
							</li>
                                                        </c:when>
                                                        <c:otherwise>
                                                        <li class="media second-media">
								<a class="pull-left" href="#">
								</a>
								<div class="media-body">
									<ul class="sinlge-post-meta">
										<li><i class="fa fa-user"></i>${c.nomuser}</li>
										<li><i class="fa fa-clock-o"></i> ${c.date}</li>
										<li><i class="fa fa-calendar"></i> ${c.date.day} ${c.date.month}</li>
									</ul>
									<p> ${c.contenu}</p>
                                                                        <a class="btn btn-primary" href="supCommentaire?com=${c.id}&bienid=${b.id}"><i class="fa fa-reply"></i>Supprimer</a>
								</div>
							</li> 
                                                        </c:otherwise>
                                                    </c:choose>        
						</ul>
                                    </c:forEach>
				</div>     
                                 <%if(request.getSession().getAttribute("usersession")!=null){%>
                                  <div class="replay-box">
                                    <form id="defaultconForm" method="post" action="commentAbonneprofil">
                                                        <div class="row">
                                                                <div class="col-sm-4">
                                                                        <h2>Ecrire Commentaire</h2>
                                                                                <input type="hidden" name="bienid" value="${b.id}"> 
                                                                </div>
                                                                <div class="col-sm-8">
                                                                        <div class="text-area">
                                                                                <div class="blank-arrow">
                                                                                        <label>Commentaire</label>
                                                                                </div>
                                                                                <span>*</span>
                                                                                <textarea name="message" rows="11" required="true"></textarea>
                                                                                <button type="submit" class="btn btn-primary" >poster commentaire</button>
                                                                        </div>
                                                                </div>
                                                           
                                                        </div>
                                     </form>
                                </div>                                
                                 <%}%>                                    
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
            <script>
        jQuery(document).ready(function ($) {
            //Reference http://www.jssor.com/development/tip-make-responsive-slider.html

            var _CaptionTransitions = [];
            _CaptionTransitions["CLIP|L"] = { $Duration: 600, $Clip: 1, $Easing: $JssorEasing$.$EaseInOutCubic };
            _CaptionTransitions["RTT|10"] = { $Duration: 600, $Zoom: 11, $Rotate: 1, $Easing: { $Zoom: $JssorEasing$.$EaseInExpo, $Opacity: $JssorEasing$.$EaseLinear, $Rotate: $JssorEasing$.$EaseInExpo }, $Opacity: 2, $Round: { $Rotate: 0.8} };
            _CaptionTransitions["ZMF|10"] = { $Duration: 600, $Zoom: 11, $Easing: { $Zoom: $JssorEasing$.$EaseInExpo, $Opacity: $JssorEasing$.$EaseLinear }, $Opacity: 2 };
            _CaptionTransitions["FLTTR|R"] = { $Duration: 600, x: -0.2, y: -0.1, $Easing: { $Left: $JssorEasing$.$EaseLinear, $Top: $JssorEasing$.$EaseInWave }, $Opacity: 2, $Round: { $Top: 1.3} };

            var options = {
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $DragOrientation: 3,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0),

                $CaptionSliderOptions: {                            //[Optional] Options which specifies how to animate caption
                    $Class: $JssorCaptionSlider$,                   //[Required] Class to create instance to animate caption
                    $CaptionTransitions: _CaptionTransitions,       //[Required] An array of caption transitions to play caption, see caption transition section at jssor slideshow transition builder
                    $PlayInMode: 1,                                 //[Optional] 0 None (no play), 1 Chain (goes after main slide), 3 Chain Flatten (goes after main slide and flatten all caption animations), default value is 1
                    $PlayOutMode: 3                                 //[Optional] 0 None (no play), 1 Chain (goes before main slide), 3 Chain Flatten (goes before main slide and flatten all caption animations), default value is 1
                }
            };

            var jssor_slider1 = new $JssorSlider$("slider1_container", options);
            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() {

                //reserve blank width for margin+padding: margin+padding-left (10) + margin+padding-right (10)
                var paddingWidth = 20;

                //minimum width should reserve for text
                var minReserveWidth = 150;

                var parentElement = jssor_slider1.$Elmt.parentNode;

                //evaluate parent container width
                var parentWidth = parentElement.clientWidth;

                if (parentWidth) {

                    //exclude blank width
                    var availableWidth = parentWidth - paddingWidth;

                    //calculate slider width as 70% of available width
                    var sliderWidth = availableWidth * 0.7;

                    //slider width is maximum 600
                    sliderWidth = Math.min(sliderWidth, 600);

                    //slider width is minimum 200
                    sliderWidth = Math.max(sliderWidth, 200);

                    //evaluate free width for text, if the width is less than minReserveWidth then fill parent container
                    if (availableWidth - sliderWidth < minReserveWidth) {

                        //set slider width to available width
                        sliderWidth = availableWidth;

                        //slider width is minimum 200
                        sliderWidth = Math.max(sliderWidth, 200);
                    }

                    jssor_slider1.$ScaleWidth(sliderWidth);
                }
                else
                    window.setTimeout(ScaleSlider, 30);
            }
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        });
    </script>
<script type="text/javascript" src="https://apis.google.com/js/plusone.js">
{lang: 'fr'}
</script>   
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>