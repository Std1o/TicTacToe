package com.stdio.tictactoe.domain.usecases

class IsDiagonalWinUseCase {

    operator fun invoke(positions: List<Int>): Boolean {
        val diagonalLine1 = listOf(0, 4, 8)
        val diagonalLine2 = listOf(2, 4, 6)
        val case1 = diagonalLine1.all {
            positions.contains(it)
        }
        val case2 =  diagonalLine2.all {
            positions.contains(it)
        }
        return case1 || case2
    }
}