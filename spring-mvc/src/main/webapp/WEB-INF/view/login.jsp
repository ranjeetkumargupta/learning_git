<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.0/mdb.min.css"
	rel="stylesheet" />
<style>
.intro {
	height: 100%;
}

@media ( min-height : 300px) and (max-height: 450px) {
	.intro {
		height: 100%;
	}
	@media ( min-height : 300px) and (max-height: 450px) {
		.intro {
			height: auto;
		}
	}
	.gradient-custom {
		background: radial-gradient(50% 123.47% at 50% 50%, #00FF94 0%, #720059 100%),
			linear-gradient(121.28deg, #669600 0%, #FF0000 100%),
			linear-gradient(360deg, #0029FF 0%, #8FFF00 100%),
			radial-gradient(100% 164.72% at 100% 100%, #6100FF 0%, #00FF57 100%),
			radial-gradient(100% 148.07% at 0% 0%, #FFF500 0%, #51D500 100%);
		background-blend-mode: screen, color-dodge, overlay, difference, normal;
	}
}
</style>
</head>
<body>
	<section class="intro">
		<div class="mask d-flex align-items-center h-100"
			style="background-color: #D6D6D6;">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">
								<div class="my-md-5 pb-5">
									<h1 class="fw-bold mb-0">User Login Form</h1>
									<i class="fas fa-user-astronaut fa-3x my-5"></i>
									<form:form action="loginCheck" method="post"
										modelAttribute="user">

										

										<div class="form-outline mb-4">
											<form:input type="text" id="typeFirst" path="username"
												class="form-control form-control-lg" />
											<label class="form-label" for="typeFirst">User Name</label>
										</div>

										<div class="form-outline mb-4">
											<form:input type="text" id="typeLast" path="password"
												class="form-control form-control-lg" />
											<label class="form-label" for="typeLast">Password</label>
										</div>

										
										<button
											class="btn btn-primary btn-lg btn-rounded gradient-custom text-body px-5"
											type="submit">Login</button>

									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

