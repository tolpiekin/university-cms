package ua.com.foxminded.volodymyrtolpiekin.universitycms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Topic;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.repository.TopicRepository;
import ua.com.foxminded.volodymyrtolpiekin.universitycms.service.TopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic addTopic(Topic topic){
        return topicRepository.save(topic);
    }

    @Override
    public Topic findById(Long id){
        return topicRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic Not Found"));
    }

    @Override
    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    @Override
    public Topic update(Topic topic){
        return topicRepository.save(topic);
    }

    @Override
    public void deleteById(Long id){
        findById(id);
        topicRepository.deleteById(id);
    }
}
