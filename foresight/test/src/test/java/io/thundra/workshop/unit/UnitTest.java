package io.thundra.workshop.unit;

import io.thundra.workshop.controller.WorkshopController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UnitTest {

    private WorkshopController controller;

    @BeforeAll
    void init() {
        controller = new WorkshopController();
    }

    @Test
    @DisplayName("Test for dummy")
    void testDummy() {
        assertEquals("dummy", controller.dummy());
    }

    @Test
    @DisplayName("Test for index")
    void testIndex() {

        assertEquals("index", controller.index());
    }

    @Test
    @DisplayName("Test for hello")
    void testHello() {
        assertEquals("hello", controller.post("hello"));
    }
}