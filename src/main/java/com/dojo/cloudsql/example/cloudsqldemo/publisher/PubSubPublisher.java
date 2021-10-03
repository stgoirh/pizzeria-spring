package com.dojo.cloudsql.example.cloudsqldemo.publisher;

import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class PubSubPublisher {
	// TODO: parametrizar
	private String projectId = "stgo-327618";
	private String topicId = "testPubSub";

	public String publicarMensaje(String mensaje) {
		TopicName topic = TopicName.of(projectId, topicId);
			Publisher publisher = null;
		try {
			
			publisher = Publisher.newBuilder(topic).build();
			ByteString data = ByteString.copyFromUtf8(mensaje);

			PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

			// caundo se publica retorna id
			ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
			String messageId = messageIdFuture.get();
			return messageId;
		} catch (Exception e) {
			return "no se ha podido publicar mensaje";
		}
	}
}
