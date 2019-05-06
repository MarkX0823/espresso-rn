package com.espressotest

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.espressotest.EspressoViewFinder.waitForDisplayed
import com.espressotest.EspressoViewFinder.childAtIndex
import com.microsoft.appcenter.espresso.Factory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ListTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @get:Rule
    val reportHelper = Factory.getReportHelper()!!

    @Test
    fun test1() {
        waitForDisplayed(ViewMatchers.withContentDescription("myList1")) { scrollViewMatcher ->
            waitForDisplayed(childAtIndex(scrollViewMatcher, 0)) { scrollContentMatcher ->
                val scrollContentInteraction = Espresso.onView(scrollContentMatcher)
//                val baseCount = 2 // header and footer of the scrollView
                val baseCount = 0 // header and footer of the scrollView
                val expectedItemCount = 6
                scrollContentInteraction.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                scrollContentInteraction.check(ViewAssertions.matches(ViewMatchers.hasChildCount(baseCount + expectedItemCount)))
            }
        }
    }

    @After
    fun tearDown() {
        reportHelper.label("Stopping")
    }
}