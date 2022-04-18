package br.com.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;


public class LogService {
    public static void main(String[] args) {
        var logService = new LogService();
        var service = new KafkaService(LogService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER", logService::parse);

        service.run();
    }


    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------------");
        System.out.println("LOG: " + record.topic());
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
    }
}
