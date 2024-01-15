package pd.example.demoprojectproblemtaskApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import pd.example.demoprojectproblemtaskApi.model.User;
import pd.example.demoprojectproblemtaskApi.repository.UserRepository;
import pd.example.demoprojectproblemtaskApi.repository.StatusRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<User> findAll() {
       return userRepository.findAll();

    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prahalladnayak2060@gmail.com");
        message.setTo(user.getEmail());
        message.setCc("prahallad.nayak@prodevans.com");
        message.setSubject("Complain raise by"+ user.getName());
        message.setText("YOUR Complain ID IS :"+ user.getId() + "\n\n" + "SORRY FOR THE INCONVENIENCE... "+ "We will come to you very soon...");
        javaMailSender.send(message);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("prahalladnayak2060@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("Your Complain about "+ user.getProblem()+" has changed status "+user.getStatus());
        message.setText("YOUR Complain ID IS :"+ user.getId() + "\n\n" + "Issue status changed to "+user.getStatus()+"\n\n"+"Thank you");
        javaMailSender.send(message);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        
    }

    @Override
    public User find(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findUser() {
        return userRepository.findAll();
    }
}
