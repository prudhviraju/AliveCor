package com.alivecor.shared.base

import android.app.Application
import com.alivecor.shared.viewmodel.ObservableAndroidViewModel

abstract class BaseAndroidViewModel(application: Application)
    : ObservableAndroidViewModel(application) {
}