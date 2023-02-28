using System.Data;
using System.Data.SqlClient;

namespace HotelMGT
{
    public partial class Dashboard : Form
    {
        public Dashboard()
        {
            InitializeComponent();
            CountRooms();
            CountCustomers();
            CountAmount();
            GetCustomers();
        }
        SqlConnection Con = new SqlConnection(@"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=""F:\C# Projects\My Projects\HotelMGT\HotelDBMS.mdf"";Integrated Security=True;Connect Timeout=30");
        private void CountRooms()
        {
            Con.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select count(*) from RoomTbl", Con);
            DataTable dataTable = new DataTable();
            sda.Fill(dataTable);
            roomlbl2.Text = dataTable.Rows[0][0].ToString() + "   Rooms";
            Con.Close();
        }
        private void CountCustomers()
        {
            Con.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select count(*) from CustomerTbl", Con);
            DataTable dataTable = new DataTable();
            sda.Fill(dataTable);
            CustLBL.Text = dataTable.Rows[0][0].ToString() + "   Customers";
            Con.Close();
        }
        private void CountAmount()
        {
            Con.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select sum(Cost) from BookingTbl", Con);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            BookingLBL.Text = "Rs " + dt.Rows[0][0].ToString();
            Con.Close();
        }
        private void SumDaily()
        {
            Con.Open();
            SqlDataAdapter sda = new SqlDataAdapter("select sum(Cost) from BookingTbl where Bookdate='" + BDate.Value.Date + "'", Con);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            Dincomelbl.Text = "Rs " + dt.Rows[0][0].ToString();
            Con.Close();
        }
        private void GetCustomers()
        {
            Con.Open();
            SqlCommand cmd = new SqlCommand("select * from CustomerTbl ",
                                            Con);
            SqlDataReader rdr;
            rdr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Columns.Add("CustNum", typeof(int));
            dt.Load(rdr);
            CustomerCb.ValueMember = "CustNum";
            CustomerCb.DisplayMember = "CustName";

            CustomerCb.DataSource = dt;
            Con.Close();
        }
        private void SumbyCustomer()
        {
            try
            {
                Con.Open();
                SqlDataAdapter sda = new SqlDataAdapter("select sum(Cost) from BookingTbl where Customer='" + CustomerCb.SelectedValue.ToString() + "'", Con);
                DataTable dt = new DataTable();
                sda.Fill(dt);
                IncomeByCustomerLBL.Text = "Rs " + dt.Rows[0][0].ToString();
                Con.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                Con.Close();
            }
            finally
            {
                Con.Close();
            }
        }
        private void RoomLbl_Paint(object sender, PaintEventArgs e)
        {

        }

        private void BDate_ValueChanged(object sender, EventArgs e)
        {
            SumDaily();
        }

        private void CustomerCb_SelectionChangeCommitted(object sender, EventArgs e)
        {
            SumbyCustomer();
        }

        private void label4_Click(object sender, EventArgs e)
        {
            Types obj = new Types();
            obj.Show();
            this.Hide();
        }

        private void label5_Click(object sender, EventArgs e)
        {
            Rooms obj = new Rooms();
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

        private void panel3_MouseClick(object sender, MouseEventArgs e)
        {
            Login obj = new Login();
            obj.Show();
            this.Hide();
        }
    }
}
