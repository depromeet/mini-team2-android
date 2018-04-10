package com.github.depromeet.a24cafe.ui.content

import android.content.Context
import android.graphics.BitmapFactory
import com.github.depromeet.a24cafe.R
import com.skt.Tmap.TMapMarkerItem
import com.skt.Tmap.TMapPoint
import com.skt.Tmap.TMapView

class ContentPresenter: Contract.Presenter{

    private lateinit var view: Contract.View
    private lateinit var context: Context

    override fun init(view: Contract.View, context: Context) {
        this.view = view
        this.context = context
    }

    // 지도
    override fun mapSetting() {

        val lng: Double = 126.923697
        val lat: Double = 37.557146

        val tMapView = TMapView(context)
        tMapView.setSKTMapApiKey(context.resources.getString(R.string.tmap_key))
        tMapView.setCenterPoint(lng,lat )
        tMapView.zoomLevel = 17

        tMapView.addMarkerItem("스타벅스",markerOption(lat, lng, "스타벅스"))

        view.setMap().addView(tMapView)
        
    }

    private fun markerOption(lat: Double, lng: Double, title: String): TMapMarkerItem{
        val marker: TMapMarkerItem = TMapMarkerItem()
        val point: TMapPoint = TMapPoint(lat, lng)

        // 마커 아이콘
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_launcher_background)
        marker.setIcon(bitmap) // 마커 아이콘 지정
        marker.setPosition(0.5f, 1.0f) // 마커의 중심점을 중앙, 하단으로 설정
        marker.setTMapPoint(point) // 마커의 좌표 지정
        marker.setName(title) // 마커의 타이틀 지정

        return marker
    }
}