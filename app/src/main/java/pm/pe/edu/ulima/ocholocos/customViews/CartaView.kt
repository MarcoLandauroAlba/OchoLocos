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
    private val mPaintNumero : Paint = Paint()
    private var mWidth : Float = 0f
    private var mHeight : Float = 0f
    var paloCarta : Int = 0
    var NumeroCarta : Int = 0

    constructor(context: Context, attrs : AttributeSet): super(context, attrs){
        val a : TypedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CartaView,
            0,
            0
        )
        paloCarta = a.getInt(R.styleable.CartaView_PaloCarta, 4)
        NumeroCarta = a.getInt(R.styleable.CartaView_NumeroCarta, 1)
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
        drawNumero(canvas!!, NumeroCarta, paloCarta)
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
    private fun drawNumero(canvas : Canvas, numero : Int, palo : Int){
        if(palo == 1 || palo == 2){
            mPaintNumero.color = Color.RED
        }else{
            mPaintNumero.color = Color.BLACK
        }
        mPaintNumero.style = Paint.Style.FILL_AND_STROKE
        mPaintNumero.textSize = mWidth / 3f
        if(numero == 1){
            canvas.drawText("A",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("A",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 2){
            canvas.drawText("2",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("2",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 3){
            canvas.drawText("3",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("3",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 4){
            canvas.drawText("4",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("4",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 5){
            canvas.drawText("5",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("5",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 6){
            canvas.drawText("6",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("6",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 7){
            canvas.drawText("7",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("7",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 8){
            canvas.drawText("8",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("8",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 9){
            canvas.drawText("9",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("9",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 10){
            canvas.drawText("X",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("X",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 11){
            canvas.drawText("J",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("J",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 12){
            canvas.drawText("Q",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("Q",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }else if(numero == 13){
            canvas.drawText("K",mWidth / 4f - mWidth / 5f, mHeight / 10f + mHeight / 10f, mPaintNumero)
            canvas.drawText("K",mWidth / 2f + mWidth / 4f, mHeight - mHeight / 25f, mPaintNumero)
        }
    }
}