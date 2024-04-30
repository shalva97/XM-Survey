package io.github.shalva97.xm_survey

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.shalva97.xm_survey.domain.SurveyRepository
import io.github.shalva97.xm_survey.domain.models.Answer
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class LearningTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repo: SurveyRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun experimentingWithAPI() = runBlocking {
        println(repo)
        println(repo.get())
    }

    @Test
    fun experimentingWithAPI_postReq() = runBlocking {
        println(repo)
        println(
            repo.submit(
//            Answer(1, "Blue")
                Answer(1, "AAAAAAAAAAAAAAA")
            )
        )
        println("------------")
    }
}
