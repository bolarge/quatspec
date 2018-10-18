<%@include file="/WEB-INF/tags.jsp"%>
<!DOCTYPE html>
<html lang="en" >
<head>	
	<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="x-ua-compatible" content="ie=edge"> 
    
    <meta name="csrf-param" content="${_csrf.parameterName}">
	<meta name="csrf-token" content="${_csrf.token}">
	<meta name="csrf-header" content="${_csrf.headerName}">
    	
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/static/css/bootstrap.min.css' />" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/static/css/mdb.min.css' />" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/static/css/style.css' />" />
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/> "/>		
</head>

<body class="fixed-sn light-blue-skin">

	<header>
		<tiles:insertAttribute name="header" /> 
	</header>

	<main>					  
		<tiles:insertAttribute name="body"/> 
	</main>
	
	<footer class="page-footer blue mt-4">
		<tiles:insertAttribute name="bottom" />
	</footer>
	  
    <script src="<c:url value='/static/js/jquery-3.3.1.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/static/js/popper.min.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/static/js/bootstrap.min.js'/>" type="text/javascript"></script> 
    <script src="<c:url value='/static/js/mdb.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='https://maps.google.com/maps/api/js'/>" type="text/javascript"></script>
    <script src="<c:url value='/static/js/script.js'/>" type="text/javascript"></script> 
    
    <script>
        // Regular map
        function regular_map() {
            var var_location = new google.maps.LatLng(40.725118, -73.997699);

            var var_mapoptions = {
                center: var_location,
                zoom: 14
            };

            var var_map = new google.maps.Map(document.getElementById("map-container"),
                var_mapoptions);

            var var_marker = new google.maps.Marker({
                position: var_location,
                map: var_map,
                title: "New York"
            });
        }

        // Initialize maps
        google.maps.event.addDomListener(window, 'load', regular_map);
    </script>

    <!-- Carousel options -->
    <script>
        $('.carousel').carousel({
            interval: 3000,
        })
    </script>
    
     	 
</body>
</html>