package com.example.lovekwalmartcode.domain.use_case

import com.example.lovekwalmartcode.data.remote.dto.CountryItemDto
import com.example.lovekwalmartcode.data.remote.dto.toCountryItem
import com.example.lovekwalmartcode.data.repository.Repository
import com.example.lovekwalmartcode.domain.use_case.get_all_countries.GetAllCountriesUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetAllCountriesUseCaseTest {

    @Mock
    private lateinit var repository: Repository

    private lateinit var getAllCountriesUseCase: GetAllCountriesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getAllCountriesUseCase = GetAllCountriesUseCase(repository)
    }

    @Test
    fun testInvokeSuccessful() = runBlocking {
        val mockCountriesDto = listOf(
            CountryItemDto("Paris", "FR", "French", "...", "France", "Europe"),
        )
        val mockCountries = mockCountriesDto.map { it.toCountryItem() }
        `when`(repository.getCountries()).thenReturn(mockCountriesDto)

        val result = getAllCountriesUseCase.invoke()

        assertEquals(mockCountries, result)
    }

    @Test(expected = Exception::class)
    fun testInvokeFailure(): Unit = runBlocking {
        `when`(repository.getCountries()).thenThrow(Exception())

        getAllCountriesUseCase.invoke()
    }
}
