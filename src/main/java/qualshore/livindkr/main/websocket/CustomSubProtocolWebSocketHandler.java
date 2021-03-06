package qualshore.livindkr.main.websocket;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

import java.util.logging.Logger;

/**
 * Created by User on 19/02/2018.
 */

public class CustomSubProtocolWebSocketHandler extends SubProtocolWebSocketHandler {

  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomSubProtocolWebSocketHandler.class);

  @Autowired
  private SessionHandler sessionHandler;

  public CustomSubProtocolWebSocketHandler(MessageChannel clientInboundChannel, SubscribableChannel clientOutboundChannel) {
    super(clientInboundChannel, clientOutboundChannel);
  }


  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    LOGGER.info("New websocket connection was established");
    sessionHandler.register(session);
    super.afterConnectionEstablished(session);
  }
}
