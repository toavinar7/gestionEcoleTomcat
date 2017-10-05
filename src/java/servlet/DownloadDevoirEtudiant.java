package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DERA PC
 */
@WebServlet(name = "DownloadDevoirEtudiant", urlPatterns = {"/DownloadDevoirEtudiant"})
public class DownloadDevoirEtudiant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomDevoir = request.getParameter("devoir");
        String filePath = "/home/toavina/Documents/ecole/gestionEcole/web/uploadDevoir/" + nomDevoir;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);
        ServletContext context = getServletContext();
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
    }

}
