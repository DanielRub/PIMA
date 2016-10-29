package com.kevinjanvier.angalia.utility;

import android.content.Context;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by kevinjanvier on 10/12/16.
 */

public class Utility {
    Context context;
    public static int SPLASH_TIME_OUT = 3000;

    public void ProgressDialog(final Context context, String message){
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(message);
        pDialog.setCancelable(false);
        pDialog.show();
    }


}
