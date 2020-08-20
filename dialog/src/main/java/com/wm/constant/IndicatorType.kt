package com.wm.constant

object IndicatorType {
    const val BALL_PULSE_INDICATOR= "BallPulseIndicator"
    const val BALL_GRID_PULSE_INDICATOR= "BallGridPulseIndicator"
    const val BALL_CLIP_ROTATE_INDICATOR= "BallClipRotateIndicator"
    const val BALL_CLIP_ROTATE_PULSE_INDICATOR= "BallClipRotatePulseIndicator"

    const val SQUARE_SPIN_INDICATOR= "SquareSpinIndicator"
    const val BALL_CLIP_ROTATE_MULTIPLE_INDICATOR= "BallClipRotateMultipleIndicator"
    const val BALL_PULSE_RISE_INDICATOR= "BallPulseRiseIndicator"
    const val BALL_ROTATE_INDICATOR= "BallRotateIndicator"

    const val CUBE_TRANSITION_INDICATOR= "CubeTransitionIndicator"
    const val BALL_ZIG_ZAG_INDICATOR= "BallZigZagIndicator"
    const val BALL_ZIG_ZAG_DEFLECT_INDICATOR= "BallZigZagDeflectIndicator"
    const val BALL_TRIANGLE_PATH_INDICATOR= "BallTrianglePathIndicator"

    const val BALL_SCALE_INDICATOR= "BallScaleIndicator"
    const val LINE_SCALE_INDICATOR= "LineScaleIndicator"
    const val LINE_SCALE_PARTY_INDICATOR= "LineScalePartyIndicator"
    const val BALL_SCALE_MULTIPLE_INDICATOR = "BallScaleMultipleIndicator"

    const val BALL_PULSE_SYNC_INDICATOR= "BallPulseSyncIndicator"
    const val BALL_BEAT_INDICATOR= "BallBeatIndicator"
    const val LINE_SCALE_PULSE_OUT_INDICATOR= "LineScalePulseOutIndicator"
    const val LINE_SCALE_PULSE_OUT_RAPID_INDICATOR= "LineScalePulseOutRapidIndicator"

    const val BALL_SCALE_RIPPLE_INDICATOR= "BallScaleRippleIndicator"
    const val BALL_SCALE_RIPPLE_MULTIPLE_INDICATOR= "BallScaleRippleMultipleIndicator"
    const val BALL_SPIN_FADE_LOADER_INDICATOR= "BallSpinFadeLoaderIndicator"
    const val LINE_SPIN_FADE_LOADER_INDICATOR= "LineSpinFadeLoaderIndicator"

    const val TRIANGLE_SKEW_SPIN_INDICATOR= "TriangleSkewSpinIndicator"
    const val PACMAN_INDICATOR= "PacmanIndicator"
    const val BALL_GRID_BEAT_INDICATOR= "BallGridBeatIndicator"
    const val SEMI_CIRCLE_SPIN_INDICATOR= "SemiCircleSpinIndicator"

    fun getAllIndicator():Array<String>{
        return arrayOf(BALL_PULSE_INDICATOR,
                BALL_GRID_PULSE_INDICATOR,
                BALL_CLIP_ROTATE_INDICATOR,
                BALL_CLIP_ROTATE_PULSE_INDICATOR,
                SQUARE_SPIN_INDICATOR,
                BALL_CLIP_ROTATE_MULTIPLE_INDICATOR,
                BALL_PULSE_RISE_INDICATOR,
                BALL_ROTATE_INDICATOR,
                CUBE_TRANSITION_INDICATOR,
                BALL_ZIG_ZAG_INDICATOR,
                BALL_ZIG_ZAG_DEFLECT_INDICATOR,
                BALL_TRIANGLE_PATH_INDICATOR,
                BALL_SCALE_INDICATOR,
                LINE_SCALE_INDICATOR,
                LINE_SCALE_PARTY_INDICATOR,
                BALL_SCALE_MULTIPLE_INDICATOR,
                BALL_PULSE_SYNC_INDICATOR,
                BALL_BEAT_INDICATOR,
                LINE_SCALE_PULSE_OUT_INDICATOR,
                LINE_SCALE_PULSE_OUT_RAPID_INDICATOR,
                BALL_SCALE_RIPPLE_INDICATOR,
                BALL_SCALE_RIPPLE_MULTIPLE_INDICATOR,
                BALL_SPIN_FADE_LOADER_INDICATOR,
                LINE_SPIN_FADE_LOADER_INDICATOR,
                TRIANGLE_SKEW_SPIN_INDICATOR,
                PACMAN_INDICATOR,
                BALL_GRID_BEAT_INDICATOR,
                SEMI_CIRCLE_SPIN_INDICATOR)
    }
}