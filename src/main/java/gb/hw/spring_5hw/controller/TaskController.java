package gb.hw.spring_5hw.controller;

import gb.hw.spring_5hw.model.Task;
import gb.hw.spring_5hw.model.TaskStatus;
import gb.hw.spring_5hw.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контроллер для управления задачами.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * Добавляет новую задачу.
     *
     * @param task Новая задача
     * @return Добавленная задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * Возвращает список всех задач.
     *
     * @return Список всех задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Возвращает список задач по их статусу.
     *
     * @param status Статус задачи
     * @return Список задач с указанным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    /**
     * Обновляет статус задачи на "IN_PROGRESS".
     *
     * @param id Идентификатор задачи
     * @return Обновленная задача
     */
    @PutMapping("/{id}/start")
    public Task startTask(@PathVariable Long id) {
        return taskService.updateTaskStatus(id, TaskStatus.IN_PROGRESS);
    }

    /**
     * Обновляет статус задачи на "COMPLETED".
     *
     * @param id Идентификатор задачи
     * @return Обновленная задача
     */
    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        return taskService.updateTaskStatus(id, TaskStatus.COMPLETED);
    }

    /**
     * Удаляет задачу по её идентификатору.
     *
     * @param id Идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}