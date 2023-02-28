namespace HotelMGT
{
    partial class Login
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Login));
            this.panel1 = new System.Windows.Forms.Panel();
            this.USERNAME = new System.Windows.Forms.TextBox();
            this.PassTb = new System.Windows.Forms.TextBox();
            this.LogBtn = new Guna.UI2.WinForms.Guna2Button();
            this.ClosePic = new System.Windows.Forms.PictureBox();
            this.ContinueLbl = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.bunifuElipse1 = new Bunifu.Framework.UI.BunifuElipse(this.components);
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ClosePic)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.White;
            this.panel1.Controls.Add(this.USERNAME);
            this.panel1.Controls.Add(this.PassTb);
            this.panel1.Controls.Add(this.LogBtn);
            this.panel1.Controls.Add(this.ClosePic);
            this.panel1.Controls.Add(this.ContinueLbl);
            this.panel1.Controls.Add(this.pictureBox1);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Location = new System.Drawing.Point(12, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(647, 356);
            this.panel1.TabIndex = 0;
            // 
            // USERNAME
            // 
            this.USERNAME.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.USERNAME.Location = new System.Drawing.Point(169, 144);
            this.USERNAME.Name = "USERNAME";
            this.USERNAME.PlaceholderText = "User Name";
            this.USERNAME.AutoSize = false;
            this.USERNAME.Size = new System.Drawing.Size(300, 44);
            this.USERNAME.TabIndex = 23;
            // 
            // PassTb
            // 
            this.PassTb.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.PassTb.Location = new System.Drawing.Point(169, 199);
            this.PassTb.Name = "PassTb";
            this.PassTb.PlaceholderText = "Password";
            this.PassTb.AutoSize = false;
            this.PassTb.Size = new System.Drawing.Size(300, 44);
            this.PassTb.TabIndex = 22;
            // 
            // LogBtn
            // 
            this.LogBtn.DisabledState.BorderColor = System.Drawing.Color.DarkGray;
            this.LogBtn.DisabledState.CustomBorderColor = System.Drawing.Color.DarkGray;
            this.LogBtn.DisabledState.FillColor = System.Drawing.Color.FromArgb(((int)(((byte)(169)))), ((int)(((byte)(169)))), ((int)(((byte)(169)))));
            this.LogBtn.DisabledState.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(141)))), ((int)(((byte)(141)))), ((int)(((byte)(141)))));
            this.LogBtn.FillColor = System.Drawing.Color.DimGray;
            this.LogBtn.Font = new System.Drawing.Font("Maiandra GD", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.LogBtn.ForeColor = System.Drawing.Color.White;
            this.LogBtn.Location = new System.Drawing.Point(213, 256);
            this.LogBtn.Name = "LogBtn";
            this.LogBtn.Size = new System.Drawing.Size(180, 45);
            this.LogBtn.TabIndex = 21;
            this.LogBtn.Text = "Login";
            this.LogBtn.Click += new System.EventHandler(this.LogBtn_Click_1);
            // 
            // ClosePic
            // 
            this.ClosePic.Image = ((System.Drawing.Image)(resources.GetObject("ClosePic.Image")));
            this.ClosePic.Location = new System.Drawing.Point(591, 7);
            this.ClosePic.Name = "ClosePic";
            this.ClosePic.Size = new System.Drawing.Size(48, 45);
            this.ClosePic.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.ClosePic.TabIndex = 20;
            this.ClosePic.TabStop = false;
            this.ClosePic.Click += new System.EventHandler(this.ClosePic_Click);
            // 
            // ContinueLbl
            // 
            this.ContinueLbl.AutoSize = true;
            this.ContinueLbl.Font = new System.Drawing.Font("Maiandra GD", 12F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point);
            this.ContinueLbl.Location = new System.Drawing.Point(236, 318);
            this.ContinueLbl.Name = "ContinueLbl";
            this.ContinueLbl.Size = new System.Drawing.Size(147, 19);
            this.ContinueLbl.TabIndex = 19;
            this.ContinueLbl.Text = "Continue As Admin";
            this.ContinueLbl.Click += new System.EventHandler(this.ContinueLbl_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(254, 56);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(100, 79);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Maiandra GD", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(169, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(294, 29);
            this.label1.TabIndex = 0;
            this.label1.Text = "Hotel Management System";
            // 
            // bunifuElipse1
            // 
            this.bunifuElipse1.ElipseRadius = 30;
            this.bunifuElipse1.TargetControl = this;
            // 
            // Login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Blue;
            this.ClientSize = new System.Drawing.Size(671, 380);
            this.Controls.Add(this.panel1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Login";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.ClosePic)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion
        private PictureBox pictureBox1;
        private Label label1;
        private Bunifu.Framework.UI.BunifuElipse bunifuElipse1;
        
        private PictureBox ClosePic;
        private Label ContinueLbl;
        private Guna.UI2.WinForms.Guna2Button LogBtn;
        private TextBox PassTb;
        private TextBox USERNAME;
        private Panel panel1;
    }
}