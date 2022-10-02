package com.stdio.tictactoe.domain.usecases

import org.junit.Assert.*
import org.junit.Test

class IsVerticalWinUseCaseTest {

    private val isVerticalWinUseCase = IsVerticalWinUseCase()
    private val initPositions = List(9) { -1 }

    @Test
    fun `win by first column`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 0..6 step 3) positions[i] = i
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `win by second column`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 1..7 step 3) positions[i] = i
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `win by third column`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 2..8 step 3) positions[i] = i
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by first column`() {
        val expected = false
        val positions = initPositions.toMutableList()
        for (i in 0..3 step 3) positions[i] = i
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by second column`() {
        val expected = false
        val positions = initPositions.toMutableList()
        positions[1] = 1
        positions[4] = 4
        positions[5] = 5
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by third column`() {
        val expected = false
        val positions = initPositions.toMutableList()
        positions[2] = 2
        positions[5] = 5
        positions[7] = 7
        val actual = isVerticalWinUseCase(positions)
        assertEquals(expected, actual)
    }
}