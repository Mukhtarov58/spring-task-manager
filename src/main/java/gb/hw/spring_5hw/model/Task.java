package gb.hw.spring_5hw.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity(name = "task")
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    String name;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column(name = "date_of_create")
    private String dateOfCreate;

    public Task() {
        this.status = TaskStatus.NOT_STARTED;
        this.dateOfCreate = ZonedDateTime.now().toString();
    }
}
