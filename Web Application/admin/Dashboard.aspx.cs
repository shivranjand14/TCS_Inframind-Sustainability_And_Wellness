using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class admin_Dashboard : System.Web.UI.Page
{
    public string i;
    public int j = 0;
    protected void Page_Load(object sender, EventArgs e)
    {
        //https://ecssofttech.com/api/health_monitor/showhealthdata.php?flag=suparna
        GetData();
    }
    public void GetData()
    {
        string json = (new WebClient()).DownloadString("https://ecssofttech.com/api/health_monitor/show_all_data.php");

        if (json != null)
        {
            grdView.DataSource = JsonConvert.DeserializeObject<DataTable>(json);
            grdView.DataBind();
            i = (grdView.Rows.Count - j).ToString();
        }
    }
    public string Critical()
    {
        string json = (new WebClient()).DownloadString("https://ecssofttech.com/api/health_monitor/health_monitor_show_critical.php");
        if (json != null)
        {
            j = Convert.ToInt32(json);
            GetData();
            return json;
        }
        GetData();
        return "0";
    }
    protected void grdView_RowCommand(object sender, GridViewCommandEventArgs e)
    {

    }
}