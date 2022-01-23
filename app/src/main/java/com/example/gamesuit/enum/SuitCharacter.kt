package com.example.gamesuit.enum

import kotlin.random.Random

enum class SuitCharacter {
    ROCK,
    PAPER,
    SCISSOR;

    companion object {
        private fun determineWinnerObject(obj1: SuitCharacter, obj2: SuitCharacter): SuitCharacter {
            val objects = setOf(obj1, obj2)
            return if (objects.contains(ROCK) && objects.contains(PAPER)) PAPER
            else if (objects.contains(ROCK) && objects.contains(SCISSOR)) ROCK
            else if (objects.contains(PAPER) && objects.contains(SCISSOR)) SCISSOR
            else obj1
        }
        fun play(playerObj: SuitCharacter, oppObj: SuitCharacter): SuitResult {
            val winnerObj = determineWinnerObject(playerObj, oppObj)
            return if (playerObj == winnerObj && oppObj != winnerObj) SuitResult.WIN
            else if (playerObj != winnerObj && oppObj == winnerObj) SuitResult.LOSE
            else SuitResult.DRAW
        }
        fun generateRandom(): SuitCharacter {
            return when (Random.nextInt(1, 3)) {
                1 -> PAPER
                2 -> ROCK
                else -> SCISSOR
            }
        }
    }
}