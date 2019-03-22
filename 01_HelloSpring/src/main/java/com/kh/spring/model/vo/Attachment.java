package com.kh.spring.model.vo;

import java.sql.Date;

public class Attachment {

	private int attachmentNo;
	private int boardNo;
	private String originalFileName;
	private String renamedFileName;
	private Date uploadDate;
	private int downLoadCount;
	private String status;
	
	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	public Attachment(int attachmentNo, int boardNo, String originalFileName, String renamedFileName, Date uploadDate,
			int downLoadCount, String status) {
		super();
		this.attachmentNo = attachmentNo;
		this.boardNo = boardNo;
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
		this.uploadDate = uploadDate;
		this.downLoadCount = downLoadCount;
		this.status = status;
	}

	public int getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenamedFileName() {
		return renamedFileName;
	}

	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getDownLoadCount() {
		return downLoadCount;
	}

	public void setDownLoadCount(int downLoadCount) {
		this.downLoadCount = downLoadCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [attachmentNo=" + attachmentNo + ", boardNo=" + boardNo + ", originalFileName="
				+ originalFileName + ", renamedFileName=" + renamedFileName + ", uploadDate=" + uploadDate
				+ ", downLoadCount=" + downLoadCount + ", status=" + status + "]";
	}
	
}
