package io.github.shalva97.xm_survey.domain

import io.github.shalva97.xm_survey.domain.models.Answer
import io.github.shalva97.xm_survey.domain.models.Question

class SurveyRepositoryFake : SurveyRepository {
    override suspend fun get(): List<Question> {
        return listOf(
            Question(1, "What is the capital of France?"),
            Question(2, "Who wrote 'To Kill a Mockingbird'?"),
            Question(3, "What is the smallest prime number?"),
            Question(4, "What is the chemical symbol for gold?"),
            Question(5, "What year did World War II end?"),
            Question(6, "Who painted the Mona Lisa?"),
            Question(7, "What is the tallest mountain in the world?"),
            Question(8, "What is the square root of 144?"),
            Question(9, "Who discovered penicillin?"),
            Question(10, "Which planet is known as the Red Planet?"),
            Question(11, "What is the main ingredient in guacamole?"),
            Question(12, "Who is the author of the 'Harry Potter' series?"),
            Question(13, "What is the hardest naturally occurring mineral?"),
            Question(14, "Which element has the atomic number 1?"),
            Question(15, "What is the longest river in the world?"),
            Question(16, "Which country hosted the 2016 Summer Olympics?"),
            Question(17, "Who invented the light bulb?"),
            Question(18, "What is the speed of light in a vacuum?"),
            Question(19, "What language is primarily spoken in Brazil?"),
            Question(20, "Which composer wrote the 'Fifth Symphony'?")
        )
    }

    override suspend fun submit(questions: Answer) {
        throw android.net.http.HttpException("Things are bad", null)
    }
}
