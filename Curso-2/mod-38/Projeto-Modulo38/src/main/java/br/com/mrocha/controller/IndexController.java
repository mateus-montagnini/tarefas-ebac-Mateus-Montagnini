package br.com.mrocha.controller;

import java.io.Serializable;

public class IndexController implements Serializable {

	private static final long serialVersionUID = -784519597996507487L;

	public String redirectCliente() {
		return "/cliente/list.xhtml";
	}
	
	public String redirectProduto() {
		return "/produto/list.xhtml";
	}
}
