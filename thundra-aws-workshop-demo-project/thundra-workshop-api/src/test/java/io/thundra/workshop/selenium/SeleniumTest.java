package io.thundra.workshop.selenium;


import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest extends SeleniumTestBase{

    public SeleniumTest() {
        super();

        String flow1Url = System.getenv("FLOW1_URL");
    }

    @BeforeAll
    public void setUp() {
        this.init();
    }

    @Test
    @DisplayName("Connect Todo App")
    @Order(1)
    public void testConnect(){
        //
    }

    @Test
    @DisplayName("Add Todo")
    @Order(2)
    public void testAddTodo() {
        //
    }

    @Test
    @DisplayName("Delete Todo")
    @Order(3)
    public void testDeleteTodo() {
        //
    }

    @Test
    @DisplayName("Duplicate Todo")
    @Order(4)
    public void testUpdateTodo() {
        //
    }
    
}
