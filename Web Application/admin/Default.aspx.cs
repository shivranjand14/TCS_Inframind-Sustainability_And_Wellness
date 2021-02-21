using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class admin_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        String username = Request.Form["username"];
        String password = Request.Form["password"];

        if (username == "admin" && password == "admin")
        {
            Response.Redirect("Dashboard.aspx");

        }
        else
        {
            ModalPopupExtender1.Show();
        }
    }
}