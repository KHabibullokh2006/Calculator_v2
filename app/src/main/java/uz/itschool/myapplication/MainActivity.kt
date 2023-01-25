package uz.itschool.myapplication

import android.annotation.SuppressLint
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
    private lateinit var bcks:Button

    private lateinit var div:Button
    private lateinit var multp:Button
    private lateinit var plus:Button
    private lateinit var minus:Button
    private lateinit var equal:Button

    private lateinit var oper:TextView
    private lateinit var res:TextView

    private var ispoint = true
    private var isSymbol = false
    private var isActive = true

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
            if (ispoint && oper.text.isNotEmpty()){
                oper.text = oper.text.toString() + "."
                ispoint = false
            }
        }

        clear.setOnClickListener {
            oper.text = "0"
            ispoint = true
            isSymbol = false
        }

        bcks.setOnClickListener {
            if (oper.text.isNotEmpty()){
                oper.text = oper.text.dropLast(1)
                ispoint = true
                isSymbol = false
                isActive = false
            }
        }

        div.setOnClickListener {
            addSymbol("/")
        }

        multp.setOnClickListener {
            addSymbol("x")
        }

        plus.setOnClickListener {
            addSymbol("+")
        }

        minus.setOnClickListener {
            addSymbol("-")
        }

//        equal.setOnClickListener {
//            calculate()
//        }

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
        bcks = findViewById(R.id.backspace)

        div = findViewById(R.id.div)
        multp = findViewById(R.id.multiply)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)

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
//        res.text = calculate()
        isSymbol = true

    }

//    private fun calculate(): String {
//        var result_list = createArray(oper.text.toString())
//        hisobla(result_list)
//        lateinit var r:String
//
//    }

    private fun hisobla(resultList: MutableList<Any>) {
        var list = resultList
        var first = 0.0
        var second = 0.0
        if (list.size >= 3){
            for (i in list.indices) {
                if (list[i] == '/' || list[i] == 'x'){
                    first = list[i-1] as Double
                    second = list[i-1] as Double
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun addSymbol(symbol:String){
        if (isSymbol){
            oper.text = oper.text.toString() + symbol
            isSymbol = false
            ispoint = true
        }else{
            if (oper.text != "0"){
                oper.text = oper.text.substring(0,oper.text.length-1) + symbol
            }
        }
        ispoint = true
    }

    fun createArray(s:String):MutableList<Any>{
        var list = mutableListOf<Any>()
        var temp = ""
        for (i in s){
            if (i.isDigit() || i == '.'){
                temp+=i
            }
            else{
                list.add(temp)
                list.add(i)
                temp = ""
            }
        }
        if (temp.isEmpty()){
            list.add(temp)
        }

        Log.d("TAG", list.toString())

        return list
    }
}



