<%@ include file="/WEB-INF/tags.jsp"%>
<!-- 
<body class="top-border custombody">
	<div class="container d-flex h-100">
		<div class="row justify-content-center align-self-center"> -->
			<section class="form-simple">
				<!--Form with header-->
				<div class="card">
					<!--Header-->
					<div class="header pt-3 blue lighten-2">
						<div class="row d-flex justify-content-start">
							<h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Log in</h3>
						</div>
					</div>
					<!--Header-->
					<div class="card-body mx-4 mt-4">
						<c:url var="loginUrl" value="/j_spring_security_check" />
						<form action="${loginUrl}" method="post">

							<c:if test="${!empty requestScope['LOGIN_MESSAGE']}">
								<div class="alert alert-danger">
									<p>${requestScope['LOGIN_MESSAGE']}</p>
								</div>
							</c:if>

							<c:if
								test="${!empty param['msg'] and param['msg'] eq 'logoutcomplete'}">
								<div class="form-group alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>

							<div class="md-form">
								<input type="email" id="email" name="j_username" class="form-control">
								<label for="email">Your email</label>
							</div>

							<div class="md-form pb-3">
								<input type="password" id="password" name="j_password" class="form-control">
								<label for="password">Your password</label>
								
								<p class="font-small grey-text d-flex justify-content-end">
									Forgot <a href="#" class="dark-grey-text font-weight-bold ml-1">Password?</a>
								</p>
							</div>
							
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							
							<div class="text-center mb-4">
								<button type="submit" class="btn btn-blue btn-block z-depth-2">Log in</button>
							</div>
							
							<p class="font-small grey-text d-flex justify-content-center">
								Don't have an account? <a href="#" class="dark-grey-text font-weight-bold ml-1"> Sign up</a>
							</p>
							
						</form>
					</div>
				</div>
			</section>
		<!-- </div>
	</div>
</body> -->
