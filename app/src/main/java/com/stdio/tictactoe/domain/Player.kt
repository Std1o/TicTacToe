package com.stdio.tictactoe.domain

sealed class Player {
    object X : Player()
    object O : Player()
}
