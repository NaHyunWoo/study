package com.co.kr.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.co.kr.common.utiletc;

public class BoardVO {
	private String brdno, brdtitle, brdwriter, brdmemo, brddate, brdhit, brddeleteflag;
	private List<MultipartFile> uploadfile;
	
	
	public List<MultipartFile> getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(List<MultipartFile> uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getShortTitle(Integer len) {
		return utiletc.getShortString(brdtitle, len);
	}

	public String getBrdno() {
		return brdno;
	}

	public void setBrdno(String brdno) {
		this.brdno = brdno;
	}

	public String getBrdtitle() {
		return brdtitle;
	}

	public void setBrdtitle(String brdtitle) {
		this.brdtitle = brdtitle;
	}

	public String getBrdwriter() {
		return brdwriter;
	}

	public void setBrdwriter(String brdwriter) {
		this.brdwriter = brdwriter;
	}

	public String getBrdmemo() {
		return brdmemo.replaceAll("(?!)<script", "&lt;script");
	}

	public void setBrdmemo(String brdmemo) {
		this.brdmemo = brdmemo;
	}

	public String getBrddate() {
		return brddate;
	}

	public void setBrddate(String brddate) {
		this.brddate = brddate;
	}

	public String getBrdhit() {
		return brdhit;
	}

	public void setBrdhit(String brdhit) {
		this.brdhit = brdhit;
	}

	public String getBrddeleteflag() {
		return brddeleteflag;
	}

	public void setBrddeleteflag(String brddeleteflag) {
		this.brddeleteflag = brddeleteflag;
	}

	@Override
	public String toString() {
		return "BoardVO [brdno=" + brdno + ", brdtitle=" + brdtitle + ", brdwriter=" + brdwriter + ", brdmemo="
				+ brdmemo + ", brddate=" + brddate + ", brdhit=" + brdhit + ", brddeleteflag=" + brddeleteflag
				+ ", uploadfile=" + uploadfile + "]";
	}


}