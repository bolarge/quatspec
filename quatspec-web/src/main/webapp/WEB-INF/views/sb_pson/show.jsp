<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:form="http://www.springframework.org/tags/form" 
	xmlns:joda="http://www.joda.org/joda/time/tags"
		
	version="2.0">
     
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <jsp:output omit-xml-declaration="yes"/>

	<spring:message code="label_person_info" var="labelPersonInfo" />
	<spring:message code="label_person_first_name" var="labelPersonFirstName" />
	<spring:message code="label_person_last_name" var="labelPersonLastName" />
	<spring:message code="label_person_birth_date" var="labelPersonBirthDate" />
	<spring:message code="label_person_sex" var="labelPersonSex" />
	<spring:message code="label_person_street" var="labelPersonStreet" />
	<spring:message code="label_person_city" var="labelPersonCity" />
	<spring:message code="label_person_state" var="labelPersonState" />
	<spring:message code="label_person_email" var="labelPersonEmail" />
	<spring:message code="label_person_description" var="labelPersonDescription" />
	<spring:message code="label_person_update" var="labelPersonUpdate" />
	<spring:message code="date_format_pattern" var="dateFormatPattern" />
	<spring:message code="label_person_photo" var="labelPersonPhoto" />

	<spring:url value="/public/sb_pson/photo" var="personPhotoUrl" />
	<spring:url value="/public/sb_pson" var="editPersonUrl" />

<div class="divide">
	<form class="form-horizontal">
		<c:if test="${not empty message}">
			<div id="message" class="${message.type}">${message.message}</div>
		</c:if>
		<fieldset>
			<legend>${labelPersonInfo}</legend>
			<div class="row-fluid">
				<div class="span4">
					<div class="control-group">
						<label class="control-label" for="firstName">${labelPersonFirstName}</label>
						<div class="controls">
							<input type="text" id="fname" name="firstName"
								value="${person.firstName}" readonly="readonly"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="lastName">${labelPersonLastName}</label>
						<div class="controls">
							<input type="text" id="lname" name="lastName"
								value="${person.lastName }" readonly="readonly"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="sex">${labelPersonSex}</label>
						<div class="controls">
							<input type="text" id="sex" name="sex" value="${person.sex }"
								readonly="readonly"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="birthDate">${labelPersonBirthDate}</label>
						<div class="controls">
							
								<joda:format value="${person.birthDate}" pattern="${dateFormatPattern}"/>
								
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="email">${labelPersonEmail}</label>
						<div class="controls">
							<input type="text" id="email" name="email"
								value="${person.email }" readonly="readonly"/>
						</div>
					</div>
				</div>
				<!-- End First Row -->

				<div class="span4 offset1">
					<!-- Begin Second Row -->
					<div class="control-group">
						<label class="control-label" for="street">${labelPersonStreet}</label>
						<div class="controls">
							<input type="text" id="street" name="street"
								value="${person.street }" readonly="readonly"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="city">${labelPersonCity}</label>
						<div class="controls">
							<input type="text" id="city" name="city" value="${person.city }"
								readonly="readonly"/>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="state">${labelPersonState}</label>
						<div class="controls">
							<input type="text" id="state" name="state"
								value="${person.state }" readonly="readonly"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="photo">${labelPersonPhoto}</label>
						<div>
							<img src="${personPhotoUrl}/${person.id}"></img>
						</div>
					</div>

				</div>
				<!-- End Second Row -->
			</div>
			<!-- End Main Row -->
		</fieldset>
		<a href="${editPersonUrl}/${person.id}?form">${labelPersonUpdate}</a>
	</form>
</div>
</div>
