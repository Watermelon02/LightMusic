package watermelon.lightmusic.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.LinearLayout
import androidx.core.graphics.blue
import kotlin.math.absoluteValue

/**
 * description ： 解决滑动冲突，同时根据传入的颜色绘制动态渐变背景
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/24 22:39
 */
class PlayListColorfulBackground(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {
    private var lastX = 0f
    private var lastY = 0f
    private var alpha1 = 0
    private var alpha2 = 0
    private var color1 = Color.WHITE
    private var color2 = Color.WHITE
    private val paint = Paint().apply { style = Paint.Style.FILL }
    private var gradient = LinearGradient(
        0f,
        0f,
        width.toFloat(),
        height.toFloat(),
        arrayOf(color1, color2).toIntArray(),
        null,
        Shader.TileMode.REPEAT
    )
    private var animator1 = ValueAnimator.ofFloat(1f, 0.25f).apply {
        duration = 9000
        repeatMode = ValueAnimator.REVERSE
        repeatCount = ValueAnimator.INFINITE
    }
    private var animator2: ValueAnimator = ValueAnimator.ofFloat(1f, 4f).apply {
        duration = 4000
        repeatMode = ValueAnimator.REVERSE
        repeatCount = ValueAnimator.INFINITE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            arrayOf(color1, color2).toIntArray(),
            null,
            Shader.TileMode.REPEAT
        )
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = ev.rawX
                lastY = ev.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = ev.rawX - lastX
                val dy = ev.rawY - lastY
                if (dx.absoluteValue > dy.absoluteValue) {
                    if ((getChildAt(0).canScrollHorizontally(1) && dx < 0) || (getChildAt(0).canScrollHorizontally(
                            -1
                        ) && dx > 0)
                    ) {
                        parent.requestDisallowInterceptTouchEvent(true)
                    }
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
                lastX = ev.rawX
                lastY = ev.rawY
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    fun setColor(color: Int) {
        animator1.removeAllUpdateListeners()
        animator2.removeAllUpdateListeners()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            alpha1 = (Color.alpha(color) * 0.8).toInt()
            alpha2 = (Color.alpha(color) * 0.2).toInt()
        }
        animator1.addUpdateListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                this.color1 = Color.argb(
                    (alpha1 * (it.animatedValue as Float)).toInt(),
                    Color.red(color),
                    Color.green(color),
                    Color.blue(color)
                )
                invalidate()
            }
        }
        animator2.addUpdateListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                this.color2 = Color.argb(
                    (alpha2 * (it.animatedValue as Float)).toInt(),
                    Color.red(color),
                    Color.green(color),
                    Color.blue(color)
                )
                invalidate()
            }
        }
        animator1.start()
        animator2.start()
    }
}