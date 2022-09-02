package com.dh.clinicaodontologica.repository;

import com.dh.clinicaodontologica.model.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EnderecoRepository {
    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();

    private static int idEndereco = 1;

    public Endereco salvar(Endereco endereco) {
        endereco.setId(idEndereco++);
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

//    public Endereco getById(int id) {
//        return enderecoMap.get(id);
//    }

//    public String delete(int id) {
//        enderecoMap.remove(id);
//        return "Deletado";
//    }

    public Endereco update(Endereco endereco) {
        enderecoMap.put(endereco.getId(), endereco);
        return endereco;
    }

    public List<Endereco> listarTodos() {
        List<Endereco> enderecoEntities = new ArrayList<>(enderecoMap.values());
        return enderecoEntities;
    }
}
