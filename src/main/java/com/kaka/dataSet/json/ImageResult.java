package com.kaka.dataSet.json;

/**
 * Created by Shanshan Jiang on 1/12/16.
 */
public class ImageResult {

    private String imageName;

    public String getOcrResult() {
        return ocrResult;
    }

    public void setOcrResult(String ocrResult) {
        this.ocrResult = ocrResult;
    }

    private String ocrResult;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
