package br.com.mrocha.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mrocha.domain.Cliente;
import br.com.mrocha.service.IClienteService;




@Named
@ViewScoped
public class ClienteController implements Serializable {
	
private static final long serialVersionUID = 8030245985235567808L;
	
	private Cliente cliente;
	
	private Collection<Cliente> clientes;
	
	@Inject
	private IClienteService clienteService;
	
	private Boolean isUpdate;
	
	private String cpfMask;
	
	private String telMask;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();
			this.clientes = clienteService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao listar todos os clientes"));
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.cliente = new Cliente();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao cancelar ação"));
		}
		
    } 
	
	public void edit(Cliente cliente) {
		try {
			this.isUpdate = true;
			this.cliente = cliente;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao excluir cliente"));
		}
		
    } 
	
	public void delete(Cliente cliente) {
		try {
			clienteService.excluir(cliente);
			clientes.remove(cliente);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao excluir cliente"));
		}
		
    } 
	
	public void add() {
		try {
			limparCampos();
			clienteService.cadastrar(cliente);
			this.clientes = clienteService.buscarTodos();
			this.cliente = new Cliente();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao criar cliente"));
		}
		
        
    }
    
    private void limparCampos() {
    	setCpfMask(null);
    	setTelMask(null);
    }

	public void update() {
    	try {
			clienteService.alterar(this.cliente);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Cliente Atualiado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage("Erro ao atualizar cliente"));
		}
        
    }
	
	public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getCpfMask() {
		return cpfMask;
	}

	public void setCpfMask(String cpfMask) {
		this.cpfMask = cpfMask;
	}

	public String getTelMask() {
		return telMask;
	}

	public void setTelMask(String telMask) {
		this.telMask = telMask;
	}
}

