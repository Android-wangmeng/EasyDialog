
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.wm.anim;

import com.wm.anim.attention.BounceAnimator;
import com.wm.anim.attention.FlashAnimator;
import com.wm.anim.attention.PulseAnimator;
import com.wm.anim.attention.RubberBandAnimator;
import com.wm.anim.attention.ShakeAnimator;
import com.wm.anim.attention.StandUpAnimator;
import com.wm.anim.attention.SwingAnimator;
import com.wm.anim.attention.TadaAnimator;
import com.wm.anim.attention.WaveAnimator;
import com.wm.anim.attention.WobbleAnimator;
import com.wm.anim.bouncing_entrances.BounceInAnimator;
import com.wm.anim.bouncing_entrances.BounceInDownAnimator;
import com.wm.anim.bouncing_entrances.BounceInLeftAnimator;
import com.wm.anim.bouncing_entrances.BounceInRightAnimator;
import com.wm.anim.bouncing_entrances.BounceInUpAnimator;
import com.wm.anim.flippers.FlipInXAnimator;
import com.wm.anim.flippers.FlipInYAnimator;
import com.wm.anim.flippers.FlipOutXAnimator;
import com.wm.anim.flippers.FlipOutYAnimator;
import com.wm.anim.rotating_entrances.RotateInAnimator;
import com.wm.anim.rotating_entrances.RotateInDownLeftAnimator;
import com.wm.anim.rotating_entrances.RotateInDownRightAnimator;
import com.wm.anim.rotating_entrances.RotateInUpLeftAnimator;
import com.wm.anim.rotating_entrances.RotateInUpRightAnimator;
import com.wm.anim.rotating_exits.RotateOutAnimator;
import com.wm.anim.rotating_exits.RotateOutDownLeftAnimator;
import com.wm.anim.rotating_exits.RotateOutDownRightAnimator;
import com.wm.anim.rotating_exits.RotateOutUpLeftAnimator;
import com.wm.anim.rotating_exits.RotateOutUpRightAnimator;
import com.wm.anim.sliders.SlideInDownAnimator;
import com.wm.anim.sliders.SlideInLeftAnimator;
import com.wm.anim.sliders.SlideInRightAnimator;
import com.wm.anim.sliders.SlideInUpAnimator;
import com.wm.anim.sliders.SlideOutDownAnimator;
import com.wm.anim.sliders.SlideOutLeftAnimator;
import com.wm.anim.sliders.SlideOutRightAnimator;
import com.wm.anim.sliders.SlideOutUpAnimator;
import com.wm.anim.zooming_entrances.ZoomInAnimator;
import com.wm.anim.zooming_entrances.ZoomInDownAnimator;
import com.wm.anim.zooming_entrances.ZoomInLeftAnimator;
import com.wm.anim.zooming_entrances.ZoomInRightAnimator;
import com.wm.anim.zooming_entrances.ZoomInUpAnimator;
import com.wm.anim.zooming_exits.ZoomOutAnimator;
import com.wm.anim.zooming_exits.ZoomOutDownAnimator;
import com.wm.anim.zooming_exits.ZoomOutLeftAnimator;
import com.wm.anim.zooming_exits.ZoomOutRightAnimator;
import com.wm.anim.zooming_exits.ZoomOutUpAnimator;

public enum AnimationType {

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);



    private Class animatorClazz;

    private AnimationType(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
