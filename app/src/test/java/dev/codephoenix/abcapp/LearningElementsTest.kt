package dev.codephoenix.abcapp

import dev.codephoenix.abcapp.data.LearningElements
import dev.codephoenix.abcapp.di.learningElementsModule
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito.verify

class LearningElementsTest : KoinTest {

    val learningElements: LearningElements by inject()
    val abcList: ArrayList<String> = ArrayList()


    @Before
    fun before() {
        
        startKoin { modules(learningElementsModule) }
        declareMock<LearningElements>()
        
    }
    @Test
    fun testLearningElementAdded() {
        learningElements.addAlphabet(abcList)

        verify(learningElements).addAlphabet(abcList)

    }

}