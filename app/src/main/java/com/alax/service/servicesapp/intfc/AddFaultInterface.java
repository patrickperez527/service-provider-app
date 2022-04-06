package com.np.onei.servicesapp.intfc;

import android.app.ProgressDialog;

public interface AddFaultInterface {
    void AddFaultSuccess(String msg);
    void AddFaultFailed(String msg);
    void RequestProgressShow(ProgressDialog pd);
    void RequestProgressFinish(ProgressDialog pd);

}
