package com.example.demo.services;

import com.example.demo.exceptions.TechNullException;
import com.example.demo.models.TechModel;
import com.example.demo.repositories.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechService {

    @Autowired
    private TechRepository techRepository;

    public TechModel createTech(TechModel techModel) {

        List<String> camposNulos = TechNullException.getCamposNulos(techModel);

        if(!camposNulos.isEmpty())
            throw new TechNullException(camposNulos);

        return techRepository.save(techModel);
    }

    public List<TechModel> getAllTechs() {
        return techRepository.findAll();
    }
    public TechModel getTechById(Long id) {
        return techRepository.findById(id).get();
    }
}
