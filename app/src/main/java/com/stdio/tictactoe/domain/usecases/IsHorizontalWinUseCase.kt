package com.stdio.tictactoe.domain.usecases

class IsHorizontalWinUseCase {

    operator fun invoke(positions: List<Int>): Boolean {
        for (i in positions.indices step 3) {
            val twoRunningInRow = 1 + positions[i] == positions[i + 1]
            if (twoRunningInRow && (1 + positions[i + 1] == positions[i + 2])) {
                return true
            }
        }
        return false
    }
}