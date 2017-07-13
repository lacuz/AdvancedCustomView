package com.lacuz.advancedcustomview.season


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lacuz.advancedcustomview.R
import kotlinx.android.synthetic.main.fragment_season.*


/**
 * A simple [Fragment] subclass.
 */
class SeasonFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_season, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivSpring.setOnClickListener {
            SeasonActivity().actionActivity(activity,0)
        }
        ivSummer.setOnClickListener {
            SeasonActivity().actionActivity(activity,1)
        }
        ivFall.setOnClickListener {
            SeasonActivity().actionActivity(activity,2)
        }
        ivWinter.setOnClickListener {
            SeasonActivity().actionActivity(activity,3)
        }
    }

}
