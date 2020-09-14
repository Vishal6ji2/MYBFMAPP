package com.example.bfmapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anychart.core.resource.Logo;
import com.example.bfmapp.R;
import com.github.sumimakito.awesomeqr.option.RenderOption;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static android.graphics.Color.WHITE;

public class YourQrCodeActivity extends AppCompatActivity {

    ImageView qrimg;
    TextView txtname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_qr_code);

        qrimg = findViewById(R.id.myqr_qrimg);
        txtname = findViewById(R.id.myqr_txtname);

        generateqrCode();

    }


    public void generateqrCode() {

        int width = 200;
        int height = 200;

        int smalldimension = width < height ? width : height;


        String name = "Captain_Vishal";
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hintmap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        hintmap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);


        createQrCode(name, charset, hintmap, smalldimension, smalldimension);


    }

    private void createQrCode(String name, String charset, Map<EncodeHintType, ErrorCorrectionLevel> hintmap, int smalldimension, int smalldimension1) {


        try {
            //generating qr code in bitmatrix type
            BitMatrix matrix = new MultiFormatWriter().encode(new String(name.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, smalldimension, smalldimension1, hintmap);
            //converting bitmatrix to bitmap

            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];
            // All are 0, or black, by default
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    //pixels[offset + x] = matrix.get(x, y) ? BLACK : WHITE;
                    pixels[offset + x] = matrix.get(x, y) ?
                            ResourcesCompat.getColor(getResources(), R.color.bluecolor, null) : WHITE;
                }
            }

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

            Bitmap overlay = BitmapFactory.decodeResource(getResources(), R.drawable.logotwo);


            qrimg.setImageBitmap(bitmap);

        } catch (WriterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private Bitmap mergebitmaps(Bitmap overlay, Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Bitmap combined = Bitmap.createBitmap(width,height,bitmap.getConfig());

        Canvas canvas = new Canvas(combined);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawBitmap(bitmap, new Matrix(), null);

        int centreX = (canvasWidth  - overlay.getWidth()) /2;
        int centreY = (canvasHeight - overlay.getHeight()) /2 ;
        canvas.drawBitmap(overlay, centreX, centreY, null);

        return combined;

    }
}