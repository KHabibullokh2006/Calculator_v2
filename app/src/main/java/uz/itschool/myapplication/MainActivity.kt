package uz.itschool.myapplication

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var one:Button
    private lateinit var two:Button
    private lateinit var three:Button
    private lateinit var four:Button
    private lateinit var five:Button
    private lateinit var six:Button
    private lateinit var seven:Button
    private lateinit var eight:Button
    private lateinit var nine:Button
    private lateinit var zero:Button

    private lateinit var point:Button
    private lateinit var clear:Button

    private lateinit var div:Button
    private lateinit var multp:Button

    private lateinit var oper:TextView
    private lateinit var res:TextView

    private var ispoint = true
    private var isSymbol = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)

        point.setOnClickListener{
            if (ispoint){
                oper.text = oper.text.toString() + "."
                ispoint = false
            }
        }

        clear.setOnClickListener {
            oper.text = "0"
            ispoint = true
            isSymbol = false
        }

        div.setOnClickListener {
            addSymbol("/")
        }

        multp.setOnClickListener {
            addSymbol("x")
        }
    }

    fun initUI(){
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)

        point = findViewById(R.id.point)
        clear = findViewById(R.id.clear_text)

        div = findViewById(R.id.div)
        multp = findViewById(R.id.multiply)

        oper = findViewById(R.id.operand)
        res = findViewById(R.id.result)
    }

    override fun onClick(p0: View?) {
        val btn = findViewById<Button>(p0!!.id)
        if (oper.text != "0"){
            oper.text = oper.text.toString() + btn.text
            Log.d("AAA", btn.text.toString())
        }
        else{
            oper.text = btn.text
        }
        res.text = calculate()
        isSymbol = true

    }

    private fun calculate(): String {
        var r = "123"
        return r
    }

    fun addSymbol(symbol:String){
        if (isSymbol){
            oper.text = oper.text.toString() + symbol
            isSymbol = false
        }else{
            if (oper.text != "0"){
                oper.text = oper.text.substring(0,oper.text.length-1) + symbol
            }
        }
        ispoint = true
    }
}