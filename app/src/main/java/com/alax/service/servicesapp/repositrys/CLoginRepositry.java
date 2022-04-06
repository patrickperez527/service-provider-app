package com.np.onei.servicesapp.repositrys;

import android.app.ProgressDialog;
import android.content.Context;

import com.np.onei.servicesapp.intfc.LoginInterface;
import com.np.onei.servicesapp.intfc.SignupInterface;
import com.np.onei.servicesapp.models.CLoginWrapper;
import com.np.onei.servicesapp.services.APIs;
import com.np.onei.utils.SingletonObjectAccess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CLoginRepositry {
    Context cnt;
    ProgressDialog pd;
    LoginInterface LI;

    public CLoginRepositry(Context cnt, ProgressDialog pd, LoginInterface LI) {
        this.cnt = cnt;
        this.pd = pd;
        this.LI = LI;
    }
    public void CloginInvok(String email,String pas){
        LI.RequestProgressShow(pd);
        APIs apiservice= SingletonObjectAccess.getApiService();
        Call<CLoginWrapper> call=apiservice.getClogin(email,pas);
        call.enqueue(new Callback<CLoginWrapper>() {
            @Override
            public void onResponse(Call<CLoginWrapper> call, Response<CLoginWrapper> response) {
                if(response.body().getResponse().get(0).getStatus().equals("1"))
                {
                    LI.SingupSuccess(response.body().getResponse());
                    LI.RequestProgressFinish(pd);
                }else
                {
                    LI.RequestProgressFinish(pd);
                    LI.SignupFailed(response.body().getResponse().get(0).getMessage());
                }
            }

            @Override
            public void onFailure(Call<CLoginWrapper> call, Throwable t) {
                LI.SignupFailed(t.toString());
            }
        });


    }
}
