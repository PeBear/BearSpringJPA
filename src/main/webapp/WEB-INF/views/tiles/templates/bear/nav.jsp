<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
  <div class="position-sticky pt-3">
    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted text-uppercase">
      <span>Bear Management</span>
    </h6>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="<c:url value="/bear/user"/>">
          <i class="bi bi-house-door align-text-bottom"></i>
          User Management
        </a>
      </li>
    </ul>
  </div>
</nav>
