package com.alivecor.flow.userage

import androidx.databinding.Bindable
import com.alivecor.BR
import com.alivecor.extension.getAge
import com.alivecor.models.UserProfile
import com.alivecor.shared.base.BaseViewModel

class UserAgeViewModel:BaseViewModel(),IViewModel {

    private lateinit var iView: IView
    override fun init(iView: IView, userProfile: UserProfile) {
        this.iView = iView
        firstName = userProfile.firstName
        lastName = userProfile.lastName
        age = "${getAge(userProfile.dob)}"
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

    var age:String = ""
        @Bindable
        get
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
}