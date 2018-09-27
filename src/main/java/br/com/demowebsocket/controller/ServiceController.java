package br.com.demowebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.demowebsocket.model.ChatMessage;
import br.com.demowebsocket.model.ChatMessage.MessageType;
import br.com.demowebsocket.model.WSMessage;
import br.com.demowebsocket.util.ValidatorUtils;

@RestController
@RequestMapping("/message")
public class ServiceController {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> sendMessage(@RequestBody WSMessage value) throws Exception {
		
		if (value == null ||
                ValidatorUtils.isNullOrEmpty(value.getAction()) ||
                ValidatorUtils.isNullOrEmpty(value.getType()) || 
                ValidatorUtils.isNullOrEmpty(value.getValue()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		switch (value.getType()) {
		case "ag":
			this.messagingTemplate.convertAndSend("/topic/public/" + value.getValue(),new ChatMessage(MessageType.CHAT, value.getParams(), "ADM"));
			break;
		case "user":
			this.messagingTemplate.convertAndSend("/queue/private/" + value.getValue(), new ChatMessage(MessageType.CHAT, value.getParams(), "ADM"));
			break;
		case "seg":
			this.messagingTemplate.convertAndSend("/topic/public/segment/" + value.getValue(),new ChatMessage(MessageType.CHAT, value.getParams(), "ADM"));
			break;
		default:
			break;
		}
		
		return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	}
	
}
