using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class admin_SearchRecord : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void button_click(object sender, EventArgs e)
    {
        string json = (new WebClient()).DownloadString("https://ecssofttech.com/api/health_monitor/showhealthdata.php?flag=" + Request.Form["SearchName"]);
        if (json != "{\"message\":\"No Record Found.\",\"status\":false}")
        {
            var obj = JsonConvert.DeserializeObject<DataTable>(json);

            if (obj != null)
            {
                name.Text = obj.Rows[0][1].ToString();
                bt.Text = obj.Rows[0][2].ToString();
                bp.Text = obj.Rows[0][3].ToString();
                rr.Text = obj.Rows[0][4].ToString();
                g.Text = obj.Rows[0][5].ToString();
                hr.Text = obj.Rows[0][6].ToString();
                os.Text = obj.Rows[0][7].ToString();
                ecg.Text = obj.Rows[0][8].ToString();
                bs.Text = obj.Rows[0][9].ToString();
                d.Text = obj.Rows[0][10].ToString();

                Page.ClientScript.RegisterStartupScript(this.GetType(), "CallMyFunction", "js()", true);
            }
        }
        else
        {
            name.Text = "";
            bt.Text = "";
            bp.Text = "";
            rr.Text = "";
            g.Text = "";
            hr.Text = "";
            os.Text = "";
            ecg.Text = "";
            bs.Text = "";
            d.Text = "";

            Response.Write("<script LANGUAGE= 'JavaScript' >alert ('No Record Available')</Script>");
        }
    }
}