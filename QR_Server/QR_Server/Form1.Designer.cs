namespace QR_Server
{
    partial class Form1
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.buttonQR = new System.Windows.Forms.Button();
            this.pictureQR = new System.Windows.Forms.PictureBox();
            this.textBox_QR = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureQR)).BeginInit();
            this.SuspendLayout();
            // 
            // buttonQR
            // 
            this.buttonQR.Location = new System.Drawing.Point(307, 342);
            this.buttonQR.Name = "buttonQR";
            this.buttonQR.Size = new System.Drawing.Size(97, 24);
            this.buttonQR.TabIndex = 0;
            this.buttonQR.Text = "生成";
            this.buttonQR.UseVisualStyleBackColor = true;
            this.buttonQR.Click += new System.EventHandler(this.buttonQR_Click);
            // 
            // pictureQR
            // 
            this.pictureQR.Location = new System.Drawing.Point(58, 39);
            this.pictureQR.Name = "pictureQR";
            this.pictureQR.Size = new System.Drawing.Size(346, 267);
            this.pictureQR.TabIndex = 1;
            this.pictureQR.TabStop = false;
            // 
            // textBox_QR
            // 
            this.textBox_QR.Location = new System.Drawing.Point(76, 341);
            this.textBox_QR.Name = "textBox_QR";
            this.textBox_QR.Size = new System.Drawing.Size(190, 25);
            this.textBox_QR.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(509, 422);
            this.Controls.Add(this.textBox_QR);
            this.Controls.Add(this.pictureQR);
            this.Controls.Add(this.buttonQR);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.pictureQR)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonQR;
        private System.Windows.Forms.PictureBox pictureQR;
        private System.Windows.Forms.TextBox textBox_QR;
    }
}

