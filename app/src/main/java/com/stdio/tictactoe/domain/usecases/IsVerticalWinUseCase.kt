package com.stdio.tictactoe.domain.usecases

class IsVerticalWinUseCase {

    operator fun invoke(positions: List<Int>): Boolean {
        for (i in positions.indices) {
            if (positionsCountWithStep3(i, positions) == 3) return true
        }
        return false
    }

    private fun positionsCountWithStep3(pos: Int, positions: List<Int>): Int {
        var count = 0
        for (i in pos until positions.size step 3) {
            if (positions[i] == i) count++
        }
        return count
    }
}