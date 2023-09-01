package main.services;

import main.dao.IProdutoDAO;
import main.domain.Produto;
import main.services.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
