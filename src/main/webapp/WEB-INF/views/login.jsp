<html lang="zxx">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false"%>
<c:url var="postloginUrl" value="/homecontroller/home" />

<link rel="stylesheet"
	href="<c:url value='${pageContext.request.contextPath}/css/login.css' />"
	type="text/css" media="all" />
<style>
.input-error {
	border-bottom: 1px solid rgba(255, 0, 0, 0.4);
}
</style>
<body>
	<br>
	<br>
	<div class="cont">
		<div class="form sign-in">
			<form action="${postloginUrl}" method="POST">
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

		<div class="sub-cont">
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

			<form class="form sign-up">
				<h2>Create your Account</h2>
				<label> <span>Name</span> <input type="text" />
				</label> <label> <span>Email</span> <input type="email" />
				</label> <label> <span>Password</span> <input type="password" />
				</label>
				<button type="submit" class="submit">Sign Up</button>
			</form>
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
