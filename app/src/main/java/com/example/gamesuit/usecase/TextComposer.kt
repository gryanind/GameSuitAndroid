package com.example.gamesuit.usecase

import com.example.gamesuit.enum.SuitCharacter
import com.example.gamesuit.enum.SuitResult

class TextComposer {
    companion object {
        fun composeResultText(oppObj: SuitCharacter, SuitResult: SuitResult): String {
            return if (SuitResult == com.example.gamesuit.enum.SuitResult.WIN) "You won!"
            else if (SuitResult == com.example.gamesuit.enum.SuitResult.LOSE) "You lost!" else "Draw!"
        }

    }
}