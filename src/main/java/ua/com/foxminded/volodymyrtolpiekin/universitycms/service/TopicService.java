package ua.com.foxminded.volodymyrtolpiekin.universitycms.service;

import ua.com.foxminded.volodymyrtolpiekin.universitycms.models.Topic;

import java.util.List;

public interface TopicService {
    Topic addTopic(Topic topic);

    Topic findById(Long id);

    List<Topic> findAll();

    Topic update(Topic topic);

    void deleteById(Long id);
}
