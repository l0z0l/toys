package com.fatyu.model;

import java.io.Serializable;

public class Mp3Bean implements Serializable{
	private static final long serialVersionUID = 7683648467417870897L;

	@Override
	public String toString() {
		return "[Mp3 info is {id:" + this.id + ",mp3.name:" + this.mp3Name
				+ ",mp3.size:" + this.mp3Size + ",lrc.name:" + this.lrcName
				+ ",lrc.size:" + this.lrcSize + "}]";
	}

	// mp3_ID
	private String id;
	// mp3名称
	private String mp3Name;
	// mp3文件大小
	private String mp3Size;
	// 歌词文件大小
	private String lrcSize;
	// 歌词文件名称
	private String lrcName;

	/**
	 * 无参构造方法
	 */
	public Mp3Bean() {
		super();
	}

	/**
	 * 全部参数的构造方法
	 * 
	 * @param id
	 * @param mp3Name
	 * @param mp3Size
	 * @param lrcSize
	 * @param lrcName
	 */
	public Mp3Bean(String id, String mp3Name, String mp3Size, String lrcSize,
			String lrcName) {
		super();
		this.id = id;
		this.mp3Name = mp3Name;
		this.mp3Size = mp3Size;
		this.lrcSize = lrcSize;
		this.lrcName = lrcName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMp3Name() {
		return mp3Name;
	}

	public void setMp3Name(String mp3Name) {
		this.mp3Name = mp3Name;
	}

	public String getMp3Size() {
		return mp3Size;
	}

	public void setMp3Size(String mp3Size) {
		this.mp3Size = mp3Size;
	}

	public String getLrcSize() {
		return lrcSize;
	}

	public void setLrcSize(String lrcSize) {
		this.lrcSize = lrcSize;
	}

	public String getLrcName() {
		return lrcName;
	}

	public void setLrcName(String lrcName) {
		this.lrcName = lrcName;
	}

}
