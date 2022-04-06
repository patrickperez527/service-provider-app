package com.np.onei.servicesapp.intfc;

import android.app.ProgressDialog;

public interface EnqryInterface {
    void SingupSuccess(String msg);
    void SignupFailed(String msg);
    void RequestProgressShow(ProgressDialog pd);
    void RequestProgressFinish(ProgressDialog pd);

}
