using Guna.UI2.WinForms;
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
    public partial class Splash : Form
    {
        public Splash()
        {
            InitializeComponent();
            

        }
        int startup = 0;
        private void timer1_Tick(object sender, EventArgs e)
        {
            startup += 1;
            Myprogressbar.Value= startup;
            if (Myprogressbar.Value == 100)
            {
                
                timer1.Stop();
                Login obg = new Login();           
                obg.Show();
                this.Hide();
            }
        }

        private void Splash_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }
    }
}
