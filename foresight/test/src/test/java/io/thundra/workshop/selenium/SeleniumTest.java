package io.thundra.workshop.selenium;

import io.thundra.workshop.common.Constants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeleniumTest extends SeleniumTestBase{


    public SeleniumTest() {
        super();
    }

    @BeforeAll
    public void initialize() {
        this.init(Objects.requireNonNull(Constants.WEB_CONTENT_RETRIEVER_URL));
        this.setBaseUrl(this.getBaseUrl().concat("/todo-app"));
    }

    @BeforeEach
    public void beforeEach() {

        this.setupDriver();

        driver.get(this.getBaseUrl());
        driver.manage().window();
    }

    @AfterEach
    public void destroy() {
        this.tearDown();
    }

    private void addTodo(String todo) {
        WebElement todoInput = this.getDriver().findElement(By.id("newTodo"));
        WebElement addButton = this.getDriver().findElement(By.id("newTodoSubmit"));

        if(todoInput == null || addButton == null) {
            throw new RuntimeException("Todo inputs are not found");
        }

        todoInput.sendKeys(todo);
        addButton.click();

        todoInput.clear();
        getScreenShot();
    }


    @Test
    @DisplayName("Test Connect Todo App")
    @Order(1)
    void testConnect(){
        String title = driver.getTitle();
        assertEquals("Thundra Todo App", title);
        getScreenShot();
    }


    @Test
    @DisplayName("Test Add Todo")
    @Order(2)
    void testAddTodo() {

        getScreenShot();
        this.addTodo("Test Todo");
        WebElement todoList = this.getDriver().findElement(new By.ByClassName("todo-list"));
        WebElement todoItem = todoList.findElement(new By.ByTagName("li"));

        assertNotNull(todoItem, "Todo item could not added");
        assertEquals("Test Todo", todoItem.getText());

    }

    @Test
    @DisplayName("Test Delete Todo")
    @Order(3)
    void testDeleteTodo() {
        this.addTodo("Test Todo");
        WebElement todoList = this.getDriver().findElement(new By.ByClassName("todo-list"));
        WebElement todoItem = todoList.findElement(new By.ByTagName("li"));
        WebElement deleteButton = todoItem.findElements(new By.ByTagName("span")).get(2);

        assertNotNull(deleteButton, "Delete button could not found");
        deleteButton.click();

        WebElement todoListAfterDelete = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterDelete.findElements(new By.ByTagName("li"));

        assertEquals(0, todoItems.size(), "Todo item could not deleted");
        getScreenShot();

    }

    @Test
    @DisplayName("Test Duplicate Todo")
    @Order(4)
    void testDuplicateTodo() {
        this.addTodo("Test Todo");
        WebElement todoList = this.getDriver().findElement(new By.ByClassName("todo-list"));
        WebElement todoItem = todoList.findElement(new By.ByTagName("li"));
        WebElement duplicateBtn = todoItem.findElements(new By.ByTagName("span")).get(1);

        assertNotNull(duplicateBtn, "Duplicate button could not found");
        duplicateBtn.click();

        WebElement todoListAfterDuplicate = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterDuplicate.findElements(new By.ByTagName("li"));

        assertEquals(2, todoItems.size(), "Todo item could not duplicated");
        getScreenShot();
    }

    @Test
    @DisplayName("Test Mark Todo as Completed")
    @Order(5)
    void testMarkCompleted(){
        this.addTodo("Test Todo");
        WebElement todoList = this.getDriver().findElement(new By.ByClassName("todo-list"));
        WebElement todoItem = todoList.findElement(new By.ByTagName("li"));

        WebElement checkBtn = todoItem.findElements(new By.ByTagName("span")).get(0);

        assertNotNull(checkBtn, "Check button could not found");
        checkBtn.click();

        WebElement todoListAfterMark = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterMark.findElements(new By.ByTagName("li"));
        WebElement todoItemAfterMark = todoItems.get(0);

        assertNotNull(todoItemAfterMark);
        assertTrue(todoItemAfterMark.getAttribute("class").contains("done"),
                "Todo item could not marked as completed");

        getScreenShot();
    }

    @Test
    @DisplayName("Test Clear All Todos")
    @Order(6)
    void testClearAllTodos() throws Exception {
        this.addTodo("Test Todo1");
        this.addTodo("Test Todo2");
        this.addTodo("Test Todo3");
        this.addTodo("Test Todo4");


        WebElement clearAllBtn = this.getDriver().findElement(By.id("clearAllBtn"));
        assertNotNull(clearAllBtn, "Clear All button could not found");

        clearAllBtn.click();

        WebElement todoListAfterClear = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterClear.findElements(new By.ByTagName("li"));

        assertEquals(0, todoItems.size(), "Todo item could not cleared");
        getScreenShot();
    }

    @Test
    @DisplayName("Test Mark All Todos as Completed")
    @Order(7)
    void testMarkAllTodosCompleted() {
        this.addTodo("Test Todo1");
        this.addTodo("Test Todo2");
        this.addTodo("Test Todo3");
        this.addTodo("Test Todo4");

        WebElement markAllBtn = this.getDriver().findElement(By.id("checkAllCompletedBtn"));
        assertNotNull(markAllBtn, "Mark All button could not found");

        markAllBtn.click();

        WebElement todoListAfterMark = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterMark.findElements(new By.ByTagName("li"));
        for(WebElement todoItem : todoItems){
            assertTrue(todoItem.getAttribute("class").contains("done"), "One of items could not marked as completed");
            getScreenShot();
        }
    }

    @Test
    @DisplayName("Test Clear Completed Todos")
    @Order(8)
    void testClearAllCompletedTodos()  {
        this.addTodo("Test Todo1");
        this.addTodo("Test Todo2");
        this.addTodo("Test Todo3");
        this.addTodo("Test Todo4");

        WebElement markAllBtn = this.getDriver().findElement(By.id("checkAllCompletedBtn"));
        assertNotNull(markAllBtn, "Mark All button could not found");

        markAllBtn.click();
        getScreenShot();


        WebElement clearCompletedBtn = this.getDriver().findElement(By.id("clearCompletedBtn"));
        assertNotNull(clearCompletedBtn, "Clear Completed button could not found");

        clearCompletedBtn.click();

        WebElement todoListAfterClear = this.getDriver().findElement(new By.ByClassName("todo-list"));
        List<WebElement> todoItems = todoListAfterClear.findElements(new By.ByTagName("li"));

        assertEquals(0, todoItems.size(), "Todo item could not cleared");
        getScreenShot();
    }

}
