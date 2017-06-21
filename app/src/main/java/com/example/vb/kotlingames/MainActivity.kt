package com.example.vb.kotlingames

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var totalMoney = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCredit.text=totalMoney.toString()

        btnNewGame.setOnClickListener {

            imageEnabled(true)
            txtResult.text=""

            select1.setBackgroundColor(Color.GRAY)
            select2.setBackgroundColor(Color.GRAY)
            select3.setBackgroundColor(Color.GRAY)

            select1.setImageResource(android.R.color.transparent)
            select2.setImageResource(android.R.color.transparent)
            select3.setImageResource(android.R.color.transparent)

        }


    }

     fun ClickItem(view: View){

         val rndNumber =1+Random().nextInt(3)
         val imgbutton = view as ImageButton

         when(imgbutton.id){

             R.id.select1-> {
                 TheGame(rndNumber)
                 if (rndNumber==1) WinUser()
                 else LooseUser()

             }
             R.id.select2->{
                 TheGame(rndNumber)
                 if (rndNumber==2) WinUser()
                 else LooseUser()
             }

             R.id.select3->{
                TheGame(rndNumber)
                 if (rndNumber==3) WinUser()
                 else LooseUser()
             }



         }

        }

    private fun TheGame(rndNumber: Int) {
            select1.setBackgroundColor(Color.TRANSPARENT)
            select2.setBackgroundColor(Color.TRANSPARENT)
            select3.setBackgroundColor(Color.TRANSPARENT)

            imageEnabled(false)


            if (rndNumber==1) select1.setImageResource(R.drawable.asd)
            else if (rndNumber==2) select2.setImageResource(R.drawable.asd)
            else select3.setImageResource(R.drawable.asd)


    }

    private fun imageEnabled(bools: Boolean) {
        select1.isEnabled=bools
        select2.isEnabled=bools
        select3.isEnabled=bools
    }

    private fun LooseUser() {
        txtResult.text="Kaybettiniz"
        totalMoney--
        txtCredit.text=totalMoney.toString()
    }

    private fun WinUser() {
        txtResult.text="Kazandınız"
        totalMoney++
        txtCredit.text=totalMoney.toString()

    }
}
