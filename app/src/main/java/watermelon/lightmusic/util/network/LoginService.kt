package watermelon.lightmusic.util.network

import android.app.Application
import android.content.Context
import android.util.Log
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * description ： 设置用户登录cookie
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 19:15
 */
class LoginService(private val mContext: Context) : CookieJar {
    private val mCookieJar by lazy {
        PersistentCookieJar(
            SetCookieCache(), SharedPrefsCookiePersistor(
                mContext
            )
        )
    }


    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return mCookieJar.loadForRequest(url)
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        mCookieJar.saveFromResponse(url, cookies)
    }
}