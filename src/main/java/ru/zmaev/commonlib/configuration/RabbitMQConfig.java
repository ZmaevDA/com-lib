package ru.zmaev.commonlib.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.template.queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.template.exchange.name}")
    private String exchangeName;
    @Value("${spring.rabbitmq.template.binding.routing-key}")
    private String routingKey;

    @Bean
    public Queue buildQueue() {
        return new Queue(queueName);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplateCustomizer rabbitTemplateCustomizer(Jackson2JsonMessageConverter messageConverter) {
        return rabbitTemplate -> rabbitTemplate.setMessageConverter(messageConverter);
    }
}
