package gb.hw.spring_5hw.service;

import gb.hw.spring_5hw.model.Task;
import gb.hw.spring_5hw.model.TaskStatus;
import gb.hw.spring_5hw.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;


/**
 * Сервисный класс для выполнения операций с задачами.
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Добавляет новую задачу.
     *
     * @param task Новая задача
     * @return Добавленная задача
     */
    public Task addTask(Task task) {
        task.setDateOfCreate(ZonedDateTime.now().toString());
        return taskRepository.save(task);
    }

    /**
     * Возвращает список всех задач.
     *
     * @return Список всех задач
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Возвращает список задач по их статусу.
     *
     * @param status Статус задачи
     * @return Список задач с указанным статусом
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Обновляет статус задачи.
     *
     * @param id     Идентификатор задачи
     * @param status Новый статус задачи
     * @return Обновленная задача
     */
    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        task.setStatus(status);
        return taskRepository.save(task);
    }

    /**
     * Удаляет задачу по её идентификатору.
     *
     * @param id Идентификатор задачи
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}