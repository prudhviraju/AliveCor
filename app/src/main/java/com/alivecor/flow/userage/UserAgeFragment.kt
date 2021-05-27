package com.alivecor.flow.userage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alivecor.R
import com.alivecor.databinding.FragmentUserageBinding
import com.alivecor.models.UserProfile
import com.alivecor.shared.base.BaseFragment
import com.alivecor.shared.viewmodelfactory.UserViewModelFactory

class UserAgeFragment:BaseFragment(),IView {

    private lateinit var mBinding: FragmentUserageBinding
    private val mViewModel: UserAgeViewModel
            by lazy {
                ViewModelProviders.of(this, UserViewModelFactory)
                    .get(UserAgeViewModel::class.java)
            }

    companion object {
        const val TAG = "USER_AGE_FRAGMENT"

        fun newInstance(): UserAgeFragment {
            return UserAgeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_userage,
            container, false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        val userInfo = bundle?.getParcelable<UserProfile>("userInfo") as UserProfile

        mViewModel.init(this,userInfo)
        mBinding.userage = mViewModel


    }
}