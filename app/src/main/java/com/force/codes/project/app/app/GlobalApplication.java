/*
 * Created by Force Porquillo on 6/20/20 4:10 PM
 * FEU Institute of Technology
 * Copyright (c) 2020.  All rights reserved.
 * Last modified 6/20/20 4:10 PM
 */

package com.force.codes.project.app.app;

import android.app.Application;
import android.util.Log;

import com.force.codes.project.app.BuildConfig;
import com.force.codes.project.app.data_layer.resources.database.LocalDatabase;
import com.force.codes.project.app.presentation_layer.controller.custom.utils.CustomCrashLibrary;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import leakcanary.AppWatcher;
import leakcanary.ObjectWatcher;
import timber.log.Timber;

public class GlobalApplication extends Application{

    DebugTreeApplication debugTreeApplication;

    @Override
    public void onCreate(){
        super.onCreate();

        LocalDatabase.setInstance(this);

        debugTreeApplication = new DebugTreeApplication(this);

        if(BuildConfig.DEBUG){
           debugTreeApplication.DebugTree();
        }else{
            Timber.plant(new DebugTreeApplication.CrashReportingTree());
        }
    }
}
