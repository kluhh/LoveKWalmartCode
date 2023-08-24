package com.example.lovekwalmartcode.presentation

import com.example.lovekwalmartcode.domain.model.CountryItem
import com.example.lovekwalmartcode.presentation.countries.CountriesAdapter
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class CountriesAdapterTest {

    private lateinit var countriesAdapter: CountriesAdapter

    @Before
    fun setUp() {
        val mockCountries = listOf(
            CountryItem("Walmart", "WM", "All", "...", "Everywhere", "Everywhere"),
            CountryItem("Paris", "FR", "French", "...", "France", "Europe"),
        )
        countriesAdapter = CountriesAdapter(mockCountries)
    }

    @Test
    fun testItemCount() {
        val expectedCount = 2  // adjust based on the number of mock countries added
        val actualCount = countriesAdapter.itemCount
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun testBindViewHolder() {
        val mockViewHolder = mock<CountriesAdapter.CountryViewHolder>()
        val position = 0

        countriesAdapter.onBindViewHolder(mockViewHolder, position)


    }
}
