<c:url value="/api/auth/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">       
	<c:if test="${not empty param.error}">        
		<p> Invalid username and password. </p>
		<p><c:out value="${param.error}"></c:out></p>
		<p><c:out value="${param.logout}"></c:out></p>
	</c:if>
	<c:if test="${param.logout}">       
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>	
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>	
	</p>
	<input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>