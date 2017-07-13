package com.lacuz.advancedcustomview.season

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.lacuz.advancedcustomview.R
import kotlinx.android.synthetic.main.activity_season.*

class SeasonActivity : Activity() {

    fun actionActivity(activity: Activity, type: Int) {
        var intent = Intent(activity, SeasonActivity::class.java)
        intent.putExtra("type", type)
        activity.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_season)
        var type = intent.getIntExtra("type", 0)
        when (type) {
            0 -> {
                rain.visibility = View.VISIBLE
            }
            1 -> {
                summer.visibility = View.VISIBLE
            }
            2 -> {
                fall.visibility = View.VISIBLE
            }
            3 -> {
                snow.visibility = View.VISIBLE
            }
        }
    }
}
