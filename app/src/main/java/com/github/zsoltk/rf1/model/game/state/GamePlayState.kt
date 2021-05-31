package com.github.zsoltk.rf1.model.game.state

data class GamePlayState(
    val gameState: GameState = GameState(),
    val uiState: UiState = UiState(gameState.currentSnaphotState),
    // TODO move GameController.PromotionState here
)
