<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="navbar navbar-expand-lg navbar-dark bd-navbar sticky-top">
  <nav class="container-xxl bd-gutter flex-wrap flex-lg-nowrap" aria-label="Main navigation">
    <a class="navbar-brand p-0 me-0 me-lg-2" href="<c:url value="/"/>" style="background-color: unset !important;">
      <img src="<c:url value="/assets/images/favicon_io/android-chrome-192x192.png"/>" alt="" width="32" height="30" class="d-inline-block align-text-top"> Bear Solutions
    </a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
        <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle" id="main-navi" data-bs-toggle="dropdown" aria-expanded="false" data-bs-display="static">
          Bear Apps
        </button>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="main-navi">
          <li>
            <a class="dropdown-item current" aria-current="true" href="<c:url value="/bear/dashboard"/>">
              Bear Management
            </a>
          </li>
          <li>
            <a class="dropdown-item current" aria-current="true" href="<c:url value="/expenseNote/dashboard"/>">
              Expense Note
            </a>
          </li>
        </ul>
      </li>
    </ul>

    <ul class="navbar-nav flex-row flex-wrap bd-navbar-nav">
      <li class="nav-item dropdown">
        <button class="btn btn-link nav-link py-2 px-0 px-lg-2 dropdown-toggle" id="bd-versions" data-bs-toggle="dropdown" aria-expanded="false" data-bs-display="static">
          <i class="bi bi-person-circle"></i>
        </button>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="bd-versions">
          <li><h6 class="dropdown-header">Full name</h6></li>
          <li>
            <a class="dropdown-item current" aria-current="true" href="<c:url value="/bear/user/detail?userId=2"/>">
              Profile
            </a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>
          <li>
            <a class="dropdown-item" href="https://getbootstrap.com/docs/5.1/components/navbar/">Settings</a>
          </li>
          <li>
            <hr class="dropdown-divider">
          </li>
          <li>
            <a class="dropdown-item" href="<c:url value="/logout"/>">Sign out</a>
          </li>
        </ul>
      </li>
    </ul>
  </nav>
</header>
