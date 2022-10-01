package com.kartezyatech.cv_portal_app.exception;

public class CvPortalAppException extends RuntimeException {

    public CvPortalAppException(String exMessage,Exception exception){
        super(exMessage,exception);
    }

    public CvPortalAppException(String exMessage){
        super(exMessage);
    }
}
