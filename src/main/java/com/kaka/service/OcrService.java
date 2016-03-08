package com.kaka.service;

import com.kaka.api.OcrApi;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by Shanshan Jiang on 12/4/15.
 */
public class OcrService implements OcrApi {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(
            @FormDataParam("file") InputStream inputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetails) {

        TesseractTranslator tesseractTranslator = new TesseractTranslator("/usr/local/share/tessdata", "japanese");
        String result = tesseractTranslator.translate(inputStream);


        System.out.print(result);
        return Response.status(200).build();
    }
}
