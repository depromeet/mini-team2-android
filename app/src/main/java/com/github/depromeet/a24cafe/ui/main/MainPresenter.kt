package com.github.depromeet.a24cafe.ui.main

import android.content.Context
import android.content.Intent
import com.github.depromeet.a24cafe.adapter.MainAdapter
import com.github.depromeet.a24cafe.adapter.MainAdapterContract
import com.github.depromeet.a24cafe.api.boardApi
import com.github.depromeet.a24cafe.api.extentions.plusAssign
import com.github.depromeet.a24cafe.ui.metroContent.MetroContentActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class MainPresenter : Contract.Presenter {

    private lateinit var view: Contract.View
    private lateinit var context: Context

    private lateinit var mainAdapterModel: MainAdapterContract.Model
    private lateinit var mainAdapterView: MainAdapterContract.View

    internal val disposables = CompositeDisposable()
    internal val api by lazy { boardApi() }

    override fun init(view: Contract.View, context: Context) {
        this.view = view
        this.context = context
    }

    override fun getListData() {

        val adapter = MainAdapter(context) {
            val intent = Intent(context, MetroContentActivity::class.java)
            intent.putExtra("boardId", it)
            context.startActivity(intent)

        }

        view.setList().adapter = adapter
        mainAdapterModel = adapter
        mainAdapterView = adapter

        getData()

    }
    // 데이터 받아오기
    private fun getData() {

        disposables += api.getMainBoardList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mainAdapterModel.addItem(it)
                    mainAdapterView.notifyChange()
                }) {
                    it.printStackTrace()
                }

    }

}