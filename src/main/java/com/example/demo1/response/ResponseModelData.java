package com.example.demo1.response;


import java.util.Date;

/**
 * Represents a upload response data.
 * <p>
 * Uses as deserialization model for Gson.
 */
public class ResponseModelData {
    public ResponseModelData() {
    }

    private String id;
    private String title;
    private String url_viewer;
    private String url;
    private String display_url;
    private String delete_url;
    
    private int size;
    private long time;
    private long expiration;
    
    private ResponseModelImage image;
    private ResponseModelImage thumb;
    private ResponseModelImage medium;

    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getViewerUrl() {
        return url_viewer;
    }

    public String getImageUrl() {
        return url;
    }

    public String getDisplayUrl() {
        return display_url;
    }

    public String getDeleteUrl() {
        return delete_url;
    }

    public int getImageSize() {
        return size;
    }

    public long getTimestamp() {
        return time;
    }

    public Date getUploadedDate() {
        return new Date(time * 1000);
    }


    public long getExpiration() {
        return expiration;
    }

    public ResponseModelImage getOriginalImage() {
        return image;
    }

    public ResponseModelImage getThumbnail() {
        return thumb;
    }

    public ResponseModelImage getMediumImage() {
        return medium;
    }
    
    @Override
    public String toString() {
        return "Data{"
                + "id=" + id + ", "
                + "title=" + title + ", "
                + "url_viewer=" + url_viewer + ", "
                + "url=" + url + ", "
                + "display_url=" + display_url + ", "
                + "delete_url=" + delete_url + ", "
                + "size=" + size + ", "
                + "time=" + time + ", "
                + "expiration=" + expiration + ", "
                + "image=" + image + ", "
                + "thumb=" + thumb + ", "
                + "medium=" + medium + "}";
    }
    
}
