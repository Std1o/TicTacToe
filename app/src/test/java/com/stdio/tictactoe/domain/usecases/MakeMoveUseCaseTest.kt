package com.stdio.tictactoe.domain.usecases

import com.stdio.tictactoe.domain.GameState
import com.stdio.tictactoe.domain.Player
import org.junit.Assert.*
import org.junit.Test

class MakeMoveUseCaseTest {
    /*
    positions
     |0|1|2|
     |3|4|5|
     |6|7|8|
     */
    @Test
    fun `horizontal win for X`() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue, makeMoveUseCase(0))// X
        assertEquals(GameState.Continue, makeMoveUseCase(4))// O
        assertEquals(GameState.Continue, makeMoveUseCase(8))// X
        assertEquals(GameState.Continue, makeMoveUseCase(2))// O
        assertEquals(GameState.Continue, makeMoveUseCase(6))// X
        assertEquals(GameState.Continue, makeMoveUseCase(3))// O
        assertEquals(GameState.HorizontalWin(Player.X), makeMoveUseCase(7))// X
    }

    @Test
    fun `vertical win for X`() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue, makeMoveUseCase(0))// X
        assertEquals(GameState.Continue, makeMoveUseCase(4))// O
        assertEquals(GameState.Continue, makeMoveUseCase(8))// X
        assertEquals(GameState.Continue, makeMoveUseCase(2))// O
        assertEquals(GameState.Continue, makeMoveUseCase(6))// X
        assertEquals(GameState.Continue, makeMoveUseCase(7))// O
        assertEquals(GameState.VerticalWin(Player.X), makeMoveUseCase(3))// X
    }

    @Test
    fun `diagonal win for X`() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue, makeMoveUseCase(4))// X
        assertEquals(GameState.Continue, makeMoveUseCase(5))// O
        assertEquals(GameState.Continue, makeMoveUseCase(8))// X
        assertEquals(GameState.Continue, makeMoveUseCase(0))// O
        assertEquals(GameState.Continue, makeMoveUseCase(6))// X
        assertEquals(GameState.Continue, makeMoveUseCase(7))// O
        assertEquals(GameState.DiagonalWin(Player.X), makeMoveUseCase(2))// X
    }

    @Test
    fun draw() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue, makeMoveUseCase(0))// X
        assertEquals(GameState.Continue, makeMoveUseCase(4))// O
        assertEquals(GameState.Continue, makeMoveUseCase(8))// X
        assertEquals(GameState.Continue, makeMoveUseCase(1))// O
        assertEquals(GameState.Continue, makeMoveUseCase(7))// X
        assertEquals(GameState.Continue, makeMoveUseCase(6))// O
        assertEquals(GameState.Continue, makeMoveUseCase(2))// X
        assertEquals(GameState.Continue, makeMoveUseCase(5))// O
        assertEquals(GameState.Draw, makeMoveUseCase(3))// X
    }
}