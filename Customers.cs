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
    public partial class Customers : Form
    {
        public Customers()
        {
            InitializeComponent();
            populate();
        }
        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
        private void populate()
        {
            Con.Open();
            string Query = "select * from CustomerTbl";
            SqlDataAdapter sda = new SqlDataAdapter(Query, Con);
            SqlCommandBuilder builder = new SqlCommandBuilder(sda);
            var ds = new DataSet();
            sda.Fill(ds);
            CustomerDGV.DataSource = ds.Tables[0];
            Con.Close();
        }
        private void InsertCustomer()
        {

            if (CNameTb.Text == "" || CGenderCb.SelectedIndex == -1 || CPhoneTb.Text == "" )
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("insert into CustomerTbl(CustName,CustPhone,CustGender) values(@CN,@CP,@CG)", Con);
                    cmd.Parameters.AddWithValue("@CN", CNameTb.Text);
                    cmd.Parameters.AddWithValue("@CP", CPhoneTb.Text);
                    cmd.Parameters.AddWithValue("@CG", CGenderCb.SelectedItem.ToString());
                    
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Customer Inserted Successfully");
                    Con.Close();
                    populate();

                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                finally { Con.Close(); }
            }



        }


        int KEY = 0;

        private void updateCustomer()
        {
            if (CNameTb.Text == "" || CGenderCb.SelectedIndex == -1 || CPhoneTb.Text == "")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("update CustomerTbl set CustName = @CN,CustPhone=@CP,CustGender = @CG where CustNum = @CKEY ", Con);
                    cmd.Parameters.AddWithValue("@CN", CNameTb.Text);
                    cmd.Parameters.AddWithValue("@CP", CPhoneTb.Text);
                    cmd.Parameters.AddWithValue("@CG", CGenderCb.SelectedItem.ToString());
                    cmd.Parameters.AddWithValue("@CKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Customer Updated Successfully");
                    Con.Close();
                    populate();

                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                finally { Con.Close(); }
            }

        }


        private void DeleteCustomer()
        {
            if (KEY == 0)
            {
                MessageBox.Show("Select a User !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("delete from CustomerTbl where CustNum = @CKey ", Con);
                    cmd.Parameters.AddWithValue("@CKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Customer Deleted Successfully");
                    Con.Close();
                    populate();

                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                finally { Con.Close(); }
            }

        }
        private void UpdateBtn_Click_1(object sender, EventArgs e)
        {
            updateCustomer();
        }

        private void SaveBtn_Click_1(object sender, EventArgs e)
        {
            InsertCustomer();
        }

        private void DeleteBtn_Click_1(object sender, EventArgs e)
        {
            DeleteCustomer();
        }

        private void CustomerDGV_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
           
        }

        private void panel3_MouseClick(object sender, MouseEventArgs e)
        {
            Login obj = new Login();
            obj.Show();
            this.Hide();
        }

        private void panel9_MouseClick(object sender, MouseEventArgs e)
        {
            Customers obj= new Customers();
            obj.Show();
            this.Hide();
        }

        private void panel8_MouseClick(object sender, MouseEventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void panel6_MouseClick(object sender, MouseEventArgs e)
        {
            Rooms obj = new Rooms();
            obj.Show();
            this.Hide();
        }

        private void panel5_MouseClick(object sender, MouseEventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void label7_Click(object sender, EventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void label5_Click(object sender, EventArgs e)
        {
            Rooms obj = new Rooms();
            obj.Show();
            this.Hide();
        }

        private void label4_Click(object sender, EventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void label2_Click(object sender, EventArgs e)
        {
            Dashboard obj = new Dashboard();
            obj.Show();
            this.Hide();
        }

        private void CustomerDGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            CNameTb.Text = CustomerDGV.SelectedRows[0].Cells[1].Value.ToString();
            CGenderCb.Text = CustomerDGV.SelectedRows[0].Cells[3].Value.ToString();
            CPhoneTb.Text = CustomerDGV.SelectedRows[0].Cells[2].Value.ToString();
            if (CNameTb.Text == "")
            {
                KEY = 0;
            }
            else
            {
                KEY = Convert.ToInt32(CustomerDGV.SelectedRows[0].Cells[0].Value.ToString());
            }
        }
    }
}
