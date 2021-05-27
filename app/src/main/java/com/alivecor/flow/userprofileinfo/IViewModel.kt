package com.alivecor.flow.userprofileinfo

import android.view.View

interface IViewModel {
    fun init(iView: IView)
    fun tapOnNext(view: View)
    fun tapOnDob(view: View)
}