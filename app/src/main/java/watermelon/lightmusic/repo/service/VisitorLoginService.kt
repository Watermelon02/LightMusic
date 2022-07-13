package watermelon.lightmusic.repo.service

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * author : Watermelon02
 * email : 1446157077@qq.com
 * date : 2022/6/20 10:50
 */
interface VisitorLoginService {
    @GET("/register/anonimous")
    suspend fun visitorLogin():Any?
}