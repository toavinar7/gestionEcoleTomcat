
package servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import modele.Classe;
import modele.Matiere;
import modele.Devoir;
import modele.Enseignant;
import modele.NotificationEleve;
import modele.Etudiant;
import util.Fonction;



/**
 *
 * @author Utilisateur
 */
@MultipartConfig 
@WebServlet(name = "AjoutDevoir", urlPatterns = {"/AjoutDevoir"})
public class AjoutDevoir extends HttpServlet {
      
    private final String UPLOAD_DIRECTORY = "/home/toavina/Documents/ecole/gestionEcole/web/uploadDevoir/";
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
        String name="";
        String description="";
        int idClasse=0;
        int idMatiere=0;
        String dateRendre= "";
        String pdfUrl="";
        
        Devoir devoir=new Devoir();
        Classe classe= new Classe();
        Matiere matiere=new Matiere();    
        List<Devoir> ldevoir=new ArrayList<Devoir>();
        NotificationEleve notification=new NotificationEleve();
        Fonction f= new Fonction();
        
        if(ServletFileUpload.isMultipartContent(request))
        {
            try 
            {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts)
                {                   
                    if(!item.isFormField())
                    {
                        String nameSplit=new File(item.getName()).getName();
                        int countDevoir=f.listeDevoir(0,0).size()+1;
                        name = countDevoir+f.splitCaractere(nameSplit);
                        
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                    
                    if(item.isFormField())
                    {
                        String fieldname = item.getFieldName();
                       // String value= item.getString();
                        if(fieldname.equalsIgnoreCase("description"))
                        { 
                            description = (String)item.getString(); 
                        }
                        if(fieldname.equalsIgnoreCase("classe"))
                        { 
                            idClasse= (Integer.parseInt(item.getString()));                             
                        }
                        if(fieldname.equalsIgnoreCase("matiere"))
                        { 
                            idMatiere= (Integer.parseInt(item.getString()));                             
                        }
                        if(fieldname.equalsIgnoreCase("dateRendre"))
                        { 
                            dateRendre = (String)item.getString(); 
                        }
                          
                    }
                }
                pdfUrl=name; 
               
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully"+name);
            } 
            catch (Exception ex) 
            {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }               
        }
        else
        {
            request.setAttribute("message","Sorry this Servlet only handles file upload request");
        }
         
        try 
        {
            Enseignant ens=(Enseignant) request.getSession().getAttribute("enseignant");
            Date dateActuel=null;
            java.util.Date temp=new java.util.Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
            String dateAujourdhui="";
            dateAujourdhui = sdf.format(new java.util.Date());
            
            classe=f.listeClasse(idClasse).get(0);
           // System.out.println("classe: "+classe);
            matiere=f.listeMatiere(idMatiere).get(0);
            devoir.setCommentaire(description);
            devoir.setPdfUrl(pdfUrl);
            devoir.setLibele(matiere);
            devoir.setIdEnseignant(ens);
            devoir.setDateEntrer(dateAujourdhui);
            devoir.setDateCorrection(dateRendre);
            devoir.setIdClasse(classe);
            f.insererDevoir(devoir);
         
            
            
            List<Etudiant> lEtudiantClasse= new ArrayList<Etudiant>();            
            lEtudiantClasse=f.listeEtudiant(0,null,devoir.getIdClasse().getId());
            
            for(int i=0; i<lEtudiantClasse.size();i++)
            {
                Etudiant etudiant=new Etudiant();
                etudiant.setId(lEtudiantClasse.get(i).getId());
                notification.setIdEtudiant(etudiant);
                notification.setDevoir(devoir);
                f.insererNotificationEleve(notification);
                
            }
            
            ldevoir=f.listeDevoirClasse(idClasse, ens.getId());
            
            
        }
        catch(SQLException ex) 
        {
            Logger.getLogger(AjoutDevoir.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listeDevoir",ldevoir);
        request.getRequestDispatcher("listeDevoirEnseignant.jsp").forward(request, response);

    }  
    
    
}
