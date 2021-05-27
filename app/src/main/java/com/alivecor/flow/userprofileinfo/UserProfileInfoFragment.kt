package com.alivecor.flow.userprofileinfo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.alivecor.R
import com.alivecor.databinding.FragmentUserprofileinfoBinding
import com.alivecor.extension.showToast
import com.alivecor.flow.userage.UserAgeFragment
import com.alivecor.flow.userprofile.UserProfileActivity
import com.alivecor.models.UserProfile
import com.alivecor.shared.base.BaseFragment
import com.alivecor.shared.viewmodelfactory.UserViewModelFactory
import java.util.*

class UserProfileInfoFragment : BaseFragment(),IView {
    private lateinit var mBinding: FragmentUserprofileinfoBinding
    private val mViewModel: UserProfileInfoViewModel
            by lazy {
                ViewModelProviders.of(this, UserViewModelFactory)
                    .get(UserProfileInfoViewModel::class.java)
            }

    companion object {
        const val TAG = "USER_PROFILE_FRAGMENT"

        fun newInstance(): UserProfileInfoFragment {
            return UserProfileInfoFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_userprofileinfo,
            container, false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.init(this)
        mBinding.userprofileinfo = mViewModel
    }

    override fun navigateToUserAge() {
        if(mViewModel.firstName.isNotEmpty()&&mViewModel.lastName.isNotEmpty()&&mViewModel.dob.isNotEmpty()) {
            val frag=UserAgeFragment.newInstance()
            val bundle = Bundle()
            bundle.putParcelable("userInfo",UserProfile(mViewModel.firstName,mViewModel.lastName,mViewModel.dob))
            frag.arguments = bundle
            (activity as UserProfileActivity).replaceFragment(frag,UserAgeFragment.TAG)
        }else{
            showToast(this.requireContext(),getString(R.string.fields_mandatory))
        }
    }

    override fun tappedDate() {
        val cldr: Calendar = Calendar.getInstance()
        val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
        val month: Int = cldr.get(Calendar.MONTH)
        val year: Int = cldr.get(Calendar.YEAR)

        // date picker dialog
        val picker = DatePickerDialog(
            this.requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                val date: String = "${dayOfMonth}/${monthOfYear + 1}/$year"
                mViewModel.dob = date
            },
            year,
            month,
            day
        )
        picker.datePicker.maxDate = System.currentTimeMillis()
        picker.show()
    }
}