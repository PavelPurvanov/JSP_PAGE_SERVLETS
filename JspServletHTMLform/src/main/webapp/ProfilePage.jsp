<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.UserBean"%>

<jsp:useBean id="user" class="model.UserBean" scope="request"></jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style/main.css">

</head>
<body>

	<header class="header"></header>

	<input type="hidden" name="id" value="<%=user.getId()%>" />

	<main class="main">
		<div class="shell">
			<div class="profile">
				<img class="profile-image" src="images/user.jpg" />

				<div class="profile-info">

					<div class="centered">
						<a href="UserServlet?id=<%=user.getId()%>&action=edit"
							class="button">Редактиране</a>
					</div>
					<h2 class="heading">Профилна информация</h2>
					<span class="text"> <label>Име:</label> <%=user.getFirstName()%>

					</span> <span class="text"> <label>Работа:</label> <%=user.getJob()%>

					</span> <span class="text"><label> Описание: </label> <%=user.getInfo() %>
							
					</span>
				</div>
			</div>

			<h1 class="heading centered">Умения</h1>
			<div class="info-box">
				<div class="pro-skills">
					<h2 class="heading centered">Професионални</h2>
					<span class="text">JAVA</span>
					<div class="bar bar-java"></div>
					<span class="text">HTML</span>
					<div class="bar bar-html"></div>
					<span class="text">CSS</span>
					<div class="bar bar-css"></div>
					<span class="text">JavaScript</span>
					<div class="bar bar-js"></div>
				</div>
				<div class="pers-skills">
					<h2 class="heading centered">Личностни</h2>
					<span class="text">Комуникативност</span>
					<div class="bar bar-commun"></div>
					<span class="text">Екиптна работа</span>
					<div class="bar bar-team"></div>
					<span class="text">Креативност</span>
					<div class="bar bar-create"></div>
				</div>
			</div>

			<h1 class="heading centered contact-heading">Конакти</h1>
			<div class="info-box">

				<div class="contact-box">
					<span class="text">Имейл</span> <span class="contact-text">
						<%=user.getEmail()%>
					</span>
				</div>

				<div class="contact-box">
					<span class="text">Град</span> <span class="contact-text"> <%=user.getCity()%>

					</span>
				</div>

				<div class="contact-box">
					<span class="text">Телефон</span> <span class="contact-text">


						<%=user.getPhone()%>

					</span>
				</div>

				<div class="contact-box">
					<span class="text">Улица</span> <span class="contact-text">


						<%=user.getStreet()%>

					</span>
				</div>


			</div>

		</div>

	</main>
	<footer class="footer"></footer>



</body>
</html>