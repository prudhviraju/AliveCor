package com.alivecor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(val firstName: String, val lastName:String, val dob:String):Parcelable
