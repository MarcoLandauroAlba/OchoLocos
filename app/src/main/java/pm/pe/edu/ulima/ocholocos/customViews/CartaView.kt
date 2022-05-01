package pm.pe.edu.ulima.ocholocos.customViews

import android.R
import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CartaView : View{
    private val mPaint : Paint = Paint()
    private val mPaintN : Paint = Paint()
    private val mPaintR : Paint = Paint()
    private var mSize : Float = 0f
    private var mWidth : Float = 0f
    private var mHeight : Float = 0f

    constructor(context: Context, attrs : AttributeSet): super(context, attrs){

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
        canvas!!.drawColor(Color.WHITE)
        drawCarta(canvas!!)
        drawPalo(canvas!!)

    }
    private fun drawCarta(canvas : Canvas){
        val lado = mWidth / 2f
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        canvas!!.drawRect(0f,mHeight,mWidth,0f, mPaint)
    }
    private fun drawPalo(canvas : Canvas){
        mPaintN.color = Color.BLACK
        mPaintN.style = Paint.Style.FILL_AND_STROKE
        mPaintR.color = Color.RED
        mPaintR.style = Paint.Style.FILL_AND_STROKE
        mPaintR.textSize = 500f
        mPaintN.textSize = mWidth / 1.5f
        //canvas!!.drawRect(lado / 2f,mHeight / 2f + mSize / 4f,mWidth - mWidth / 4f,mHeight/3f, mPaint)
        //canvas!!.drawText("♤",mWidth / 2f -  mWidth / 4f, mHeight / 2f +  mHeight / 6.3f, mPaintN)
        canvas!!.drawText("♧",mWidth / 2f -  mWidth / 3.3f, mHeight / 2f +  mHeight / 6f, mPaintN)
        //canvas!!.drawText("♥",mWidth / 6f + 50f, mHeight/2f + 150f, mPaintR)
        //canvas!!.drawText("♦",mWidth / 6f + 50f, mHeight/2f + 150f, mPaintR)
    }
}