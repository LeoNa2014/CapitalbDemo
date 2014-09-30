<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- AppName goes here -->
<html ng-app="userApp">
<head>
<title>Capitalb Demo Application - Leo Na</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="author" content="Leo Na">
<meta name="description" content="Capitalb Demo Application">
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css"/>">
<script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.20/angular.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
<script type="text/javascript" src="assets/js/ui-bootstrap-tpls-0.9.0.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/spa_restful.js"/>"></script>
<!-- 
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-37706354-1', 'hello-angularjs.appspot.com');
	ga('send', 'pageview');
</script>
 -->
</head>
<!-- Controller name goes here -->
<body>
	<div class="container-narrow">
		<h3 class="muted">Capitalb Demo Application - Leo Na</h3>
		<hr>
		<div class="row-fluid">
        	<div class="span2">
				<div class="tabbable tabs-left">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href=""#/">Home</a></li>
						<li><a data-toggle="tab" href="#/recipe/register">New Recipe</a></li>
						<li><a data-toggle="tab" href="#/recipe/all">All Recipes</a></li>
					</ul>
				</div>
			</div>
        	<div class="span10">
        		<div ng-view></div>
        	</div>
        </div>
	</div> 

</body>
</html>