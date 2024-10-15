package com.example.myapplicationapp


import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Math.random
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var num1 = 0
    var num2 = 0
    var first=0
    var sec=0
    lateinit var box1:TextView
    lateinit var box2:TextView
    lateinit var strike:TextView
    lateinit var score:TextView
    lateinit var button: Button
    lateinit var tap:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        box1= findViewById(R.id.num1)
        box2= findViewById(R.id.num2)
        tap = findViewById(R.id.tap)
        button= findViewById(R.id.button)
        var playing = false
        button.setOnClickListener{
            playing = true
            button.text = "RESTART"
            tap.text = "Tap the larger number!"
            num1=0
            num2=0
            strike= findViewById(R.id.strike)
            score= findViewById(R.id.score)
            backgroundcolor("#FFFDEF74")
            strike.setTextColor(Color.parseColor("#000000"))
            score.setTextColor(Color.parseColor("#000000"))
            getnumbers()
        }
        box1.setOnClickListener {
            if(playing){
                if(first>sec){
                    num1++
                    score.setTextColor(Color.parseColor("#FFFDEF74"))
                    strike.setTextColor(Color.parseColor("#000000"))
                    backgroundcolor("#90EE90")
                } else {
                    num2++
                    score.setTextColor(Color.parseColor("#000000"))
                    strike.setTextColor(Color.parseColor("#FFFDEF74"))
                    backgroundcolor("#FF0000")
                }
                if(num1 != 10 && num2 !=3) getnumbers() else default()
            }
            if(num1 == 10) {

                val toast: Toast = Toast.makeText(this, "You win!", Toast.LENGTH_SHORT)
                toast.show()
                playing = false
                score.setTextColor(Color.parseColor("#008000"))
            }else if(num2 ==3){
                val toast: Toast = Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT)
                toast.show()
                playing = false
                strike.setTextColor(Color.parseColor("#FF0000"))
            }
        }
        box2.setOnClickListener {
            if(playing){
                if(sec>first){
                    num1++
                    score.setTextColor(Color.parseColor("#FFFDEF74"))
                    strike.setTextColor(Color.parseColor("#000000"))
                    backgroundcolor("#90EE90")
                } else {
                    num2++
                    score.setTextColor(Color.parseColor("#000000"))
                    strike.setTextColor(Color.parseColor("#FFFDEF74"))
                    backgroundcolor("#FF0000")
                }
                if(num1 != 10 && num2 !=3) getnumbers() else default()
            }
            if(num1 == 10) {
                val toast: Toast = Toast.makeText(this, "You win!", Toast.LENGTH_SHORT)
                toast.show()
                playing = false
                score.setTextColor(Color.parseColor("#008000"))
            }else if(num2 ==3){
                val toast: Toast = Toast.makeText(this, "You lose!", Toast.LENGTH_SHORT)
                toast.show()
                playing = false
                strike.setTextColor(Color.parseColor("#FF0000"))
            }
        }

    }
    private fun backgroundcolor(color:String){
        val backgroundcolor:LinearLayout=findViewById(R.id.main)
        backgroundcolor.setBackgroundColor(Color.parseColor(color))
    }
    private fun getnumbers() {
        first = Random.nextInt(100)+1
        sec = Random.nextInt(100)+1
        while(sec == first){
            sec = Random.nextInt(100)+1
        }
        score.text = "Score:$num1"
        strike.text="Score:$num2"
        box1.text = "$first"
        box2.text = "$sec"
    }
    private fun default(){
        button.text = "RESTART"
        tap.text = "Tap restart to play again!"
        strike= findViewById(R.id.strike)
        score= findViewById(R.id.score)
        score.text = "Score:$num1"
        strike.text="Score:$num2"
        box1.text = ""
        box2.text = ""
        backgroundcolor("#FFFDEF74")
    }
}
