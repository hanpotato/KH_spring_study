package com.kh.spring.common.socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

//소켓핸들러 객체는 두개의 상속 객체를 가질 수 있음
//1. TextWebSocketHandler : 문자만 전송 채팅전용, 알람 기타 문자들만 사용하는 경우
//2. BinaryWebSocketHandler : 문자도 되고 파일까지 받을 수 있음

/*public class SocketHandler extends TextWebSocketHandler {*/
public class SocketHandler extends BinaryWebSocketHandler {
	
	private Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	private List<WebSocketSession> list = new ArrayList();
	private String fileName;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("session id : " + session.getId());
		list.add(session);
		
		super.afterConnectionEstablished(session);
	}
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		
		logger.debug("들어온 값 확인 : " + session.getId() + " : " + message);
		String dir = "C:\\testDownload\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddmmssSSS");
		int rnd = (int)(Math.random()*1000);
		String reFileName = sdf.format(new Date(System.currentTimeMillis())) + "_" + rnd + fileName;
		FileOutputStream fos = new FileOutputStream(new File(dir + reFileName));
		/*FileOutputStream fos = new FileOutputStream(new File(dir + session.getId()));*/
		
		//java.nio.ByteBuffer로 import
		ByteBuffer bb = message.getPayload();
		fos.write(bb.array());
		fos.close();
		Map<String,String> map = new HashMap();
		map.put("nickname", "관리자");
		map.put("msg", session.getId() + "파일업로드가 완료되었습니다.");
		ObjectMapper mapper = new ObjectMapper();
		for(WebSocketSession s : list) {
			s.sendMessage(new TextMessage(mapper.writeValueAsString(map)));
		}
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		// TODO Auto-generated method stub
		logger.debug("message : " + message);
		String msg = message.getPayload();
		logger.debug("메세지 변환 전 : " + msg);
		/*메세지 파싱 처리하기*/
		Map<String,String> map = new HashMap();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(msg,HashMap.class);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		logger.debug("메세지 변환 후 : " + map);
		//session.sendMessage : session에 메세지를 보내는 메소드
		//전달된 메소드는 페이지의 onmessage함수를 호출!
		/*session.sendMessage(message);*/
		
		if(map.get("flag") != null && map.get("flag").equals("file")) {
			fileName = map.get("msg");
		}
		else {
			for(WebSocketSession s : list) {
				
				//if(s==session) {continue;}
				
				/*
				귓속말 로직 구현 형식
				if(map.containsKey("whisper")) {
					if(map.get("whisper").equals())
				}
				*/
				
				try {
					s.sendMessage(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("close : " + session.getId());
		list.remove(session);
	}

	
}
