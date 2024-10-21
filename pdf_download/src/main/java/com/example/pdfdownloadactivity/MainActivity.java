
package com.example.pdfdownloadactivity;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pdf1, pdf2, pdf3, pdf4, pdf5;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdf1 = findViewById(R.id.pdf1);
        pdf2 = findViewById(R.id.pdf2);
        pdf3 = findViewById(R.id.pdf3);
        pdf4 = findViewById(R.id.pdf4);
        pdf5 = findViewById(R.id.pdf5);
        downloadButton = findViewById(R.id.downloadButton);

        downloadButton.setOnClickListener(v -> {
            downloadPDF(pdf1.getText().toString());
            downloadPDF(pdf2.getText().toString());
            downloadPDF(pdf3.getText().toString());
            downloadPDF(pdf4.getText().toString());
            downloadPDF(pdf5.getText().toString());
        });
    }

    private void downloadPDF(String url) {
        if (url.isEmpty()) {
            Toast.makeText(this, "URL is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle("Downloading PDF");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "downloaded_pdf.pdf");
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }
}
