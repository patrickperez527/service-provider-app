package com.np.onei.utils;

import co.paystack.android.PaystackSdk;

class Bootstrap {
    public static void setPaystackKey(String publicKey) {
        PaystackSdk.setPublicKey(publicKey);
    }
}