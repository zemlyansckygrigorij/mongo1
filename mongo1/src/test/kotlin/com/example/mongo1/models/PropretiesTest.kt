package com.example.mongo1.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class PropretiesTest {

    private lateinit var propreties: Propreties
    @BeforeEach
    fun setUp() {
        propreties=Propreties(
                "MediaTek",
                    "4 GB",
                    "2 MP",
                    "2000 mAh",
                    "2.4 (6.1 cm)",
                      "512 MB")
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    @DisplayName("Should return the correct Performance")
    fun getPerformance() {
        val performance = propreties.performance
        assertThat(performance).isEqualTo("MediaTek")
    }

    @Test
    @DisplayName("Should return the correct storage")
    fun getStorage() {
        val storage = propreties.storage
        assertThat(storage).isEqualTo("4 GB")
    }

    @Test
    @DisplayName("Should return the correct camera")
    fun getCamera() {
        val camera = propreties.camera
        assertThat(camera).isEqualTo("2 MP")
    }

    @Test
    @DisplayName("Should return the correct battery")
    fun getBattery() {
        val battery = propreties.battery
        assertThat(battery).isEqualTo("2000 mAh")
    }

    @Test
    @DisplayName("Should return the correct display")
    fun getDisplay() {
        val display = propreties.display
        assertThat(display).isEqualTo("2.4 (6.1 cm)")
    }

    @Test
    @DisplayName("Should return the correct ram")
    fun getRam() {
        val ram = propreties.ram
        assertThat(ram).isEqualTo("512 MB")
    }
}