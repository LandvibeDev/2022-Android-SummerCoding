package kr.co.landvibe.retrofit_example_week_6.remote

import kr.co.landvibe.retrofit_example_week_6.dto.HPCharacter
import retrofit2.Response

/*
* Created by JJJoonngg
*/

class HPRepository {
    suspend fun getHPCharacters(): Response<HPCharacter> {
        return RetrofitHelper.hpService.getHPCharacters()
    }
}