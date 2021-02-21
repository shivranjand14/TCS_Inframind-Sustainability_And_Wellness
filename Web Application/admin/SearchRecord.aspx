<%@ Page Language="C#" AutoEventWireup="true" CodeFile="SearchRecord.aspx.cs" Inherits="admin_SearchRecord" %>

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

    <style>
        .bp{
            border-color:red;
            background-color:red;
        }
    </style>
    <script>
        function js() {
            var bpcount = 0;
            var rrcount = 0;

            let bt = document.getElementById('bt');
            if (parseInt(bt.value) < 97 || parseInt(bt.value) >= 99)
            {

                bt.style.borderColor = "red";
                bt.style.color = "red";
            }

            let bp = document.getElementById('bp');
            if (parseInt(bp.value) > 120)
            {
                bp.style.borderColor = "red";
                bp.style.color = "red";

                bpcount = 1;
            }
            if(parseInt(bp.value) > 99 && parseInt(bp.value) < 126)
            {
                bpcount = 2;
            }

            let rr = document.getElementById('rr');
            if (parseInt(rr.value) < 12 || parseInt(rr.value) > 16)
            {
                rr.style.borderColor = "red";
                rr.style.color = "red";
               
                let rrl = document.getElementById('rrl');
                rrl.textContent = "Indicating Brobchiectasis"
                rrl.style.display = "block";

                if(parseInt(rr.value) > 19 && parseInt(rr.value) < 31)
                {
                    rrcount = 1;
                }
                
            }

            let g = document.getElementById('g');
            if (parseInt(g.value) >  140)
            {
                g.style.borderColor = "red";
                g.style.color = "red";

            }

            let hr = document.getElementById('hr');
            if (parseInt(hr.value) < 60 || parseInt(hr.value) > 100)
            {
                hr.style.borderColor = "red";
                hr.style.color = "red";

                if (bpcount == 1) {
                    let bpl = document.getElementById('bpl');
                    bpl.textContent = "Indicating CHD"
                    bpl.style.display = "block";
                    let hrl = document.getElementById('hrl');
                    hrl.textContent = "Indicating CHD"
                    hrl.style.display = "block";
                }
            }

            let os = document.getElementById('os');
            if (parseInt(os.value) < 95 || parseInt(os.value) > 100)
            {
                os.style.borderColor = "red";
                os.style.color = "red";

                if (parseInt(os.value) < 95)
                {
                    let osl = document.getElementById('osl');
                    osl.textContent = "Indicating Hypoxemia"
                    osl.style.display = "block";
                }
                if(parseInt(os.value) > 91 && parseInt(os.value) < 96 && bpcount == 2 && rrcount == 1)
                {
                    let main = document.getElementById('main');
                    main.style.display = "block";
                    
                }

            }

            let ecg = document.getElementById('ecg');
            if (parseInt(ecg.value) < 120 || parseInt(ecg.value) > 200)
            {
                ecg.style.borderColor = "red";
                ecg.style.color = "red";

            }

            let bs = document.getElementById('bs');
            if (parseInt(bs.value) >= 140)
            {
                bs.style.borderColor = "red";
                bs.style.color = "red";
                if (parseInt(bs.value) > 140 && parseInt(bs.value) < 200)
                {
                    let bsl = document.getElementById('bsl');
                    bsl.textContent = "Indicating Prediabetes"
                    bsl.style.display = "block";
                }
                else
                {
                    let bsl = document.getElementById('bsl');
                    bsl.textContent = "Indicating Diabetes"
                    bsl.style.display = "block";
                }

            }
        }
    </script>
   
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
                                <h3>Search Record
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
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="theme-card" style="margin-right:10px">
                                                                                                             
                                    <form name="form1" runat="server" class="theme-form" style="margin:auto; margin-left:0px;margin-right:10px; margin-top:15px; width:100%">
                                        <div style="width:70%; margin:auto;">
                                            <div class="form-row">
                                                    <asp:TextBox ID ="SearchName" class="form-control" style="width:50%" runat="server" type="text" required="" placeholder="Search By Name"></asp:TextBox>
                                                    <%--<button type="button" class="btn btn-primary" OnClick="button_click">Search</button>--%>
                                                <asp:Button ID="Button1" runat="server" OnClick="button_click" CssClass="btn btn-primary" 
                                   Text="Search"/>
                                                </div>
                                        </div> 
                                        <hr /> 
                                        <label id="main" style="width:100%; padding-left:20px; font-weight:500; font-size:15px; border-left: 8px solid red; background-color:rgb(238, 155, 155); display:none">The Values Of Oxygen Saturation, Blood Pressure And Respiration Rate Is Indicating <b>Asthma</b></label>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label1" runat="server" Font-Bold="True" Font-Size="Larger">Name:</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="name" class="form-control" style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" required="" Enabled="false"></asp:TextBox>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label2" runat="server" Font-Bold="True" Font-Size="Larger">Body Temprature :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="bt" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required=""  Enabled="false"></asp:TextBox>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label3" runat="server" Font-Bold="True" Font-Size="Larger">Blood Pressure :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="bp" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required=""  Enabled="false"></asp:TextBox>
                                                <label id="bpl" style="width:100%; text-align:center; color:red; display:none"></label>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label4" runat="server" Font-Bold="True" Font-Size="Larger">Respiratory Rate :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="rr" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                                <label id="rrl" style="width:100%; text-align:center; color:red; display:none"></label>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label5" runat="server" Font-Bold="True" Font-Size="Larger">Glucose :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="g" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label6" runat="server" Font-Bold="True" Font-Size="Larger">Heart Rate :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="hr" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                                <label id="hrl" style="width:100%; text-align:center; color:red; display:none"></label>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label7" runat="server" Font-Bold="True" Font-Size="Larger">Oxygen Saturation :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="os" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                                <label id="osl" style="width:100%; text-align:center; color:red; display:none"></label>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label8" runat="server" Font-Bold="True" Font-Size="Larger">Electrocardiogram:</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="ecg" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label9" runat="server" Font-Bold="True" Font-Size="Larger">Blood Sugar:</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="bs" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                                <label id="bsl" style="width:100%; text-align:center; color:red; display:none"></label>
                                            </div>  
                                        </div>
                                        <br />
                                        <div class="form-row">
                                            <div class="col-md-6" style="text-align:center;">
                                                <asp:label ID="Label10" runat="server" Font-Bold="True" Font-Size="Larger">Date :</asp:label>
                                            </div>
                                            <div class="col-md-6" style="margin-left:0px" >
                                                <asp:TextBox ID ="d" class="form-control " style="width:80%; font-size:20px; font-weight:500" runat="server" type="text" autopostback="true" required="" Enabled="false"></asp:TextBox>
                                            </div>  
                                        </div>
                                        <br />

                                                                                       
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                

                
                   
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

