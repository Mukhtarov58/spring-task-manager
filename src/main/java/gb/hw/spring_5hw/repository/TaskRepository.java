package gb.hw.spring_5hw.repository;

import gb.hw.spring_5hw.model.Task;
import gb.hw.spring_5hw.model.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
