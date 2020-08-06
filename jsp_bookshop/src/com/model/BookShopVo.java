package com.model;

import java.sql.Date;

public class BookShopVo {
	private int book_id;
	private String title;
	private String pubs;
	private Date pub_date;
	private String author_name;
	
	public BookShopVo() {}
	
	public BookShopVo(int book_id, String title, String pubs, Date pub_date, String author_name) {
		this.book_id = book_id;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.author_name = author_name;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	@Override
	public String toString() {
		return "Vo [book_id=" + book_id + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date
				+ ", author_name=" + author_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author_name == null) ? 0 : author_name.hashCode());
		result = prime * result + book_id;
		result = prime * result + ((pub_date == null) ? 0 : pub_date.hashCode());
		result = prime * result + ((pubs == null) ? 0 : pubs.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookShopVo other = (BookShopVo) obj;
		if (author_name == null) {
			if (other.author_name != null)
				return false;
		} else if (!author_name.equals(other.author_name))
			return false;
		if (book_id != other.book_id)
			return false;
		if (pub_date == null) {
			if (other.pub_date != null)
				return false;
		} else if (!pub_date.equals(other.pub_date))
			return false;
		if (pubs == null) {
			if (other.pubs != null)
				return false;
		} else if (!pubs.equals(other.pubs))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
