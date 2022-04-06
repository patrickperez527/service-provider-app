package com.np.onei.servicesapp;

import com.np.onei.servicesapp.models.CLoginResponse;

import java.util.List;

public class AppController {

    private static AppController instance;
private List<CLoginResponse> CloginObject;
    private AppController(){}

    public AppController(List<CLoginResponse> cloginObject) {
        CloginObject = cloginObject;
    }

    //static block initialization for exception handling
    static{
        try{
            instance = new AppController();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static AppController getInstance(){
        return instance;
    }
}
