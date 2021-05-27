package com.alivecor.flow.userage

import com.alivecor.models.UserProfile

interface IViewModel {
    fun init(iView: IView,userProfile: UserProfile)
}