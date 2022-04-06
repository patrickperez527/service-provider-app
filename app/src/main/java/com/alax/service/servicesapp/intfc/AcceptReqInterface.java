package com.np.onei.servicesapp.intfc;

import android.app.ProgressDialog;

public interface AcceptReqInterface {
    void AcceptReqSuccess(String msg);
    void AcceptReqFailed(String msg);
    void RequestProgressShow(ProgressDialog pd);
    void RequestProgressFinish(ProgressDialog pd);

}
