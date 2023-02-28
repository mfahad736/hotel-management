using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HotelMGT
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }
        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
        private void ClosePic_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void ContinueLbl_Click(object sender, EventArgs e)
        {
            AdminLogin Obj = new AdminLogin();
            Obj.Show();
            this.Hide();
        }

        private void LogBtn_Click_1(object sender, EventArgs e)
        {
            if (USERNAME.Text == "" || PassTb.Text == "")
            {
                MessageBox.Show("Enter Username or Password !!! ");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlDataAdapter sda = new SqlDataAdapter("select count(*) from UserTbl where UName='"+USERNAME.Text+"'and Upassword='"+ PassTb.Text+"'", Con);
                    DataTable dt = new DataTable();
                    sda.Fill(dt);
                    if (dt.Rows[0][0].ToString() == "1")
                    {
                        Rooms obj = new Rooms();
                        obj.Show();
                        this.Hide();
                        Con.Close();
                    }
                    else
                    {
                        MessageBox.Show("Wrong Username or Password !!! ");
                    }


                    Con.Close();

                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
            }
        }
    }
}
