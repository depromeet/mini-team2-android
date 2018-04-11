package com.github.depromeet.a24cafe.ui.content

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
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
        presenter.getData(getBoardId(), getPostId())

    }

    private fun getBoardId(): Int {
        return intent.getIntExtra("boardId", 0)
    }

    private fun getPostId(): Int{
        return intent.getIntExtra("postId", 0)
    }

    override fun setMap(): LinearLayout {
        return content_map
    }

    override fun setText(title: String, content: String, createdAt: String, phone: String?, time: String?, exit: String?) {
        runOnUiThread {
            content_title.text = title
            content_content.text = content
            content_submit_time.text = createdAt + " 작성"
            content_tel.text = phone
            content_opentime.text = time
            content_metro_location.text = exit

            Log.e("test", "$title $content, $createdAt ")
        }
    }


    override fun onStop() {
        super.onStop()
        finish()
    }

}
