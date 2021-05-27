package com.alivecor.shared.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alivecor.flow.userage.UserAgeViewModel
import com.alivecor.flow.userprofile.UserProfileViewModel
import com.alivecor.flow.userprofileinfo.UserProfileInfoViewModel

/**
 * Factory for ViewModels
 */
object UserViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(UserProfileViewModel::class.java) -> UserProfileViewModel() as T
            modelClass.isAssignableFrom(UserProfileInfoViewModel::class.java) -> UserProfileInfoViewModel() as T
            modelClass.isAssignableFrom(UserAgeViewModel::class.java) -> UserAgeViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}