package com.example.emili.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.emili.swoosh.Utils.EXTRA_LEAGUE
import com.example.emili.swoosh.R
import com.example.emili.swoosh.Utils.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBallerClicked(view: View){
        beginnerSkillButton.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClicked(view: View){
        ballerSkillButton.isChecked = false
        skill = "beginner"
    }

    fun onSkillFinishClicked(view: View){
        if (skill != "" && ballerSkillButton.isChecked || beginnerSkillButton.isChecked) {
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, league)
            intent.putExtra(EXTRA_SKILL, skill)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
