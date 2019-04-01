package com.henriquealrs.android.semana3_aula1

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val supportMapFragment = supportFragmentManager.findFragmentById((R.id.map)) as SupportMapFragment

        supportMapFragment.getMapAsync {
            map = it
            val latitude = -23.5739861
            val longitude = -46.6441447

            val latLng = LatLng(latitude, longitude)

            val addMarker = it.addMarker(MarkerOptions().position(latLng).title("GlobalCode"))
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17F))
            startLocation()
        }
    }

    private fun startLocation() {

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val locationProvider = LocationManager.NETWORK_PROVIDER

        val bestLocation = locationManager.getLastKnownLocation(locationProvider)

        val latLng = LatLng(bestLocation.latitude, bestLocation.longitude)

        map.addMarker(MarkerOptions().position(latLng).title("GlobalCode"))

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17F))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> if (grantResults[0] == PERMISSION_GRANTED) {
                startLocation()
            }
        }
    }

}