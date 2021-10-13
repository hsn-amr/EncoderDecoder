package com.example.encoderdecoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RVEncryption
    lateinit var rvMain: RecyclerView
    lateinit var textForEncodeInput: EditText
    lateinit var encodeButton: Button
    lateinit var textForDecodeInput: EditText
    lateinit var decodeButton: Button

    var textList = ArrayList<Encryption>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)

        textForEncodeInput = findViewById(R.id.etEncode)
        encodeButton = findViewById(R.id.btnEncode)
        encodeButton.setOnClickListener {
            if(textForEncodeInput.text.isNotEmpty()){
                val e = Encryption(textForEncodeInput.text.toString())
                e.encode()
                textList.add(e)

                rvMain.adapter!!.notifyDataSetChanged()
                textForEncodeInput.text.clear()
            }else{
                Toast.makeText(this, "Please, Enter a text", Toast.LENGTH_LONG).show()
            }
        }

        textForDecodeInput = findViewById(R.id.etDecode)
        decodeButton = findViewById(R.id.btnDecode)
        decodeButton.setOnClickListener {
            if(textForDecodeInput.text.isNotEmpty()){
                val e = Encryption(textForDecodeInput.text.toString())
                e.decode()
                textList.add(e)

                rvMain.adapter!!.notifyDataSetChanged()
                textForDecodeInput.text.clear()
            }else{
                Toast.makeText(this, "Please, Enter a text", Toast.LENGTH_LONG).show()
            }
        }


        adapter = RVEncryption(textList)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)
    }
}