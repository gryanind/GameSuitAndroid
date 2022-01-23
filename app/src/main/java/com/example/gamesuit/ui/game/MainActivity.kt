package com.example.gamesuit.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.gamesuit.R
import com.example.gamesuit.databinding.ActivityHomeBinding
import com.example.gamesuit.databinding.ActivityMainBinding
import com.example.gamesuit.enum.SuitCharacter
import com.example.gamesuit.usecase.TextComposer

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    private lateinit var binding : ActivityHomeBinding
    private lateinit var binding1: ActivityMainBinding

    private var isGameFinished: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        setClickListeners()
    }

    private fun bindViews() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding1 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding1.tvStatusGame.isVisible = false
    }

    private fun setClickListeners(){
        binding.btnStart.setOnClickListener {
            setContentView(binding1.root)
        }

        binding.btnExit.setOnClickListener {
            System.exit(0)
        }

        binding1.flChoiceHome.setOnClickListener {
            setContentView(binding.root)
        }

        // Paper
        binding1.flChoice1.setOnClickListener {
            Log.d(TAG, "Player Choose Paper")
            binding1.flChoice1.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            binding1.flChoice2.setBackgroundColor(0)
            binding1.flChoice3.setBackgroundColor(0)
            val oppObj = SuitCharacter.generateRandom()
            showComputerChoice(oppObj)
            val suitResult = SuitCharacter.play(SuitCharacter.PAPER, oppObj)
            binding1.tvStatusGame.isVisible = true
            binding1.tvStatusGame.text = TextComposer.composeResultText(oppObj, suitResult)
        }

        //Rock
        binding1.flChoice2.setOnClickListener {
            Log.d(TAG, "Player Choose Rock")
            binding1.flChoice1.setBackgroundColor(0)
            binding1.flChoice2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            binding1.flChoice3.setBackgroundColor(0)
            val oppObj = SuitCharacter.generateRandom()
            showComputerChoice(oppObj)
            val suitResult = SuitCharacter.play(SuitCharacter.ROCK, oppObj)
            binding1.tvStatusGame.isVisible = true
            binding1.tvStatusGame.text = TextComposer.composeResultText(oppObj, suitResult)
        }

        //Scissor
        binding1.flChoice3.setOnClickListener {
            Log.d(TAG, "Player Choose Scissor")
            binding1.flChoice1.setBackgroundColor(0)
            binding1.flChoice2.setBackgroundColor(0)
            binding1.flChoice3.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            val oppObj = SuitCharacter.generateRandom()
            showComputerChoice(oppObj)
            val suitResult = SuitCharacter.play(SuitCharacter.SCISSOR, oppObj)
            binding1.tvStatusGame.isVisible = true
            binding1.tvStatusGame.text = TextComposer.composeResultText(oppObj, suitResult)

        }

        binding1.flChoiceRefresh.setOnClickListener {
            if (isGameFinished){
                Log.d(TAG, "Game Reset")
                resetGame()
            }else{
                startGame()
            }
        }
    }

    private fun showComputerChoice(
        choice: SuitCharacter
    ) {
        when (choice) {
            SuitCharacter.PAPER -> {
                Log.d(TAG, "Computer Choose Paper")
                binding1.flChoice4.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
                binding1.flChoice5.setBackgroundColor(0)
                binding1.flChoice6.setBackgroundColor(0)
            }
            SuitCharacter.ROCK -> {
                Log.d(TAG, "Computer Choose Rock")
                binding1.flChoice4.setBackgroundColor(0)
                binding1.flChoice6.setBackgroundColor(0)
                binding1.flChoice5.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            }
            else -> {
                Log.d(TAG, "Computer Choose Scissor")
                binding1.flChoice4.setBackgroundColor(0)
                binding1.flChoice5.setBackgroundColor(0)
                binding1.flChoice6.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            }
        }
    }


    private fun startGame(){
        Log.d(TAG, "Game Start")
        binding1.flChoice1.setBackgroundColor(0)
        binding1.flChoice2.setBackgroundColor(0)
        binding1.flChoice3.setBackgroundColor(0)
        binding1.flChoice4.setBackgroundColor(0)
        binding1.flChoice5.setBackgroundColor(0)
        binding1.flChoice6.setBackgroundColor(0)
        isGameFinished = true
        binding1.flChoiceRefresh
        binding1.tvStatusGame.text = ""
    }

    private fun resetGame(){
        binding1.flChoice1.setBackgroundColor(0)
        binding1.flChoice2.setBackgroundColor(0)
        binding1.flChoice3.setBackgroundColor(0)
        binding1.flChoice4.setBackgroundColor(0)
        binding1.flChoice5.setBackgroundColor(0)
        binding1.flChoice6.setBackgroundColor(0)
        isGameFinished = false
        binding1.flChoiceRefresh
        binding1.tvStatusGame.text = ""
    }


}