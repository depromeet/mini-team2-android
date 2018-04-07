package com.github.depromeet.a24cafe.ui.splash

class SplashPresenter : Contract.Presenter {

    private lateinit var view: Contract.View

    override fun init(view: Contract.View) {
        this.view = view

        intentActivity()
    }

    private fun intentActivity() {


        try{
            Thread.sleep(2000)

        }catch (e: InterruptedException){
            e.printStackTrace()
        }

        view.finishSplash()
    }
}