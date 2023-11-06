/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.DAO;

import br.edu.unijui.dataBase.Models.Reserva;
import br.edu.unijui.dataBase.Models.Cliente;
import br.edu.unijui.xml.ManipuladorXML;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author gisel
 */
public class RelatoriosDAO {
    
     public static void xmlClientes(ArrayList<Cliente> clientes) throws SQLException {
         
        Document doc = ManipuladorXML.newDocument();
        Element clientesElement = doc.createElement("clientes");
        doc.appendChild(clientesElement);

        for (Cliente cliente : clientes) {
            Element clienteElement = doc.createElement("cliente");
            clientesElement.appendChild(clienteElement); 

            Element nomeElement = doc.createElement("nome");
            Text nomeText = doc.createTextNode(cliente.getNome());
            nomeElement.appendChild(nomeText);
            clienteElement.appendChild(nomeElement);

            Element emailElement = doc.createElement("email");
            Text emailText = doc.createTextNode(cliente.getEmail());
            emailElement.appendChild(emailText);
            clienteElement.appendChild(emailElement);

            Element telefoneElement = doc.createElement("telefone");
            Text telefoneText = doc.createTextNode(cliente.getTelefone());
            telefoneElement.appendChild(telefoneText);
            clienteElement.appendChild(telefoneElement);
            
            
            Element dtCadastroElement = doc.createElement("dtCadastro");
            Date data = cliente.getDtCadastro();
            Text dtCadastroText = doc.createTextNode(data == null? "" : data.toString());
            dtCadastroElement.appendChild(dtCadastroText);
            clienteElement.appendChild(dtCadastroElement);    
        }
        ManipuladorXML.writeXmlFile(doc, "Clientes.xml");
    }  
     
     public static void xmlReservas(ArrayList<Reserva> reservas) throws SQLException {
         
        Document doc2 = ManipuladorXML.newDocument();
        Element reservasElement = doc2.createElement("Reservas");
        doc2.appendChild(reservasElement);

        for (Reserva reserva : reservas) {
            Element reservaElement = doc2.createElement("Reserva");
            reservasElement.appendChild(reservaElement); 

            Element nomeElement = doc2.createElement("quarto");
            Integer quarto = reserva.getQuarto();
            Text nomeText = doc2.createTextNode(quarto.toString());
            nomeElement.appendChild(nomeText);
            reservasElement.appendChild(nomeElement);

            Element clienteIdElement = doc2.createElement("cliente");
            int clienteId = reserva.getCliente();
            Text clienteIdText = doc2.createTextNode(String.valueOf(clienteId));
            clienteIdElement.appendChild(clienteIdText);
            reservasElement.appendChild(clienteIdElement);
            
            
            Element dtCheckinElement = doc2.createElement("checkin");
            Date dataCheckin = reserva.getCheckin();
            Text dtCheckinText = doc2.createTextNode(dataCheckin == null? "" : dataCheckin.toString());
            dtCheckinElement.appendChild(dtCheckinText);
            reservasElement.appendChild(dtCheckinElement); 
            
            Element dtCheckoutElement = doc2.createElement("checkout");
            Date dataCheckout = reserva.getCheckout();
            Text dtCheckoutText = doc2.createTextNode(dataCheckout == null? "" : dataCheckout.toString());
            dtCheckoutElement.appendChild(dtCheckoutText);
            reservasElement.appendChild(dtCheckoutElement); 
        }
        ManipuladorXML.writeXmlFile(doc2, "Reserva.xml");
    }  
}
