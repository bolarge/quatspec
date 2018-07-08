<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:form="http://www.springframework.org/tags/form" version="2.0">
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<jsp:output omit-xml-declaration="yes" />

	<spring:message code="label_person_info" var="labelPersonInfo" />
	<spring:message code="label_person_first_name"
		var="labelPersonFirstName" />
	<spring:message code="label_person_last_name" var="labelPersonLastName" />
	<spring:message code="label_person_birth_date"
		var="labelPersonBirthDate" />
	<spring:message code="label_person_sex" var="labelPersonSex" />
	<spring:message code="label_person_street" var="labelPersonStreet" />
	<spring:message code="label_person_city" var="labelPersonCity" />
	<spring:message code="label_person_state" var="labelPersonState" />
	<spring:message code="label_person_email" var="labelPersonEmail" />
	<spring:message code="label_person_fone" var="labelPersonPhone" />
	<spring:message code="label_person_user_type" var="labelPersonUserType" />
	<spring:message code="label_person_password" var="labelPersonPassword" />
	<spring:message code="label_person_photo" var="labelPersonPhoto" />
	<spring:message code="label_person_enabled" var="labelPersonEnabled" />
	<spring:message code="label_person_description"
		var="labelPersonDescription" />
	<spring:message code="label_person_update" var="labelPersonUpdate" />
	<spring:message code="label_person_new" var="labelPersonNew" />
	<spring:message code="date_format_pattern" var="dateFormatPattern" />
	<spring:message code="label_person_new" var="labelPersonNew" />

	<spring:eval
		expression="person.id == null ? labelPersonNew:labelPersonUpdate"
		var="formTitle" />

	<script type="text/javascript">
		$(function() {
			$('#birthDate').datepicker({
				dateFormat : 'yy-mm-dd',
				changeYear : true
			});

			$("#personDescription").ckeditor({
				toolbar : 'Basic',
				uiColor : '#CCCCCC'
			});
		});
	</script>

	<div class="divide">
		<form:form class="form-horizontal" modelAttribute="person"
			id="personUpdateForm" method="post" enctype="multipart/form-data">

			<c:if test="${not empty message}">
				<div id="message" class="${message.type}">${message.message}</div>
			</c:if>

			<fieldset>
				<legend>${formTitle}</legend>
				<div class="row-fluid">
					<div class="span4">
						<div class="control-group">
							<label class="control-label" for="firstName">${labelPersonFirstName}*</label>
							<div class="controls">
								<form:input path="firstName" />
							</div>
							<div>
								<form:errors path="firstName" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="lastName">${labelPersonLastName}*</label>
							<div class="controls">
								<form:input path="lastName" />

							</div>
							<div>
								<form:errors path="lastName" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="sex">${labelPersonSex}</label>
							<div class="controls">
								<form:input path="sex" />
							</div>
							<div>
								<form:errors path="sex" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="birthDate">${labelPersonBirthDate}</label>
							<div class="controls">
								<form:input path="birthDate" />
							</div>
							<div>
								<form:errors path="birthDate" cssClass="error" />
							</div>
						</div>

						<!-- 
						<div class="controls">
					<input type="text" id="uBirth" value='<joda:format value="${person.birthDate}"
						pattern="${dateFormatPattern}"/>' >
				</div>
						 -->

						<div class="control-group">
							<label class="control-label" for="email">${labelPersonEmail}*</label>
							<div class="controls">
								<form:input path="email" />
							</div>
							<div>
								<form:errors path="email" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="password">${labelPersonPassword}</label>
							<div class="controls">
								<form:password path="password" />
							</div>
							<div>
								<form:errors path="password" cssClass="error" />
							</div>
						</div>
						<!-- Close Span 1 -->
					</div>
					<div class="span4 offset1">
						<div class="control-group">
							<label class="control-label" for="street">${labelPersonStreet}</label>
							<div class="controls">
								<form:input path="street" />
							</div>
							<div>
								<form:errors path="street" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="city">${labelPersonCity}</label>
							<div class="controls">
								<form:input path="city" />
							</div>
							<div>
								<form:errors path="city" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="state">${labelPersonState}</label>
							<div class="controls">
								<form:input path="state" />
							</div>
							<div>
								<form:errors path="state" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="userType">${labelPersonUserType}*</label>
							<div class="controls">
								<form:input path="userType" readonly="true" />
							</div>
							<div>
								<form:errors path="userType" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="description">${labelPersonPhone}</label>
							<div class="controls">
								<form:input path="description" />
							</div>
							<div>
								<form:errors path="description" cssClass="error" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="photo">${labelPersonPhoto}</label>
							<div class="controls">
								<input name="file" type="file" />
							</div>
						</div>
						<form:hidden path="version" />
					</div>
					<!-- Close span 2 pull-right-->
				</div>
				<!-- Close row 2 -->
				<div class="row-fluid">
					<div class="span10">
						<div class="text-center">
							<button type="submit" class="btn">Save Member</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					</div>
				</div>
				<!-- Close row3 -->
			</fieldset>
		</form:form>
	</div>
</div>