package com.stdio.tictactoe.domain.usecases

import com.stdio.tictactoe.domain.GameState
import com.stdio.tictactoe.domain.Player

class MakeMoveUseCase {

    private val isHorizontalWinUseCase = IsHorizontalWinUseCase()
    private val isVerticalWinUseCase = IsVerticalWinUseCase()
    private val isDiagonalWinUseCase = IsDiagonalWinUseCase()
    private var currentPlayer: Player = Player.X
    private val xPlayerMoves = MutableList(9) { -1 }
    private val oPlayerMoves = MutableList(9) { -1 }

    operator fun invoke(position: Int): GameState {
        val positions = if (currentPlayer == Player.X) xPlayerMoves else oPlayerMoves
        positions[position] = position
        lateinit var gameState: GameState
        if (isHorizontalWinUseCase(positions)) {
            gameState = GameState.HorizontalWin(currentPlayer)
        } else if (isVerticalWinUseCase(positions)) {
            gameState = GameState.VerticalWin(currentPlayer)
        } else if (isDiagonalWinUseCase(positions)) {
            gameState = GameState.DiagonalWin(currentPlayer)
        } else if ((xPlayerMoves.count { it != -1 } + oPlayerMoves.count { it != -1 }) == 9) {
            gameState = GameState.Draw
        } else {
            gameState = GameState.Continue
        }
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
        return gameState
    }
}