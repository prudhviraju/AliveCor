package com.alivecor.flow.userprofile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.alivecor.R
import com.alivecor.databinding.ActivityUserprofileBinding
import com.alivecor.flow.userprofileinfo.UserProfileInfoFragment
import com.alivecor.shared.base.BaseActivity
import com.alivecor.shared.viewmodelfactory.UserViewModelFactory

class UserProfileActivity: BaseActivity() {

    lateinit var mBinding: ActivityUserprofileBinding
    private val mViewModel: UserProfileViewModel
            by lazy {
                ViewModelProviders.of(this, UserViewModelFactory)
                    .get(UserProfileViewModel::class.java)
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_userprofile, parentViewGroup, true)
        mBinding.userprofile = mViewModel

        if (savedInstanceState == null) {
           replaceFragment(UserProfileInfoFragment.newInstance(),UserProfileInfoFragment.TAG)
        }
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag).addToBackStack(tag).commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val backCount = fragmentManager.backStackEntryCount

        if(backCount > 1){
            fragmentManager.popBackStack()
        }else{
            finish()
        }
    }

}