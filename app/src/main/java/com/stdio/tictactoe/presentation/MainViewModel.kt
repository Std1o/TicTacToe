package com.stdio.tictactoe.presentation

import androidx.lifecycle.ViewModel
import com.stdio.tictactoe.domain.GameState
import com.stdio.tictactoe.domain.Player
import com.stdio.tictactoe.domain.usecases.MakeMoveUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow<GameState>(GameState.Continue(Player.None, -1))
    val stateFlow = _stateFlow.asStateFlow()

    private val makeMoveUseCase = MakeMoveUseCase()

    fun move(position: Int) {
        _stateFlow.value = makeMoveUseCase(position)
    }

}