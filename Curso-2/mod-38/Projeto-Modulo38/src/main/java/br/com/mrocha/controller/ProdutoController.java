package br.com.mrocha.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mrocha.domain.Produto;
import br.com.mrocha.service.IProdutoService;



@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 367088063926303823L;
	
	private Produto produto;
	
	private Collection<Produto> produtos;
	
	@Inject
	private IProdutoService produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro listar todos os produtos"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro cancelar ação"));
		}
		
    } 
	
	public void edit(Produto produto) {
		try {
			this.isUpdate = true;
			this.produto = produto;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro editar produto"));
		}
		
    } 
	
	public void delete(Produto produto) {
		try {
			produtoService.excluir(produto);
			produtos.remove(produto);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro excluir produto"));
		}
		
    } 
	
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro criar produto"));
		}
		
        
    }

    public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Produto Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro atualizar produto"));
		}
        
    }
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}
