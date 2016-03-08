package com.kaka.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

/**
 * Created by Shanshan Jiang on 12/4/15.
 */
@Path("/uploadPhoto")
public interface OcrApi {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    Response uploadFile(
            @FormDataParam("file") InputStream aUploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition aFileDetail);
}
