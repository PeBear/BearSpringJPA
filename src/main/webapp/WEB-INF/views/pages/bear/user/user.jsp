<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome to User List</h1>

<%--@elvariable id="userList" type="java.util.List<com.bear.bearspring.common.dto.UserDTO>"--%>
<c:if test="${empty userList}">
  No user found
</c:if>

<c:if test="${not empty userList}">
  <table class="table table-bordered table-striped table-hover text-center">
    <thead>
    <tr>
      <th>STT</th>
      <th>Username</th>
      <th>Full Name</th>
      <th>Email</th>
      <th>Mobile</th>
      <th>Joined Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}" varStatus="item">
      <tr>
        <td>${item.index + 1}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td>${user.fullName}</td>
        <td>${user.mobile}</td>
        <td>${user.joinedAt}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <nav>
    <ul class="pagination justify-content-end">
      <li class="page-item">
        <a class="page-link" href="#">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li class="page-item"><a class="page-link" href="#">1</a></li>
      <li class="page-item"><a class="page-link" href="#">2</a></li>
      <li class="page-item"><a class="page-link" href="#">3</a></li>
      <li class="page-item">
        <a class="page-link" href="#">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</c:if>
