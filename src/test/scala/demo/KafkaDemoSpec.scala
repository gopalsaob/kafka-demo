package demo

import demo.producer.MessageProducer
import net.manub.embeddedkafka.EmbeddedKafka
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.scalatest.{FreeSpec, Matchers}

class KafkaDemoSpec extends FreeSpec with Matchers with EmbeddedKafka {

  "Given A Kafka server " - {

    "test producer" in {
      val topicName: String = "testProducer"
      implicit val deserializer = new StringDeserializer
      withRunningKafka {
        createCustomTopic(topic = topicName)
        val producer = MessageProducer()
        val producerRecord = new ProducerRecord(topicName, "messageKey", "TestingProducer")
        producer.send(producerRecord)
        producer.close()
        consumeFirstMessageFrom[String](topicName)
      } should be ("TestingProducer")
    }

    // Need to integrate with Actor based consumer, evaluate
    // 1. http://www.cakesolutions.net/teamblogs/getting-started-with-kafka-using-scala-kafka-client-and-akka
    // 2. https://github.com/sclasen/akka-kafka
    "test consumer " ignore {
      val topicName: String = "testConsumer"
      withRunningKafka {
        createCustomTopic(topic = topicName)
        publishStringMessageToKafka(topicName, "TestingConsumer")
        None
      } should be (Some("TestingConsumer"))
    }
  }
}
