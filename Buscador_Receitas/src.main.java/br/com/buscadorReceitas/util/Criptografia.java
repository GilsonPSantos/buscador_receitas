package br.com.buscadorReceitas.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.buscadorReceitas.exception.IntegrationException;
import br.com.buscadorReceitas.model.Usuario;

public class Criptografia {

	public static void criptografarSenha(Usuario usuario) throws IntegrationException{
		
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(usuario.getSenha().getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			usuario.setSenha(hexString.toString());	
		}catch(NoSuchAlgorithmException ex) {
			throw new IntegrationException(ex);
		}catch(UnsupportedEncodingException ex) {
			throw new IntegrationException(ex);
		}
	}
}
