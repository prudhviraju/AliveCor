package com.alivecor.extension

import android.content.Context
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun getAge(dobString: String): String {
    var date: Date? = null
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    try {
        date = sdf.parse(dobString)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val dob: Calendar = Calendar.getInstance()
    val today: Calendar = Calendar.getInstance()
    dob.time = date

    return findAge(today.get(Calendar.DAY_OF_MONTH),(today.get(Calendar.MONTH)+1),today.get(Calendar.YEAR),
        dob.get(Calendar.DAY_OF_MONTH),dob.get(Calendar.MONTH),dob.get(Calendar.YEAR))
}

fun findAge(
    current_date: Int, current_month: Int,
    current_year: Int, birth_date: Int,
    birth_month: Int, birth_year: Int
) :String{
    var current_date = current_date
    var current_month = current_month
    var current_year = current_year
    val month = intArrayOf(
        31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31
    )

    if (birth_date > current_date) {
        current_month -= 1
        current_date += month[birth_month - 1]
    }

    if (birth_month > current_month) {
        current_year -= 1
        current_month += 12
    }

    // calculate date, month, year
    val calculated_date = current_date - birth_date
    val calculated_month = current_month - birth_month
    val calculated_year = current_year - birth_year

    // print the present age
    return "$calculated_year years , $calculated_month months, $calculated_date days."
}
