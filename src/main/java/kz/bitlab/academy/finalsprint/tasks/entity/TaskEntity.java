package kz.bitlab.academy.finalsprint.tasks.entity;

import jakarta.persistence.*;
import kz.bitlab.academy.finalsprint.folders.entity.FolderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status", nullable = false)
    private int status = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id", nullable = false)
    private FolderEntity folder;

    public TaskEntity(String title, String description, FolderEntity folder) {
        this.title = title;
        this.description = description;
        this.folder = folder;
    }

}
