using System.Data;
using System.Data.SqlClient;

namespace HotelMGT
{
    public partial class Users : Form
    {
        public Users()
        {
            InitializeComponent();
            populate();
        }

        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
        private void populate()
        {
            Con.Open();
            string Query = "select * from UserTbl";
            SqlDataAdapter sda = new SqlDataAdapter(Query, Con);
            SqlCommandBuilder builder = new SqlCommandBuilder(sda);
            var ds = new DataSet();
            sda.Fill(ds);
            UserDGV.DataSource = ds.Tables[0];
            Con.Close();
        }
        private void InsertUser()
        {

            if (UnameTb.Text == "" || GenderCb.SelectedIndex == -1 || PhoneTb.Text == "" || PasswordTb.Text == "")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("insert into UserTbl(UName,UPhone,UGender,UPassword) values(@UN,@UP,@UG,@UPP)", Con);
                    cmd.Parameters.AddWithValue("@UN", UnameTb.Text);
                    cmd.Parameters.AddWithValue("@UP", PhoneTb.Text);
                    cmd.Parameters.AddWithValue("@UG", GenderCb.SelectedItem.ToString());
                    cmd.Parameters.AddWithValue("@UPP", PasswordTb.Text);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("User Inserted Successfully");
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

        private void updateUsers()
        {
            if (UnameTb.Text == "" || GenderCb.SelectedIndex == -1 || PhoneTb.Text == "" || PasswordTb.Text == "")
            {
                MessageBox.Show("Missing Information !!!");
            }
            else
            {
                try
                {
                    Con.Open();
                    SqlCommand cmd = new SqlCommand("update UserTbl set UName = @UN,UPhone=@UP,UGender = @UG,UPassword=@UPP where UNum = @UKEY ", Con);
                    cmd.Parameters.AddWithValue("@UN", UnameTb.Text);
                    cmd.Parameters.AddWithValue("@UP", PhoneTb.Text);
                    cmd.Parameters.AddWithValue("@UG", GenderCb.SelectedItem.ToString());
                    cmd.Parameters.AddWithValue("@UPP", PasswordTb.Text);
                    cmd.Parameters.AddWithValue("@UKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("User Updated Successfully");
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


        private void DeleteUsers()
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
                    SqlCommand cmd = new SqlCommand("delete from UserTbl where UNum = @UKey ", Con);
                    cmd.Parameters.AddWithValue("@UKey", KEY);
                    cmd.ExecuteNonQuery();
                    MessageBox.Show("User Deleted Successfully");
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


        private void label1_MouseClick(object sender, MouseEventArgs e)
        {
            Login obj = new Login();
            obj.Show();
            this.Hide();
        }

        private void UserDGV_CellContentClick_1(object sender, DataGridViewCellEventArgs e)
        {
            UnameTb.Text = UserDGV.SelectedRows[0].Cells[1].Value.ToString();
            GenderCb.Text = UserDGV.SelectedRows[0].Cells[3].Value.ToString();
            PhoneTb.Text = UserDGV.SelectedRows[0].Cells[2].Value.ToString();
            PasswordTb.Text = UserDGV.SelectedRows[0].Cells[4].Value.ToString();

            if (UnameTb.Text == "")
            {
                KEY = 0;
            }
            else
            {
                KEY = Convert.ToInt32(UserDGV.SelectedRows[0].Cells[0].Value.ToString());
            }
        }

        private void UpdateBtn_Click_1(object sender, EventArgs e)
        {
            updateUsers();
        }

        private void SaveBtn_Click_1(object sender, EventArgs e)
        {
            InsertUser();
        }

        private void DeleteBtn_Click_1(object sender, EventArgs e)
        {
            DeleteUsers();
        }

        private void panel3_MouseClick(object sender, MouseEventArgs e)
        {
            Login obj = new Login();
            obj.Show();
            this.Hide();
        }

        private void label6_MouseClick(object sender, MouseEventArgs e)
        {
            Customers obj = new Customers();
            obj.Show();
            this.Hide();
        }

        private void label7_MouseClick(object sender, MouseEventArgs e)
        {
            Booking obj = new Booking();
            obj.Show();
            this.Hide();
        }

        private void label5_MouseClick(object sender, MouseEventArgs e)
        {
            Rooms obj = new Rooms();
            obj.Show();
            this.Hide();
        }

        private void label4_MouseClick(object sender, MouseEventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void UserDGV_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void UserDGV_CellContentClick_2(object sender, DataGridViewCellEventArgs e)
        {
            UnameTb.Text = UserDGV.SelectedRows[0].Cells[1].Value.ToString();
            GenderCb.Text = UserDGV.SelectedRows[0].Cells[3].Value.ToString();
            PhoneTb.Text = UserDGV.SelectedRows[0].Cells[2].Value.ToString();
            PasswordTb.Text = UserDGV.SelectedRows[0].Cells[4].Value.ToString();

            if (UnameTb.Text == "")
            {
                KEY = 0;
            }
            else
            {
                KEY = Convert.ToInt32(UserDGV.SelectedRows[0].Cells[0].Value.ToString());
            }
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }
    }
}
