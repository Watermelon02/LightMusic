package watermelon.lightmusic.base

import android.app.Application
import android.content.Context
import watermelon.lightmusic.repo.databse.MusicDatabase
import watermelon.lightmusic.repo.service.VisitorLoginService
import watermelon.lightmusic.util.network.ApiGenerator

/**
 * description ： TODO:类的作用
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 19:41
 */
class BaseApp: Application() {
    companion object {
        lateinit var appContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        appContext = this
        ApiGenerator.init(applicationContext)
        MusicDatabase.createInstance(this)
    }
}