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

public class TechSignupRepositry {
    Context cnt;
    ProgressDialog pd;
    SignupInterface LI;

    public TechSignupRepositry(Context cnt, ProgressDialog pd, SignupInterface LI) {
        this.cnt = cnt;
        this.pd = pd;
        this.LI = LI;
    }
    public void CSignupInvok(String fname,String lname,String phn,String addre,String mail,String pas){
        LI.RequestProgressShow(pd);
        APIs apiservice= SingletonObjectAccess.getApiService();
        Call<CLoginWrapper> call=apiservice.CustSignup( fname, lname, phn, addre, mail, pas);
        call.enqueue(new Callback<CLoginWrapper>() {
            @Override
            public void onResponse(Call<CLoginWrapper> call, Response<CLoginWrapper> response) {
                if(response.body().getResponse().get(0).getStatus().equals("1"))
                {
                    LI.SingupSuccess(response.body().getResponse().get(0).getMessage());
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
