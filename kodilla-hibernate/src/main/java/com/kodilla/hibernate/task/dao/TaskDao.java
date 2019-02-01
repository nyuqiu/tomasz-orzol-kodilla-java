package com.kodilla.hibernate.task.dao;

<<<<<<< HEAD
import com.kodilla.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {
    List<Task> findByDuration(int duration);
}
=======
public class TaskDao {
}
>>>>>>> 7f4463768ac0c647e98bb2fc7fd21a29fb7efa43
