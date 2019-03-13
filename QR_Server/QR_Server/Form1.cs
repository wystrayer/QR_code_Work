using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using ZXing;
using ZXing.QrCode;
using ZXing.Common;
using ZXing.Rendering;


namespace QR_Server
{
    public partial class Form1 : Form
    {
        EncodingOptions options = null;
        BarcodeWriter writer = null;

        public Form1()
        {
            InitializeComponent();
            options = new QrCodeEncodingOptions
            {
                DisableECI = true,
                CharacterSet = "UTF-8",
                Width = pictureQR.Width,
                Height = pictureQR.Height
            };
            writer = new BarcodeWriter();
            writer.Format = BarcodeFormat.QR_CODE;
            writer.Options = options;
        }

        private void buttonQR_Click(object sender, EventArgs e)
        {
            if (textBox_QR.Text == string.Empty)
            {
                MessageBox.Show("输入内容不能为空!");
                return;
            }
            Bitmap bitmap = writer.Write(textBox_QR.Text);
            pictureQR.Image = bitmap;
        }
    }
}
