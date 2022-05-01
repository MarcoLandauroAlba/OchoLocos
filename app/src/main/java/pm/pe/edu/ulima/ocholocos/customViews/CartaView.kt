package pm.pe.edu.ulima.ocholocos.customViews


import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import pm.pe.edu.ulima.ocholocos.R

class CartaView : View{
    private val mPaint : Paint = Paint()
    private val mPaintN : Paint = Paint()
    private val mPaintR : Paint = Paint()
    private var mSize : Float = 0f
    private var mWidth : Float = 0f
    private var mHeight : Float = 0f
    private var paloCarta : Int = 0

    constructor(context: Context, attrs : AttributeSet): super(context, attrs){
        val a : TypedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CartaView,
            0,
            0
        )
        paloCarta = a.getInt(R.styleable.CartaView_PaloCarta, 4)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = View.MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mHeight = View.MeasureSpec.getSize(heightMeasureSpec).toFloat()
        setMeasuredDimension(mWidth.toInt(),mHeight.toInt())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawColor(Color.WHITE)
        drawCarta(canvas!!)
        drawPalo(canvas!!, paloCarta)

    }
    private fun drawCarta(canvas : Canvas){
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        canvas!!.drawRect(0f,mHeight,mWidth,0f, mPaint)
    }
    private fun drawPalo(canvas : Canvas, palo : Int){
        mPaintN.color = Color.BLACK
        mPaintN.style = Paint.Style.FILL_AND_STROKE
        mPaintR.color = Color.RED
        mPaintR.style = Paint.Style.FILL_AND_STROKE
        mPaintR.textSize = mWidth / 2f
        mPaintN.textSize = mWidth / 1.5f
        if(palo == 0){
            canvas!!.drawText("♥",mWidth / 2f -  mWidth / 3.2f, mHeight / 2f +  mHeight / 10f, mPaintR)
        }else if(palo == 1){
            canvas!!.drawText("♥",mWidth / 2f -  mWidth / 3.2f, mHeight / 2f +  mHeight / 10f, mPaintR)
        }else if(palo == 2){
            canvas!!.drawText("♦",mWidth / 2f -  mWidth / 3.1f, mHeight / 2f +  mHeight / 10f, mPaintR)
        }else if(palo == 3){
            canvas!!.drawText("♧",mWidth / 2f -  mWidth / 3.3f, mHeight / 2f +  mHeight / 6.8f, mPaintN)
        }else if(palo == 4){
            canvas!!.drawText("♤",mWidth / 2f -  mWidth / 4f, mHeight / 2f +  mHeight / 6.3f, mPaintN)
        }
    }
}