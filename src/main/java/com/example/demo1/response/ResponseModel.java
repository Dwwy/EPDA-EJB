package com.example.demo1.response;


public class ResponseModel {

    private ResponseModelData data;
    private boolean success;
    private int status;

    public ResponseModel() {
    }

    /**
     * Returns a deserialized response data as {@link ResponseModelData} instance.
     * @return Deserialized (wrapped) response data.
     */
    public ResponseModelData getResponseData() {
        return data;
    }

    /**
     * Returns an upload successfull status.
     * @return 'true' when it uploaded successfully or 'false' if not.
     */
    public boolean isUploadedSuccess() {
        return success;
    }

    /**
     * Returns a request status code.
     * <p>
     * It must be 200 as OK request status.
     * @return Request status as int code.
     */
    public int getRequestStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        return "Response{"
                + "data=" + data + ", "
                + "success=" + success + ", "
                + "status=" + status + "}";
    }
    
}
