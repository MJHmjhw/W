package com.zhiyou.model;

import java.sql.Timestamp;
import java.util.Date;

public class Message {
	private Integer message_id;
	private String subject;
	private String content;
	private Integer sender;
	private Integer send_delete;
	private Integer send_status;
	private Timestamp save_time;
	private Timestamp send_time;
	private Timestamp send_update_time;
	private Integer receiver;
	private Integer receive_delete;
	private Integer receive_status;
	private Timestamp receive_update_time;
	public Message(Integer message_id, String subject, String content, Integer sender, Integer send_delete,
			Integer send_status, Timestamp save_time, Timestamp send_time, Timestamp send_update_time, Integer receiver,
			Integer receive_delete, Integer receive_status, Timestamp receive_update_time) {
		super();
		this.message_id = message_id;
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.send_delete = send_delete;
		this.send_status = send_status;
		this.save_time = save_time;
		this.send_time = send_time;
		this.send_update_time = send_update_time;
		this.receiver = receiver;
		this.receive_delete = receive_delete;
		this.receive_status = receive_status;
		this.receive_update_time = receive_update_time;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", subject=" + subject + ", content=" + content + ", sender="
				+ sender + ", send_delete=" + send_delete + ", send_status=" + send_status + ", save_time=" + save_time
				+ ", send_time=" + send_time + ", send_update_time=" + send_update_time + ", receiver=" + receiver
				+ ", receive_delete=" + receive_delete + ", receive_status=" + receive_status + ", receive_update_time="
				+ receive_update_time + "]";
	}
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSender(Integer sender) {
		this.sender = sender;
	}
	public Integer getSend_delete() {
		return send_delete;
	}
	public void setSend_delete(Integer send_delete) {
		this.send_delete = send_delete;
	}
	public Integer getSend_status() {
		return send_status;
	}
	public void setSend_status(Integer send_status) {
		this.send_status = send_status;
	}
	public Timestamp getSave_time() {
		return save_time;
	}
	public void setSave_time(Timestamp save_time) {
		this.save_time = save_time;
	}
	public Timestamp getSend_time() {
		return send_time;
	}
	public void setSend_time(Timestamp send_time) {
		this.send_time = send_time;
	}
	public Timestamp getSend_update_time() {
		return send_update_time;
	}
	public void setSend_update_time(Timestamp send_update_time) {
		this.send_update_time = send_update_time;
	}
	public Integer getReceiver() {
		return receiver;
	}
	public void setReceiver(Integer receiver) {
		this.receiver = receiver;
	}
	public Integer getReceive_delete() {
		return receive_delete;
	}
	public void setReceive_delete(Integer receive_delete) {
		this.receive_delete = receive_delete;
	}
	public Integer getReceive_status() {
		return receive_status;
	}
	public void setReceive_status(Integer receive_status) {
		this.receive_status = receive_status;
	}
	public Timestamp getReceive_update_time() {
		return receive_update_time;
	}
	public void setReceive_update_time(Timestamp receive_update_time) {
		this.receive_update_time = receive_update_time;
	}
	
	
}
