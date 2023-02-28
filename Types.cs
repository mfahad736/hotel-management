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
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace HotelMGT
{
    public partial class Types : Form
    {
        public Types()
        {
            InitializeComponent();
            populate();
        }
        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
       
        private void populate()
        {
            Con.Open();
            string Query = "select * from TypeTbl";
            SqlDataAdapter sda=new SqlDataAdapter(Query, Con);
            SqlCommandBuilder builder= new SqlCommandBuilder(sda);
            var ds =new DataSet();
            sda.Fill(ds);  
            TypeDGV.DataSource= ds.Tables[0];  

            Con.Close();    
        }
        private void InsertCategories()
        {

            if (TypeNameTb.Text == "" || CostTb.Text=="")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {

                    Con.Open();

                    SqlCommand cmd = new SqlCommand("insert into TypeTbl(TypeName,TypeCost) values(@TN,@TC)", Con);

                    cmd.Parameters.AddWithValue("@TN", TypeNameTb.Text);
                    cmd.Parameters.AddWithValue("@TC", CostTb.Text);                 
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Category Inserted Successfully");
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

        private void UpdateCategories()
        {

            if (TypeNameTb.Text == "" || CostTb.Text == "")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {

                    Con.Open();

                    SqlCommand cmd = new SqlCommand("update TypeTbl set TypeName=@TN,TypeCost=@TC where  TypeNum= @TKEY", Con);
                    cmd.Parameters.AddWithValue("@TN", TypeNameTb.Text);
                    cmd.Parameters.AddWithValue("@TC", CostTb.Text);
                    cmd.Parameters.AddWithValue("@TKEY", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Category Updated Successfully");
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
        private void DeleteCategories()
        {

            if (TypeNameTb.Text == "" || CostTb.Text == "")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {

                    Con.Open();

                    SqlCommand cmd = new SqlCommand("delete from TypeTbl where TypeNum= @TKEY ", Con);
                    cmd.Parameters.AddWithValue("@TKEY", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Category Deleted Successfully");
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
      

        private void label5_Click(object sender, EventArgs e)
        {
            Rooms obj = new Rooms();
            obj.Show();
            this.Hide();

        }
        int KEY = 0;
        private void UpdateBtn_Click_1(object sender, EventArgs e)
        {
            UpdateCategories();
        }

        private void DeleteBtn_Click_1(object sender, EventArgs e)
        {
            DeleteCategories();
        }

        private void SaveBtn_Click_1(object sender, EventArgs e)
        {
            InsertCategories();
        }

        private void TypeDGV_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
            
        }

        private void panel3_MouseClick(object sender, MouseEventArgs e)
        {
            Customers obj = new Customers();
            obj.Show();
            this.Hide();
        }

        private void label2_Click(object sender, EventArgs e)
        {
            Dashboard obj = new Dashboard();
            obj.Show();
            this.Hide();
        }

        private void label7_Click(object sender, EventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void label6_Click(object sender, EventArgs e)
        {
            Customers obj = new Customers();
            obj.Show();
            this.Hide();
        }

        private void TypeDGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            TypeNameTb.Text = TypeDGV.SelectedRows[0].Cells[1].Value.ToString();
            CostTb.Text = TypeDGV.SelectedRows[0].Cells[2].Value.ToString();
            if (TypeNameTb.Text == "")
            {
                KEY = 0;
            }
            else
            {
                KEY = Convert.ToInt32(TypeDGV.SelectedRows[0].Cells[0].Value.ToString());
            }
        }
    }
}
