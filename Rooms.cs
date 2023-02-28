
using System.Data;
using System.Data.SqlClient;
namespace HotelMGT

{
    public partial class Rooms : Form
    {
        public Rooms()
        {
            InitializeComponent();
            GetCategories();
            populate();
            
        }
        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
        private void GetCategories()
        {


            Con.Open();
            string query = "select * from TypeTbl";
            DataTable dt=new DataTable();
            SqlDataAdapter sda = new SqlDataAdapter(query,Con);
            sda.Fill(dt);
            RTypeCb.DisplayMember = dt.Columns["TypeName"].ToString();
            RTypeCb.ValueMember= dt.Columns["TypeNum"].ToString();
            RTypeCb.DataSource = dt;
            Con.Close();














            // Old Data Technique
           /*  Con.Open();
            SqlCommand cmd= new SqlCommand("select * from TypeTbl", Con);
            SqlDataReader rdr;
            rdr=cmd.ExecuteReader();
            DataTable dt=new DataTable();
            dt.Columns.Add("TypeNum" , typeof(int));
            dt.Load(rdr);          
            RTypeCb.ValueMember = "TypeNum".ToString();
            RTypeCb.DisplayMember="TypeName".ToString();
            RTypeCb.DataSource = dt;
            Con.Close();    */
        }
        private void populate()
        {
            Con.Open();
            string Query = "select * from RoomTbl";
            SqlDataAdapter sda = new SqlDataAdapter(Query, Con);
            SqlCommandBuilder builder = new SqlCommandBuilder(sda);
            var ds = new DataSet();
            sda.Fill(ds);
            RoomsDGV.DataSource = ds.Tables[0];
            Con.Close();
        }
        private void InsertRooms()
        {

            if (RnameTb.Text == "" || RTypeCb.SelectedIndex == -1 || StatusCb.SelectedIndex == -1)
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("insert into RoomTbl(RName,RType,RStatus) values(@RN,@RT,@RS)", Con);
                    cmd.Parameters.AddWithValue("@RN", RnameTb.Text);
                    cmd.Parameters.AddWithValue("@RT", RTypeCb.SelectedValue.ToString());
                    cmd.Parameters.AddWithValue("@RS", "Available");
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Room Inserted Successfully");
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
        private void updateRooms()
        {
            if (RnameTb.Text == "" || RTypeCb.SelectedIndex == -1 || StatusCb.SelectedIndex == -1)
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("update RoomTbl set RName=@RN,RType=@RT,RStatus=@RS where RNum=@RKEY", Con);
                    cmd.Parameters.AddWithValue("@RN", RnameTb.Text);
                    cmd.Parameters.AddWithValue("@RT", RTypeCb.SelectedIndex.ToString());
                    cmd.Parameters.AddWithValue("@RS", StatusCb.SelectedItem.ToString());
                    cmd.Parameters.AddWithValue("@RKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Room Updated Successfully");
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
       

        private void DeleteRooms()
        {
            if (KEY == 0)
            {
                MessageBox.Show("Select a Room !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("delete from RoomTbl where RNum=@RKey", Con);
                    cmd.Parameters.AddWithValue("@RKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("Room Deleted Successfully");
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
        

        private void LogOutPanel_Click(object sender, EventArgs e)
        {
            Login obj= new Login();
            obj.Show();
            this.Hide();
        }

        private void UpdateBtn_Click_1(object sender, EventArgs e)
        {
            updateRooms();
        }

        private void SaveBtn_Click_1(object sender, EventArgs e)
        {
            InsertRooms();
        }

        private void DeleteBtn_Click_1(object sender, EventArgs e)
        {
            DeleteRooms();
        }

        private void RoomsDGV_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
           
        }

        private void panel3_MouseClick(object sender, MouseEventArgs e)
        {
            Login obj =new Login();
            obj.Show();
            this.Hide();
        }

        private void panel5_MouseClick(object sender, MouseEventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void panel8_MouseClick(object sender, MouseEventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void panel7_MouseClick(object sender, MouseEventArgs e)
        {
            Customers obj = new Customers();
            obj.Show();
            this.Hide();
        }
        private void label2_Click(object sender, EventArgs e)
        {
           
        }

        private void label7_Click(object sender, EventArgs e)
        {
        }

        private void label6_Click(object sender, EventArgs e)
        {
           

        }

        private void RoomsDGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            RnameTb.Text = RoomsDGV.SelectedRows[0].Cells[1].Value.ToString();
            RTypeCb.Text = RoomsDGV.SelectedRows[0].Cells[2].Value.ToString();
            StatusCb.Text = RoomsDGV.SelectedRows[0].Cells[3].Value.ToString();

            if (RnameTb.Text == "")
            {
                KEY = 0;
            }
            else
            {
                KEY = Convert.ToInt32(RoomsDGV.SelectedRows[0].Cells[0].Value.ToString());
            }
        }

        private void label4_MouseClick(object sender, MouseEventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void label2_MouseClick(object sender, MouseEventArgs e)
        {
            Dashboard obj = new Dashboard();
            obj.Show();
            this.Hide();
        }

        private void label7_MouseClick(object sender, MouseEventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void label6_MouseClick(object sender, MouseEventArgs e)
        {
            Customers obj = new Customers();
            obj.Show();
            this.Hide();
        }
    }    
}