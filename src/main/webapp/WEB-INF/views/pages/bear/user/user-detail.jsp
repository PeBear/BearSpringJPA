<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome to User Detail</h1>

<c:if test="${empty user}">
  No user found
</c:if>

<c:if test="${user}">
  <h1>${user.username}</h1>
  <h1>${user.email}</h1>
  <h1>${user.fullname}</h1>
  <h1>${user.mobile}</h1>
  <h1>${user.joinedDate}</h1>
</c:if>


