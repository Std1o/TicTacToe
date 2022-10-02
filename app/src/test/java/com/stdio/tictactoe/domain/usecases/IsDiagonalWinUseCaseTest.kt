package com.stdio.tictactoe.domain.usecases

import org.junit.Assert.*
import org.junit.Test

class IsDiagonalWinUseCaseTest {

    private val isDiagonalWinUseCase = IsDiagonalWinUseCase()
    private val initPositions = List(9) { -1 }

    @Test
    fun `win by diagonal line 1`() {
        val expected = true
        val positions = initPositions.toMutableList()
        positions[0] = 0
        positions[4] = 4
        positions[8] = 8
        val actual = isDiagonalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `win by diagonal line 2`() {
        val expected = true
        val positions = initPositions.toMutableList()
        positions[2] = 2
        positions[4] = 4
        positions[6] = 6
        val actual = isDiagonalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by diagonal line 1`() {
        val expected = false
        val positions = initPositions.toMutableList()
        positions[0] = 0
        positions[4] = 4
        positions[7] = 7
        val actual = isDiagonalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by diagonal line 2`() {
        val expected = false
        val positions = initPositions.toMutableList()
        positions[0] = 0
        positions[4] = 4
        positions[6] = 6
        val actual = isDiagonalWinUseCase(positions)
        assertEquals(expected, actual)
    }
}