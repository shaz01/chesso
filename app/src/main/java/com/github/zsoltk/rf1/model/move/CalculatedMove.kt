package com.github.zsoltk.rf1.model.move

import com.github.zsoltk.rf1.model.board.Position
import com.github.zsoltk.rf1.model.piece.Pawn
import com.github.zsoltk.rf1.model.piece.Piece

data class CalculatedMove(
    val move: Move,
    val isCapture: Boolean? = null,
    val effect: MoveEffect? = null
) {
    val from: Position = move.from

    val to: Position = move.to

    val piece: Piece = move.piece

    override fun toString(): String {
        val symbol = when {
            piece !is Pawn -> piece.symbol
            isCapture == true -> move.from.fileAsLetter
            else -> ""
        }
        val capture = if (isCapture == true) "x" else ""
        val postFix = when (effect) {
            MoveEffect.CHECK -> "+"
            MoveEffect.CHECKMATE -> "#"
            else -> ""
        }
        return "$symbol$capture${move.to}$postFix"
    }
}
