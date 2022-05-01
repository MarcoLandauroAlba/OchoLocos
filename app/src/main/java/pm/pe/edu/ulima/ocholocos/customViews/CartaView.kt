package pm.pe.edu.ulima.ocholocos.customViews

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import pm.pe.edu.ulima.ocholocos.R

class CartaView : View{
    private val mPaint : Paint = Paint()
    private var mSize : Float = 0f
    private var mWidth : Float = 0f
    private var mHeight : Float = 0f

    constructor(context : Context) : super(context){
        //Crear una instancia con solo codigo Kotlin
    }
    constructor(context: Context, attrs : AttributeSet): super(context, attrs){
        //Crear una instancia a partir de XML
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = View.MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec).toFloat()

        mSize = Math.min(mWidth, mHeight)

        setMeasuredDimension(mWidth.toInt(),mHeight.toInt())
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCarta(canvas!!)
    }
    private fun drawCarta(canvas : Canvas){
        val lado = mWidth / 2f
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        canvas!!.drawRect(0f,mHeight,mWidth,0f, mPaint)
    }
}