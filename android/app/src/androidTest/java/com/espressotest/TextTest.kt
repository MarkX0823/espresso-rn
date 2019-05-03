package com.espressotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.espressotest.EspressoViewFinder.childAtIndex
import com.espressotest.EspressoViewFinder.waitForDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TextTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {
        waitForDisplayed(withContentDescription("myText1")) {
            textView -> onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test2() {
        waitForDisplayed(withContentDescription("myText2")) {
            textView -> onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test3() {
        waitForDisplayed(withContentDescription("myText3")) {
            textView -> onView(textView).check(matches(isDisplayed()))
        }
    }

    @Test
    fun test4() {
        waitForDisplayed(withContentDescription("myList1")) {
            scrollViewMatcher ->
            waitForDisplayed(childAtIndex(scrollViewMatcher, 0)) {
                scrollContentMatcher ->
                val scrollContentInteraction = onView(scrollContentMatcher)
//                val baseCount = 2 // header and footer of the scrollView
                val baseCount = 0 // header and footer of the scrollView
                val expectedItemCount = 6
                scrollContentInteraction.check(matches(isDisplayed()))
                scrollContentInteraction.check(matches(hasChildCount(baseCount + expectedItemCount)))
            }
        }
    }
}
