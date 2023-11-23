package com.example.ligasatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var rvClub:RecyclerView
    private val list = ArrayList<Club>()

    companion object{
        val DATA_CLUB = "ID KEY FOOD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClub =findViewById(R.id.rv_club)
        rvClub.setHasFixedSize(true)

        list.addAll(getListClub())
        showRecycleList()

        supportActionBar?.title="Liga 1"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.person -> {
                val intent = Intent(this@MainActivity, ProfileMenu::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListClub(): ArrayList<Club> {
        val namaClub = resources.getStringArray(R.array.nama_club)
        val berdiri = resources.getStringArray(R.array.berdiri)
        val manager = resources.getStringArray(R.array.manager)
        val pelatih = resources.getStringArray(R.array.pelatih)
        val stadion = resources.getStringArray(R.array.stadion)
        val lokasi = resources.getStringArray(R.array.lokasi)
        val deskripsi = resources.getStringArray(R.array.desk)
        val logoClub = resources.getStringArray(R.array.logo_club)
        val gambarClub = resources.getStringArray(R.array.gambar_club)

        val listClub =ArrayList<Club>()
        for (i in namaClub.indices){
            val club = Club(namaClub[i], berdiri[i], manager[i], pelatih[i], stadion[i], lokasi[i], deskripsi[i], logoClub[i], gambarClub[i])
            listClub.add(club)
        }
        return listClub
    }
    private fun showRecycleList() {
        rvClub.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(list)
        rvClub.adapter = listClubAdapter

//        listClubAdapter.setOnItemCallback(object : ListClubAdapter.OnItemCallback {
//            override fun onItemClicked(data: Club) {
//                val intentDetail = Intent(this@MainActivity, DetailClub::class.java)
//                intentDetail.putExtra(DATA_CLUB, data)
//                startActivity(intentDetail)
////                showSelectedHero(data)
//            }
//        })
    }

//    private fun showSelectedHero(club: Club) {
//        Toast.makeText(this, "Kamu memilih " + club.coach, Toast.LENGTH_SHORT).show()
//    }
}