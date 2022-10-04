package com.stdio.tictactoe.domain

sealed class GameState {

    fun getCurrentPlayer(): Player {
        if (this is HorizontalWin) return this.winner
        if (this is VerticalWin) return this.winner
        if (this is DiagonalWin) return this.winner
        if (this is Draw) return this.player
        if (this is Continue) return this.player
        return Player.X
    }

    fun getCurrentPosition(): Int {
        if (this is HorizontalWin) return this.position
        if (this is VerticalWin) return this.position
        if (this is DiagonalWin) return this.position
        if (this is Draw) return this.position
        if (this is Continue) return this.position
        return -1
    }
    data class HorizontalWin(val winner: Player, val position: Int) : GameState()
    data class VerticalWin(val winner: Player, val position: Int) : GameState()
    data class DiagonalWin(val winner: Player, val position: Int) : GameState()
    data class Draw(val player: Player, val position: Int) : GameState()
    data class Continue(val player: Player, val position: Int) : GameState()
}
