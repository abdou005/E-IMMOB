<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">                                    
                                    <form action="recherche" method="post" class="form-horizontal" id="formrecherche">
					<div class="left-sidebar">
						<h2>Rechercher</h2>
                                                <p><strong>Type d'annonce</strong></p>
                                                <table>                                                  
                                                    <tr><td><input type="radio" name="type" value="vente" checked>Vente</td><td><input type="radio" name="type" value="location">Location</td></tr>
                                                    <tr><td><input type="radio" name="type" value="colocation">Colocation</td><td><input type="radio" name="type" value="locationvac">LOCATIONVACANCES</td></tr>
                                                </table>
                                                <hr/>
                                                 <p><strong>Prix(DT)</strong></p>
                                                <table>
                                                    <tr><td><input type="number" class="form-control" name="minprix" placeholder="min"/></td>
                                                        <td><input type="number" class="form-control" name="maxprix" placeholder="max"/></td></tr>
                                                </table>
                                                <hr/>
                                                 <p><strong>Superficier Total(m2)</strong></p>
                                                <table>                                                  
                                                    <tr><td>
                                                            <select class="form-control" name="sprftomin">
                                                                                        <option selected value="10">min</option>
                                                                                        <c:forEach var="st" begin="10" end="1000" step="10">
                                                                                        <option  value="${st}">${st}</option>  
                                                                                        </c:forEach>
                                                                                        
                                                            </select>
                                                        </td>
                                                        <td>
                                                            <select class="form-control" name="sprftomax">
                                                                                        <option selected value="2000">max</option>
                                                                                        <c:forEach var="st" begin="10" end="1000" step="10">
                                                                                        <option  value="${st}">${st}</option>  
                                                                                        </c:forEach>
                                                                                        <option  value="2000">1000+</option>
                                                            </select>
                                                        </td></tr>
                                                </table>                                                                                       
                                                <hr/>
                                                <p><strong>Governorat</strong></p>
                                                <select class="form-control" name="country" data-fv-notempty data-fv-notempty-message="Le pays est nécessaire">
                                                                        <option  selected value="Sousse">Selectionnez</option>
                                                                       <c:forEach var="c" items="${applicationScope['governorat']}" >
                                                                        <option value="${c}">${c}</option>
                                                                       </c:forEach>                         
                                                </select>                                                                                     
                                                <hr/>                                               
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" id="stu" data-parent="#accordian" href="#studio" class="collapsed">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                                                                        Habitable
										</a>
									</h4>
								</div>
								<div id="studio" class="panel-collapse collapse" style="height: 0px;">
									<div class="panel-body">
                                                                            <p><strong>Superficier habitable(m2)</strong></p>
                                                                            <table>                                                  
                                                                                <tr><td>
                                                                                    <select class="form-control" name="sprfhamin">
                                                                                        <option selected value="10">min</option>
                                                                                        <c:forEach var="sh" begin="10" end="1000" step="10">
                                                                                        <option  value="${sh}">${sh}</option>  
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </td>
                                                                                <td>
                                                                                    <select class="form-control" name="sprfhamax">
                                                                                        <option selected value="2000">max</option>
                                                                                        <c:forEach var="sh" begin="10" end="1000" step="10">
                                                                                        <option  value="${sh}">${sh}</option>  
                                                                                        </c:forEach>
                                                                                        <option  value="2000">1000+</option>
                                                                                    </select>
                                                                                </td></tr>
                                                                            </table>
                                                                             <hr/>
                                                                            <p><strong>Nombre de pièces</strong></p>
                                                                            <table>                                                  
                                                                            <tr><td> 
                                                                            <select class="form-control" name="minnbpc">
                                                                                <option selected value="2">min</option>
                                                                                <c:forEach var="p" begin="1" end="10" step="1">
                                                                                <option  value="${p}">${p}</option>  
                                                                                </c:forEach>
                                                                            </select></td>
                                                                            <td><select class="form-control" name="maxnbpc">
                                                                             <option selected value="20">max</option>
                                                                                <c:forEach var="p" begin="1" end="10" step="1">
                                                                                <option  value="${p}">${p}</option>  
                                                                                </c:forEach> 
                                                                                <option  value="20">10+</option> 
                                                                            </select></td>
                                                                            </tr>
                                                                            </table>
                                                                             <hr/>
                                                                            <p><strong>Equipement</strong></p>
                                                                            <table>                                                  
                                                                                <tr><td>Balcon :</td><td><input type="radio" name="balcon" value="oui" checked>oui </td><td><input type="radio" name="balcon" value="non">non</td></tr>
                                                                                <tr><td>Climatisation :</td><td><input type="radio" name="clim" value="oui" checked>oui</td><td> <input type="radio" name="clim" value="non">non</td></tr>
                                                                                <tr><td>Chaufage :</td><td><input type="radio" name="chauf" value="oui" checked>oui</td><td> <input type="radio" name="chauf" value="non">non</td></tr>
                                                                            </table>                                                                             
                                                                            <div class="row">
                                                                            <div class="col-sm-12" style="margin-bottom: 50px;">
                                                                                 <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Selectionnez type <span class="caret"></span></button>
                                                                                       <ul class="dropdown-menu" role="menu">
                                                                                           <li><a href="#" class="apar" id="appar">Appartement</a></li>
                                                                                           <li><a href="#" class="vill" id="vill" >Villa</a></li>
                                                                                       </ul>
                                                                            </div>
                                                                            </div>
                                                                            <div id="apartemp" style="display: none;"><!-- Appartement -->
                                                                                <table> 
                                                                                <tr><td><strong>Numero d'etage</strong></td><td></td></tr>
                                                                                <tr><td> 
                                                                                <select class="form-control" name="numetgmin">
                                                                                    <option selected value="1">min</option>
                                                                                    <c:forEach var="p" begin="1" end="10" step="1">
                                                                                    <option  value="${p}">${p}</option>  
                                                                                    </c:forEach>
                                                                                </select></td>
                                                                                <td><select class="form-control" name="numetgmax">
                                                                                 <option selected value="20">max</option>
                                                                                    <c:forEach var="p" begin="1" end="10" step="1">
                                                                                    <option  value="${p}">${p}</option>  
                                                                                    </c:forEach> 
                                                                                    <option  value="20">10+</option> 
                                                                                </select></td>
                                                                                </tr>
                                                                                <tr><td><strong>Caractéristique</strong></td><td></td></tr>
                                                                                <tr><td>Assenceur :</td><td><input type="radio" name="assenc" value="oui" checked>oui </td><td><input type="radio" name="assenc" value="non">non</td></tr>
                                                                                <tr><td>Parking :</td><td><input type="radio" name="parking" value="oui" checked>oui</td><td> <input type="radio" name="parking" value="non">non</td></tr>
                                                                                <tr><td>Sandic :</td><td><input type="radio" name="sandic" value="oui" checked>oui</td><td> <input type="radio" name="sandic" value="non">non</td></tr>
                                                                                </table>
                                                                            <div class="col-sm-3">      
                                                                                        <button type="button" class="btn btn-link removeButton">Remove</button>
                                                                            </div>
                                                                         </div>                                                                          
                                                                         <div id="villtemp" style="display: none;"> <!-- Villa -->
                                                                             <table> 
                                                                                <tr><td><strong>Nombre d'etage</strong></td><td></td></tr>
                                                                                <tr><td> 
                                                                                <select class="form-control" name="nbretgmin">
                                                                                    <option selected value="1">min</option>
                                                                                    <c:forEach var="p" begin="1" end="10" step="1">
                                                                                    <option  value="${p}">${p}</option>  
                                                                                    </c:forEach>
                                                                                </select></td>
                                                                                <td><select class="form-control" name="nbretgmax">
                                                                                 <option selected value="10">max</option>
                                                                                    <c:forEach var="p" begin="1" end="10" step="1">
                                                                                    <option  value="${p}">${p}</option>  
                                                                                    </c:forEach> 
                                                                                </select></td>
                                                                                </tr>
                                                                                <tr><td><strong>Caractéristique</strong></td><td></td></tr>
                                                                                <tr><td>Jardin :</td><td><input type="radio" name="jardin" value="oui" checked>oui </td><td><input type="radio" name="jardin" value="non">non</td></tr>
                                                                                <tr><td>Garage :</td><td><input type="radio" name="garage" value="oui" checked>oui</td><td> <input type="radio" name="garage" value="non">non</td></tr>
                                                                                <tr><td>Piscine :</td><td><input type="radio" name="piscine" value="oui" checked>oui</td><td> <input type="radio" name="piscine" value="non">non</td></tr>
                                                                                </table>
                                                                            <div class="row">
                                                                                     <div class="col-sm-3">      
                                                                                            <button type="button" class="btn btn-link removeButton">Remove</button>
                                                                                      </div>
                                                                            </div>
                                                                         </div>
									</div>
								</div>
							</div>
                                                        <div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" id="dep" data-parent="#accordian" href="#depot" class="collapsed">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Depot
										</a>
									</h4>
								</div>
								<div id="depot" class="panel-collapse collapse" style="height: 0px;">
									<div class="panel-body">
                                                                            <p><strong>Superficier couvert(m2)</strong></p>
                                                                            <table>                                                  
                                                                                <tr><td>
                                                                                    <select class="form-control" name="sprfcovmin">
                                                                                        <option selected value="10">min</option>
                                                                                       <c:forEach var="sc" begin="10" end="1000" step="10">
                                                                                       <option  value="${sc}">${sc}</option>  
                                                                                       </c:forEach>                                                                                             
                                                                                    </select>
                                                                                    </td>
                                                                                    <td>
                                                                                    <select class="form-control" name="sprfcovmax">
                                                                                        <option selected value="6000">max</option>
                                                                                       <c:forEach var="sc" begin="10" end="1000" step="10">
                                                                                       <option  value="${sc}">${sc}+</option>  
                                                                                       </c:forEach>                                                                                             
                                                                                    </select>
                                                                                    </td></tr>
                                                                            </table>
									</div>
								</div>
							</div>
                                                        <div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" id="ter" data-parent="#accordian" href="#terain" class="collapsed">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											Terain
										</a>
									</h4>
								</div>
								<div id="terain" class="panel-collapse collapse" style="height: 0px;">
									<div class="panel-body">
                                                                            <p><strong>Zonne</strong></p>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="zonne" value="villa" checked/> Villa
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="zonne" value="indist" /> Indristrueille                                      
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="zonne" value="agricole" />Agricole
                                                                                            </label>
                                                                                        </div>
                                                                                         <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="zonne" value="touristique" />Touristique
                                                                                            </label>
                                                                                        </div>
									</div>
								</div>
							</div>
                                                    
						</div><!--/category-products-->   
                                               `                                         <p><strong>Voir les annonces de </strong></p>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="typevend" value="tous" checked/> Tous les vendeurs
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="typevend" value="part" /> Particuliers                                      
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="typevend" value="prof" />Professionnels
                                                                                            </label>
                                                                                        </div>
                                                                                         <div class="radio">
                                                                                            <label>
                                                                                                <input type="radio" name="typevend" value="agence" />Agences immobiliers
                                                                                            </label>
                                                                                        </div>
                                                                                            <hr/>
					</div>
                                        <input type="hidden" name="entity" id="hidden" value="annonce">
                                        <div class="col-sm-10">
                                        <button type="submit" class="btn btn-outline btn-primary btn-lg btn-block">Recherche Annonce</button>
                                        </div>
                                        </form>                                  
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
                                        		<li><a href="">Previous</a></li>
                                                        <c:forEach var="v" begin="1" end="${applicationScope.nbpage}"> 
							<li><a href="pagination?p=${v}">${v}</a></li>							 
                                                        </c:forEach>
							<li><a href="">Next</a></li>
						</ul>
                           
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
<script>

$(document).ready(function() {
    $('.apar').on('click', function() {
            var $that     = $(this),
                $template = $('#apartemp'),
                $newRow   = $template.clone().removeAttr('id').insertBefore($template).show();

            $that.parent().addClass('disabled');

            // Set the label and field name
            var fieldName = $that.attr('data-name');
            $newRow
                
                .on('click', '.removeButton', function() {
                    // Remove field when clicking the Remove button
                    $('#contactForm').formValidation('removeField', fieldName);

                    // Enable the Add button
                    $that.parent().removeClass('disabled');

                    // Remove element
                    $newRow.remove();
                });

            // Add new field
            /*$('#contactForm').formValidation('addField', fieldName, {
                message: 'The phone number is not valid',
                validators: {
                    digits: {
                        message: 'The value can contain only digits'
                    }
                }
            });*/
        });
		  $('.vill').on('click', function() {
            var $that     = $(this),
                $template = $('#villtemp'),
                $newRow   = $template.clone().removeAttr('id').insertBefore($template).show();

            $that.parent().addClass('disabled');

            // Set the label and field name
            var fieldName = $that.attr('data-name');
            $newRow
                
                .on('click', '.removeButton', function() {
                    // Remove field when clicking the Remove button
                    $('#contactForm').formValidation('removeField', fieldName);

                    // Enable the Add button
                    $that.parent().removeClass('disabled');

                    // Remove element
                    $newRow.remove();
                });

            // Add new field
            /*$('#contactForm').formValidation('addField', fieldName, {
                message: 'The phone number is not valid',
                validators: {
                    digits: {
                        message: 'The value can contain only digits'
                    }
                }
            });*/
        });
            $('#formrecherche').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
             minprix: {
                validators: {
                    notEmpty: {
                    },
                    digits: {}
                }               
            },
            maxprix: {
                validators: {
                    notEmpty: {
                    },
                    digits: {}
                }               
            }         
        }
    });
        $('#stu').click(function(){
          var v = document.getElementById("hidden").value="studio";           
        });
         $('#dep').click(function(){
          var v = document.getElementById("hidden").value="depot";           
        });
         $('#ter').click(function(){
          var v = document.getElementById("hidden").value="terrain";           
        });
         $('#appar').click(function(){
          var v = document.getElementById("hidden").value="appartement";           
        });
         $('#vill').click(function(){
          var v = document.getElementById("hidden").value="villa";           
        });
});          
</script>
        <script src="form/formconnexion.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>