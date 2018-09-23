package com.example.emili.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.emili.swoosh.R
import com.example.emili.swoosh.Utils.EXTRA_LEAGUE
import com.example.emili.swoosh.Utils.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)

        seachLeaguesText.text = "Looking for $league $skill league near you..."
    }
}
