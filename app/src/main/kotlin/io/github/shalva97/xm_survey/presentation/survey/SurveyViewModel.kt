package io.github.shalva97.xm_survey.presentation.survey

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.shalva97.xm_survey.presentation.models.QuestionUI
import javax.inject.Inject

@HiltViewModel
class SurveyViewModel @Inject constructor() : ViewModel() {

    fun submitAnswer(id: Int, answer: String) {
        println(answer)
//        TODO("Not yet implemented")
    }

    val questions = listOf(
        QuestionUI(1, "What is the capital of France?"),
        QuestionUI(2, "Who wrote 'To Kill a Mockingbird'?"),
        QuestionUI(3, "What is the smallest prime number?"),
        QuestionUI(4, "What is the chemical symbol for gold?"),
        QuestionUI(5, "What year did World War II end?"),
        QuestionUI(6, "Who painted the Mona Lisa?"),
        QuestionUI(7, "What is the tallest mountain in the world?"),
        QuestionUI(8, "What is the square root of 144?"),
        QuestionUI(9, "Who discovered penicillin?"),
        QuestionUI(10, "Which planet is known as the Red Planet?"),
        QuestionUI(11, "What is the main ingredient in guacamole?"),
        QuestionUI(12, "Who is the author of the 'Harry Potter' series?"),
        QuestionUI(13, "What is the hardest naturally occurring mineral?"),
        QuestionUI(14, "Which element has the atomic number 1?"),
        QuestionUI(15, "What is the longest river in the world?"),
        QuestionUI(16, "Which country hosted the 2016 Summer Olympics?"),
        QuestionUI(17, "Who invented the light bulb?"),
        QuestionUI(18, "What is the speed of light in a vacuum?"),
        QuestionUI(19, "What language is primarily spoken in Brazil?"),
        QuestionUI(20, "Which composer wrote the 'Fifth Symphony'?")
    )
}
