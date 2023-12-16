package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView

    var places = arrayOf("Gol Ghumat", "Char Minar", "Taj Hotel", "Taj Mahal", "CST")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)
        val placename = findViewById<TextView>(R.id.tVName)

        next.setOnClickListener {
            //Jump to next image
            var idCurrentImageString = "pic$currentImage"

            //Get the INTEGER address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage+1)%5

            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placename.text = places[currentImage]

        }

        prev.setOnClickListener {
            //Jump to previous image
            var idCurrentImageString = "pic$currentImage"

            //Get the INTEGER address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (5+currentImage-1)%5

            var idImageToShowString = "pic"+currentImage
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placename.text = places[currentImage]

        }


    }
}