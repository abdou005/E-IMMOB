<%@page import="model.Type"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Abonne"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>E-Immobilier</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="all" href="assets/styles.css" />        
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
							<a href="/accueil"><img src="image/logo.png" alt="" /></a>
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
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->   
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
                                                    <form method="post" action="rechercheMC">
                                                        <input type="text" placeholder="Recherche"/>
                                                    </form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->  
        <div class="container">
<section id="form" style="margin-top: 5px;"><!--form-->
<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">
        <% if(request.getAttribute("confmodif")!=null){%>
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification </strong>avec succe.
        </div> 
        <%} %>
        <% if(request.getAttribute("confsup")!=null){%>
         <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>supprimer</strong> avec succe.
        </div>   
        <%} %> 
          <% if(request.getAttribute("confmodifprofil")!=null){%>
         <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification Profil</strong> avec succe.
        </div>   
        <%} %>
        <% if(request.getAttribute("confpswsuc")!=null){%>
         <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification password</strong> avec succe.
        </div>   
        <%} %> 
        <% if(request.getAttribute("confpswerr")!=null){%>
         <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <strong>Modification password</strong> S-V-P Veuillez remplir correctement les champs ou le nouveau mot de passe doit etre supérieure a 3 caractères.
        </div>   
        <%} %> 
    </div> 
    <div class="col-sm-2"></div>   
</div>
     <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Mon compte
                        </div>
                        <!-- .panel-heading -->
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Mes Annonces</a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                                <section id="cart_items">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Annonce</td>
							<td class="description"></td>
							<td class="price">Type</td>
							<td class="quantity">Ville</td>
							<td class="total">Prix</td>
							<td class="total">Action</td>
                                                       
						</tr>
					</thead>
                                        <tbody>
                                            <c:forEach var="a" items="${sessionScope.listannonceactive}">
						<tr>
							<td class="cart_product">
                                                                <a href="annonceProfil?an=${a.key.id}">
                                                                        <c:choose>
                                                                        <c:when test="${empty a.value}">
                                                                            <img src="image/photoDefaut.jpg" alt="" width="50px" height="50px">
                                                                        </c:when> 
                                                                        <c:otherwise>  
                                                                            <c:forEach var="i" items="${a.value}" begin="0" end="0">
                                                                                <img src="MesImage/${i.url}" alt="" width="50px" height="50px">
                                                                            </c:forEach>
                                                                        </c:otherwise>  
                                                                        </c:choose>
                                                                </a>
							</td>
							<td class="cart_description">
								<p><fmt:formatDate type="date" value="${a.key.dateModif}" /></p>
                                                                <p>${a.key.titre}</p>
                                                                <p><c:choose>
                                                                        <c:when test="${a.key.class.name.equals('model.Studio')}"><c:out value="Studio"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Appartement')}"><c:out value="Appartement"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Villa')}"><c:out value="Villa"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Depot')}"><c:out value="Depot"/></c:when>
                                                                       <c:when test="${a.key.class.name.equals('model.Terain')}"><c:out value="Terain"/></c:when> 
                                                                       <c:otherwise><c:out value="Bien"/></c:otherwise>    
                                                                    </c:choose></p>
							</td>
							<td class="cart_price">
								<p>${a.key.type.typeAnnonce}</p>                                                               
							</td>
							<td class="cart_quantity">
                                                            <p>${a.key.gov}</p>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${a.key.prix}</p>
							</td>
                                                                <td class="cart_delete">
                                                                    <a class="cart_quantity_delete" href="desactiverAnnonce?d=${a.key.id}" title="Desactiver Annonce"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
                                                                    <a class="cart_quantity_delete" href="annonceProfil?an=${a.key.id}" title="consulter"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></a>
                                                                    <a class="cart_quantity_delete" href="modifierAnnonce?an=${a.key.id}" title="Modifier"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                                                    <a class="cart_quantity_delete" href="uploadImg?an=${a.key.id}" title="Ajouter des images"><span class="glyphicon glyphicon-picture" aria-hidden="true"></span></a>
                                                                    <a class="cart_quantity_delete" href="supAnnonce?s=${a.key.id}" title="Suprimmer Annonce"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>                                                                    
                                                                </td>                                                        
						</tr>
                                            </c:forEach>
                                                <tr>
							<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
									<tr>
										<td>Vente</td>
                                                                                <td>(${sessionScope.uservente})</td>
									</tr>
									<tr>
										<td>Location</td>
										<td>(${sessionScope.userloc})</td>
									</tr>
                                                                        <tr>
										<td>Location Vacance</td>
										<td>(${sessionScope.userlocv})</td>
									</tr>
									<tr class="shipping-cost">
										<td>Colocation</td>
										<td>(${sessionScope.usercol})</td>										
									</tr>
                                                                        
									<tr>
										<td>Total</td>
										<td><span>(${sessionScope.userto})</span></td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>                           
                            </div>
    </section>   
                                        </div>
                                    </div>
                                </div>
                                 <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#anndesactive">Annonces Desactives</a>
                                        </h4>
                                    </div>
                                    <div id="anndesactive" class="panel-collapse collapse">
                                        <div class="panel-body">
        <section id="cart_items">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Annonce</td>
							<td class="description"></td>
							<td class="price">Type</td>
							<td class="quantity">Ville</td>
							<td class="total">Prix</td>
							<td class="total">Action</td>
                                                       
						</tr>
					</thead>
                                        <tbody>
                                            <c:forEach var="a" items="${sessionScope.listannoncedesactive}">
						<tr>
							<td class="cart_product">
								<a href="annonceProfil?an=${a.key.id}">
                                                                    <c:choose>
                                                                    <c:when test="${empty a.value}">
                                                                        <img src="image/photoDefaut.jpg" alt="" width="50px" height="50px">
                                                                    </c:when> 
                                                                    <c:otherwise>  
                                                                        <c:forEach var="i" items="${a.value}" begin="0" end="0">
                                                                            <img src="MesImage/${i.url}" alt="" width="50px" height="50px">
                                                                        </c:forEach>
                                                                    </c:otherwise>  
                                                                    </c:choose>
                                                                </a>
                                                                     <p style="color:#FE980F;"><c:choose><c:when test="${a.key.activeAdmin == true}">(Activer par l'admin)</c:when><c:otherwise>(Desactiver par l'admin)</c:otherwise></c:choose></p>
							</td>
							<td class="cart_description">
								<p><fmt:formatDate type="date" value="${a.key.dateModif}" /></p>
                                                                <p>${a.key.titre}</p>
                                                                <p><c:choose>
                                                                        <c:when test="${a.key.class.name.equals('model.Studio')}"><c:out value="Studio"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Appartement')}"><c:out value="Appartement"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Villa')}"><c:out value="Villa"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Depot')}"><c:out value="Depot"/></c:when>
                                                                       <c:when test="${a.key.class.name.equals('model.Terain')}"><c:out value="Terain"/></c:when> 
                                                                       <c:otherwise><c:out value="Bien"/></c:otherwise>    
                                                                    </c:choose></p>
							</td>
							<td class="cart_price">
								<p>${a.key.type.typeAnnonce}</p>                                                               
							</td>
							<td class="cart_quantity">
                                                            <p>${a.key.gov}</p>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${a.key.prix}</p>
							</td>                                                       
							<td class="cart_delete">
                                                            <c:if test="${a.key.activeAdmin == true}"> <a class="cart_quantity_delete" href="activerAnnonce?d=${a.key.id}" title="Activer Annonce"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a></c:if> 
                                                                <a class="cart_quantity_delete" href="annonceProfil?an=${a.key.id}" title="consulter"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></a>
                                                                <a class="cart_quantity_delete" href="modifierAnnonce?an=${a.key.id}" title="Modifier"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                                                <a class="cart_quantity_delete" href="uploadImg?an=${a.key.id}" title="Ajouter des images"><span class="glyphicon glyphicon-picture" aria-hidden="true"></span></a>
                                                                <a class="cart_quantity_delete" href="supAnnonce?s=${a.key.id}" title="Suprimmer Annonce"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>                                                                        
							</td>
						</tr>
                                            </c:forEach>
					</tbody>
				</table>                           
                            </div>
    </section>   
                                        </div>
                                    </div>
                                </div>                                       
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Annonces Sauvgaders</a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
        <section id="cart_items">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Annonce</td>
							<td class="description"></td>
							<td class="price">Type</td>
							<td class="quantity">Ville</td>
							<td class="total">Prix</td>
							<td class="total">Action</td>
                                                       
						</tr>
					</thead>
                                        <tbody>
                                            <c:forEach var="a" items="${sessionScope.listannoncesauv}">
                                               ${a.key.active}
                                               <c:choose>
                                                   <c:when test="${a.key.active == false}">
                                                       <tr>
							<td class="cart_product">
								<a href="#">
                                                                    <c:choose>
                                                                    <c:when test="${empty a.value}">
                                                                        <img src="image/photoDefaut.jpg" alt="" width="50px" height="50px">
                                                                    </c:when> 
                                                                    <c:otherwise>  
                                                                        <c:forEach var="i" items="${a.value}" begin="0" end="0">
                                                                            <img src="MesImage/${i.url}" alt="" width="50px" height="50px">
                                                                        </c:forEach>
                                                                    </c:otherwise>  
                                                                    </c:choose>
                                                                </a>
                                                            <p>Desactiver</p>
							</td>
							<td class="cart_description">
								<p><fmt:formatDate type="date" value="${a.key.dateModif}" /></p>
                                                                <p>${a.key.titre}</p>
                                                                <p><c:choose>
                                                                       <c:when test="${a.key.class.name.equals('model.Studio')}"><c:out value="Studio"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Appartement')}"><c:out value="Appartement"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Villa')}"><c:out value="Villa"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Depot')}"><c:out value="Depot"/></c:when>
                                                                       <c:when test="${a.key.class.name.equals('model.Terain')}"><c:out value="Terain"/></c:when> 
                                                                       <c:otherwise><c:out value="Bien"/></c:otherwise>    
                                                                    </c:choose></p>
							</td>
							<td class="cart_price">
								<p>${a.key.type.typeAnnonce}</p>                                                               
							</td>
							<td class="cart_quantity">
                                                            <p>${a.key.gov}</p>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${a.key.prix}</p>
							</td>                                                       
							<td class="cart_delete">
                                                                <a class="cart_quantity_delete" href="supSauv?s=${a.key.id}" title="Suprimmer Sauvgarde"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
							</td>
						</tr>
                                                   </c:when>
                                                   <c:otherwise>
                                                       <tr>
							<td class="cart_product">
								<a href="annonce?ann=${a.key.id}">
                                                                    <c:choose>
                                                                    <c:when test="${empty a.value}">
                                                                        <img src="image/photoDefaut.jpg" alt="" width="50px" height="50px">
                                                                    </c:when> 
                                                                    <c:otherwise>  
                                                                        <c:forEach var="i" items="${a.value}" begin="0" end="0">
                                                                            <img src="MesImage/${i.url}" alt="" width="50px" height="50px">
                                                                        </c:forEach>
                                                                    </c:otherwise>  
                                                                    </c:choose>
                                                                </a>
							</td>
							<td class="cart_description">
								<p><fmt:formatDate type="date" value="${a.key.dateModif}" /></p>
                                                                <p>${a.key.titre}</p>
                                                                <p><c:choose>
                                                                        <c:when test="${a.key.class.name.equals('model.Studio')}"><c:out value="Studio"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Appartement')}"><c:out value="Appartement"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Villa')}"><c:out value="Villa"/></c:when> 
                                                                       <c:when test="${a.key.class.name.equals('model.Depot')}"><c:out value="Depot"/></c:when>
                                                                       <c:when test="${a.key.class.name.equals('model.Terain')}"><c:out value="Terain"/></c:when> 
                                                                       <c:otherwise><c:out value="Bien"/></c:otherwise>    
                                                                    </c:choose></p>
							</td>
							<td class="cart_price">
								<p>${a.key.type.typeAnnonce}</p>                                                               
							</td>
							<td class="cart_quantity">
                                                            <p>${a.key.gov}</p>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${a.key.prix}</p>
							</td>                                                       
							<td class="cart_delete">
                                                                <a class="cart_quantity_delete" href="annonce?ann=${a.key.id}" title="consulter"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span></a>
                                                                <a class="cart_quantity_delete" href="supSauv?s=${a.key.id}" title="Suprimmer Annonce"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
							</td>
						</tr>
                                                   </c:otherwise>
                                               </c:choose>     
                                            </c:forEach>
					</tbody>
				</table>                           
                            </div>
    </section>  
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Reglages</a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <div class="col-lg-8">
                                                        <form id="defaultForm" method="post" class="form-horizontal" action="modifierUser">   
                                                               <% Abonne abonne = (Abonne)request.getSession().getAttribute("usersession");%>
                                                                <div class="form-group">
                                                                            <label class="col-lg-3 control-label">Type</label>
                                                                            <div class="col-lg-5">
                                                                                <div class="radio">
                                                                                    <label>
                                                                                        <input type="radio" name="type" value="PARTICULIER" <%if(abonne.getAbonneType()==Type.PARTICULIER){%>checked<%}%>/> Particulier
                                                                                    </label>
                                                                                </div>
                                                                                <div class="radio">
                                                                                    <label>
                                                                                        <input type="radio" name="type" value="PROMOTEUR" <%if(abonne.getAbonneType()==Type.PROMOTEUR){%>checked<%}%>/> Promoteur                                       
                                                                                    </label>
                                                                                </div>
                                                                                <div class="radio">
                                                                                    <label>
                                                                                        <input type="radio" name="type" value="AGENCE_IMMOBILIER"  <%if(abonne.getAbonneType()==Type.AGENCE_IMMOBILIER){%>checked<%}%>/> Agence Immobilier
                                                                                    </label>
                                                                                </div>
                                                                        </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <label class="col-lg-3 control-label">Ville<sup>*</sup></label>
                                                                <div class="col-lg-5">
                                                                    <select class="form-control" name="country" data-fv-notempty data-fv-notempty-message="Le pays est nécessaire">
                                                                        <option value="<%=abonne.getVille() %>"><%=abonne.getVille() %></option>
                                                                        <c:forEach var="c" items="${applicationScope['governorat']}" >
                                                                        <option value="${c}">${c}</option>
                                                                       </c:forEach>                         
                                                                    </select>
                                                                </div>
                                                                </div>
                                                                 <div class="form-group">
                                                                    <label class="col-lg-3 control-label"></label>
                                                                    <div class="col-lg-5">
                                                                        <div class="input-group">
                                                                            <span class="input-group-addon">Code Postal</span>
                                                                            <input type="text" class="form-control" name="postalCode" value="<%=abonne.getCodePostal() %>"/>
                                                                        </div>
                                                                    </div>                    
                                                                </div>  
                                                                <div class="form-group">
                                                                <label class="col-lg-3 control-label">Mobile</label>
                                                                    <div class="col-lg-5">
                                                                        <input class="form-control" type="text" name="senderPhone" value="<%=abonne.getTel1() %>"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                <label class="col-lg-3 control-label">Autre Tel</label>
                                                                    <div class="col-lg-5">
                                                                        <input class="form-control" type="text" name="phone" value="<%=abonne.getTel2() %>"/>
                                                                    </div>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label class="col-lg-3 control-label">Adresse</label>
                                                                    <div class="col-lg-5">
                                                                        <input class="form-control" type="text" name="senderAddress" value="<%=abonne.getAdresse() %>"/>
                                                                    </div>
                                                                </div>  
                                                                <div class="form-group">
                                                                    <div class="col-lg-9 col-lg-offset-3">
                                                                        <button type="submit" class="btn btn-primary">Confirmer modification</button>
                                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Modifier votre mot de passe</button>
                                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Desactiver Compte</button>
                                                                    </div>  
                                                                </div>
                                                        </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- .panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
 <!-- Small modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <div class="login-form"><!--login form-->
                         <h2>Modifier votre mot de passe</h2>
                            <form id="defaultForm" method="post" class="form-horizontal" action="modifierPasword">
                                 <div class="form-group">
                                      <div class="col-sm-9">
                                       <input type="password" class="form-control" name="passwordannc" placeholder="Mot de passe actuel"/>
                                       </div>
                                 </div>  
                                 <div class="form-group">
                                      <div class="col-sm-9">
                                       <input type="password" class="form-control" name="password" placeholder="Nouveau mot de passe"/>
                                       </div>
                                 </div>
                                 <div class="form-group">
                                      <div class="col-sm-9">
                                       <input type="password" class="form-control" name="confirmPassword" placeholder="Confirmer le mot passe"/>
                                       </div>
                                 </div>  
                                 <span>
                                     <input type="checkbox" class="checkbox" checked> 
                                      OK
                                  </span>
                                <div class="form-group">
                                   <div class="col-sm-9 col-sm-offset-3">
                                    <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Confirme</button>
                                    </div>
                                </div>
                            </form>
                    </div>
                </div>
            </div>
    </div>
  </div>
</div>
</section>
</div>
<!-- Large modal -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-2">
            <form id="defaultconForm" method="post" class="form-horizontal" action="supUser">                                  
                                <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Confirmer</button>
             </form>
        </div>   
        <div class="col-lg-5"></div>     
    </div>
</div>
<br><br><br><br><br>
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
        <script src="assets/filedrag.js"></script>  
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>