package com.project.dajver.dagger2testexample.modules;

import com.project.dajver.dagger2testexample.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by gleb on 8/16/17.
 */

@Module
public abstract class MyApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();
}