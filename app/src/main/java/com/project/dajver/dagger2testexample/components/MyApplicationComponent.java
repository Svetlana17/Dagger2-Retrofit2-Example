package com.project.dajver.dagger2testexample.components;

import com.project.dajver.dagger2testexample.App;
import com.project.dajver.dagger2testexample.modules.MyApplicationModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by gleb on 8/16/17.
 */

@Component(modules = { AndroidInjectionModule.class, MyApplicationModule.class})
public interface MyApplicationComponent extends AndroidInjector<App> { }