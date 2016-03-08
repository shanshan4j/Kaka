package com.kaka.application;

import com.kaka.api.OcrApi;
import com.kaka.service.OcrService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Shanshan Jiang on 12/4/15.
 */
public class KakaApplication extends Application<KakaConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(KakaApplication.class);

    public static void main(String[] args) throws Exception {
        String[] hardCodedArgs = {"server","kaka.yml"};
        new KakaApplication().run(hardCodedArgs);
    }

    @Override
    public void run(KakaConfiguration configuration, Environment environment) throws Exception {
        final OcrService ocrService = new OcrService();
        environment.jersey().register(ocrService);
//        register(MultiPartFeature.class);
        environment.jersey().register(MultiPartFeature.class);
    }

    @Override
    public void initialize(Bootstrap<KakaConfiguration> bootstrap) {
    }
}
