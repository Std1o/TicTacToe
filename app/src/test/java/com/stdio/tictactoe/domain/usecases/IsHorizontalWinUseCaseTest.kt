package com.stdio.tictactoe.domain.usecases

import org.junit.Assert.*

import org.junit.Test

class IsHorizontalWinUseCaseTest {

    private val isHorizontalWinUseCase = IsHorizontalWinUseCase()
    private val initPositions = List(9){-1}

    @Test
    fun `win by first row`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 0..2) positions[i] = i
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `win by second row`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 3..5) positions[i] = i
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `win by third row`() {
        val expected = true
        val positions = initPositions.toMutableList()
        for (i in 6..8) positions[i] = i
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by first row`() {
        val expected = false
        val positions = initPositions.toMutableList()
        for (i in 0..1) positions[i] = i
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by second row`() {
        val expected = false
        val positions = initPositions.toMutableList()
        positions[1] = 1
        positions[4] = 4
        positions[5] = 5
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }

    @Test
    fun `no win by third row`() {
        val expected = false
        val positions = initPositions.toMutableList()
        for (i in 5..7) positions[i] = i
        val actual = isHorizontalWinUseCase(positions)
        assertEquals(expected, actual)
    }
}