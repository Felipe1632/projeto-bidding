/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.bidding.service;

import com.bidding.system.bidding.model.EditalDTO;
import com.bidding.system.bidding.model.LanceDTO;
import com.bidding.system.bidding.model.UserDTO;
import com.bidding.system.bidding.repository.EditalRepository;
import com.bidding.system.bidding.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class LanceService {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private EditalRepository EditalRepository;
    
    public void RegistroLance(Long id, LanceDTO novoLance, String token){
    if(tokenService.validarToken(token)){
        UserDTO usuarioLogado = tokenService.extrairClaim(token);
        
            if(!usuarioLogado.getRole().trim().equalsIgnoreCase("FORNECEDOR")){
                        throw new ResponseStatusException(HttpStatusCode.valueOf(403), "Você não é fornecedor!"); 
                }
            
                EditalDTO edital = EditalRepository.getById(id);
                if(!edital.getStatus().equals("ABERTO")) {
                        throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Você não pode criar lances para um edital fechado!");
                }
                
                if(edital.getData_fechamento().before(novoLance.getData_lance())){
                        throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Data do lance posterior ao fechamento!"); 
                }
            }else {
                        throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Token não autorizado!");   
                   }      
  }   
}
