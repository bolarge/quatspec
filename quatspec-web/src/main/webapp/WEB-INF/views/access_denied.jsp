<%@ include file="/WEB-INF/tags.jsp"%>

<spring:message code="label_login" var="labelLogin" />
<spring:url var="loginUrl" value="login" />

<body class="top-border custombody">
	<div class="container d-flex h-100">
	
	<spring:url var="logoutUrl" value="logout" />
	<h1>Access Denied page</h1>

	<div class="row justify-content-center nse-login align-self-center">
		<div class="">
			<span>Dear <strong>${principal}</strong>, You are not
				authorized to access this page.
			</span> <span class="floatRight"><c:url var="logoutUrl"
					value="${loginUrl}" />Logout</span>
		</div>
	</div>
</div>
</body>