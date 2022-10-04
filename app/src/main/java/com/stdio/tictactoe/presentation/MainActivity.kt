package com.stdio.tictactoe.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.stdio.tictactoe.R
import com.stdio.tictactoe.databinding.ActivityMainBinding
import com.stdio.tictactoe.domain.GameState
import com.stdio.tictactoe.domain.Player

class MainActivity : AppCompatActivity() {

    lateinit var rvAdapter: RVAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    companion object {
        const val KEY_GAME_RESULT = "game_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()

        lifecycleScope.launchWhenCreated {
            viewModel.stateFlow.collect {
                rvAdapter.updatePosition(it.getCurrentPosition(), it.getCurrentPlayer())
                if (it is GameState.Draw) {
                    showResultDialog(R.string.draw)
                } else if (it !is GameState.Continue) {
                    showResultDialog(getWinnerResId(it))
                } else {
                    //it.player is player who moved, that's why other player's turn
                    val playerTurn =
                        if (it.player == Player.O || it.player == Player.None) R.string.player_x_turn
                        else R.string.player_o_turn
                    binding.playerTurn.setText(playerTurn)
                }
            }
        }
        setFragmentResultListener()
    }

    private fun initRV() {
        rvAdapter = RVAdapter {
            viewModel.move(it)
        }
        binding.recyclerView.adapter = rvAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                GridLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                GridLayoutManager.HORIZONTAL
            )
        )
    }

    private fun getWinnerResId(gameState: GameState): Int {
        return if (gameState.getCurrentPlayer() == Player.X) {
            R.string.player_x_won
        } else {
            R.string.player_o_won
        }
    }

    private fun showResultDialog(@StringRes gameResultResId: Int) {
        GameResultDialogFragment
            .newInstance(gameResultResId)
            .show(supportFragmentManager, KEY_GAME_RESULT)
    }

    private fun setFragmentResultListener() {
        supportFragmentManager.setFragmentResultListener(KEY_GAME_RESULT, this) { _, _ ->
            rvAdapter.reset()
            binding.playerTurn.setText(R.string.player_x_turn)
        }
    }
}