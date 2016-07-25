package demo.producer

import java.util.Properties

import demo.config.DemoConfig
import org.apache.kafka.clients.producer.KafkaProducer

object MessageProducer {

  def apply() = {
    val props = new Properties()
    props.put("bootstrap.servers", DemoConfig.Kafka.bootstrapServers)
    props.put("acks", "all")
    props.put("key.serializer", DemoConfig.Kafka.keySerializer)
    props.put("value.serializer", DemoConfig.Kafka.valueSerializer)
    new KafkaProducer[String, String](props)
  }

}
