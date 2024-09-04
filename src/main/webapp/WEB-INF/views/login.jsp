<html lang="zxx">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<c:url var="postloginUrl" value="/homecontroller/home" />
<c:url var="postsignupUrl" value="/logincontroller/process" />

<link rel="stylesheet"
	href="<c:url value='${pageContext.request.contextPath}/css/login.css' />"
	type="text/css" media="all" />
<style>
.error {
	color: red;
	font-size: 12px;
}

.short {
	color: red;
}

.input-error {
	border-bottom: 1px solid rgba(255, 0, 0, 0.4);
}
</style>
<body>
	<br>
	<br>
	<div
		class="cont  <c:if test="${formtype == 'signup'}">s--signup</c:if>">
		<div class="form sign-in ">
			<form autocomplete="off" action="${postloginUrl}" method="POST">
				<h2>Welcome</h2>
				<label> <span>Email</span> <input placeholder="Enter Email"
					name="email" id="email" type="email" required
					class="<c:if test='${param.error != null}'>input-error</c:if>">
				</label> <label> <span>Password</span> <input placeholder="Password"
					name="password" id="password" type="password" required
					class="<c:if test='${param.error != null}'>input-error</c:if>">
				</label>
				<p class="forgot-pass">Forgot password?</p>
				<button type="submit" class="submit">Sign In</button>
			</form>
		</div>

		<div class="sub-cont ">
			<div class="img">
				<div class="img__text m--up">
					<h3>Don't have an account? Please Sign up!</h3>
				</div>
				<div class="img__text m--in">
					<h3>If you already have an account, just sign in.</h3>
				</div>
				<div class="img__btn">
					<span class="m--up">Sign Up</span> <span class="m--in">Sign
						In</span>
				</div>
			</div>

			<form:form autocomplete="off" method="POST" action="${postsignupUrl}"
				modelAttribute="userForm" class="form sign-up">
				<h2>Create your Account</h2>

				<label> <spring:bind path="name">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="name" class="form-control"
								placeholder="Username" autofocus="true"></form:input>
							<form:errors path="name"></form:errors>
						</div>
					</spring:bind>
				</label>

				<label> <spring:bind path="formemail">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="formemail" path="formemail"
								class="form-control" placeholder="Enter Email"></form:input>
							<form:errors path="formemail"></form:errors>
						</div>
					</spring:bind>
				</label>
				<label> <spring:bind path="phoneNo">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="phoneNo" path="phoneNo" class="form-control"
								placeholder="Enter Phone Number"></form:input>
							<form:errors path="phoneNo"></form:errors>
						</div>
					</spring:bind>
				</label>
				<label> <spring:bind path="formpassword">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="formpassword"
								class="form-control" placeholder="Password"></form:input>
							<form:errors path="formpassword"></form:errors>
						</div>
					</spring:bind>
				</label>
				<label> <spring:bind path="passwordConfirm">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Confirm Password"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
						</div>
					</spring:bind>
				</label>

				<button type="submit" class="submit">Sign Up</button>
			</form:form>

		</div>
	</div>

	<script>
		document.querySelector('.img__btn').addEventListener(
				'click',
				function() {
					document.querySelector('.cont').classList
							.toggle('s--signup');
				});
	</script>
</body>
</html>
