package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Topic;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Optional<Topic> addTopic(Topic topic){
        topicRepository.save(topic);
        return topicRepository.findById(topic.getId());
    }

    public Optional<Topic> findById(Long id){
        try {
            return Optional.of(topicRepository.findById(id)).orElseThrow(()->new TopicNotFoundException(id));
        }
        catch (TopicNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic Not Found", exc);
        }
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public Optional<Topic> update(Long id,Topic topic){
        topic.setId(id);
        topicRepository.save(topic);
        return topicRepository.findById(id);
    }

    public void deleteById(Long id){
        try {
            Optional.of(topicRepository.findById(id)).orElseThrow(()->new TopicNotFoundException(id));
        }
        catch (TopicNotFoundException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic Not Found", exc);
        }
        topicRepository.deleteById(id);
    }
}
