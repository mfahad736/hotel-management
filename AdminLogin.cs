using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace HotelMGT
{
    public partial class AdminLogin : Form
    {
        public AdminLogin()
        {
            InitializeComponent();
        }

        

        private void ClosePic_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        private void LogBtClick()
        {
            if (PassTb.Text == "")
            {
                MessageBox.Show("Enter Admin Password !!!");
            }
            else
            {
                if (PassTb.Text == "Password")
                {
                    Users obj = new Users();
                    obj.Show();
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Wrong Admin Password !!!");
                }
            }
        }



        private void LogBtn_Click_1(object sender, EventArgs e)
        {
            LogBtClick();
        }
        private void ContinueLbl_Click(object sender, EventArgs e)
        {
            Login Obj = new Login();
            Obj.Show();
            this.Hide();
        }

        private void PassTb_TextChanged(object sender, EventArgs e)
        {
            
        }
    }
}
