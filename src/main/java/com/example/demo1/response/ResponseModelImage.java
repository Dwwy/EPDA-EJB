package com.example.demo1.response;

public class ResponseModelImage {
    public ResponseModelImage() {
    }

    private String filename;
    private String name;
    private String mime;
    private String extension;
    private String url;

    public String getFilename() {
        return filename;
    }

    public String getImageName() {
        return name;
    }

    public String getMimeType() {
        return mime;
    }

    public String getFileExtension() {
        return extension;
    }

    public String getUrl() {
        return url;
    }
    
    @Override
    public String toString() {
        return "Image{"
                + "filename=" + filename + ", "
                + "name=" + name + ", "
                + "mime=" + mime + ", "
                + "extension=" + extension + ", "
                + "url=" + url + "}";
    }
    
}
