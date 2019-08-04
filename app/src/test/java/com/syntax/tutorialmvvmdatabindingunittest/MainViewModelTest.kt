package com.syntax.tutorialmvvmdatabindingunittest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.syntax.tutorialmvvmdatabindingunittest.model.ValueGenerator
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var mockValue: ValueGenerator

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(mockValue)
    }

    @Test
    fun testIsNotEmptyField() {
        viewModel.valueA = 1
        viewModel.valueB = 2
        viewModel.valueC = 3
        viewModel.name = "Fiqri Kece"
        val isNotEmpty = viewModel.isNotEmptyField()
        Assert.assertEquals(true, isNotEmpty)
    }
}