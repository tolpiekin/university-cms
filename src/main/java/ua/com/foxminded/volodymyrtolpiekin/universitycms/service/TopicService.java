package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Topic;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Optional<Topic> addTopic(Topic topic){
        return Optional.of(topicRepository.save(topic));
    }

    public Optional<Topic> findById(Long id){
        return topicRepository.findById(id);
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
        topicRepository.deleteById(id);
    }
}
