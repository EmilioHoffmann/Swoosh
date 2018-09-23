package com.example.emili.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.emili.swoosh.Model.Player
import com.example.emili.swoosh.R
import com.example.emili.swoosh.Utils.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle??) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onBallerClicked(view: View){
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
    }

    fun onBeginnerClicked(view: View){
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillFinishClicked(view: View){
        if (player.skill != "" && ballerSkillButton.isChecked || beginnerSkillButton.isChecked) {
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_PLAYER, player)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
