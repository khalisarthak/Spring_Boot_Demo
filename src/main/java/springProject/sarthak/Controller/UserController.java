package springProject.sarthak.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springProject.sarthak.Entity.UserInformation;
import springProject.sarthak.Service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/home")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public ResponseEntity<String>addU(@RequestBody UserInformation user)
    {
        String msg = this.userService.addUser(user);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
    @GetMapping("/getId/{userId}")
    public ResponseEntity<UserInformation>getU(@PathVariable("userId")int id)
    {
        UserInformation userInformation=this.userService.getfromId(id);
        return new ResponseEntity<>(userInformation,HttpStatus.OK);

    }
    @PutMapping("/setname/{userId}")
    public ResponseEntity<String>setU(@PathVariable("userId")int id,@RequestBody UserInformation user){
        String message=this.userService.setUser(id,user);
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteData/{userId}")
    public ResponseEntity<String>deleteU(@PathVariable("userId")int id){
        String message=this.userService.deleteUser(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
