/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DAO.AtletaJpaController;
import DTO.Atleta;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alvaro
 */
public class Registro {

    private Atleta atleta;
    private EntityManagerFactory emf;
    private ExternalContext contexto;
    private String objetivoOtro;
    private String textoAlergia;
    private String comidaNoGusta;
    private String enfermedad;
    private String deporteComplementado;
    private String pass1;
    private String pass2;
    private String resultadoPass;
    /**
     * Creates a new instance of Registro
     */
    public Registro() {
        emf = Persistence.createEntityManagerFactory("DeltaFitPU");
        contexto = FacesContext.getCurrentInstance().getExternalContext();
        atleta = new Atleta();
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    
    public String getDeporteComplementado() {
        return deporteComplementado;
    }

    public void setDeporteComplementado(String deporteComplementado) {
        this.deporteComplementado = deporteComplementado;
    }        

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    
    public String getComidaNoGusta() {
        return comidaNoGusta;
    }

    public void setComidaNoGusta(String comidaNoGusta) {
        this.comidaNoGusta = comidaNoGusta;
    }
    
    public String getObjetivoOtro() {
        return objetivoOtro;
    }

    public void setObjetivoOtro(String objetivoOtro) {
        this.objetivoOtro = objetivoOtro;
    }

    public String getTextoAlergia() {
        return textoAlergia;
    }

    public void setTextoAlergia(String textoAlergia) {
        this.textoAlergia = textoAlergia;
    }

       
    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ExternalContext getContexto() {
        return contexto;
    }

    public void setContexto(ExternalContext contexto) {
        this.contexto = contexto;
    }

    public String getResultadoPass() {
        return resultadoPass;
    }

    public void setResultadoPass(String resultadoPass) {
        this.resultadoPass = resultadoPass;
    }    
    
    public String registro() {
        /*Este metodo será llamado desde el boton del registro, la comprobación
        de campos de que sean correctos se hará en la parte del cliente
         */

        AtletaJpaController controlAtleta = new AtletaJpaController(emf);
        String resultado;
        if(pass1.equals(pass2)) {
            /*Como las contraseñas coinciden se la asignamos al atleta*/
            atleta.setPass(pass1);
            
            /*Comprobamos si el usuario ha escrito algun campo mas que no lo controle el objeto atleta, y se lo asignamos a atleta*/
            if(!objetivoOtro.equals("")) atleta.setObjetivo(objetivoOtro);
            
            if(!textoAlergia.equals("")) atleta.setAlergia(textoAlergia);
            
            if(!comidaNoGusta.equals("")) atleta.setComidaNoGusta(comidaNoGusta);
            
            if(!enfermedad.equals("")) atleta.setEnfermedad(enfermedad);
            
            if(!deporteComplementado.equals("")) atleta.setDeporteComplementado(deporteComplementado);
            
            controlAtleta.create(atleta);
            resultado = "ok";
        } else {
            
            resultadoPass = "Las contraseñas deben coincidir";
            resultado = "no";
        }
        
        return resultado;
    }

}
