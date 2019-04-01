package com.henriquealrs.android.semana3_aula1

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() , LocationListener {
    override fun onLocationChanged(location: Location?) {
        location?.let {
            val latLng = LatLng(it.latitude, it.longitude)

            map.addMarker(MarkerOptions().position(latLng).title("New Position"))

            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17F))
        }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        Toast.makeText(this, "onStatusChanged $provider", Toast.LENGTH_LONG).show()
    }

    override fun onProviderEnabled(provider: String?) {

        Toast.makeText(this, "onProviderEnabled $provider", Toast.LENGTH_LONG).show()
    }

    override fun onProviderDisabled(provider: String?) {

        Toast.makeText(this, "onProviderDisabled $provider", Toast.LENGTH_LONG).show()
    }

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

        var bestLocation = locationManager.getLastKnownLocation(locationProvider)

        locationManager.allProviders.forEach {
            val checkLocation: Location? = locationManager.getLastKnownLocation(it)

            checkLocation?.let {
                if(bestLocation == null || bestLocation!!.accuracy < it.accuracy) {
                    bestLocation = it
                }
            }
        }

        bestLocation?.let {
            val latLng = LatLng(it.latitude, it.longitude)

            map.addMarker(MarkerOptions().position(latLng).title("GlobalCode"))

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17F))
        }

        locationManager.requestLocationUpdates(
            locationProvider,
            2000L,
            2F,
            this)
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