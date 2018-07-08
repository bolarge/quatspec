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
    <script src="<c:url value='/static/js/script.js'/>" type="text/javascript"></script> 
     	 
</body>
</html>