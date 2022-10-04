package com.stdio.tictactoe.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import com.stdio.tictactoe.databinding.DialogGameResultBinding
import com.stdio.tictactoe.presentation.MainActivity.Companion.KEY_GAME_RESULT

class GameResultDialogFragment : DialogFragment() {

    private var _binding: DialogGameResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DialogGameResultBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireDialog().setCancelable(false)
        requireDialog().window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        arguments?.getInt(ARG_GAME_RESULT)?.let {
            binding.title.setText(it)
        }
        binding.btnRestart.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .setFragmentResult(KEY_GAME_RESULT, Bundle())
            dismiss()
        }
    }

    companion object {
        private const val ARG_GAME_RESULT = "game_result"

        fun newInstance(@StringRes gameResultResId: Int): GameResultDialogFragment =
            GameResultDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_GAME_RESULT, gameResultResId)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}