<%@ include file="/WEB-INF/tags.jsp"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!--Navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark double-nav  fixed-top scrolling-navbar">

            <!-- SideNav slide-out button -->
            <div class="float-left">
                <a href="#" data-activates="slide-out" class="button-collapse">
                    <i class="fa fa-bars"></i>
                </a>
            </div>

            <!-- Breadcrumb-->
            <div class="breadcrumb-dn mr-auto">
                <p>Payspec Payment</p>
            </div>

            <!-- Links -->
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li class="nav-item">
                    <a class="nav-link">
                        <i class="fa fa-envelope"></i>
                        <span class="clearfix d-none d-sm-inline-block">Contact</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link">
                        <i class="fa fa-gear"></i>
                        <span class="clearfix d-none d-sm-inline-block">Settings</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user"></i>
                        <span class="clearfix d-none d-sm-inline-block">Account</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Help</a>
                        <a class="dropdown-item" href="${contextPath}/edit/profile">Edit Account</a>
                        <a class="dropdown-item" href="signout?">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>
        <!--/.Navbar-->

<!-- Sidebar navigation -->
        <div id="slide-out" class="side-nav fixed sn-bg-4">
            <ul class="custom-scrollbar list-unstyled">
                <!-- Logo -->
                <li class="logo-sn waves-effect">
                    <div class=" text-center">
                        <a href="#" class="pl-0">
                            <img src="" class="" alt="Payspec Logo">
                            <!-- <img src="https://mdbootstrap.com/img/logo/mdb-transparent.png" class=""> -->
                        </a>
                    </div>
                </li>
                <!--/. Logo -->
                <!--Search Form-->
                <li>
                    <form class="search-form" role="search">
                        <div class="md-form my-0 waves-light">
                            <input type="text" class="form-control py-2" placeholder="Search">
                        </div>
                    </form>
                </li>
                <!--/.Search Form-->
                <!-- Side navigation links -->
                <li>
                    <ul class="collapsible collapsible-accordion">
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-chevron-right"></i> User Management
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">Administrator</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Customer</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Financial Institution</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Telco</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Regulator</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-hand-pointer-o"></i> Account Management
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">Account Setup</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Report</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-hand-pointer-o"></i> Payment Management
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">Payment Setup</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Report</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-hand-pointer-o"></i> Product Management
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">Payspec Payment</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Payspec e-Trade</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">QuatCart e-Commerce</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Payspec POS</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Quadrant Delivery</a>
                                    </li>
                                    
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-eye"></i> Application Configuration
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">Profile</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Role</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Menu</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Security Policy</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Password Policy</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li>
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-envelope-o"></i> Business Confguration
                                <i class="fa fa-angle-down rotate-icon"></i>
                            </a>
                            <div class="collapsible-body">
                                <ul>
                                    <li>
                                        <a href="#" class="waves-effect">FAQ</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Write a message</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">FAQ</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Write a message</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">FAQ</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Write a message</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">FAQ</a>
                                    </li>
                                    <li>
                                        <a href="#" class="waves-effect">Write a message</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </li>
                <!--/. Side navigation links -->
            </ul>

            <!-- Mask -->
            <div class="sidenav-bg mask-strong"></div>

        </div>
        <!--/. Sidebar navigation -->