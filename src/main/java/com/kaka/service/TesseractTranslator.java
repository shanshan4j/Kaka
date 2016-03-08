package com.kaka.service;

import com.google.common.io.ByteStreams;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.tesseract;

/**
 * Created by Shanshan Jiang on 11/24/15.
 */

import java.io.IOException;
import java.io.InputStream;

import static org.bytedeco.javacpp.tesseract.*;

public class TesseractTranslator {

    public static TessBaseAPI API = new tesseract.TessBaseAPI();

    public TesseractTranslator (String trainedDatePath, String language) {
        if(API.Init(trainedDatePath, language) != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }
    }

    public String translate(InputStream inputStream) {
        byte[] filedata= new byte[0];
        try {
            filedata = ByteStreams.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lept.PIX image = lept.pixReadMem(filedata, filedata.length);
        API.SetImage(image);

        //Get OCR result
        BytePointer outText = API.GetUTF8Text();
        String result = outText.getString();
        outText.deallocate();
        lept.pixDestroy(image);
        return result;
    }


//    public static void main(String[] args) {
//        BytePointer outText;
//
//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//        // Initialize tesseract-ocr with English, without specifying tessdata path
//        if (api.Init("/usr/local/share/tessdata", "eng+japanese") != 0) {
//            System.err.println("Could not initialize tesseract.");
//            System.exit(1);
//        }
//
//        // Open input image with leptonica library
//        lept.PIX image = pixRead(args.length > 0 ? args[0] : "/Users/wzxjxp/Downloads/Receipt.png");
//        api.SetImage(image);
//        // Get OCR result
//        outText = api.GetUTF8Text();
//        System.out.println("OCR output:\n" + outText.getString());
//
//        // Destroy used object and release memory
//        api.End();
//        outText.deallocate();
//        pixDestroy(image);
//    }
}
