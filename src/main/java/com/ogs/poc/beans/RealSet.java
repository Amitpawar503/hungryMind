package com.ogs.poc.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "realset")
public class RealSet {

	@Id
	public String _id;

	public String real1;

	public String real2;

	public String real3;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getReal1() {
		return real1;
	}

	public void setReal1(String real1) {
		this.real1 = real1;
	}

	public String getReal2() {
		return real2;
	}

	public void setReal2(String real2) {
		this.real2 = real2;
	}

	public String getReal3() {
		return real3;
	}

	public void setReal3(String real3) {
		this.real3 = real3;
	}

}
