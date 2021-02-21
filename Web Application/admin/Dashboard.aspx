<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Dashboard.aspx.cs" Inherits="admin_Dashboard" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   

    <title>Health Monitor</title>

    <!-- Google font-->
    <link href="https://fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Font Awesome-->
    <link rel="stylesheet" type="text/css" href="../assets/css/fontawesome.css">

    <!-- Flag icon-->
    <link rel="stylesheet" type="text/css" href="../assets/css/flag-icon.css">

    <!-- ico-font-->
    <link rel="stylesheet" type="text/css" href="../assets/css/icofont.css">

    <!-- Prism css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/prism.css">

    <!-- Chartist css -->
    <link rel="stylesheet" type="text/css" href="../assets/css/chartist.css">

    <!-- Bootstrap css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">

    <!-- App css-->
    <link rel="stylesheet" type="text/css" href="../assets/css/admin.css">

   
</head>

<body>

<!-- page-wrapper Start-->
<div class="page-wrapper">

    <!-- Page Header Start-->
    <div class="page-main-header">
        <div class="main-header-right row">
            <div class="main-header-left d-lg-none">
                <div class="logo-wrapper"><a href="index.html"><img class="blur-up lazyloaded" alt=""></a></div>
            </div>
            <div class="mobile-sidebar">
                <div class="media-body text-right switch-sm">
                    <label class="switch"><a href="#"><i id="sidebar-toggle" data-feather="align-left"></i></a></label>
                </div>
            </div>
            <div class="nav-right col">
                <ul class="nav-menus">
                    <li>
                        
                    <li class="onhover-dropdown">
                        <div class="media align-items-center"><img class="align-self-center pull-right img-50 rounded-circle blur-up lazyloaded" src="../assets/images/dashboard/man.png" alt="header-user">
                            <div class="dotted-animation"><span class="animate-circle"></span><span class="main-circle"></span></div>
                        </div>
                        <ul class="profile-dropdown onhover-show-div p-20">
                            <li><a href="Logout.aspx"><i data-feather="log-out"></i>Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="d-lg-none mobile-toggle pull-right"><i data-feather="more-horizontal"></i></div>
            </div>
        </div>
    </div>
    <!-- Page Header Ends -->

    <!-- Page Body Start-->
    <div class="page-body-wrapper">

        <!-- Page Sidebar Start-->
        <div class="page-sidebar">
            <div class="main-header-left d-none d-lg-block">
                <div class="logo-wrapper"><a href="index.html"><img class="blur-up lazyloaded" alt=""></a></div>
            </div>
            <div class="sidebar custom-scrollbar">
              
                <ul class="sidebar-menu">
                    <li><a class="sidebar-header" href="Dashboard.aspx"><i data-feather="home"></i><span>Dashboard</span></a></li>
                    <li><a class="sidebar-header" href="SearchRecord.aspx"><i data-feather="box"></i> <span>Search Record</span></a></li>
                </ul>
            </div>
        </div>
        <!-- Page Sidebar Ends-->

        <!-- Right sidebar Start-->
        <div class="right-sidebar" id="right_side_bar">
            <div>
                <div class="container p-0">
                    <div class="modal-header p-l-20 p-r-20">
                        <div class="col-sm-8 p-0">
                            <h6 class="modal-title font-weight-bold">FRIEND LIST</h6>
                        </div>
                        <div class="col-sm-4 text-right p-0"><i class="mr-2" data-feather="settings"></i></div>
                    </div>
                </div>
                <div class="friend-list-search mt-0">
                    <input type="text" placeholder="search friend"><i class="fa fa-search"></i>
                </div>
                <div class="p-l-30 p-r-30">
                    <div class="chat-box">
                        <div class="people-list friend-list">
                            <ul class="list">
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/user.png" alt="">
                                    <div class="status-circle online"></div>
                                    <div class="about">
                                        <div class="name">Vincent Porter</div>
                                        <div class="status"> Online</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/user1.jpg" alt="">
                                    <div class="status-circle away"></div>
                                    <div class="about">
                                        <div class="name">Ain Chavez</div>
                                        <div class="status"> 28 minutes ago</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/user2.jpg" alt="">
                                    <div class="status-circle online"></div>
                                    <div class="about">
                                        <div class="name">Kori Thomas</div>
                                        <div class="status"> Online</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/user3.jpg" alt="">
                                    <div class="status-circle online"></div>
                                    <div class="about">
                                        <div class="name">Erica Hughes</div>
                                        <div class="status"> Online</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/man.png" alt="">
                                    <div class="status-circle offline"></div>
                                    <div class="about">
                                        <div class="name">Ginger Johnston</div>
                                        <div class="status"> 2 minutes ago</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/user5.jpg" alt="">
                                    <div class="status-circle away"></div>
                                    <div class="about">
                                        <div class="name">Prasanth Anand</div>
                                        <div class="status"> 2 hour ago</div>
                                    </div>
                                </li>
                                <li class="clearfix"><img class="rounded-circle user-image" src="../assets/images/dashboard/designer.jpg" alt="">
                                    <div class="status-circle online"></div>
                                    <div class="about">
                                        <div class="name">Hileri Jecno</div>
                                        <div class="status"> Online</div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Right sidebar Ends-->

        <div class="page-body">

            <!-- Container-fluid starts-->
            <div class="container-fluid">
                <div class="page-header">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="page-header-left">
                                <h3>Dashboard
                                    <small>Admin panel</small>
                                </h3>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <ol class="breadcrumb pull-right">
                                <li class="breadcrumb-item"><a href="index.html"><i data-feather="home"></i></a></li>
                                <li class="breadcrumb-item active">Dashboard</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Container-fluid Ends-->

            <!-- Container-fluid starts-->
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-3 col-md-6 xl-50">
                        <div class="card o-hidden widget-cards">
                            <div class="bg-warning card-body">
                                <div class="media static-top-widget row">
                                    <div class="icons-widgets col-4">
                                        <div class="align-self-center text-center"><i data-feather="users" class="font-warning"></i></div>
                                    </div>
                                    <div class="media-body col-8"><span class="m-0">Critical Users</span>
                                        <h3 class="mb-0"> <span class="counter"><%=Critical() %></span><small></small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-md-6 xl-50">
                        <div class="card o-hidden  widget-cards">
                            <div class="bg-secondary card-body">
                                <div class="media static-top-widget row">
                                    <div class="icons-widgets col-4">
                                        <div class="align-self-center text-center"><i data-feather="users" class="font-secondary"></i></div>
                                    </div>
                                    <div class="media-body col-8"><span class="m-0">Normal Users</span>
                                        <h3 class="mb-0"> <span class="counter"><%=(i) %></span><small></small></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                <form runat="server">
                    <div class="card">
                                                    <div class="card-body">

                         <div class="theme-card" style="margin-right:10px">
                <div class="table-responsive" style="align-content:center">

                                    <div class="clsmargin" style="margin:auto">
            
                                      <asp:GridView ID="grdView" runat="server" AutoGenerateColumns="False" OnRowCommand="grdView_RowCommand" CssClass="table table-hover table-striped" GridLines="None" BorderStyle="Dashed" style="border-collapse:collapse;">
                <Columns>
                    <asp:TemplateField HeaderText="ID">
                        <ItemTemplate>
                            <asp:Label ID="lblID" runat="server" Text='<%#Eval("id") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Username">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("name") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Body Temprature">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("bodytemprature") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Blood Pressure">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("bloodpressure") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Respiratory Rate">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("respiratoryrate") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Glucose">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("glucose") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Heart Rate">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("heartrate") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Oxygen Saturation">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("oxygensaturation") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Electrocardiogram">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("electrocardiogram") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Blood Sugar">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("bloodsugar") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Date">
                        <ItemTemplate>
                            <asp:Label ID="lblFullName" runat="server" Text='<%#Eval("date") %>'></asp:Label>
                        </ItemTemplate>
                    </asp:TemplateField>
                 
                </Columns>
                                          <FooterStyle BackColor="#F7DFB5" ForeColor="#8C4510" />
                                          <HeaderStyle BorderStyle="Solid" BackColor="#A55129" Font-Bold="True" ForeColor="White" />
                                          <PagerStyle ForeColor="#8C4510" HorizontalAlign="Center" />
                                          <RowStyle BackColor="#FFF7E7" ForeColor="#8C4510" />
                                          <SelectedRowStyle BackColor="#738A9C" Font-Bold="True" ForeColor="White" />
                                          <SortedAscendingCellStyle BackColor="#FFF1D4" />
                                          <SortedAscendingHeaderStyle BackColor="#B95C30" />
                                          <SortedDescendingCellStyle BackColor="#F1E5CE" />
                                          <SortedDescendingHeaderStyle BackColor="#93451F" />
            </asp:GridView>

                                </div>
                                    </div>
                        </div>
                                                        </div>
                        </div>
                  </form>
                   
                </div>
                
            </div>
            <!-- Container-fluid Ends-->

        </div>

        <!-- footer start-->
        <footer class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 footer-copyright">
                        <p class="mb-0">Copyright 2020 © SPKV Takari</p>
                    </div>
                    <div class="col-md-6">
                        <p class="pull-right mb-0">Hand crafted & made with<i class="fa fa-heart"></i></p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- footer end-->
    </div>
<!-- latest jquery-->
<script src="../assets/js/jquery-3.3.1.min.js"></script>

<!-- Bootstrap js-->
<script src="../assets/js/popper.min.js"></script>
<script src="../assets/js/bootstrap.js"></script>

<!-- feather icon js-->
<script src="../assets/js/icons/feather-icon/feather.min.js"></script>
<script src="../assets/js/icons/feather-icon/feather-icon.js"></script>

<!-- Sidebar jquery-->
<script src="../assets/js/sidebar-menu.js"></script>

<!--chartist js-->
<script src="../assets/js/chart/chartist/chartist.js"></script>

<!--chartjs js-->
<script src="../assets/js/chart/chartjs/chart.min.js"></script>

<!-- lazyload js-->
<script src="../assets/js/lazysizes.min.js"></script>

<!--copycode js-->
<script src="../assets/js/prism/prism.min.js"></script>
<script src="../assets/js/clipboard/clipboard.min.js"></script>
<script src="../assets/js/custom-card/custom-card.js"></script>

<!--counter js-->
<script src="../assets/js/counter/jquery.waypoints.min.js"></script>
<script src="../assets/js/counter/jquery.counterup.min.js"></script>
<script src="../assets/js/counter/counter-custom.js"></script>

<!--peity chart js-->
<script src="../assets/js/chart/peity-chart/peity.jquery.js"></script>

<!--sparkline chart js-->
<script src="../assets/js/chart/sparkline/sparkline.js"></script>

<!--Customizer admin-->
<script src="../assets/js/admin-customizer.js"></script>

<!--dashboard custom js-->
<script src="../assets/js/dashboard/default.js"></script>

<!--right sidebar js-->
<script src="../assets/js/chat-menu.js"></script>

<!--height equal js-->
<script src="../assets/js/height-equal.js"></script>

<!-- lazyload js-->
<script src="../assets/js/lazysizes.min.js"></script>

<!--script admin-->
<script src="../assets/js/admin-script.js"></script>

</body>
</html>

