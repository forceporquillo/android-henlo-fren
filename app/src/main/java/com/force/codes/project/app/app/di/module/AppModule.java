/*
 * Created by Force Porquillo on 7/1/20 6:30 AM
 * FEU Institute of Technology
 * Copyright (c) 2020.  All rights reserved.
 * Last modified 7/1/20 6:30 AM
 */

package com.force.codes.project.app.app.di.module;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.force.codes.project.app.data_layer.model.map_data.WorldData;
import com.force.codes.project.app.data_layer.model.twitter.TwitterData;
import com.force.codes.project.app.service.executors.AppExecutors;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Flowable;

@Module
public class AppModule{
    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Named("LiveDataVM")
    static MutableLiveData<WorldData> provideMutableLiveData(){
        return new MutableLiveData<>();
    }

    @Provides
    @Singleton
    static AppExecutors providesAppExecutor(){
        return new AppExecutors();
    }

    @Provides
    @Named("MapListDataSet")
    static List<String> providesDataSet(){
        return new LinkedList<>(Arrays.asList("Philippines", "Global Cases"));
    }

    @Provides
    static Runnable[] providesRunnableThread(){
        return new Runnable[1];
    }

    @Provides
    static Marker[] providesMarker(){
        return new Marker[1];
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Singleton
    @Provides
    static List<Flowable<List<TwitterData>>> provideFlowableListData(){
        return new ArrayList<>();
    }
}
