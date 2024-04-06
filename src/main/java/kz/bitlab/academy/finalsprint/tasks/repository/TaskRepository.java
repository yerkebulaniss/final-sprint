package kz.bitlab.academy.finalsprint.tasks.repository;

import kz.bitlab.academy.finalsprint.tasks.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByFolderIdOrderById(Long folderId);

    void deleteAllByFolderId(Long folderId);

}
