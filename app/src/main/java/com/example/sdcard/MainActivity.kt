package com.example.sdcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a:EditText=findViewById(R.id.name)
        val a2:EditText=findViewById(R.id.cg)
        val btSave:Button=findViewById(R.id.b1)
        val btLoad:Button=findViewById(R.id.b2)
        btSave.setOnClickListener{
            val name=a.text.toString()
            val cgpa=a2.text.toString()
            val file=File(getExternalFilesDir(null),"student.txt")
            val fos=FileOutputStream(file,false)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            a.setText("")
            a2.setText("")
            Toast.makeText(this@MainActivity,"Info loaded",Toast.LENGTH_LONG)
    }
        btLoad.setOnClickListener{
            val file= File(getExternalFilesDir(null),"student.txt")
            val fis=FileInputStream(file)
            val isr=InputStreamReader(fis)
            val br=BufferedReader(isr)
            val line : String
            line =br.readLine()
            var parts = line.split(",")
            a.setText(parts[0])
            a2.setText(parts[1])
            Toast.makeText(this@MainActivity,"Info loaded",Toast.LENGTH_LONG)
        }