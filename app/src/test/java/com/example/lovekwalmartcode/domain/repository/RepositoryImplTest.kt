package com.example.lovekwalmartcode.domain.repository

import com.example.lovekwalmartcode.data.remote.CountriesApi
import com.example.lovekwalmartcode.data.remote.dto.CountryItemDto
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RepositoryImplTest {

    @Mock
    private lateinit var countriesApi: CountriesApi

    private lateinit var repository: RepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = RepositoryImpl(countriesApi)
    }

    @Test
    fun testGetCountriesSuccessful() = runBlocking {
        val mockCountries = listOf(
            CountryItemDto("Walmart", "WM", "All", "...", "Walmart", "Everywhere"),
        )
        `when`(countriesApi.getCountries()).thenReturn(mockCountries)

        val result = repository.getCountries()

        assertEquals(mockCountries, result)
    }

    @Test(expected = Exception::class)
    fun testGetCountriesFailure(): Unit = runBlocking {
        `when`(countriesApi.getCountries()).thenThrow(Exception())

        repository.getCountries()
    }

}
