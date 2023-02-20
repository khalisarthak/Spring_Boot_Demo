package springProject.sarthak.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springProject.sarthak.Entity.UserInformation;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserInformation,Integer>{


}
