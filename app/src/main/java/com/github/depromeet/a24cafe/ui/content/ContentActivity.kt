package com.github.depromeet.a24cafe.ui.content

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import com.github.depromeet.a24cafe.R
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : AppCompatActivity(), Contract.View {

    private lateinit var presenter: ContentPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        init()
    }

    private fun init() {
        presenter = ContentPresenter()
        presenter.init(this, this)
        presenter.mapSetting()
        presenter.getData()

    }

    private fun getContentId(): Int {
        return intent.getIntExtra("id", 0)
    }

    override fun setMap(): LinearLayout {
        return content_map
    }

    override fun setText(title: String, content: String, createdAt: String) {
        runOnUiThread {
            content_title.text = title
            content_content.text = content
            content_submit_time.text = createdAt + " 작성"
        }
    }


    override fun onStop() {
        super.onStop()
        finish()
    }

}