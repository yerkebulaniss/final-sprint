package kz.bitlab.academy.finalsprint.folders.entity;

import jakarta.persistence.*;
import kz.bitlab.academy.finalsprint.categories.entity.CategoryEntity;
import kz.bitlab.academy.finalsprint.tasks.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FolderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "folders_categories",
            joinColumns = @JoinColumn(name = "folder_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> categories;

    @OneToMany
    @JoinTable(name = "tasks",
            joinColumns = @JoinColumn(name = "folder_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<TaskEntity> tasks;

    public FolderEntity(String name) {
        this.name = name;
    }

    @Transient
    public void addCategory(CategoryEntity category) {
        if (this.categories == null)
            this.categories = new ArrayList<>();

        this.categories.add(category);
    }

}
