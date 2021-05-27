package com.alivecor.flow.userprofileinfo

import android.view.View
import androidx.databinding.Bindable
import com.alivecor.BR
import com.alivecor.shared.base.BaseViewModel

class UserProfileInfoViewModel:BaseViewModel(),IViewModel {

    private lateinit var iView: IView

    override fun init(iView: IView) {
       this.iView = iView
    }

    override fun tapOnNext(view: View) {
        iView.navigateToUserAge()
    }

    override fun tapOnDob(view: View){
         iView.tappedDate()
    }

    var firstName:String = ""
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    var lastName:String = ""
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

    var dob:String = ""
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.dob)
        }
}