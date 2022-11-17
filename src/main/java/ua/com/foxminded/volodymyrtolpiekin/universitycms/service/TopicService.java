package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Topic;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic addTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public Topic findById(Long id){
        return topicRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic Not Found"));
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Topic update(Topic topic){
        return topicRepository.save(topic);
    }

    public void deleteById(Long id){
        findById(id);
        topicRepository.deleteById(id);
    }
}
