package watermelon.lightmusic.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import com.google.android.material.card.MaterialCardView

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/23 20:58
 */
class ColorfulCard(context: Context?, attrs: AttributeSet?) : MaterialCardView(context, attrs) {
    private var maxDy = 100f
    private var lastY = 0f
    var totalDy = 0f
    private var lastX = 0f
    var swipeListener: (() -> Unit)? = null
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("", "onMeasure: ")
    }
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        //图片下方歌单名字的高度
        maxDy = (bottom - top) * 0.28f
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                lastY = ev.rawY
                lastX = ev.rawX
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val dy = ev.rawY - lastY
                val dx = ev.rawX - lastX
                if ((dy > 0 && totalDy + dy <= maxDy) || (dy < 0 && totalDy + dy >= 0f)) {
                    y += dy
                    totalDy += dy
                    if (totalDy == maxDy) swipeListener?.invoke()
                }
                lastY = ev.rawY
                lastX = ev.rawX
            }
            MotionEvent.ACTION_UP -> {
                if (totalDy > 2 * maxDy / 3){
                    animate().y(maxDy)
                    swipeListener?.invoke()
                }else animate().y(0f)
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}