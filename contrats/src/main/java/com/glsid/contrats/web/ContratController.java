package com.glsid.contrats.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glsid.contrats.aspects.Decrypt;
import com.glsid.contrats.aspects.Encrypt;
import com.glsid.contrats.aspects.MyLog;
import com.glsid.contrats.aspects.SecuredByAspect;
import com.glsid.contrats.dao.ContratRepository;
import com.glsid.contrats.entities.Contrat;

@RestController
public class ContratController {
    @Autowired
    private ContratRepository contratRepository;

    @GetMapping("contrats")
    @Decrypt(values = {"titre","nomClient","cinClient"})
    //@SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public List<Contrat> index() {
        return contratRepository.findAll();
    }

    @GetMapping("contrats/{id}")
//    @Decrypt(values = {"titre","nomClient","cinClient"})
 //   @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public Contrat get(@PathVariable Long id) {
        return contratRepository.findById(id).get();
    }

    @GetMapping("contrats/cin/{cin}")
  // @Decrypt(values = {"titre","nomClient","cinClient"})
   // @SecuredByAspect(roles = {"ADMIN","USER"})
    @MyLog
    public Contrat get(@PathVariable String cin) {
        return contratRepository.findByCinClient(cin);
    }

    @PostMapping("contrats/save")
  //  @Encrypt(values = {"titre","nomClient","cinClient"})
 //   @SecuredByAspect(roles = {"ADMIN"})
    @MyLog
    //@CachableAspect(values = {"titre","nomClient","cinClient"})
    public String save(@RequestBody Contrat contrat) {
        contrat.setDate(new Date());
        //System.out.println(contrat.getMontant());
        contratRepository.save(contrat);
        return "Vous avez ajouté ce contrat avec succès!";
    }

}


