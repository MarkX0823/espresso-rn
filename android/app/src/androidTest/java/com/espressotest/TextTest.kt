package com.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.espressotest.EspressoViewFinder.waitForDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TextTest {

    val STRING_TO_BE_TYPED = "Espresso!!!"

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {
        waitForDisplayed(withContentDescription("myText1")) { textView ->
            onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test2() {
        waitForDisplayed(withContentDescription("myText2")) { textView ->
            onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test3() {
        waitForDisplayed(withContentDescription("myText3")) { textView ->
            onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test4() {
        waitForDisplayed(withText("Test")) { textView ->
            onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test5() {
        waitForDisplayed(withContentDescription("myText5")) { editText ->
            onView(editText).perform(replaceText(STRING_TO_BE_TYPED), closeSoftKeyboard())
            onView(editText).check(matches(withText(STRING_TO_BE_TYPED)))
        }
    }
}
