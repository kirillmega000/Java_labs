package com.example.company.maina

import android.content.Context.LOCATION_SERVICE
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationProvider
import android.net.Network
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*




class DashboardFragment : Fragment() {
    private lateinit var locationManager:LocationManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    companion object {

        fun newInstance(): DashboardFragment {
            return DashboardFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        locationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager
        var locationListener:LocationListener=object:LocationListener{
           override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {
                if (provider == LocationManager.GPS_PROVIDER) {
                    if(status== LocationProvider.AVAILABLE)
                    GPS_en.setText("Enabled")
                    else GPS_en.setText("Disabled")
                } else if (provider == LocationManager.NETWORK_PROVIDER) {
                    if(status== LocationProvider.AVAILABLE)
                        Net_en.setText("Enabled")
                    else Net_en.setText("Disabled")
                } }
           override fun onLocationChanged(location: Location) {}

            override fun onProviderEnabled(provider: String?) {}

            override fun onProviderDisabled(provider: String?) {}
        }
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000 * 10, 10.toFloat(), locationListener)
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 1000 * 10, 10.toFloat(),
                    locationListener)
        } catch (e:SecurityException){
            e.printStackTrace()
        }
        checkEnabled()
        but_geo_set.setOnClickListener { startActivity( Intent(
                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)) }
    }
    private fun checkEnabled() {

            if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                GPS_en.setText("Enabled")
            else GPS_en.setText("Disabled")

            if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
                Net_en.setText("Enabled")
            else Net_en.setText("Disabled")
    }
}


