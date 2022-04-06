package com.np.onei.servicesapp.intfc;

import android.app.ProgressDialog;

import com.np.onei.servicesapp.models.CLoginResponse;
import com.np.onei.servicesapp.models.TLoginResponse;

import java.util.List;

public interface TLoginInterface {
    void SingupSuccess(List<TLoginResponse> msg);
    void SignupFailed(String msg);
    void RequestProgressShow(ProgressDialog pd);
    void RequestProgressFinish(ProgressDialog pd);
}
