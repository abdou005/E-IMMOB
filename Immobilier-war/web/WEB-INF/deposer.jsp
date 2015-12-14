<%@page import="model.Abonne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
								<li><a href=""><i class="fa fa-facebook"></i></a></li>
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
                                                    <form method="post" action="#">
                                                        <input type="text" placeholder="Recherche"/>
                                                    </form>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header -->
<section id="form" style="margin-top: 5px;"><!--form-->
        <div class="row"> 
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10"><h2 class="title text-center">Ajouter une annonce </h2></div>
                    <div class="col-sm-1"></div>           
        </div>
        <form id="defaultdeposerForm" method="post" class="form-horizontal" action="deposerAnno"> 
        <div class="row">
                    <div class="col-sm-1"></div>
				<div class="col-sm-5">
                                        <div class="form-group">
                                                 <label class="col-sm-3 control-label">Type<sup>*</sup></label>
                                                 <div class="col-sm-6">                                                                                                               
                                                     <c:forEach var="t" items="${requestScope['typeann']}">                                                           
                                                            <label>
                                                                 <input type="radio" name="type" value="${t}"> ${t}
                                                            </label>                                               
                                                    </c:forEach> 
                                                 </div>
                                         </div>
                                        <div class="form-group">
                                             <label class="col-sm-3 control-label">Titre<sup>*</sup></label>
                                             <div class="col-sm-6">
                                                 <input type="text" class="form-control" name="titre" placeholder="titre" />
                                             </div>
                                        </div>         
                                        <div class="form-group">
                                             <label class="col-sm-3 control-label">Prix<sup>*</sup></label>
                                             <div class="col-sm-6">
                                                 <input type="number" class="form-control" name="prix" placeholder="(DT)"/> 
                                             </div>
                                        </div>
                                        <div class="form-group">
                                             <label class="col-sm-3 control-label">Superficier total<sup>*</sup></label>
                                               <div class="col-sm-6">
                                                   <input type="number" class="form-control" name="superficiertotal" placeholder="(m2)"/>
                                             </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label">Gouvernorat<sup>*</sup></label>
                                            <div class="col-sm-6">
                                                <select class="form-control" name="country" data-fv-notempty data-fv-notempty-message="Le pays est nécessaire"> 
                                                    <option value="">--Selectionnez--</option>
                                            <c:forEach var="c" items="${requestScope['governorat']}" >
                                                <option value="${c}">${c}</option>
                                            </c:forEach>                        
                                                </select>
                                            </div>
                                        </div>
                                          
				</div>
                                <div class="col-sm-5">
                                         <div class="form-group">
                                             <label class="col-sm-3 control-label">Delegation<sup>*</sup></label>
                                               <div class="col-sm-6">
                                               <input type="text" class="form-control" name="delegtion" placeholder="village"/>
                                             </div>
                                        </div>
                                        <div class="form-group">
                                                 <label class="col-sm-3 control-label">Titre Bleu</label>
                                                 <div class="col-sm-5">                                                     
                                                        <label>
                                                            <input type="radio" name="titrebleu" value="non" checked/> non 
                                                        </label>                                                     
                                                        <label>
                                                            <input type="radio" name="titrebleu" value="oui" /> oui                                       
                                                        </label>                                                 
                                                 </div>
                                         </div>
                                         <div class="form-group">
                                             <label class="col-sm-3 control-label">Description<sup>*</sup></label>
                                             <div class="col-sm-6">
                                                 <textarea class="form-control" rows="3" name="desc" placeholder="(Descriptions)"></textarea>
                                             </div>
                                         </div>
                                         <div class="form-group">
                                             <label class="col-sm-3 control-label">Rendre active</label>
                                             <div class="col-sm-6">
                                             <input type="checkbox" name = "active" value="activ"></div>
                                         </div>  
                                </div>
		</div>
<div class="row"> 
    <div class="col-sm-1"></div>
            <div class="col-sm-11">
                <div class="category-tab">
                    <div class="col-sm-11">
                        <ul class="nav nav-tabs">
                        <li><a href="#tshirt" id="stu" data-toggle="tab">Habitable</a></li>
                        <li><a href="#blazers" id="dep" data-toggle="tab">Depot</a></li>
                        <li><a href="#sunglass" id="terr" data-toggle="tab">Terain</a></li>
                        <li><a href="#kids" id="bur" data-toggle="tab">Bureau</a></li>            
                        </ul>
                    </div>
                    <div class="col-sm-11">
                            <div class="tab-content"><!--issiiiiiiiiiiiiiiiiiiiiiiiiii-->
                                <div class="tab-pane fade" id="tshirt" ><!--habitable  active in--> 
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Superficier habitable(m2)</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="superficierhabitable"  value="0"/>
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Annee de construction</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="annconst" value="0" />
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Nombre de piece</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="nbrpiece" value="0"  />
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Salon</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="nbrsalon" value="0" />
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Chambre</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="nbrchambre" value="0" />
                                                      </div>
                                            </div>
                                             <div class="form-group">
                                                      <label class="col-sm-3 control-label">Salle de bain</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="nbrsalbain" value="0" />
                                                      </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">                               
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Cuisine</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="nbrcuisine" value="0" />
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">WC</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="wc" value="0" />
                                                      </div>
                                            </div>
                                            <div class="form-group">
                                                 <label class="col-sm-3 control-label">Balcon</label>
                                                 <div class="col-sm-5">                                                     
                                                        <label>
                                                            <input type="radio" name="balc" value="non" checked/> non 
                                                        </label>                                                     
                                                        <label>
                                                            <input type="radio" name="balc" value="oui" /> oui                                       
                                                        </label>                                                 
                                                 </div>
                                            </div>
                                             <div class="form-group">
                                                 <label class="col-sm-3 control-label">Climatiseur</label>
                                                 <div class="col-sm-5">                                                     
                                                        <label>
                                                            <input type="radio" name="clim" value="non" checked/> non 
                                                        </label>                                                     
                                                        <label>
                                                            <input type="radio" name="clim" value="oui" /> oui                                       
                                                        </label>                                                 
                                                 </div>
                                            </div>                                             
                                             <div class="form-group">
                                                 <label class="col-sm-3 control-label">Chaufage</label>
                                                 <div class="col-sm-5">                                                     
                                                        <label>
                                                            <input type="radio" name="chauf" value="non" checked/> non 
                                                        </label>                                                     
                                                        <label>
                                                            <input type="radio" name="chauf" value="oui" /> oui                                       
                                                        </label>                                                 
                                                 </div>
                                         </div>
                                            <div class="form-group">
                                                      <label class="col-sm-3 control-label">Selectionnez</label>
                                                      <div class="col-sm-4">
                                                          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Type <span class="caret"></span></button>
                                                                <ul class="dropdown-menu" role="menu">
                                                                    <li><a href="#" class="apar" id="apart">Appartement</a></li>
                                                                    <li><a href="#" class="vill" id="vil" >Villa</a></li>
                                                                </ul>
                                                      </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4"><!--Appar villa-->
                                             <!-- Template for dynamic field -->
                                             <div id="apartemp" style="display: none;"><!-- Appartement -->
                                                <div class="form-group">
                                                      <label class="col-sm-3 control-label">Numero d'etage</label>
                                                      <div class="col-sm-4">
                                                          <input type="number" class="form-control" name="numetage" value="1"/>                                                  
                                                      </div>
                                                </div>                                             
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Assenceur</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="assenceur" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="assenceur" value="oui" /> oui                                       
                                                           </label>                                                 
                                                   </div>
                                                </div>                                      
                                                 <div class="form-group">
                                                    <label class="col-sm-3 control-label">Parking</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="parking" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="parking" value="oui" /> oui                                       
                                                           </label>                                                 
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Sandic</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="sandik" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="sandik" value="oui" /> oui                                       
                                                           </label>                                                 
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">      
                                                    <button type="button" class="btn btn-link removeButton" style="color: #FE980F;">Remove</button>
                                                </div>
                                             </div>
                                             <div id="villtemp" style="display: none;">   <!-- Villa -->
                                                <div class="form-group">
                                                      <label class="col-sm-3 control-label">Nombre d'etage</label>
                                                      <div class="col-sm-4">
                                                          <input class="form-control" type="number" name="nbretage" value="1"/>
                                                      </div>
                                                </div>                                            
                                                 <div class="form-group">
                                                    <label class="col-sm-3 control-label">Jardin</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="jardin" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="jardin" value="oui" /> oui                                       
                                                           </label>                                                 
                                                    </div>
                                                 </div>
                                                 <div class="form-group">
                                                    <label class="col-sm-3 control-label">Garage</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="garage" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="garage" value="oui" /> oui                                       
                                                           </label>                                                 
                                                    </div>
                                                 </div>
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Piscine</label>
                                                    <div class="col-sm-5">                                                     
                                                           <label>
                                                               <input type="radio" name="piscine" value="non" checked/> non 
                                                           </label>                                                     
                                                           <label>
                                                               <input type="radio" name="piscine" value="oui" /> oui                                       
                                                           </label>                                                 
                                                    </div>
                                                </div>
                                                <div class="col-sm-3">
                                                            <button type="button" class="btn btn-link removeButton" style="color: #FE980F;">Remove</button>
                                                </div>
                                             </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="blazers" > <!--depot-->
                                    <div class="form-group">
                                                      <label class="col-sm-3 control-label">Annee Construction</label>
                                                      <div class="col-sm-3">
                                                          <input type="number" class="form-control" name="anneeconstdepot" value="0" placeholder="(m2)"/>
                                                      </div>
                                    </div>
                                    <div class="form-group">
                                                      <label class="col-sm-3 control-label">Superficier couvert</label>
                                                      <div class="col-sm-3">
                                                          <input type="number" class="form-control" name="superficiercouvert" value="0" placeholder="(m2)"/>
                                                      </div>
                                    </div>
                                </div>
                                <div class="tab-pane fade" id="sunglass" > <!--villa-->
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">Zonne</label>
                                        <div class="col-sm-5">
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
                                <div class="tab-pane fade" id="kids" >   <!--Bureaux-->                                                           
                                   Bureaux       
                                </div>
                        </div>
                    </div>
                </div>
            </div>
</div> 
            <div class="row">
            
                <div class=" col-sm-8"></div>
            <div class=" col-sm-3">
                <input type="hidden" name="entity" value="annonce" id="hidden">
            <button type="submit" class="btn btn-outline btn-primary btn-sm btn-block">Ajouter Annonce</button>
            </div>
      
            </div>
 </form>
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
<script type="text/javascript">
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
     $('#defaultdeposerForm').formValidation({
        message: 'This value is not valid',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            type: {
                validators: {
                    notEmpty: {
                        message: "Le Type d'annonce est nécessaire"
                    }
                }
            },     
            titre: {
                validators: {
                    notEmpty: {
                        message: "Le Titre d'annonce est nécessaire"
                    },
                    stringLength: {
                        min: 5,
                        max: 50,
                        message: "Le Titre d'annonce entre 5 et 50 caractere"
                    }
                }               
            },
            prix: {
                validators: {
                    notEmpty: {
                        message: "Le Titre d'annonce est nécessaire"
                    },
                    digits: {}
                }               
            },
            superficiertotal:{
                 validators: {
                    notEmpty: {
                        message: "Le gouvernorat d'annonce est nécessaire"
                    },
                    digits: {}
                }
                
            },
            country:{
                 validators: {
                    notEmpty: {
                        message: "Le gouvernorat d'annonce est nécessaire"
                    }
                } 
            },
            delegtion: {
                validators: {
                    notEmpty: {
                        message: "Delegation d'annonce est nécessaire"
                    },
                    stringLength: {
                        min: 5,
                        max: 50,
                        message: "Delegation d'annonce entre 3 et 50 caractere"
                    }
                }
            },
            desc: {
                validators: {
                    notEmpty: {
                        message: "Description d'annonce est nécessaire"
                    },
                    stringLength: {
                        min: 50,
                        message: "Description d'annonce entre 50 et 1000 caractere"
                    }
                }
            },
            nbretage:{
                 validators: {
                    digits: {}
                }
            },
            numetage:{
                 validators: {
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
         $('#terr').click(function(){
          var v = document.getElementById("hidden").value="terrain";           
        });
         $('#bur').click(function(){
          var v = document.getElementById("hidden").value="bureau";           
        });
         $('#apart').click(function(){
          var v = document.getElementById("hidden").value="appartement";           
        });
         $('#vil').click(function(){
          var v = document.getElementById("hidden").value="villa";           
        });
    });
</script> 
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
</body>
</html>