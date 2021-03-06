package com.newgram.s2oul_android.data.repository

import com.newgram.s2oul_android.data.source.showDetail.ShowDetailSource
import com.newgram.s2oul_android.data.source.showDetail.ShowDetailSourceImpl
import com.newgram.s2oul_android.entity.ShowDetail
import io.reactivex.Flowable

object ShowDetailRepository: ShowDetailSource{

    private val dataSource = ShowDetailSourceImpl

    override fun loadShow(showId: String): Flowable<ShowDetail> =
        dataSource.loadShow(showId)
}