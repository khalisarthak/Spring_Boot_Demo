package springProject.sarthak.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import springProject.sarthak.Entity.UserInformation;
import springProject.sarthak.Exception.ResourceNotFound;
import springProject.sarthak.Repository.UserRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public String addUser(UserInformation userInformation){
        this.userRepo.save(userInformation);

        return "user has been added";
        //return entityManager.createQuery("from "+entityClass.getSimpleName()+" ORDER BY id DESC",entityClass).setMaxResults(n).getResultList();
        //return "Data added successfully";
    }
    public UserInformation getfromId(int id)
    {
        UserInformation userInformation=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","id",id));
        return userInformation;
    }
    public String setUser(int id,UserInformation userInformation)
    {
       UserInformation userInformation1=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","id",id));
       userInformation1.setUserName(userInformation.getUserName());
       userInformation1.setUserAddress(userInformation.getUserAddress());
       userInformation1.setUserAge(userInformation.getUserAge());
       userInformation1.setUserEmail(userInformation.getUserEmail());
       userInformation1.setUserJob(userInformation.getUserJob());
       userInformation1.setUserNumber(userInformation.getUserNumber());
       this.userRepo.save(userInformation1);
       return "value updated";
    }
    public String deleteUser(int id)
    {
        UserInformation userInformation=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","id",id));
        this.userRepo.deleteById(id);
        return "User deleted successfully";
    }

}