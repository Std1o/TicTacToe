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
        assertEquals(GameState.Continue(Player.X, 0), makeMoveUseCase(0))
        assertEquals(GameState.Continue(Player.O, 4), makeMoveUseCase(4))
        assertEquals(GameState.Continue(Player.X, 8), makeMoveUseCase(8))
        assertEquals(GameState.Continue(Player.O, 2), makeMoveUseCase(2))
        assertEquals(GameState.Continue(Player.X, 6), makeMoveUseCase(6))
        assertEquals(GameState.Continue(Player.O, 3), makeMoveUseCase(3))
        assertEquals(GameState.HorizontalWin(Player.X, 7), makeMoveUseCase(7))
    }

    @Test
    fun `vertical win for X`() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue(Player.X, 0), makeMoveUseCase(0))
        assertEquals(GameState.Continue(Player.O, 4), makeMoveUseCase(4))
        assertEquals(GameState.Continue(Player.X, 8), makeMoveUseCase(8))
        assertEquals(GameState.Continue(Player.O, 2), makeMoveUseCase(2))
        assertEquals(GameState.Continue(Player.X, 6), makeMoveUseCase(6))
        assertEquals(GameState.Continue(Player.O, 7), makeMoveUseCase(7))
        assertEquals(GameState.VerticalWin(Player.X, 3), makeMoveUseCase(3))
    }

    @Test
    fun `diagonal win for X`() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue(Player.X, 4), makeMoveUseCase(4))
        assertEquals(GameState.Continue(Player.O, 5), makeMoveUseCase(5))
        assertEquals(GameState.Continue(Player.X, 8), makeMoveUseCase(8))
        assertEquals(GameState.Continue(Player.O, 0), makeMoveUseCase(0))
        assertEquals(GameState.Continue(Player.X, 6), makeMoveUseCase(6))
        assertEquals(GameState.Continue(Player.O, 7), makeMoveUseCase(7))
        assertEquals(GameState.DiagonalWin(Player.X, 2), makeMoveUseCase(2))
    }

    @Test
    fun draw() {
        val makeMoveUseCase = MakeMoveUseCase()
        assertEquals(GameState.Continue(Player.X, 0), makeMoveUseCase(0))
        assertEquals(GameState.Continue(Player.O, 4), makeMoveUseCase(4))
        assertEquals(GameState.Continue(Player.X, 8), makeMoveUseCase(8))
        assertEquals(GameState.Continue(Player.O, 1), makeMoveUseCase(1))
        assertEquals(GameState.Continue(Player.X, 7), makeMoveUseCase(7))
        assertEquals(GameState.Continue(Player.O, 6), makeMoveUseCase(6))
        assertEquals(GameState.Continue(Player.X, 2), makeMoveUseCase(2))
        assertEquals(GameState.Continue(Player.O, 5), makeMoveUseCase(5))
        assertEquals(GameState.Draw(Player.X, 3), makeMoveUseCase(3))
    }
}