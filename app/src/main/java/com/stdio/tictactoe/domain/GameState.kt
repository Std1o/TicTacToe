package com.stdio.tictactoe.domain

sealed class GameState {
    data class HorizontalWin(val winner: Player) : GameState()
    data class VerticalWin(val winner: Player) : GameState()
    data class DiagonalWin(val winner: Player) : GameState()
    object Draw : GameState()
    object Continue : GameState()
}
