<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<link
	href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
</head>

<body>
	<table class="table table-striped">
		<tr>
			<th>TODO</th>
			<th>ONGOING</th>
			<th>DONE</th>
		</tr>
		<c:forEach items="${stories}" var="story">
			<tr>
				<td><c:if test="${story.column == 'todo'}">
				${story.label}
				</c:if></td>
				<td><c:if test="${story.column == 'ongoing'}">
				${story.label}
				</c:if></td>
				<td><c:if test="${story.column == 'done'}">
				${story.label}
				</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
