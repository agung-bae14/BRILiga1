package com.example.ligasatu

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ligasatu.MainActivity.Companion.DATA_CLUB
import com.example.ligasatu.databinding.ActivityDetailClubBinding

class DetailClub : AppCompatActivity(), View.OnClickListener {
    private lateinit var gambar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_club)

        val btnDialPhone:ImageView = findViewById(R.id.action_share)
        btnDialPhone.setOnClickListener(this)

        val  dataclub = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Club>("key_club", Club::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Club>("key_club")
        }
            val name = findViewById<TextView>(R.id.nama_detail1)
            val name1 = findViewById<TextView>(R.id.nama_detail)
            val since = findViewById<TextView>(R.id.berdiri_detail)
            val manager = findViewById<TextView>(R.id.manager_detail)
            val coach = findViewById<TextView>(R.id.pelatih_detail)
            val stadium = findViewById<TextView>(R.id.stadion_detail)
            val location = findViewById<TextView>(R.id.lokasi_detail)
            val description = findViewById<TextView>(R.id.desk_detail)
            val logo = findViewById<ImageView>(R.id.logo_detail)
            val photo = findViewById<ImageView>(R.id.img_detail)

            name.text = dataclub?.name
            name1.text = dataclub?.name
            since.text = dataclub?.since
            manager.text = dataclub?.manager
            coach.text = dataclub?.coach
            stadium.text = dataclub?.stadium
            location.text = dataclub?.location
            description.text = dataclub?.description
            Glide.with(this)
                .load(dataclub?.logo)
                .into(logo)
            Glide.with(this)
                .load(dataclub?.photo)
                .into(photo)

        gambar = findViewById(R.id.nama_detail1)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "$gambar")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }

    }

}